package io.github.debuggyteam.architecture_extensions;

import java.util.Set;

import io.github.debuggyteam.architecture_extensions.api.ArchExIntegration;
import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import net.minecraft.block.Block;

public class ArchExIntegrationContextImpl implements ArchExIntegration.Context {
	private final ArchExIntegration integration;
	private final String modId;

	public ArchExIntegrationContextImpl(ArchExIntegration integration, String modId) {
		this.integration = integration;
		this.modId = modId;
	}

	@Override
	public void makeArchExBlocks(BlockType type, BlockGroup... groups) {
		for (BlockGroup group : groups) {
			
			
			for(BlockGroup.GroupedBlock groupedBlock : group) {
				DeferredRegistration.register(modId, group, groupedBlock, Set.of(type), integration::onBlockCreated);
			}
		}
	}
	
	@FunctionalInterface
	public static interface BlockCreationCallback {
		public void onBlockCreated(BlockGroup group, BlockType blockType,  Block base, Block created);
	}
}
