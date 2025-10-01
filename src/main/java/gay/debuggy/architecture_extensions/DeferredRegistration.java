package gay.debuggy.architecture_extensions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import org.jetbrains.annotations.Nullable;


import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

import gay.debuggy.architecture_extensions.api.BlockGroup;
import gay.debuggy.architecture_extensions.api.BlockShape;
import gay.debuggy.architecture_extensions.resource.DataGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class DeferredRegistration {
	private static Multimap<Identifier, Entry> deferrals = MultimapBuilder.hashKeys().arrayListValues(2).build();
	
	/**
	 * Called by ArchEx to start resolving deferred registrations.
	 */
	public static void init() {

		var event = RegistryEntryAddedCallback.event(Registries.BLOCK);
		event.register((intId, identifier, object) -> {
			Collection<Entry> safeEntries = deferrals.get(identifier);

			Iterator<Entry> i = safeEntries.iterator();

			while(i.hasNext()) {
				Entry entry = i.next();
				if (entry.register()) {
					i.remove();
				} else {
					ArchitectureExtensions.LOGGER.warn("An unexpected problem ocurred generating " + entry.getIds() + " - this request is still deferred.");
				}
			}
		});
	}
	
	/**
	 * Called indirectly by users to register derived blocks.
	 * @param modId
	 * @param group
	 * @param groupedBlock
	 * @param blockTypes
	 */
	public static void register(String modId, BlockGroup group, BlockGroup.GroupedBlock groupedBlock, Collection<BlockShape> blockTypes, @Nullable BlockCreationCallback callback) {
		Entry deferral = new Entry(modId, group, groupedBlock, Set.copyOf(blockTypes), callback);
		
		if (!deferral.register()) {
			//ArchitectureExtensions.LOGGER.info("Deferred generation: " + deferral.modId() + " requested " + deferral.getIds() + " and registration was deferred.");
			deferrals.put(groupedBlock.baseBlockId(), deferral);
		} else {
			//ArchitectureExtensions.LOGGER.info("Deferred generation: " + deferral.modId() + " requested " + deferral.getIds() + " and registration was completed immediately.");
		}
	}
	
	
	/**
	 * Called by ArchEx to warn users that we couldn't create blocks that were requested.
	 */
	public static void assertFinished() {
		for(Entry entry : deferrals.values()) {
			String sourceString = (entry.modId().equals("file")) ? "A file in the staticdata folder" : "Mod '" + entry.modId() + "'";
			ArchitectureExtensions.LOGGER.warn(sourceString + " requested architecture extensions blocks derived from base block " + entry.groupedBlock.id() + ", but this base block was never registered.");
		}
	}
	
	private static record Entry(String modId, BlockGroup group, BlockGroup.GroupedBlock groupedBlock, Set<BlockShape> blockTypes, BlockCreationCallback callback) {
		public boolean register() {
			Block baseBlock = groupedBlock.baseBlock().get();
			if (baseBlock == Blocks.AIR || baseBlock == null) return false;
			
			for(BlockShape blockType : blockTypes) {
				BlockShape.TypedGroupedBlock created = blockType.register(group, groupedBlock, callback, modId);
				DataGeneration.collect(created);
			}
			
			return true;
		}
		
		public Set<String> getIds() {
			String modId = this.modId();
			if (modId.equals("file")) modId = ArchitectureExtensions.MOD_ID; // If it's a staticdata resource, use our own id
			
			HashSet<String> result = new HashSet<>();
			for(BlockShape bt : blockTypes) {
				Identifier id = Identifier.of(modId, groupedBlock.id().getPath() + "_" + bt);
				result.add(id.toString());
			}
			return result;
		}
	}
}
