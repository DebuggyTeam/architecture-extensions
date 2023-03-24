package io.github.debuggyteam.architecture_extensions;

import java.util.Set;

import com.google.common.collect.Sets;

import io.github.debuggyteam.architecture_extensions.api.ArchExIntegration;
import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import io.github.debuggyteam.architecture_extensions.resource.DataGeneration;
import net.minecraft.item.ItemGroup;

public class ArchExIntegrationContextImpl implements ArchExIntegration.Context {
	private final ArchExIntegration integration;

	private final Set<ItemGroup> itemGroupsToModify = Sets.newHashSet();

	public ArchExIntegrationContextImpl(ArchExIntegration integration) {
		this.integration = integration;
		this.integration.itemGroups(itemGroupsToModify::add);
	}

	@Override
	public void makeArchExBlocks(BlockType type, BlockGroup... groups) {
		for (BlockGroup group : groups) { group.forEach(groupedBlock -> DataGeneration.collect(type.register(groupedBlock, itemGroupsToModify))); }
	}
}
