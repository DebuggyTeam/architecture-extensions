package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.RecipeConfigurator;
import io.github.debuggyteam.architecture_extensions.api.TextureConfiguration;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.util.Identifier;

public final class VanillaBlockGroups {
	public static final BlockGroup STONE = BlockGroup.of(new BlockGroup.GroupedBlock("stone", Blocks.STONE, (type, textureId) -> "minecraft:block/stone", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
															new BlockGroup.GroupedBlock("blackstone", Blocks.BLACKSTONE, TextureConfiguration.TOP.apply(new Identifier("blackstone")), RecipeConfigurator.STONECUTTER, MapColor.BLACK),
															new BlockGroup.GroupedBlock("sandstone", Blocks.SANDSTONE, TextureConfiguration.TOP_BOTTOM.apply(new Identifier("sandstone")), RecipeConfigurator.STONECUTTER, MapColor.PALE_YELLOW),
															new BlockGroup.GroupedBlock("red_sandstone", Blocks.RED_SANDSTONE, TextureConfiguration.TOP_BOTTOM.apply(new Identifier("red_sandstone")), RecipeConfigurator.STONECUTTER, MapColor.ORANGE),
															new BlockGroup.GroupedBlock("granite", Blocks.GRANITE, (type, textureId) -> "minecraft:block/granite", RecipeConfigurator.STONECUTTER, MapColor.DIRT_BROWN),
															new BlockGroup.GroupedBlock("diorite", Blocks.DIORITE, (type, textureId) -> "minecraft:block/diorite", RecipeConfigurator.STONECUTTER, MapColor.OFF_WHITE),
															new BlockGroup.GroupedBlock("andesite", Blocks.ANDESITE, (type, textureId) -> "minecraft:block/andesite", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY));

	public static final BlockGroup AQUATIC_STONE = BlockGroup.of(new BlockGroup.GroupedBlock("prismarine", Blocks.PRISMARINE, (type, textureId) -> "minecraft:block/prismarine", RecipeConfigurator.STONECUTTER, MapColor.CYAN));

	public static final BlockGroup PROCESSED_STONE = BlockGroup.of(new BlockGroup.GroupedBlock("cobbled_deepslate", Blocks.COBBLED_DEEPSLATE, (type, textureId) -> "minecraft:block/cobbled_deepslate", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE_GRAY),
																	new BlockGroup.GroupedBlock("polished_deepslate", Blocks.POLISHED_DEEPSLATE, (type, textureId) -> "minecraft:block/polished_deepslate", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE_GRAY),
																	new BlockGroup.GroupedBlock("polished_blackstone", Blocks.POLISHED_BLACKSTONE, (type, textureId) -> "minecraft:block/polished_blackstone", RecipeConfigurator.STONECUTTER, MapColor.BLACK),
																	new BlockGroup.GroupedBlock("cobblestone", Blocks.COBBLESTONE, (type, textureId) -> "minecraft:block/cobblestone", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
																	new BlockGroup.GroupedBlock("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE, (type, textureId) -> "minecraft:block/mossy_cobblestone", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY));

	public static final BlockGroup WOOD = BlockGroup.of(new BlockGroup.GroupedBlock("oak", Blocks.OAK_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("oak")), RecipeConfigurator.SAWING, MapColor.OAK_TAN),
														new BlockGroup.GroupedBlock("spruce", Blocks.SPRUCE_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("spruce")), RecipeConfigurator.SAWING, MapColor.SPRUCE_BROWN),
														new BlockGroup.GroupedBlock("birch", Blocks.BIRCH_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("birch")), RecipeConfigurator.SAWING, MapColor.PALE_YELLOW),
														new BlockGroup.GroupedBlock("jungle", Blocks.JUNGLE_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("jungle")), RecipeConfigurator.SAWING, MapColor.DIRT_BROWN),
														new BlockGroup.GroupedBlock("acacia", Blocks.ACACIA_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("acacia")), RecipeConfigurator.SAWING, MapColor.ORANGE),
														new BlockGroup.GroupedBlock("dark_oak", Blocks.DARK_OAK_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("dark_oak")), RecipeConfigurator.SAWING, MapColor.BROWN),
														new BlockGroup.GroupedBlock("mangrove", Blocks.MANGROVE_LOG, TextureConfiguration.WOOD_WITH_LOG.apply(new Identifier("mangrove")), RecipeConfigurator.SAWING, MapColor.RED),
														new BlockGroup.GroupedBlock("crimson", Blocks.CRIMSON_STEM, TextureConfiguration.WOOD_WITH_STEM.apply(new Identifier("crimson")), RecipeConfigurator.SAWING, MapColor.DULL_PINK),
														new BlockGroup.GroupedBlock("warped", Blocks.WARPED_STEM, TextureConfiguration.WOOD_WITH_STEM.apply(new Identifier("warped")), RecipeConfigurator.SAWING, MapColor.DARK_AQUA));

	public static final BlockGroup BRICK = BlockGroup.of(new BlockGroup.GroupedBlock("brick", Blocks.BRICKS, (type, textureId) -> "minecraft:block/bricks", RecipeConfigurator.STONECUTTER, MapColor.RED),
														new BlockGroup.GroupedBlock("nether_brick", Blocks.NETHER_BRICKS, (type, textureId) -> "minecraft:block/nether_bricks", RecipeConfigurator.STONECUTTER, MapColor.DARK_RED),
														new BlockGroup.GroupedBlock("red_nether_brick", Blocks.RED_NETHER_BRICKS, (type, textureId) -> "minecraft:block/red_nether_bricks", RecipeConfigurator.STONECUTTER, MapColor.DARK_RED),
														new BlockGroup.GroupedBlock("stone_brick", Blocks.STONE_BRICKS, (type, textureId) -> "minecraft:block/stone_bricks", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
														new BlockGroup.GroupedBlock("polished_blackstone_brick", Blocks.POLISHED_BLACKSTONE_BRICKS, (type, textureId) -> "minecraft:block/polished_blackstone_bricks", RecipeConfigurator.STONECUTTER, MapColor.BLACK),
														new BlockGroup.GroupedBlock("mossy_stone_brick", Blocks.MOSSY_STONE_BRICKS, (type, textureId) -> "minecraft:block/mossy_stone_bricks", RecipeConfigurator.STONECUTTER, MapColor.STONE_GRAY),
														new BlockGroup.GroupedBlock("mud_brick", Blocks.MUD_BRICKS, (type, textureId) -> "minecraft:block/mud_bricks", RecipeConfigurator.STONECUTTER, MapColor.BROWN),
														new BlockGroup.GroupedBlock("end_stone_brick", Blocks.END_STONE_BRICKS, (type, textureId) -> "minecraft:block/end_stone_bricks", RecipeConfigurator.STONECUTTER, MapColor.PALE_YELLOW),
														new BlockGroup.GroupedBlock("purpur", Blocks.PURPUR_BLOCK, (type, textureId) -> "minecraft:block/purpur_block", RecipeConfigurator.STONECUTTER, MapColor.DULL_PINK),
														new BlockGroup.GroupedBlock("deepslate_brick", Blocks.DEEPSLATE_BRICKS, (type, textureId) -> "minecraft:block/deepslate_bricks", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE_GRAY),
														new BlockGroup.GroupedBlock("prismarine_brick", Blocks.PRISMARINE_BRICKS, (type, textureId) -> "minecraft:block/prismarine_bricks", RecipeConfigurator.STONECUTTER, MapColor.DIAMOND_BLUE),
														new BlockGroup.GroupedBlock("dark_prismarine", Blocks.DARK_PRISMARINE, (type, textureId) -> "minecraft:block/dark_prismarine", RecipeConfigurator.STONECUTTER, MapColor.DIAMOND_BLUE));

	public static final BlockGroup TILE = BlockGroup.of(new BlockGroup.GroupedBlock("deepslate_tile", Blocks.DEEPSLATE_TILES, (type, textureId) -> "minecraft:block/deepslate_tiles", RecipeConfigurator.STONECUTTER, MapColor.DEEPSLATE_GRAY));

	public static final BlockGroup CRYSTAL = BlockGroup.of(new BlockGroup.GroupedBlock("quartz", Blocks.QUARTZ_BLOCK, TextureConfiguration.SIDED.apply(new Identifier("quartz_block")), RecipeConfigurator.STONECUTTER, MapColor.OFF_WHITE),
															new BlockGroup.GroupedBlock("smooth_quartz", Blocks.SMOOTH_QUARTZ, (type, textureId) -> "minecraft:block/quartz_block_bottom", RecipeConfigurator.STONECUTTER, MapColor.OFF_WHITE));
}
