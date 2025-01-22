package gay.debuggy.architecture_extensions;

import gay.debuggy.architecture_extensions.api.BlockGroup;
import gay.debuggy.architecture_extensions.api.BlockType;
import net.minecraft.block.Block;

@FunctionalInterface
public interface BlockCreationCallback {
	public void onBlockCreated(BlockGroup group, BlockType blockType,  Block base, Block created);
}
