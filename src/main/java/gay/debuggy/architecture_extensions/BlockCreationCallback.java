package gay.debuggy.architecture_extensions;

import gay.debuggy.architecture_extensions.api.BlockGroup;
import gay.debuggy.architecture_extensions.api.BlockShape;
import net.minecraft.block.Block;

@FunctionalInterface
public interface BlockCreationCallback {
	public void onBlockCreated(BlockGroup group, BlockShape blockType,  Block base, Block created);
}
