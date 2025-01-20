package gay.debuggy.architecture_extensions;

import gay.debuggy.architecture_extensions.blocks.BeamBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ArchExBlocks {
	private static <T extends Block> T registerBlock(String path, T block) {
		Registry.register(Registries.BLOCK, Identifier.of(ArchitectureExtensions.MOD_ID, path), block);
		Registry.register(Registries.ITEM, Identifier.of(ArchitectureExtensions.MOD_ID, path), new BlockItem(block, new Item.Settings()));
		return block;
	}
	
	public static final BeamBlock BIRCH_BEAM = registerBlock("birch_beam", new BeamBlock(Block.Settings.copy(Blocks.BIRCH_LOG)));
	
	public static void init() {}
}
