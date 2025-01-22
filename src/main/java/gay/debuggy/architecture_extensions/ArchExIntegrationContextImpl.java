package gay.debuggy.architecture_extensions;

import java.util.Set;

import gay.debuggy.architecture_extensions.api.ArchExIntegration;
import gay.debuggy.architecture_extensions.api.BlockGroup;
import gay.debuggy.architecture_extensions.api.BlockType;

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
}
