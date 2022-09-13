package io.github.woodiertexas.architecture_extensions;

import io.github.woodiertexas.architecture_extensions.api.ArchExIntegration;
import io.github.woodiertexas.architecture_extensions.api.BlockGroup;
import io.github.woodiertexas.architecture_extensions.api.BlockType;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;

public class VanillaIntegration implements ArchExIntegration {
	public static final VanillaIntegration INSTANCE = new VanillaIntegration();

	private static final BlockGroup BAMBOO_ROD = BlockGroup.of(new BlockGroup.Block("bamboo", Blocks.BAMBOO, (type, textureId) -> "minecraft:block/bamboo_stalk"));
	private static final BlockGroup COPPER_ROD = BlockGroup.of(new BlockGroup.Block("copper", Blocks.LIGHTNING_ROD, (type, textureId) -> "architecture_extensions:/block/copper_rod"));
	private static final BlockGroup IRON_ROD = BlockGroup.of(new BlockGroup.Block("iron", Blocks.IRON_BARS, (type, textureId) -> "minecraft:block/iron_bars"));

	@Override
	public void integrate(Context ctx) {
		ctx.makeArchExBlocks(BlockType.ARCH, BlockGroup.STONE, BlockGroup.AQUATIC_STONE, BlockGroup.PROCESSED_STONE, BlockGroup.BRICK, BlockGroup.TILE, BlockGroup.CRYSTAL);
		ctx.makeArchExBlocks(BlockType.BEAM, BlockGroup.WOOD);
		ctx.makeArchExBlocks(BlockType.COLUMN, BlockGroup.STONE, BlockGroup.AQUATIC_STONE, BlockGroup.PROCESSED_STONE, BlockGroup.BRICK, BlockGroup.TILE, BlockGroup.CRYSTAL);
		ctx.makeArchExBlocks(BlockType.FENCE_POST, BlockGroup.WOOD);
		ctx.makeArchExBlocks(BlockType.JOIST, BlockGroup.WOOD);
		ctx.makeArchExBlocks(BlockType.MOLDING, BlockGroup.WOOD);
		ctx.makeArchExBlocks(BlockType.POST_CAP, BlockGroup.WOOD);
		ctx.makeArchExBlocks(BlockType.POST_LANTERN, BlockGroup.WOOD);
		ctx.makeArchExBlocks(BlockType.ROD, BAMBOO_ROD, COPPER_ROD, IRON_ROD);
		ctx.makeArchExBlocks(BlockType.ROOF, BlockGroup.STONE, BlockGroup.PROCESSED_STONE, BlockGroup.BRICK, BlockGroup.TILE, BlockGroup.CRYSTAL);
		ctx.makeArchExBlocks(BlockType.WALL_POST, BlockGroup.STONE, BlockGroup.AQUATIC_STONE, BlockGroup.PROCESSED_STONE, BlockGroup.BRICK, BlockGroup.TILE, BlockGroup.CRYSTAL);
	}

	@Override
	public ItemGroup itemGroup() {
		return ItemGroup.DECORATIONS;
	}
}
