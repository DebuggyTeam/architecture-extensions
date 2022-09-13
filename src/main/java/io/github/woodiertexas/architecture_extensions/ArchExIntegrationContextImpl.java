package io.github.woodiertexas.architecture_extensions;

import io.github.woodiertexas.architecture_extensions.api.ArchExIntegration;
import io.github.woodiertexas.architecture_extensions.api.BlockType;
import io.github.woodiertexas.architecture_extensions.api.BlockGroup;

public class ArchExIntegrationContextImpl implements ArchExIntegration.Context {
	private final ArchExIntegration integration;

	public ArchExIntegrationContextImpl(ArchExIntegration integration) {
		this.integration = integration;
	}

	@Override
	public void makeArchExBlocks(BlockType type, BlockGroup... groups) {
		for (BlockGroup group : groups) { group.forEach(block -> type.register(block.id(), block.baseBlock(), integration.itemGroup())); }
	}
}
