package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.api.ArchExIntegration;
import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import io.github.debuggyteam.architecture_extensions.resource.DataGeneration;
import net.minecraft.block.Block;

public class ArchExIntegrationContextImpl implements ArchExIntegration.Context {
	private final ArchExIntegration integration;

	public ArchExIntegrationContextImpl(ArchExIntegration integration) {
		this.integration = integration;
	}

	@Override
	public void makeArchExBlocks(BlockType type, BlockGroup... groups) {
		for (BlockGroup group : groups) {
			for(BlockGroup.GroupedBlock groupedBlock : group) {
				BlockType.TypedGroupedBlock created = type.register(group, groupedBlock, integration::onBlockCreated);
				DataGeneration.collect(created);
			}
		}
	}

	@FunctionalInterface
	public static interface BlockCreationCallback {
		public void onBlockCreated(BlockGroup group, BlockType blockType,  Block base, Block created);
	}
}
