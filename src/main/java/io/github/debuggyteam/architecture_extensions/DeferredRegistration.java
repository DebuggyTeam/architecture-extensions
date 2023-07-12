package io.github.debuggyteam.architecture_extensions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.registry.api.event.RegistryEvents;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import io.github.debuggyteam.architecture_extensions.resource.DataGeneration;
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
		RegistryEvents.getEntryAddEvent(Registries.BLOCK).register(ctx -> {
			Identifier registeredId = ctx.id();
			Collection<Entry> safeEntries = deferrals.get(registeredId);
			Iterator<Entry> i = safeEntries.iterator();
			while(i.hasNext()) {
				Entry entry = i.next();
				if (entry.register()) {
					i.remove();
					//ArchitectureExtensions.LOGGER.info("Deferred generation: "+entry.modId()+" requested "+entry.getIds()+", which is now complete.");
				} else {
					ArchitectureExtensions.LOGGER.warn("An unexpected problem ocurred generating "+entry.getIds()+" - this request is still deferred.");
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
	public static void register(String modId, BlockGroup group, BlockGroup.GroupedBlock groupedBlock, Collection<BlockType> blockTypes, @Nullable BlockCreationCallback callback) {
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
	
	private static record Entry(String modId, BlockGroup group, BlockGroup.GroupedBlock groupedBlock, Set<BlockType> blockTypes, BlockCreationCallback callback) {
		public boolean register() {
			Block baseBlock = groupedBlock.baseBlock().get();
			if (baseBlock == Blocks.AIR || baseBlock == null) return false;
			
			for(BlockType blockType : blockTypes) {
				BlockType.TypedGroupedBlock created = blockType.register(group, groupedBlock, callback, modId);
				DataGeneration.collect(created);
			}
			
			return true;
		}
		
		public Set<String> getIds() {
			String modId = this.modId();
			if (Objects.equals(modId, "file")) modId = ArchitectureExtensions.MOD_CONTAINER.metadata().id(); // If it's a staticdata resource, use our own id
			
			HashSet<String> result = new HashSet<>();
			for(BlockType bt : blockTypes) {
				Identifier id = new Identifier(modId, groupedBlock.id().getPath() + "_" + bt);
				result.add(id.toString());
			}
			return result;
		}
	}
}
