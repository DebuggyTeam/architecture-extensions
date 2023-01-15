package io.github.debuggyteam.architecture_extensions;

import com.google.common.collect.Sets;

import io.github.debuggyteam.architecture_extensions.api.ArchExIntegration;
import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import io.github.debuggyteam.architecture_extensions.resource.DataGeneration;
import net.minecraft.item.ItemGroup;

public class ArchExIntegrationContextImpl implements ArchExIntegration.Context {
	private final ArchExIntegration integration;

	private final ItemGroup[] itemGroupsToModify;

	public ArchExIntegrationContextImpl(ArchExIntegration integration) {
		this.integration = integration;

		final var itemGroupSet = Sets.newHashSet();
		this.integration.itemGroups(itemGroupSet::add);
		this.itemGroupsToModify = itemGroupSet.toArray(new ItemGroup[] {});
	}

	@Override
	public void makeArchExBlocks(BlockType type, BlockGroup... groups) {
		for (BlockGroup group : groups) { group.forEach(groupedBlock -> DataGeneration.collect(type.register(groupedBlock, itemGroupsToModify))); }
	}
}
