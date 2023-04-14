package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import net.minecraft.block.Block;

@FunctionalInterface
public interface BlockCreationCallback {
	public void onBlockCreated(BlockGroup group, BlockType blockType,  Block base, Block created);
}