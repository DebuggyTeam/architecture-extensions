package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.RecipeConfigurator;
import io.github.debuggyteam.architecture_extensions.api.TextureConfiguration;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public final class VanillaBlockGroups {
	public static final BlockGroup WOOD = BlockGroup.of(
		BlockGroup.GroupedBlock.builder(Blocks.OAK_LOG)
			.id(new Identifier("oak"))
			.textures(TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("oak")))
			.usesTablesaw()
			.mapColor(MapColor.WOOD)
			.build(),
		
		BlockGroup.GroupedBlock.builder(Blocks.SPRUCE_LOG)
			.id(new Identifier("spruce"))
			.textures(TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("spruce")))
			.usesTablesaw()
			.mapColor(MapColor.PODZOL)
			.build(),
		
		BlockGroup.GroupedBlock.builder(Blocks.BIRCH_LOG)
			.id(new Identifier("birch"))
			.textures(TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("birch")))
			.usesTablesaw()
			.mapColor(MapColor.SAND)
			.build(),
		
		BlockGroup.GroupedBlock.builder(Blocks.JUNGLE_LOG)
			.id(new Identifier("jungle"))
			.textures(TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("jungle")))
			.usesTablesaw()
			.mapColor(MapColor.DIRT)
			.build(),
		
		BlockGroup.GroupedBlock.builder(Blocks.ACACIA_LOG)
			.id(new Identifier("acacia"))
			.textures(TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("acacia")))
			.usesTablesaw()
			.mapColor(MapColor.ORANGE)
			.build(),
		
		BlockGroup.GroupedBlock.builder(Blocks.CHERRY_LOG)
			.id(new Identifier("cherry"))
			.textures(TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("cherry")))
			.usesTablesaw()
			.mapColor(MapColor.WHITE_TERRACOTTA)
			.build(),
		
		BlockGroup.GroupedBlock.builder(Blocks.DARK_OAK_LOG)
			.id(new Identifier("dark_oak"))
			.textures(TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("dark_oak")))
			.usesTablesaw()
			.mapColor(MapColor.BROWN)
			.build(),
		
		BlockGroup.GroupedBlock.builder(Blocks.MANGROVE_LOG)
			.id(new Identifier("mangrove"))
			.textures(TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("mangrove")))
			.usesTablesaw()
			.mapColor(MapColor.RED)
			.build(),
		
		BlockGroup.GroupedBlock.builder(Blocks.BAMBOO_PLANKS)
			.id(new Identifier("bamboo"))
			.textures((type, textureId) -> "minecraft:block/bamboo_planks")
			.usesTablesaw()
			.mapColor(MapColor.YELLOW)
			.build(),
			
		
		BlockGroup.GroupedBlock.builder(Blocks.CRIMSON_STEM)
			.id(new Identifier("crimson"))
			.textures(TextureConfiguration.WOOD_WITH_STEM.apply(new Identifier("crimson")))
			.usesTablesaw()
			.mapColor(MapColor.CRIMSON_STEM)
			.build(),
		
		BlockGroup.GroupedBlock.builder(Blocks.WARPED_STEM)
			.id(new Identifier("warped"))
			.textures(TextureConfiguration.WOOD_WITH_STEM.apply(new Identifier("warped")))
			.usesTablesaw()
			.mapColor(MapColor.WARPED_STEM)
			.build()
	);

	public static final BlockGroup STONE = BlockGroup.of(
		new BlockGroup.GroupedBlock("stone", Blocks.STONE, (type, textureId) -> "minecraft:block/stone", RecipeConfigurator.STONECUTTER, MapColor.STONE),
		new BlockGroup.GroupedBlock("granite", Blocks.GRANITE, (type, textureId) -> "minecraft:block/granite", RecipeConfigurator.STONECUTTER, MapColor.DIRT),
		new BlockGroup.GroupedBlock("diorite", Blocks.DIORITE, (type, textureId) -> "minecraft:block/diorite", RecipeConfigurator.STONECUTTER, MapColor.QUARTZ),
		new BlockGroup.GroupedBlock("andesite", Blocks.ANDESITE, (type, textureId) -> "minecraft:block/andesite", RecipeConfigurator.STONECUTTER, MapColor.STONE),
		new BlockGroup.GroupedBlock("calcite", Blocks.CALCITE, (type, textureId) -> "minecraft:block/calcite", RecipeConfigurator.STONECUTTER, MapColor.WHITE_TERRACOTTA),
		new BlockGroup.GroupedBlock("tuff", Blocks.TUFF, (type, textureId) -> "minecraft:block/tuff", RecipeConfigurator.STONECUTTER, MapColor.STONE),
		new BlockGroup.GroupedBlock("dripstone", Blocks.DRIPSTONE_BLOCK, (type, textureId) -> "minecraft:block/dripstone_block", RecipeConfigurator.STONECUTTER, MapColor.BROWN_TERRACOTTA),
		new BlockGroup.GroupedBlock("obsidian", Blocks.OBSIDIAN, (type, textureId) -> "minecraft:block/obsidian", RecipeConfigurator.STONECUTTER, MapColor.BLACK),
		new BlockGroup.GroupedBlock("deepslate", Blocks.DEEPSLATE, (type, textureId) -> "minecraft:block/deepslate", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE),
		new BlockGroup.GroupedBlock("sandstone", Blocks.SANDSTONE, TextureConfiguration.TOP_BOTTOM.apply(new Identifier("sandstone")), RecipeConfigurator.STONECUTTER, MapColor.SAND),
		new BlockGroup.GroupedBlock("red_sandstone", Blocks.RED_SANDSTONE, TextureConfiguration.TOP_BOTTOM.apply(new Identifier("red_sandstone")), RecipeConfigurator.STONECUTTER, MapColor.ORANGE),
		new BlockGroup.GroupedBlock("end_stone", Blocks.BASALT, (type, textureId) -> "minecraft:block/end_stone", RecipeConfigurator.STONECUTTER, MapColor.BLACK),
		new BlockGroup.GroupedBlock("blackstone", Blocks.BLACKSTONE, TextureConfiguration.TOP.apply(new Identifier("blackstone")), RecipeConfigurator.STONECUTTER, MapColor.BLACK),
		new BlockGroup.GroupedBlock("raw_iron", Blocks.RAW_IRON_BLOCK, (type, textureId) -> "minecraft:block/raw_iron_block", RecipeConfigurator.STONECUTTER, MapColor.RAW_IRON),
		new BlockGroup.GroupedBlock("raw_copper", Blocks.RAW_COPPER_BLOCK, (type, textureId) -> "minecraft:block/raw_copper_block", RecipeConfigurator.STONECUTTER, MapColor.ORANGE),
		new BlockGroup.GroupedBlock("raw_gold", Blocks.RAW_GOLD_BLOCK, (type, textureId) -> "minecraft:block/raw_gold_block", RecipeConfigurator.STONECUTTER, MapColor.GOLD)
	);

	public static final BlockGroup AQUATIC_STONE = BlockGroup.of(
		new BlockGroup.GroupedBlock("prismarine", Blocks.PRISMARINE, (type, textureId) -> "minecraft:block/prismarine", RecipeConfigurator.STONECUTTER, MapColor.CYAN),
		new BlockGroup.GroupedBlock("sea_lantern", Blocks.SEA_LANTERN, (type, textureId) -> "minecraft:block/sea_lantern", RecipeConfigurator.STONECUTTER, MapColor.QUARTZ)
	);

	public static final BlockGroup PROCESSED_STONE = BlockGroup.of(
		new BlockGroup.GroupedBlock("cobblestone", Blocks.COBBLESTONE, (type, textureId) -> "minecraft:block/cobblestone", RecipeConfigurator.STONECUTTER, MapColor.STONE),
		new BlockGroup.GroupedBlock("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE, (type, textureId) -> "minecraft:block/mossy_cobblestone", RecipeConfigurator.STONECUTTER, MapColor.STONE),
		new BlockGroup.GroupedBlock("cobbled_deepslate", Blocks.COBBLED_DEEPSLATE, (type, textureId) -> "minecraft:block/cobbled_deepslate", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE),
		new BlockGroup.GroupedBlock("polished_deepslate", Blocks.POLISHED_DEEPSLATE, (type, textureId) -> "minecraft:block/polished_deepslate", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE),
		new BlockGroup.GroupedBlock("polished_blackstone", Blocks.POLISHED_BLACKSTONE, (type, textureId) -> "minecraft:block/polished_blackstone", RecipeConfigurator.STONECUTTER, MapColor.BLACK)
	);

	public static final BlockGroup BRICK = BlockGroup.of(
		new BlockGroup.GroupedBlock("stone_brick", Blocks.STONE_BRICKS, (type, textureId) -> "minecraft:block/stone_bricks", RecipeConfigurator.STONECUTTER, MapColor.STONE),
		new BlockGroup.GroupedBlock("cracked_stone_brick", Blocks.CRACKED_STONE_BRICKS, (type, textureId) -> "minecraft:block/cracked_stone_bricks", RecipeConfigurator.STONECUTTER, MapColor.STONE),
		new BlockGroup.GroupedBlock("mossy_stone_brick", Blocks.MOSSY_STONE_BRICKS, (type, textureId) -> "minecraft:block/mossy_stone_bricks", RecipeConfigurator.STONECUTTER, MapColor.STONE),
		new BlockGroup.GroupedBlock("deepslate_brick", Blocks.DEEPSLATE_BRICKS, (type, textureId) -> "minecraft:block/deepslate_bricks", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE),
		new BlockGroup.GroupedBlock("cracked_deepslate_brick", Blocks.CRACKED_DEEPSLATE_BRICKS, (type, textureId) -> "minecraft:block/cracked_deepslate_bricks", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE),
		new BlockGroup.GroupedBlock("brick", Blocks.BRICKS, (type, textureId) -> "minecraft:block/bricks", RecipeConfigurator.STONECUTTER, MapColor.RED),
		new BlockGroup.GroupedBlock("mud_brick", Blocks.MUD_BRICKS, (type, textureId) -> "minecraft:block/mud_bricks", RecipeConfigurator.STONECUTTER, MapColor.LIGHT_GRAY_TERRACOTTA),
		new BlockGroup.GroupedBlock("prismarine_brick", Blocks.PRISMARINE_BRICKS, (type, textureId) -> "minecraft:block/prismarine_bricks", RecipeConfigurator.STONECUTTER, MapColor.DIAMOND),
		new BlockGroup.GroupedBlock("nether_brick", Blocks.NETHER_BRICKS, (type, textureId) -> "minecraft:block/nether_bricks", RecipeConfigurator.STONECUTTER, MapColor.NETHER),
		new BlockGroup.GroupedBlock("cracked_nether_brick", Blocks.CRACKED_NETHER_BRICKS, (type, textureId) -> "minecraft:block/cracked_nether_bricks", RecipeConfigurator.STONECUTTER, MapColor.NETHER),
		new BlockGroup.GroupedBlock("red_nether_brick", Blocks.RED_NETHER_BRICKS, (type, textureId) -> "minecraft:block/red_nether_bricks", RecipeConfigurator.STONECUTTER, MapColor.NETHER),
		new BlockGroup.GroupedBlock("polished_blackstone_brick", Blocks.POLISHED_BLACKSTONE_BRICKS, (type, textureId) -> "minecraft:block/polished_blackstone_bricks", RecipeConfigurator.STONECUTTER, MapColor.BLACK),
		new BlockGroup.GroupedBlock("cracked_polished_blackstone_brick", Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, (type, textureId) -> "minecraft:block/cracked_polished_blackstone_bricks", RecipeConfigurator.STONECUTTER, MapColor.BLACK),
		new BlockGroup.GroupedBlock("end_stone_brick", Blocks.END_STONE_BRICKS, (type, textureId) -> "minecraft:block/end_stone_bricks", RecipeConfigurator.STONECUTTER, MapColor.SAND)
	);

	public static final BlockGroup TILE = BlockGroup.of(
		new BlockGroup.GroupedBlock("deepslate_tile", Blocks.DEEPSLATE_TILES, (type, textureId) -> "minecraft:block/deepslate_tiles", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE),
		new BlockGroup.GroupedBlock("cracked_deepslate_tile", Blocks.CRACKED_DEEPSLATE_TILES, (type, textureId) -> "minecraft:block/cracked_deepslate_tiles", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE),
		new BlockGroup.GroupedBlock("dark_prismarine", Blocks.DARK_PRISMARINE, (type, textureId) -> "minecraft:block/dark_prismarine", RecipeConfigurator.STONECUTTER, MapColor.DIAMOND),
		new BlockGroup.GroupedBlock("purpur", Blocks.PURPUR_BLOCK, (type, textureId) -> "minecraft:block/purpur_block", RecipeConfigurator.STONECUTTER, MapColor.MAGENTA)
	);

	public static final BlockGroup CRYSTAL = BlockGroup.of(
		new BlockGroup.GroupedBlock("quartz", Blocks.QUARTZ_BLOCK, TextureConfiguration.SIDED.apply(new Identifier("quartz_block")), RecipeConfigurator.STONECUTTER, MapColor.QUARTZ),
		new BlockGroup.GroupedBlock("smooth_quartz", Blocks.SMOOTH_QUARTZ, (type, textureId) -> "minecraft:block/quartz_block_bottom", RecipeConfigurator.STONECUTTER, MapColor.QUARTZ)
	);

	public static final BlockGroup TERRACOTTA = BlockGroup.of(
		new BlockGroup.GroupedBlock("terracotta", Blocks.TERRACOTTA, (type, textureId) -> "minecraft:block/terracotta", RecipeConfigurator.STONECUTTER, MapColor.ORANGE),
		new BlockGroup.GroupedBlock("white_terracotta", Blocks.WHITE_TERRACOTTA, (type, textureId) -> "minecraft:block/white_terracotta", RecipeConfigurator.STONECUTTER, MapColor.WHITE_TERRACOTTA),
		new BlockGroup.GroupedBlock("light_gray_terracotta", Blocks.LIGHT_GRAY_TERRACOTTA, (type, textureId) -> "minecraft:block/light_gray_terracotta", RecipeConfigurator.STONECUTTER, MapColor.LIGHT_GRAY_TERRACOTTA),
		new BlockGroup.GroupedBlock("gray_terracotta", Blocks.GRAY_TERRACOTTA, (type, textureId) -> "minecraft:block/gray_terracotta", RecipeConfigurator.STONECUTTER, MapColor.GRAY_TERRACOTTA),
		new BlockGroup.GroupedBlock("black_terracotta", Blocks.BLACK_TERRACOTTA, (type, textureId) -> "minecraft:block/black_terracotta", RecipeConfigurator.STONECUTTER, MapColor.BLACK_TERRACOTTA),
		new BlockGroup.GroupedBlock("brown_terracotta", Blocks.BROWN_TERRACOTTA, (type, textureId) -> "minecraft:block/brown_terracotta", RecipeConfigurator.STONECUTTER, MapColor.BROWN_TERRACOTTA),
		new BlockGroup.GroupedBlock("red_terracotta", Blocks.RED_TERRACOTTA, (type, textureId) -> "minecraft:block/red_terracotta", RecipeConfigurator.STONECUTTER, MapColor.RED_TERRACOTTA),
		new BlockGroup.GroupedBlock("orange_terracotta", Blocks.ORANGE_TERRACOTTA, (type, textureId) -> "minecraft:block/orange_terracotta", RecipeConfigurator.STONECUTTER, MapColor.ORANGE_TERRACOTTA),
		new BlockGroup.GroupedBlock("yellow_terracotta", Blocks.YELLOW_TERRACOTTA, (type, textureId) -> "minecraft:block/yellow_terracotta", RecipeConfigurator.STONECUTTER, MapColor.YELLOW_TERRACOTTA),
		new BlockGroup.GroupedBlock("lime_terracotta", Blocks.LIME_TERRACOTTA, (type, textureId) -> "minecraft:block/lime_terracotta", RecipeConfigurator.STONECUTTER, MapColor.LIME_TERRACOTTA),
		new BlockGroup.GroupedBlock("green_terracotta", Blocks.GREEN_TERRACOTTA, (type, textureId) -> "minecraft:block/green_terracotta", RecipeConfigurator.STONECUTTER, MapColor.GREEN_TERRACOTTA),
		new BlockGroup.GroupedBlock("cyan_terracotta", Blocks.CYAN_TERRACOTTA, (type, textureId) -> "minecraft:block/cyan_terracotta", RecipeConfigurator.STONECUTTER, MapColor.CYAN_TERRACOTTA),
		new BlockGroup.GroupedBlock("light_blue_terracotta", Blocks.LIGHT_BLUE_TERRACOTTA, (type, textureId) -> "minecraft:block/light_blue_terracotta", RecipeConfigurator.STONECUTTER, MapColor.LIGHT_BLUE_TERRACOTTA),
		new BlockGroup.GroupedBlock("blue_terracotta", Blocks.BLUE_TERRACOTTA, (type, textureId) -> "minecraft:block/blue_terracotta", RecipeConfigurator.STONECUTTER, MapColor.BLUE_TERRACOTTA),
		new BlockGroup.GroupedBlock("purple_terracotta", Blocks.PURPLE_TERRACOTTA, (type, textureId) -> "minecraft:block/purple_terracotta", RecipeConfigurator.STONECUTTER, MapColor.PURPLE_TERRACOTTA),
		new BlockGroup.GroupedBlock("magenta_terracotta", Blocks.MAGENTA_TERRACOTTA, (type, textureId) -> "minecraft:block/magenta_terracotta", RecipeConfigurator.STONECUTTER, MapColor.MAGENTA_TERRACOTTA),
		new BlockGroup.GroupedBlock("pink_terracotta", Blocks.PINK_TERRACOTTA, (type, textureId) -> "minecraft:block/pink_terracotta", RecipeConfigurator.STONECUTTER, MapColor.PINK_TERRACOTTA)
	);

	public static final BlockGroup CONCRETE = BlockGroup.of(
		new BlockGroup.GroupedBlock("white_concrete", Blocks.WHITE_CONCRETE, (type, textureId) -> "minecraft:block/white_concrete", RecipeConfigurator.STONECUTTER, DyeColor.WHITE.getMapColor()),
		new BlockGroup.GroupedBlock("light_gray_concrete", Blocks.LIGHT_GRAY_CONCRETE, (type, textureId) -> "minecraft:block/light_gray_concrete", RecipeConfigurator.STONECUTTER, DyeColor.LIGHT_GRAY.getMapColor()),
		new BlockGroup.GroupedBlock("gray_concrete", Blocks.GRAY_CONCRETE, (type, textureId) -> "minecraft:block/gray_concrete", RecipeConfigurator.STONECUTTER, DyeColor.GRAY.getMapColor()),
		new BlockGroup.GroupedBlock("black_concrete", Blocks.BLACK_CONCRETE, (type, textureId) -> "minecraft:block/black_concrete", RecipeConfigurator.STONECUTTER, DyeColor.BLACK.getMapColor()),
		new BlockGroup.GroupedBlock("brown_concrete", Blocks.BROWN_CONCRETE, (type, textureId) -> "minecraft:block/brown_concrete", RecipeConfigurator.STONECUTTER, DyeColor.BROWN.getMapColor()),
		new BlockGroup.GroupedBlock("red_concrete", Blocks.RED_CONCRETE, (type, textureId) -> "minecraft:block/red_concrete", RecipeConfigurator.STONECUTTER, DyeColor.RED.getMapColor()),
		new BlockGroup.GroupedBlock("orange_concrete", Blocks.ORANGE_CONCRETE, (type, textureId) -> "minecraft:block/orange_concrete", RecipeConfigurator.STONECUTTER, DyeColor.ORANGE.getMapColor()),
		new BlockGroup.GroupedBlock("yellow_concrete", Blocks.YELLOW_CONCRETE, (type, textureId) -> "minecraft:block/yellow_concrete", RecipeConfigurator.STONECUTTER, DyeColor.YELLOW.getMapColor()),
		new BlockGroup.GroupedBlock("lime_concrete", Blocks.LIME_CONCRETE, (type, textureId) -> "minecraft:block/lime_concrete", RecipeConfigurator.STONECUTTER, DyeColor.LIME.getMapColor()),
		new BlockGroup.GroupedBlock("green_concrete", Blocks.GREEN_CONCRETE, (type, textureId) -> "minecraft:block/green_concrete", RecipeConfigurator.STONECUTTER, DyeColor.GREEN.getMapColor()),
		new BlockGroup.GroupedBlock("cyan_concrete", Blocks.CYAN_CONCRETE, (type, textureId) -> "minecraft:block/cyan_concrete", RecipeConfigurator.STONECUTTER, DyeColor.CYAN.getMapColor()),
		new BlockGroup.GroupedBlock("light_blue_concrete", Blocks.LIGHT_BLUE_CONCRETE, (type, textureId) -> "minecraft:block/light_blue_concrete", RecipeConfigurator.STONECUTTER, DyeColor.LIGHT_BLUE.getMapColor()),
		new BlockGroup.GroupedBlock("blue_concrete", Blocks.BLUE_CONCRETE, (type, textureId) -> "minecraft:block/blue_concrete", RecipeConfigurator.STONECUTTER, DyeColor.BLUE.getMapColor()),
		new BlockGroup.GroupedBlock("purple_concrete", Blocks.PURPLE_CONCRETE, (type, textureId) -> "minecraft:block/purple_concrete", RecipeConfigurator.STONECUTTER, DyeColor.PURPLE.getMapColor()),
		new BlockGroup.GroupedBlock("magenta_concrete", Blocks.MAGENTA_CONCRETE, (type, textureId) -> "minecraft:block/magenta_concrete", RecipeConfigurator.STONECUTTER, DyeColor.MAGENTA.getMapColor()),
		new BlockGroup.GroupedBlock("pink_concrete", Blocks.PINK_CONCRETE, (type, textureId) -> "minecraft:block/pink_concrete", RecipeConfigurator.STONECUTTER, DyeColor.PINK.getMapColor())
	);
}
