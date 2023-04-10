package io.github.debuggyteam.architecture_extensions.staticdata;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
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
	
	public static List<Item> getData(Identifier basePath) {
		List<Item> result = new ArrayList<>();
		
		for(ModContainer container : QuiltLoader.getAllMods()) {
			if (FORBIDDEN_CONTAINERS.contains(container.metadata().id())) continue;
			
			String modid = container.metadata().id();
			
			//Acquire the requested folder or resource
			Path rootPath = container.rootPath();
			Path staticDataFolder = rootPath.resolve("staticdata");
			if (!Files.exists(staticDataFolder, LinkOption.NOFOLLOW_LINKS)) continue;
			Path namespacedFolder = staticDataFolder.resolve(basePath.getNamespace());
			if (!Files.exists(namespacedFolder, LinkOption.NOFOLLOW_LINKS)) continue;
			Path pathFolder = (basePath.getPath().isBlank()) ? namespacedFolder : namespacedFolder.resolve(basePath.getPath());
			if (!Files.exists(pathFolder, LinkOption.NOFOLLOW_LINKS)) continue;
			
			//Inspect the valid Path we got
			if (Files.isRegularFile(pathFolder, LinkOption.NOFOLLOW_LINKS)) {
				//Found single file. Return it
				
				return List.of(
						new Item(modid, basePath, pathFolder)
						);
			} else {
				//Found directory. Return files in the directory.
				
				try {
					Files.list(pathFolder).forEach(sub->{
						if (!Files.isRegularFile(sub)) return;
						
						String pathPart = namespacedFolder.relativize(sub).toString();
						if (pathPart.startsWith("/")) pathPart = pathPart.substring(1);
						Item item = new Item(modid, new Identifier(basePath.getNamespace(), pathPart), sub);
						result.add(item);
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//TODO: Additionally query the 'staticdata' folder in the minecraft server dir, or the client run dir.
		
		return List.copyOf(result);
	}
	
	/**
	 * Represents a piece of static data that can be loaded in.
	 */
	public static record Item(String modid, Identifier id, Path p) {
		/**
		 * Gets this static data item as a raw InputStream
		 * @return an InputStream at the start of this static data
		 * @throws IOException if there was an error opening the stream
		 */
		public InputStream getAsStream() throws IOException {
			return Files.newInputStream(p, StandardOpenOption.READ);
		}
		
		/**
		 * Gets this static data item as a byte array
		 * @return a byte array containing the static data
		 * @throws IOException if there was an error reading in the data
		 */
		public byte[] getAsBytes() throws IOException {
			return Files.readAllBytes(p);
		}
		
		/**
		 * Gets this static data item as UTF-8 character data, as a List of lines
		 * @return the List of lines of static data
		 * @throws IOException if there was an error reading in the data
		 */
		public List<String> getAsLines() throws IOException {
			return Files.readAllLines(p, StandardCharsets.UTF_8);
		}
		
		/**
		 * Gets this static data item as UTF-8 character data
		 * @return the data interpreted as UTF-8 characters
		 * @throws IOException if there was an error reading in the data
		 */
		public String getAsString() throws IOException {
			return Files.readString(p, StandardCharsets.UTF_8);
		}
		
		@Override
		public String toString() {
			return modid+":"+id.getNamespace()+":"+id.getPath()+" > "+p.toString();
		}
	};
}
