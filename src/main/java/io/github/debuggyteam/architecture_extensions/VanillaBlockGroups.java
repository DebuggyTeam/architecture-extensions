package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.RecipeConfigurator;
import io.github.debuggyteam.architecture_extensions.api.TextureConfiguration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.util.Identifier;

public final class VanillaBlockGroups {
	public static final BlockGroup WOOD = BlockGroup.of(
			new BlockGroup.GroupedBlock("oak", Blocks.OAK_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("oak")), RecipeConfigurator.SAWING, MapColor.OAK_TAN),
			new BlockGroup.GroupedBlock("spruce", Blocks.SPRUCE_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("spruce")), RecipeConfigurator.SAWING, MapColor.SPRUCE_BROWN),
			new BlockGroup.GroupedBlock("birch", Blocks.BIRCH_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("birch")), RecipeConfigurator.SAWING, MapColor.PALE_YELLOW),
			new BlockGroup.GroupedBlock("jungle", Blocks.JUNGLE_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("jungle")), RecipeConfigurator.SAWING, MapColor.DIRT_BROWN),
			new BlockGroup.GroupedBlock("acacia", Blocks.ACACIA_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("acacia")), RecipeConfigurator.SAWING, MapColor.ORANGE),
			new BlockGroup.GroupedBlock("dark_oak", Blocks.DARK_OAK_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("dark_oak")), RecipeConfigurator.SAWING, MapColor.BROWN),
			new BlockGroup.GroupedBlock("mangrove", Blocks.MANGROVE_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("mangrove")), RecipeConfigurator.SAWING, MapColor.RED),
			new BlockGroup.GroupedBlock("crimson", Blocks.CRIMSON_STEM, TextureConfiguration.WOOD_WITH_STEM.apply(new Identifier("crimson")), RecipeConfigurator.SAWING, MapColor.DULL_PINK),
			new BlockGroup.GroupedBlock("warped", Blocks.WARPED_STEM, TextureConfiguration.WOOD_WITH_STEM.apply(new Identifier("warped")), RecipeConfigurator.SAWING, MapColor.DARK_AQUA)
	);

	public static final BlockGroup STONE = BlockGroup.of(
			new BlockGroup.GroupedBlock("stone", Blocks.STONE, (type, textureId) -> "minecraft:block/stone", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
			new BlockGroup.GroupedBlock("granite", Blocks.GRANITE, (type, textureId) -> "minecraft:block/granite", RecipeConfigurator.STONECUTTER, MapColor.DIRT_BROWN),
			new BlockGroup.GroupedBlock("diorite", Blocks.DIORITE, (type, textureId) -> "minecraft:block/diorite", RecipeConfigurator.STONECUTTER, MapColor.OFF_WHITE),
			new BlockGroup.GroupedBlock("andesite", Blocks.ANDESITE, (type, textureId) -> "minecraft:block/andesite", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
			new BlockGroup.GroupedBlock("calcite", Blocks.CALCITE, (type, textureId) -> "minecraft:block/calcite", RecipeConfigurator.STONECUTTER, MapColor.WHITE_GRAY),
			new BlockGroup.GroupedBlock("tuff", Blocks.TUFF, (type, textureId) -> "minecraft:block/tuff", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
			new BlockGroup.GroupedBlock("dripstone", Blocks.DRIPSTONE_BLOCK, (type, textureId) -> "minecraft:block/dripstone_block", RecipeConfigurator.STONECUTTER, MapColor.BROWN),
			new BlockGroup.GroupedBlock("obsidian", Blocks.OBSIDIAN, (type, textureId) -> "minecraft:block/obsidian", RecipeConfigurator.STONECUTTER, MapColor.PURPLE),
			new BlockGroup.GroupedBlock("deepslate", Blocks.DEEPSLATE, (type, textureId) -> "minecraft:block/deepslate", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
			new BlockGroup.GroupedBlock("sandstone", Blocks.SANDSTONE, TextureConfiguration.TOP_BOTTOM.apply(new Identifier("sandstone")), RecipeConfigurator.STONECUTTER, MapColor.PALE_YELLOW),
			new BlockGroup.GroupedBlock("red_sandstone", Blocks.RED_SANDSTONE, TextureConfiguration.TOP_BOTTOM.apply(new Identifier("red_sandstone")), RecipeConfigurator.STONECUTTER, MapColor.ORANGE),
			new BlockGroup.GroupedBlock("end_stone", Blocks.BASALT, (type, textureId) -> "minecraft:block/end_stone", RecipeConfigurator.STONECUTTER, MapColor.OFF_WHITE),
			new BlockGroup.GroupedBlock("blackstone", Blocks.BLACKSTONE, TextureConfiguration.TOP.apply(new Identifier("blackstone")), RecipeConfigurator.STONECUTTER, MapColor.BLACK)
	);

	public static final BlockGroup AQUATIC_STONE = BlockGroup.of(
			new BlockGroup.GroupedBlock("prismarine", Blocks.PRISMARINE, (type, textureId) -> "minecraft:block/prismarine", RecipeConfigurator.STONECUTTER, MapColor.CYAN)
	);

	public static final BlockGroup PROCESSED_STONE = BlockGroup.of(
			new BlockGroup.GroupedBlock("cobblestone", Blocks.COBBLESTONE, (type, textureId) -> "minecraft:block/cobblestone", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
			new BlockGroup.GroupedBlock("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE, (type, textureId) -> "minecraft:block/mossy_cobblestone", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
			new BlockGroup.GroupedBlock("cobbled_deepslate", Blocks.COBBLED_DEEPSLATE, (type, textureId) -> "minecraft:block/cobbled_deepslate", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE_GRAY),
			new BlockGroup.GroupedBlock("polished_deepslate", Blocks.POLISHED_DEEPSLATE, (type, textureId) -> "minecraft:block/polished_deepslate", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE_GRAY),
			new BlockGroup.GroupedBlock("polished_blackstone", Blocks.POLISHED_BLACKSTONE, (type, textureId) -> "minecraft:block/polished_blackstone", RecipeConfigurator.STONECUTTER, MapColor.BLACK)
	);

	public static final BlockGroup BRICK = BlockGroup.of(
			new BlockGroup.GroupedBlock("stone_brick", Blocks.STONE_BRICKS, (type, textureId) -> "minecraft:block/stone_bricks", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
			new BlockGroup.GroupedBlock("mossy_stone_brick", Blocks.MOSSY_STONE_BRICKS, (type, textureId) -> "minecraft:block/mossy_stone_bricks", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
			new BlockGroup.GroupedBlock("deepslate_brick", Blocks.DEEPSLATE_BRICKS, (type, textureId) -> "minecraft:block/deepslate_bricks", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE_GRAY),
			new BlockGroup.GroupedBlock("brick", Blocks.BRICKS, (type, textureId) -> "minecraft:block/bricks", RecipeConfigurator.STONECUTTER, MapColor.RED),
			new BlockGroup.GroupedBlock("mud_brick", Blocks.MUD_BRICKS, (type, textureId) -> "minecraft:block/mud_bricks", RecipeConfigurator.STONECUTTER, MapColor.BROWN),
			new BlockGroup.GroupedBlock("prismarine_brick", Blocks.PRISMARINE_BRICKS, (type, textureId) -> "minecraft:block/prismarine_bricks", RecipeConfigurator.STONECUTTER, MapColor.DIAMOND_BLUE),
			new BlockGroup.GroupedBlock("nether_brick", Blocks.NETHER_BRICKS, (type, textureId) -> "minecraft:block/nether_bricks", RecipeConfigurator.STONECUTTER, MapColor.DARK_RED),
			new BlockGroup.GroupedBlock("red_nether_brick", Blocks.RED_NETHER_BRICKS, (type, textureId) -> "minecraft:block/red_nether_bricks", RecipeConfigurator.STONECUTTER, MapColor.DARK_RED),
			new BlockGroup.GroupedBlock("polished_blackstone_brick", Blocks.POLISHED_BLACKSTONE_BRICKS, (type, textureId) -> "minecraft:block/polished_blackstone_bricks", RecipeConfigurator.STONECUTTER, MapColor.BLACK),
			new BlockGroup.GroupedBlock("end_stone_brick", Blocks.END_STONE_BRICKS, (type, textureId) -> "minecraft:block/end_stone_bricks", RecipeConfigurator.STONECUTTER, MapColor.PALE_YELLOW)
	);

	public static final BlockGroup TILE = BlockGroup.of(
			new BlockGroup.GroupedBlock("deepslate_tile", Blocks.DEEPSLATE_TILES, (type, textureId) -> "minecraft:block/deepslate_tiles", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE_GRAY),
			new BlockGroup.GroupedBlock("dark_prismarine", Blocks.DARK_PRISMARINE, (type, textureId) -> "minecraft:block/dark_prismarine", RecipeConfigurator.STONECUTTER, MapColor.DIAMOND_BLUE),
			new BlockGroup.GroupedBlock("purpur", Blocks.PURPUR_BLOCK, (type, textureId) -> "minecraft:block/purpur_block", RecipeConfigurator.STONECUTTER, MapColor.DULL_PINK)
	);

	public static final BlockGroup CRYSTAL = BlockGroup.of(
			new BlockGroup.GroupedBlock("quartz", Blocks.QUARTZ_BLOCK, TextureConfiguration.SIDED.apply(new Identifier("quartz_block")), RecipeConfigurator.STONECUTTER, MapColor.OFF_WHITE),
			new BlockGroup.GroupedBlock("smooth_quartz", Blocks.SMOOTH_QUARTZ, (type, textureId) -> "minecraft:block/quartz_block_bottom", RecipeConfigurator.STONECUTTER, MapColor.OFF_WHITE)
	);

	public static final BlockGroup TERRACOTTA = BlockGroup.of(
			new BlockGroup.GroupedBlock("terracotta", Blocks.TERRACOTTA, (type, textureId) -> "minecraft:block/terracotta", RecipeConfigurator.STONECUTTER, MapColor.OFF_WHITE),
			new BlockGroup.GroupedBlock("white_terracotta", Blocks.WHITE_TERRACOTTA, (type, textureId) -> "minecraft:block/white_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_WHITE),
			new BlockGroup.GroupedBlock("light_gray_terracotta", Blocks.LIGHT_GRAY_TERRACOTTA, (type, textureId) -> "minecraft:block/light_gray_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_GRAY),
			new BlockGroup.GroupedBlock("gray_terracotta", Blocks.GRAY_TERRACOTTA, (type, textureId) -> "minecraft:block/gray_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_GRAY),
			new BlockGroup.GroupedBlock("black_terracotta", Blocks.BLACK_TERRACOTTA, (type, textureId) -> "minecraft:block/black_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_BLACK),
			new BlockGroup.GroupedBlock("brown_terracotta", Blocks.BROWN_TERRACOTTA, (type, textureId) -> "minecraft:block/brown_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_BROWN),
			new BlockGroup.GroupedBlock("red_terracotta", Blocks.RED_TERRACOTTA, (type, textureId) -> "minecraft:block/red_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_RED),
			new BlockGroup.GroupedBlock("orange_terracotta", Blocks.ORANGE_TERRACOTTA, (type, textureId) -> "minecraft:block/orange_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_ORANGE),
			new BlockGroup.GroupedBlock("yellow_terracotta", Blocks.YELLOW_TERRACOTTA, (type, textureId) -> "minecraft:block/yellow_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_YELLOW),
			new BlockGroup.GroupedBlock("lime_terracotta", Blocks.LIME_TERRACOTTA, (type, textureId) -> "minecraft:block/lime_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_LIME),
			new BlockGroup.GroupedBlock("green_terracotta", Blocks.GREEN_TERRACOTTA, (type, textureId) -> "minecraft:block/green_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_GREEN),
			new BlockGroup.GroupedBlock("cyan_terracotta", Blocks.CYAN_TERRACOTTA, (type, textureId) -> "minecraft:block/cyan_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_CYAN),
			new BlockGroup.GroupedBlock("light_blue_terracotta", Blocks.LIGHT_BLUE_TERRACOTTA, (type, textureId) -> "minecraft:block/light_blue_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_LIGHT_BLUE),
			new BlockGroup.GroupedBlock("blue_terracotta", Blocks.BLUE_TERRACOTTA, (type, textureId) -> "minecraft:block/blue_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_BLUE),
			new BlockGroup.GroupedBlock("purple_terracotta", Blocks.PURPLE_TERRACOTTA, (type, textureId) -> "minecraft:block/purple_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_PURPLE),
			new BlockGroup.GroupedBlock("magenta_terracotta", Blocks.MAGENTA_TERRACOTTA, (type, textureId) -> "minecraft:block/magenta_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_MAGENTA),
			new BlockGroup.GroupedBlock("pink_terracotta", Blocks.PINK_TERRACOTTA, (type, textureId) -> "minecraft:block/pink_terracotta", RecipeConfigurator.STONECUTTER, MapColor.TERRACOTTA_PINK)
	);

	public static final BlockGroup CONCRETE = BlockGroup.of(
			new BlockGroup.GroupedBlock("white_concrete", Blocks.WHITE_CONCRETE, (type, textureId) -> "minecraft:block/white_concrete", RecipeConfigurator.STONECUTTER, MapColor.OFF_WHITE),
			new BlockGroup.GroupedBlock("light_gray_concrete", Blocks.LIGHT_GRAY_CONCRETE, (type, textureId) -> "minecraft:block/light_gray_concrete", RecipeConfigurator.STONECUTTER, MapColor.WHITE),
			new BlockGroup.GroupedBlock("gray_concrete", Blocks.GRAY_CONCRETE, (type, textureId) -> "minecraft:block/gray_concrete", RecipeConfigurator.STONECUTTER, MapColor.GRAY),
			new BlockGroup.GroupedBlock("black_concrete", Blocks.BLACK_CONCRETE, (type, textureId) -> "minecraft:block/black_concrete", RecipeConfigurator.STONECUTTER, MapColor.BLACK),
			new BlockGroup.GroupedBlock("brown_concrete", Blocks.BROWN_CONCRETE, (type, textureId) -> "minecraft:block/brown_concrete", RecipeConfigurator.STONECUTTER, MapColor.BROWN),
			new BlockGroup.GroupedBlock("red_concrete", Blocks.RED_CONCRETE, (type, textureId) -> "minecraft:block/red_concrete", RecipeConfigurator.STONECUTTER, MapColor.RED),
			new BlockGroup.GroupedBlock("orange_concrete", Blocks.ORANGE_CONCRETE, (type, textureId) -> "minecraft:block/orange_concrete", RecipeConfigurator.STONECUTTER, MapColor.ORANGE),
			new BlockGroup.GroupedBlock("yellow_concrete", Blocks.YELLOW_CONCRETE, (type, textureId) -> "minecraft:block/yellow_concrete", RecipeConfigurator.STONECUTTER, MapColor.YELLOW),
			new BlockGroup.GroupedBlock("lime_concrete", Blocks.LIME_CONCRETE, (type, textureId) -> "minecraft:block/lime_concrete", RecipeConfigurator.STONECUTTER, MapColor.LIME),
			new BlockGroup.GroupedBlock("green_concrete", Blocks.GREEN_CONCRETE, (type, textureId) -> "minecraft:block/green_concrete", RecipeConfigurator.STONECUTTER, MapColor.GREEN),
			new BlockGroup.GroupedBlock("cyan_concrete", Blocks.CYAN_CONCRETE, (type, textureId) -> "minecraft:block/cyan_concrete", RecipeConfigurator.STONECUTTER, MapColor.CYAN),
			new BlockGroup.GroupedBlock("light_blue_concrete", Blocks.LIGHT_BLUE_CONCRETE, (type, textureId) -> "minecraft:block/light_blue_concrete", RecipeConfigurator.STONECUTTER, MapColor.LIGHT_BLUE),
			new BlockGroup.GroupedBlock("blue_concrete", Blocks.BLUE_CONCRETE, (type, textureId) -> "minecraft:block/blue_concrete", RecipeConfigurator.STONECUTTER, MapColor.BLUE),
			new BlockGroup.GroupedBlock("purple_concrete", Blocks.PURPLE_CONCRETE, (type, textureId) -> "minecraft:block/purple_concrete", RecipeConfigurator.STONECUTTER, MapColor.PURPLE),
			new BlockGroup.GroupedBlock("magenta_concrete", Blocks.MAGENTA_CONCRETE, (type, textureId) -> "minecraft:block/magenta_concrete", RecipeConfigurator.STONECUTTER, MapColor.MAGENTA),
			new BlockGroup.GroupedBlock("pink_concrete", Blocks.PINK_CONCRETE, (type, textureId) -> "minecraft:block/pink_concrete", RecipeConfigurator.STONECUTTER, MapColor.PINK)
	);
}
