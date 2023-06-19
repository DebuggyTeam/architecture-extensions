package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.api.ArchExIntegration;
import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import io.github.debuggyteam.architecture_extensions.api.RecipeConfigurator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;

public class VanillaIntegration implements ArchExIntegration {
	public static final VanillaIntegration INSTANCE = new VanillaIntegration();

	private static final BlockGroup BAMBOO_ROD = BlockGroup.of(new BlockGroup.GroupedBlock("bamboo", Blocks.BAMBOO, (type, textureId) -> "minecraft:block/bamboo_stalk", RecipeConfigurator.simple("bamboo_rod"), MapColor.PLANT));
	private static final BlockGroup COPPER_ROD = BlockGroup.of(new BlockGroup.GroupedBlock("copper", Blocks.LIGHTNING_ROD, (type, textureId) -> "architecture_extensions:block/copper_rod", RecipeConfigurator.simple("copper_rod"), MapColor.ORANGE));
	private static final BlockGroup IRON_ROD = BlockGroup.of(new BlockGroup.GroupedBlock("iron", Blocks.IRON_BARS, (type, textureId) -> "minecraft:block/iron_bars", RecipeConfigurator.simple("iron_rod")));
	private static final BlockGroup IRON_H_BEAM = BlockGroup.of(new BlockGroup.GroupedBlock("iron", Blocks.ANVIL, (type, textureId) -> "architecture_extensions:block/tube_steel", RecipeConfigurator.simple("iron_h_beam"), MapColor.METAL));

	private static final BlockGroup TUBE_STEEL = BlockGroup.of(new BlockGroup.GroupedBlock("iron", Blocks.ANVIL, (type, textureId) -> {
		return switch (textureId) {
			case "texture_top" -> "architecture_extensions:block/tube_steel_top";
			default -> "architecture_extensions:block/tube_steel";
		};
	}, RecipeConfigurator.simple("iron_tube_steel"), MapColor.METAL));

	@Override
	public void integrate(Context ctx) {
		ctx.makeArchExBlocks(
			BlockType.ARCH, VanillaBlockGroups.STONE, VanillaBlockGroups.AQUATIC_STONE,
			VanillaBlockGroups.PROCESSED_STONE, VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE,
			VanillaBlockGroups.CRYSTAL
		);

		ctx.makeArchExBlocks(
			BlockType.WALL_COLUMN, VanillaBlockGroups.STONE, VanillaBlockGroups.AQUATIC_STONE,
			VanillaBlockGroups.PROCESSED_STONE, VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE,
			VanillaBlockGroups.CRYSTAL
		);

		ctx.makeArchExBlocks(
			BlockType.ROOF, VanillaBlockGroups.STONE, VanillaBlockGroups.PROCESSED_STONE,
			VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE, VanillaBlockGroups.CRYSTAL
		);

		ctx.makeArchExBlocks(
			BlockType.WALL_POST, VanillaBlockGroups.STONE, VanillaBlockGroups.AQUATIC_STONE,
			VanillaBlockGroups.PROCESSED_STONE, VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE,
			VanillaBlockGroups.CRYSTAL
		);

		ctx.makeArchExBlocks(
			BlockType.FACADE, VanillaBlockGroups.WOOD, VanillaBlockGroups.STONE,
			VanillaBlockGroups.AQUATIC_STONE, VanillaBlockGroups.PROCESSED_STONE,
			VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE, VanillaBlockGroups.CRYSTAL,
			VanillaBlockGroups.TERRACOTTA, VanillaBlockGroups.CONCRETE
		);
		
		ctx.makeArchExBlocks(
				BlockType.OCTOGONAL_COLUMN, VanillaBlockGroups.WOOD, VanillaBlockGroups.STONE,
				VanillaBlockGroups.AQUATIC_STONE, VanillaBlockGroups.PROCESSED_STONE,
				VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE, VanillaBlockGroups.CRYSTAL,
				VanillaBlockGroups.TERRACOTTA, VanillaBlockGroups.CONCRETE
		);

		ctx.makeArchExBlocks(BlockType.BEAM, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockType.FENCE_POST, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockType.JOIST, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockType.CROWN_MOLDING, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockType.POST_CAP, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockType.POST_LANTERN, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockType.ROD, BAMBOO_ROD, COPPER_ROD, IRON_ROD);
		ctx.makeArchExBlocks(BlockType.LATTICE, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockType.TUBE_STEEL, TUBE_STEEL);
		ctx.makeArchExBlocks(BlockType.TRANSOM, VanillaBlockGroups.WOOD);

		ctx.makeArchExBlocks(BlockType.I_BEAM, TUBE_STEEL);
		ctx.makeArchExBlocks(BlockType.H_BEAM, IRON_H_BEAM);
	}

	@Override
	public void onBlockCreated(BlockGroup group, BlockType blockType, Block baseBlock, Block block) {
		ItemGroupUtil.pull(ArchitectureExtensions.ITEM_GROUP, blockType, baseBlock, block.asItem());
	}
}
