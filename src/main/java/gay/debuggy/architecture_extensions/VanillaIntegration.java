package gay.debuggy.architecture_extensions;

import gay.debuggy.architecture_extensions.api.ArchExIntegration;
import gay.debuggy.architecture_extensions.api.BlockGroup;
import gay.debuggy.architecture_extensions.api.BlockShape;
import gay.debuggy.architecture_extensions.api.RecipeConfigurator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;

public class VanillaIntegration implements ArchExIntegration {
	public static final VanillaIntegration INSTANCE = new VanillaIntegration();

	private static final BlockGroup BAMBOO_ROD = BlockGroup.of(new BlockGroup.GroupedBlock("bamboo", Blocks.BAMBOO, (type, textureId) -> "minecraft:block/bamboo_stalk", RecipeConfigurator.simple("bamboo_rod"), MapColor.PLANT));
	private static final BlockGroup COPPER_ROD = BlockGroup.of(new BlockGroup.GroupedBlock("copper", Blocks.LIGHTNING_ROD, (type, textureId) -> "architecture_extensions:block/copper_rod", RecipeConfigurator.simple("copper_rod"), MapColor.ORANGE));
	private static final BlockGroup IRON_ROD = BlockGroup.of(new BlockGroup.GroupedBlock("iron", Blocks.IRON_BARS, (type, textureId) -> "minecraft:block/iron_bars", RecipeConfigurator.simple("iron_rod")));
	private static final BlockGroup IRON_H_BEAM = BlockGroup.of(new BlockGroup.GroupedBlock("iron", Blocks.IRON_BLOCK, (type, textureId) -> "architecture_extensions:block/iron_square_tube", RecipeConfigurator.CRAFTING, MapColor.METAL));
	
	
	private static final BlockGroup SQUARE_TUBE = BlockGroup.of(
			new BlockGroup.GroupedBlock("iron", Blocks.IRON_BLOCK, (type, textureId) -> {
				return switch (textureId) {
					case "texture_up" -> "architecture_extensions:block/iron_square_tube_top";
					default -> "architecture_extensions:block/iron_square_tube";
				};
			}, RecipeConfigurator.CRAFTING, MapColor.METAL),
			new BlockGroup.GroupedBlock("copper", Blocks.COPPER_BLOCK, (type, textureId) -> {
				return switch (textureId) {
					case "texture_up" -> "architecture_extensions:block/copper_square_tube_top";
					default -> "architecture_extensions:block/copper_square_tube";
				};
			}, RecipeConfigurator.CRAFTING, MapColor.METAL)
	);

	@Override
	public void integrate(Context ctx) {
		ctx.makeArchExBlocks(BlockShape.ARCH, 
			VanillaBlockGroups.STONE, VanillaBlockGroups.AQUATIC_STONE, VanillaBlockGroups.PROCESSED_STONE, 
			VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE, VanillaBlockGroups.CRYSTAL
		);

		ctx.makeArchExBlocks(BlockShape.CURVE,
			VanillaBlockGroups.WOOD, VanillaBlockGroups.STONE, VanillaBlockGroups.AQUATIC_STONE,
			VanillaBlockGroups.PROCESSED_STONE, VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE,
			VanillaBlockGroups.CRYSTAL
		);

		ctx.makeArchExBlocks(BlockShape.PILASTER, 
			VanillaBlockGroups.STONE, VanillaBlockGroups.AQUATIC_STONE, VanillaBlockGroups.PROCESSED_STONE, 
			VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE, VanillaBlockGroups.CRYSTAL
		);

		ctx.makeArchExBlocks(BlockShape.ROOF, 
			VanillaBlockGroups.STONE, VanillaBlockGroups.PROCESSED_STONE,
			VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE, VanillaBlockGroups.CRYSTAL
		);

		ctx.makeArchExBlocks(BlockShape.WALL_POST, 
			VanillaBlockGroups.STONE, VanillaBlockGroups.AQUATIC_STONE, VanillaBlockGroups.PROCESSED_STONE, 
			VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE, VanillaBlockGroups.CRYSTAL
		);

		ctx.makeArchExBlocks(BlockShape.FACADE,
			VanillaBlockGroups.WOOD, VanillaBlockGroups.STONE,
			VanillaBlockGroups.AQUATIC_STONE, VanillaBlockGroups.PROCESSED_STONE,
			VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE, VanillaBlockGroups.CRYSTAL,
			VanillaBlockGroups.TERRACOTTA, VanillaBlockGroups.CONCRETE, VanillaBlockGroups.GLASS,
			VanillaBlockGroups.POWDER
		);
		
		ctx.makeArchExBlocks(BlockShape.ROUND_FENCE_POST,
			VanillaBlockGroups.WOOD, VanillaBlockGroups.STONE, VanillaBlockGroups.AQUATIC_STONE,
			VanillaBlockGroups.PROCESSED_STONE, VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE,
			VanillaBlockGroups.CRYSTAL
		);
		
		ctx.makeArchExBlocks(BlockShape.ROUND_ARCH,
			VanillaBlockGroups.WOOD, VanillaBlockGroups.STONE, VanillaBlockGroups.AQUATIC_STONE,
			VanillaBlockGroups.PROCESSED_STONE, VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE,
			VanillaBlockGroups.CRYSTAL
		);
		
		ctx.makeArchExBlocks(BlockShape.OCTAGONAL_COLUMN,
			VanillaBlockGroups.WOOD, VanillaBlockGroups.STONE, VanillaBlockGroups.AQUATIC_STONE,
			VanillaBlockGroups.PROCESSED_STONE, VanillaBlockGroups.BRICK, VanillaBlockGroups.TILE,
			VanillaBlockGroups.CRYSTAL
		);

		ctx.makeArchExBlocks(BlockShape.BEAM, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockShape.FENCE_POST, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockShape.JOIST, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockShape.CROWN_MOLDING, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockShape.POST_CAP, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockShape.POST_LANTERN, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockShape.ROD, BAMBOO_ROD, COPPER_ROD, IRON_ROD);
		ctx.makeArchExBlocks(BlockShape.LATTICE, VanillaBlockGroups.WOOD);
		ctx.makeArchExBlocks(BlockShape.TRANSOM, VanillaBlockGroups.WOOD);
		
		ctx.makeArchExBlocks(BlockShape.SQUARE_TUBE, SQUARE_TUBE);
		ctx.makeArchExBlocks(BlockShape.I_BEAM, SQUARE_TUBE);
		ctx.makeArchExBlocks(BlockShape.H_BEAM, IRON_H_BEAM);
	}

	@Override
	public void onBlockCreated(BlockGroup group, BlockShape blockType, Block baseBlock, Block block) {
		ItemGroupUtil.pull(ArchitectureExtensions.ITEM_GROUP, blockType, baseBlock, block.asItem());
	}
}
