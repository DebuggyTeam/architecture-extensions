package io.github.debuggyteam.architecture_extensions.staticdata;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;

import net.minecraft.util.Identifier;

/**
 * This class accesses a non-mojang type of data called "static data". This kind of data differs from resource and data
 * for several reasons:
 * 
 * <ul>
 *   <li> It's available much earlier in the loading process - by the time a ModInitializer is called, all static data
 *        is available.
 *   <li> It's insensitive to mod load order.
 *   <li> It's not allowed to change between respack and datapack reloads.
 * </ul>
 * 
 * These properties make static data ideal for "passive", loader-agnostic mod integrations, especially ones which result
 * in new block registrations.
 * 
 * <p>Note: If block IDs are specified in static data, they may not be available yet, as the mod that registers them may
 * not have run its ModInitializer yet. It is the responsibility of the mod requesting block IDs from static data to
 * detect unregistered block IDs and defer their resolution until the data is available. This generally takes the form
 * of a block registry listener to determine when the block ID in question becomes available.
 * 
 * <p>Note: Jarmods cannot add static data. Nor can the JVM. If static data is found in a sensitive location such as
 * these, it will be ignored.
 */
public class StaticData {
	private static final Set<String> FORBIDDEN_CONTAINERS = Set.of( "java", "minecraft" );
	
	/**
	 * Acquires static data items matching the given Identifier. The Identifier can be either a specific file name, such
	 * as "examplemod:config.json", or it could be a directory path such as "examplemod:blocks". Identifiers with an
	 * empty path (such as {@code new Identifier("examplemod", "")} ) will retrieve any data sitting at the root of that
	 * namespace.
	 * 
	 * <p>Note that the namespace of the resourceId typically identifies the mod that will be *querying* the
	 * data, not the mod that is supplying it. The mod that supplied the information is always identified in the "modId"
	 * field of the returned Items, with the special id "file" identifying items supplied by placing files in a
	 * "staticdata" folder of the client or server, like "minecraft/staticdata/examplemod/foo.json".
	 * @param resourceId The Identifier of the resource being sought. The namespace of this Id is typically your own,
	 *                   the mod id of the mod requesting data.
	 * @return A List of data items discovered. File items will always occur after mod-provided items in the list.
	 */
	public static List<Item> getData(Identifier resourceId) {
		List<Item> result = new ArrayList<>();
		
		for(ModContainer container : QuiltLoader.getAllMods()) {
			if (FORBIDDEN_CONTAINERS.contains(container.metadata().id())) continue;
			
			addStaticDataItems(
					container.metadata().id(),
					resourceId,
					container.rootPath().resolve("staticdata"),
					result
					);
		}
		
		addStaticDataItems(
				"file",
				resourceId,
				QuiltLoader.getGameDir().resolve("staticdata"),
				result
				);
		
		return List.copyOf(result);
	}
	
	/**
	 * Searches this Path, which is the "staticdata" folder of a mod container, client, or server, and appends any
	 * static data matching the Identifier
	 * @param modid    The name of the container we're searching - what modid to report for found items.
	 * @param resId    The requested resource Identifier
	 * @param basePath A base path - usually `modContainer.rootPath().resolve("staticdata")` but can be a real folder too.
	 * @param results  A List of StaticData.Items that will be populated with results. Any prior results will not be removed.
	 */
	private static void addStaticDataItems(String modid, Identifier resId, Path basePath, List<Item> results) {
		//Any data found will have Identifier paths relative to this path
		Path relativePath = basePath.resolve(resId.getNamespace());
		//This is the Path actually evaluated / enumerated for data
		Path requestedPath = relativePath.resolve(resId.getPath());
		
		if (!Files.exists(requestedPath)) return;
		
		if (Files.isRegularFile(requestedPath)) {
			//resId pointed to an exact file
			results.add(new Item(modid, resId, requestedPath));
		} else {
			//resId pointed to a directory
			try {
				Files.list(requestedPath).forEach(file->{
					if (!Files.isRegularFile(file)) return; //Don't list folders
					
					String identifiedResourcePath = relativePath.relativize(file).toString();
					if (identifiedResourcePath.startsWith("/")) identifiedResourcePath = identifiedResourcePath.substring(1);
					Item item = new Item(modid, new Identifier(resId.getNamespace(), identifiedResourcePath), file);
					results.add(item);
				});
			} catch (IOException ex) {
				new IOException("There was a problem searching container '"+modid+"' for static data with resource ID '"+resId+"'.", ex).printStackTrace();
			}
		}
	}
	
	/**
	 * Represents an identified piece of static data, and a Path that can be used to load the data in.
	 */
	public static record Item(String modId, Identifier resourceId, Path dataPath) {
		/**
		 * Gets this static data item as a raw InputStream
		 * @return an InputStream at the start of this static data
		 * @throws IOException if there was an error opening the stream
		 */
		public InputStream getAsStream() throws IOException {
			return Files.newInputStream(dataPath, StandardOpenOption.READ);
		}
		
		/**
		 * Gets this static data item as a byte array
		 * @return a byte array containing the static data
		 * @throws IOException if there was an error reading in the data
		 */
		public byte[] getAsBytes() throws IOException {
			return Files.readAllBytes(dataPath);
		}
		
		/**
		 * Gets this static data item as UTF-8 character data, as a List of lines
		 * @return the List of lines of static data
		 * @throws IOException if there was an error reading in the data
		 */
		public List<String> getAsLines() throws IOException {
			return Files.readAllLines(dataPath, StandardCharsets.UTF_8);
		}
		
		/**
		 * Gets this static data item as UTF-8 character data
		 * @return the data interpreted as UTF-8 characters
		 * @throws IOException if there was an error reading in the data
		 */
		public String getAsString() throws IOException {
			return Files.readString(dataPath, StandardCharsets.UTF_8);
		}
		
		@Override
		public String toString() {
			return modId+":"+resourceId.getNamespace()+":"+resourceId.getPath()+" > "+dataPath.toString();
		}
	};
}
