package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.TextureTemplate;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.util.Identifier;

public final class VanillaBlockGroups {
	public static final BlockGroup STONE = BlockGroup.of(new BlockGroup.GroupedBlock("stone", Blocks.STONE, (type, textureId) -> "minecraft:block/stone", MapColor.STONE_GRAY),
															new BlockGroup.GroupedBlock("blackstone", Blocks.BLACKSTONE, TextureTemplate.TOP.apply(new Identifier("blackstone")), MapColor.BLACK),
															new BlockGroup.GroupedBlock("sandstone", Blocks.SANDSTONE, TextureTemplate.TOP_BOTTOM.apply(new Identifier("sandstone")), MapColor.PALE_YELLOW),
															new BlockGroup.GroupedBlock("red_sandstone", Blocks.RED_SANDSTONE, TextureTemplate.TOP_BOTTOM.apply(new Identifier("red_sandstone")), MapColor.ORANGE),
															new BlockGroup.GroupedBlock("granite", Blocks.GRANITE, (type, textureId) -> "minecraft:block/granite", MapColor.DIRT_BROWN),
															new BlockGroup.GroupedBlock("diorite", Blocks.DIORITE, (type, textureId) -> "minecraft:block/diorite", MapColor.OFF_WHITE),
															new BlockGroup.GroupedBlock("andesite", Blocks.ANDESITE, (type, textureId) -> "minecraft:block/andesite", MapColor.STONE_GRAY));

	public static final BlockGroup AQUATIC_STONE = BlockGroup.of(new BlockGroup.GroupedBlock("prismarine", Blocks.PRISMARINE, (type, textureId) -> "minecraft:block/prismarine", MapColor.CYAN));

	public static final BlockGroup PROCESSED_STONE = BlockGroup.of(new BlockGroup.GroupedBlock("cobbled_deepslate", Blocks.COBBLED_DEEPSLATE, (type, textureId) -> "minecraft:block/cobbled_deepslate", MapColor.DEEPSLATE_GRAY),
																	new BlockGroup.GroupedBlock("polished_deepslate", Blocks.POLISHED_DEEPSLATE, (type, textureId) -> "minecraft:block/polished_deepslate", MapColor.DEEPSLATE_GRAY),
																	new BlockGroup.GroupedBlock("polished_blackstone", Blocks.POLISHED_BLACKSTONE, (type, textureId) -> "minecraft:block/polished_blackstone", MapColor.BLACK),
																	new BlockGroup.GroupedBlock("cobblestone", Blocks.COBBLESTONE, (type, textureId) -> "minecraft:block/cobblestone", MapColor.STONE_GRAY),
																	new BlockGroup.GroupedBlock("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE, (type, textureId) -> "minecraft:block/mossy_cobblestone", MapColor.STONE_GRAY));

	public static final BlockGroup WOOD = BlockGroup.of(new BlockGroup.GroupedBlock("oak", Blocks.OAK_LOG, TextureTemplate.WOOD_WITH_LOG.apply(new Identifier("oak")), MapColor.OAK_TAN),
														new BlockGroup.GroupedBlock("spruce", Blocks.SPRUCE_LOG, TextureTemplate.WOOD_WITH_LOG.apply(new Identifier("spruce")), MapColor.SPRUCE_BROWN),
														new BlockGroup.GroupedBlock("birch", Blocks.BIRCH_LOG, TextureTemplate.WOOD_WITH_LOG.apply(new Identifier("birch")), MapColor.PALE_YELLOW),
														new BlockGroup.GroupedBlock("jungle", Blocks.JUNGLE_LOG, TextureTemplate.WOOD_WITH_LOG.apply(new Identifier("jungle")), MapColor.DIRT_BROWN),
														new BlockGroup.GroupedBlock("acacia", Blocks.ACACIA_LOG, TextureTemplate.WOOD_WITH_LOG.apply(new Identifier("acacia")), MapColor.ORANGE),
														new BlockGroup.GroupedBlock("dark_oak", Blocks.DARK_OAK_LOG, TextureTemplate.WOOD_WITH_LOG.apply(new Identifier("dark_oak")), MapColor.BROWN),
														new BlockGroup.GroupedBlock("mangrove", Blocks.MANGROVE_LOG, TextureTemplate.WOOD_WITH_LOG.apply(new Identifier("mangrove")), MapColor.RED),
														new BlockGroup.GroupedBlock("crimson", Blocks.CRIMSON_STEM, TextureTemplate.WOOD_WITH_STEM.apply(new Identifier("crimson")), MapColor.DULL_PINK),
														new BlockGroup.GroupedBlock("warped", Blocks.WARPED_STEM, TextureTemplate.WOOD_WITH_STEM.apply(new Identifier("warped")), MapColor.DARK_AQUA));

	public static final BlockGroup BRICK = BlockGroup.of(new BlockGroup.GroupedBlock("brick", Blocks.BRICKS, (type, textureId) -> "minecraft:block/bricks", MapColor.RED),
														new BlockGroup.GroupedBlock("nether_brick", Blocks.NETHER_BRICKS, (type, textureId) -> "minecraft:block/nether_bricks", MapColor.DARK_RED),
														new BlockGroup.GroupedBlock("red_nether_brick", Blocks.RED_NETHER_BRICKS, (type, textureId) -> "minecraft:block/red_nether_bricks", MapColor.DARK_RED),
														new BlockGroup.GroupedBlock("stone_brick", Blocks.STONE_BRICKS, (type, textureId) -> "minecraft:block/stone_bricks", MapColor.STONE_GRAY),
														new BlockGroup.GroupedBlock("polished_blackstone_brick", Blocks.POLISHED_BLACKSTONE_BRICKS, (type, textureId) -> "minecraft:block/polished_blackstone_bricks", MapColor.BLACK),
														new BlockGroup.GroupedBlock("mossy_stone_brick", Blocks.MOSSY_STONE_BRICKS, (type, textureId) -> "minecraft:block/mossy_stone_bricks", MapColor.STONE_GRAY),
														new BlockGroup.GroupedBlock("end_stone_brick", Blocks.END_STONE_BRICKS, (type, textureId) -> "minecraft:block/end_stone_bricks", MapColor.PALE_YELLOW),
														new BlockGroup.GroupedBlock("deepslate_brick", Blocks.DEEPSLATE_BRICKS, (type, textureId) -> "minecraft:block/deepslate_bricks", MapColor.DEEPSLATE_GRAY),
														new BlockGroup.GroupedBlock("prismarine_brick", Blocks.PRISMARINE_BRICKS, (type, textureId) -> "minecraft:block/prismarine_bricks", MapColor.DIAMOND_BLUE),
														new BlockGroup.GroupedBlock("dark_prismarine", Blocks.DARK_PRISMARINE, (type, textureId) -> "minecraft:block/dark_prismarine", MapColor.DIAMOND_BLUE));

	public static final BlockGroup TILE = BlockGroup.of(new BlockGroup.GroupedBlock("deepslate_tile", Blocks.DEEPSLATE_TILES, (type, textureId) -> "minecraft:block/deepslate_tiles", MapColor.DEEPSLATE_GRAY));

	public static final BlockGroup CRYSTAL = BlockGroup.of(new BlockGroup.GroupedBlock("quartz", Blocks.QUARTZ_BLOCK, TextureTemplate.SIDED.apply(new Identifier("quartz_block")), MapColor.OFF_WHITE),
															new BlockGroup.GroupedBlock("smooth_quartz", Blocks.SMOOTH_QUARTZ, (type, textureId) -> "minecraft:block/quartz_block_bottom", MapColor.OFF_WHITE));
}
