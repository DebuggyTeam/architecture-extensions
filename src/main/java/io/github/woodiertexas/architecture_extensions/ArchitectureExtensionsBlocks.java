package io.github.woodiertexas.architecture_extensions;

import io.github.woodiertexas.architecture_extensions.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndRodBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArchitectureExtensionsBlocks {

    // Creating items/blocks/etc and defining their properties
    //public static final CircleCorner STONE_BRICK_CIRCLE_CORNER = new CircleCorner(QuiltBlockSettings.of(Material.STONE).strength(2.5f).nonOpaque().requiresTool());

    // Columns
    public static final ColumnBlock STONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock GRANITE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock DIORITE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock ANDESITE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock COBBLED_DEEPSLATE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool());
    public static final ColumnBlock POLISHED_DEEPSLATE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final ColumnBlock COBBLESTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock SANDSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock RED_SANDSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock MOSSY_COBBLESTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock STONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock MOSSY_STONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock DEEPSLATE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).requiresTool());
    public static final ColumnBlock DEEPSLATE_TILE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.DEEPSLATE_TILES).requiresTool());
    public static final ColumnBlock NETHER_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.NETHER_BRICKS).requiresTool());
    public static final ColumnBlock RED_NETHER_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.NETHER_BRICKS).requiresTool());
    public static final ColumnBlock END_STONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock QUARTZ_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock PRISMARINE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock DARK_PRISMARINE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock BLACKSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock POLISHED_BLACKSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ColumnBlock POLISHED_BLACKSTONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());

    // Post Blocks
    public static final WallPostBlock GRANITE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock DIORITE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock ANDESITE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock COBBLED_DEEPSLATE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool());
    public static final WallPostBlock POLISHED_DEEPSLATE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final WallPostBlock COBBLESTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock SANDSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock RED_SANDSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock MOSSY_COBBLESTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock STONE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock MOSSY_STONE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock DEEPSLATE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).requiresTool());
    public static final WallPostBlock DEEPSLATE_TILE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.DEEPSLATE_TILES).requiresTool());
    public static final WallPostBlock NETHER_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.NETHER_BRICKS).requiresTool());
    public static final WallPostBlock RED_NETHER_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.NETHER_BRICKS).requiresTool());
    public static final WallPostBlock END_STONE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock PRISMARINE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock PRISMARINE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock BLACKSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock POLISHED_BLACKSTONE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final WallPostBlock POLISHED_BLACKSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());

    // Roof Blocks
    public static final RoofBlock GRANITE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock DIORITE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock ANDESITE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock COBBLED_DEEPSLATE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool());
    public static final RoofBlock POLISHED_DEEPSLATE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final RoofBlock COBBLESTONE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock SANDSTONE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock RED_SANDSTONE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock BRICK_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock MOSSY_COBBLESTONE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock STONE_BRICK_ROOF = new RoofBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock MOSSY_STONE_BRICK_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock DEEPSLATE_BRICK_ROOF = new RoofBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).requiresTool());
    public static final RoofBlock DEEPSLATE_TILE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.DEEPSLATE_TILES).requiresTool());
    public static final RoofBlock NETHER_BRICK_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.NETHER_BRICKS).requiresTool());
    public static final RoofBlock RED_NETHER_BRICK_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).sounds(BlockSoundGroup.NETHER_BRICKS).requiresTool());
    public static final RoofBlock END_STONE_BRICK_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock SMOOTH_QUARTZ_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock PRISMARINE_BRICK_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock BLACKSTONE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock POLISHED_BLACKSTONE_BRICK_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final RoofBlock POLISHED_BLACKSTONE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());

    // Arch Blocks
    public static final ArchBlock GRANITE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock DIORITE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock ANDESITE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock COBBLED_DEEPSLATE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock POLISHED_DEEPSLATE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock COBBLESTONE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock SANDSTONE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock RED_SANDSTONE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock BRICK_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock MOSSY_COBBLESTONE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock STONE_BRICK_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock MOSSY_STONE_BRICK_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock DEEPSLATE_BRICK_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock DEEPSLATE_TILE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock NETHER_BRICK_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock RED_NETHER_BRICK_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock END_STONE_BRICK_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock SMOOTH_QUARTZ_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock PRISMARINE_BRICK_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock BLACKSTONE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock POLISHED_BLACKSTONE_BRICK_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());
    public static final ArchBlock POLISHED_BLACKSTONE_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(2.5f).requiresTool());

    // Beam Blocks
    public static final BeamBlock OAK_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final BeamBlock SPRUCE_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final BeamBlock BIRCH_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final BeamBlock JUNGLE_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final BeamBlock ACACIA_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final BeamBlock DARK_OAK_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final BeamBlock MANGROVE_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final BeamBlock CRIMSON_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final BeamBlock WARPED_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final BeamBlock IRON_H_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.METAL).strength(8f).sounds(BlockSoundGroup.ANVIL).requiresTool());

    // Fence Post Blocks
    public static final FencePostBlock OAK_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final FencePostBlock SPRUCE_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final FencePostBlock BIRCH_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final FencePostBlock JUNGLE_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final FencePostBlock ACACIA_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final FencePostBlock DARK_OAK_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final FencePostBlock MANGROVE_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final FencePostBlock CRIMSON_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final FencePostBlock WARPED_FENCE_POST= new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());

    // Fence Post Caps and Lanterns
    public static final PostCapBlock OAK_POST_CAP = new PostCapBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final PostLanternBlock OAK_POST_LANTERN = new PostLanternBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).luminance(15).requiresTool());
    public static final PostCapBlock SPRUCE_POST_CAP = new PostCapBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final PostLanternBlock SPRUCE_POST_LANTERN = new PostLanternBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).luminance(15).requiresTool());
    public static final PostCapBlock BIRCH_POST_CAP = new PostCapBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final PostLanternBlock BIRCH_POST_LANTERN = new PostLanternBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).luminance(15).requiresTool());
    public static final PostCapBlock JUNGLE_POST_CAP = new PostCapBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final PostLanternBlock JUNGLE_POST_LANTERN = new PostLanternBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).luminance(15).requiresTool());
    public static final PostCapBlock ACACIA_POST_CAP = new PostCapBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final PostLanternBlock ACACIA_POST_LANTERN = new PostLanternBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).luminance(15).requiresTool());
    public static final PostCapBlock DARK_OAK_POST_CAP = new PostCapBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final PostLanternBlock DARK_OAK_POST_LANTERN = new PostLanternBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).luminance(15).requiresTool());
    public static final PostCapBlock MANGROVE_POST_CAP = new PostCapBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final PostLanternBlock MANGROVE_POST_LANTERN = new PostLanternBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).luminance(15).requiresTool());
    public static final PostCapBlock CRIMSON_POST_CAP = new PostCapBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final PostLanternBlock CRIMSON_POST_LANTERN = new PostLanternBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).luminance(15).requiresTool());
    public static final PostCapBlock WARPED_POST_CAP = new PostCapBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final PostLanternBlock WARPED_POST_LANTERN = new PostLanternBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).luminance(15).requiresTool());

    // Joist Blocks
    public static final JoistBlock OAK_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final JoistBlock SPRUCE_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final JoistBlock BIRCH_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final JoistBlock JUNGLE_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final JoistBlock ACACIA_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final JoistBlock DARK_OAK_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final JoistBlock MANGROVE_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final JoistBlock CRIMSON_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final JoistBlock WARPED_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());

    // Crown Molding Blocks
    public static final MoldingBlock OAK_CROWN_MOLDING = new MoldingBlock(Blocks.OAK_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock SPRUCE_CROWN_MOLDING = new MoldingBlock(Blocks.SPRUCE_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock BIRCH_CROWN_MOLDING = new MoldingBlock(Blocks.BIRCH_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock JUNGLE_CROWN_MOLDING = new MoldingBlock(Blocks.JUNGLE_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock ACACIA_CROWN_MOLDING = new MoldingBlock(Blocks.ACACIA_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock DARK_OAK_CROWN_MOLDING = new MoldingBlock(Blocks.DARK_OAK_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock MANGROVE_CROWN_MOLDING = new MoldingBlock(Blocks.DARK_OAK_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock CRIMSON_CROWN_MOLDING = new MoldingBlock(Blocks.CRIMSON_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock WARPED_CROWN_MOLDING = new MoldingBlock(Blocks.WARPED_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());

    // Rod Blocks
    public static final RodBlockTwo BAMBOO_ROD = new RodBlockTwo(QuiltBlockSettings.of(Material.BAMBOO).strength(1f).sounds(BlockSoundGroup.BAMBOO).nonOpaque().requiresTool());
    public static final RodBlockTwo COPPER_ROD = new RodBlockTwo(QuiltBlockSettings.of(Material.METAL).strength(1f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool());
    public static final EndRodBlock END_ROD_NUBLESS = new EndRodBlock(QuiltBlockSettings.of(Material.STONE).strength(1f).luminance(14).nonOpaque().requiresTool());
    public static final RodBlockTwo IRON_ROD = new RodBlockTwo(QuiltBlockSettings.of(Material.METAL).strength(1f).nonOpaque().requiresTool());

    // Peculiar Blocks
    public static final Block DEBUGGY_BLOCK = new Block(QuiltBlockSettings.of(Material.WOOL).strength(1f).sounds(BlockSoundGroup.WOOL).requiresTool());
    public static final Block FAKE_END_PORTAL_BLOCK = new Block(QuiltBlockSettings.of(Material.WOOL).strength(1f).sounds(BlockSoundGroup.WOOL).requiresTool());

    static {
        Map<String, Block> blocks = new LinkedHashMap<>();
            blocks.put("stone_column", STONE_COLUMN);
            blocks.put("granite_column", GRANITE_COLUMN);
            blocks.put("diorite_column", DIORITE_COLUMN);
            blocks.put("andesite_column", ANDESITE_COLUMN);
            blocks.put("cobbled_deepslate_column", COBBLED_DEEPSLATE_COLUMN);
            blocks.put("polished_deepslate_column", POLISHED_DEEPSLATE_COLUMN);
            blocks.put("cobblestone_column", COBBLESTONE_COLUMN);
            blocks.put("sandstone_column", SANDSTONE_COLUMN);
            blocks.put("red_sandstone_column", RED_SANDSTONE_COLUMN);
            blocks.put("brick_column", BRICK_COLUMN);
            blocks.put("mossy_cobblestone_column", MOSSY_COBBLESTONE_COLUMN);
            blocks.put("stone_brick_column", STONE_BRICK_COLUMN);
            blocks.put("mossy_stone_brick_column", MOSSY_STONE_BRICK_COLUMN);
            blocks.put("deepslate_brick_column", DEEPSLATE_BRICK_COLUMN);
            blocks.put("deepslate_tile_column", DEEPSLATE_TILE_COLUMN);
            blocks.put("nether_brick_column", NETHER_BRICK_COLUMN);
            blocks.put("red_nether_brick_column", RED_NETHER_BRICK_COLUMN);
            blocks.put("end_stone_brick_column", END_STONE_BRICK_COLUMN);
            blocks.put("quartz_column", QUARTZ_COLUMN);
            blocks.put("prismarine_brick_column", PRISMARINE_BRICK_COLUMN);
            blocks.put("dark_prismarine_column", DARK_PRISMARINE_COLUMN);
            blocks.put("blackstone_column", BLACKSTONE_COLUMN);
            blocks.put("polished_blackstone_column", POLISHED_BLACKSTONE_COLUMN);
            blocks.put("polished_blackstone_brick_column", POLISHED_BLACKSTONE_BRICK_COLUMN);
            blocks.put("granite_post", GRANITE_POST);
            blocks.put("diorite_post", DIORITE_POST);
            blocks.put("andesite_post", ANDESITE_POST);
            blocks.put("cobbled_deepslate_post", COBBLED_DEEPSLATE_POST);
            blocks.put("polished_deepslate_post", POLISHED_DEEPSLATE_POST);
            blocks.put("cobblestone_post", COBBLESTONE_POST);
            blocks.put("sandstone_post", SANDSTONE_POST);
            blocks.put("red_sandstone_post", RED_SANDSTONE_POST);
            blocks.put("brick_post", BRICK_POST);
            blocks.put("mossy_cobblestone_post", MOSSY_COBBLESTONE_POST);
            blocks.put("stone_brick_post", STONE_BRICK_POST);
            blocks.put("mossy_stone_brick_post", MOSSY_STONE_BRICK_POST);
            blocks.put("deepslate_brick_post", DEEPSLATE_BRICK_POST);
            blocks.put("deepslate_tile_post", DEEPSLATE_TILE_POST);
            blocks.put("nether_brick_post", NETHER_BRICK_POST);
            blocks.put("red_nether_brick_post", RED_NETHER_BRICK_POST);
            blocks.put("end_stone_brick_post", END_STONE_BRICK_POST);
            blocks.put("prismarine_post", PRISMARINE_POST);
            blocks.put("prismarine_brick_post", PRISMARINE_BRICK_POST);
            blocks.put("blackstone_post", BLACKSTONE_POST);
            blocks.put("polished_blackstone_brick_post", POLISHED_BLACKSTONE_BRICK_POST);
            blocks.put("polished_blackstone_post", POLISHED_BLACKSTONE_POST);
            blocks.put("granite_roof", GRANITE_ROOF);
            blocks.put("diorite_roof", DIORITE_ROOF);
            blocks.put("andesite_roof", ANDESITE_ROOF);
            blocks.put("cobbled_deepslate_roof", COBBLED_DEEPSLATE_ROOF);
            blocks.put("polished_deepslate_roof", POLISHED_DEEPSLATE_ROOF);
            blocks.put("cobblestone_roof", COBBLESTONE_ROOF);
            blocks.put("sandstone_roof", SANDSTONE_ROOF);
            blocks.put("red_sandstone_roof", RED_SANDSTONE_ROOF);
            blocks.put("brick_roof", BRICK_ROOF);
            blocks.put("mossy_cobblestone_roof", MOSSY_COBBLESTONE_ROOF);
            blocks.put("stone_brick_roof", STONE_BRICK_ROOF);
            blocks.put("mossy_stone_brick_roof", MOSSY_STONE_BRICK_ROOF);
            blocks.put("deepslate_brick_roof", DEEPSLATE_BRICK_ROOF);
            blocks.put("deepslate_tile_roof", DEEPSLATE_TILE_ROOF);
            blocks.put("nether_brick_roof", NETHER_BRICK_ROOF);
            blocks.put("red_nether_brick_roof", RED_NETHER_BRICK_ROOF);
            blocks.put("end_stone_brick_roof", END_STONE_BRICK_ROOF);
            blocks.put("smooth_quartz_roof", SMOOTH_QUARTZ_ROOF);
            blocks.put("prismarine_brick_roof", PRISMARINE_BRICK_ROOF);
            blocks.put("blackstone_roof", BLACKSTONE_ROOF);
            blocks.put("polished_blackstone_brick_roof", POLISHED_BLACKSTONE_BRICK_ROOF);
            blocks.put("polished_blackstone_roof", POLISHED_BLACKSTONE_ROOF);
            blocks.put("granite_arch", GRANITE_ARCH);
            blocks.put("diorite_arch", DIORITE_ARCH);
            blocks.put("andesite_arch", ANDESITE_ARCH);
            blocks.put("cobbled_deepslate_arch", COBBLED_DEEPSLATE_ARCH);
            blocks.put("polished_deepslate_arch", POLISHED_DEEPSLATE_ARCH);
            blocks.put("cobblestone_arch", COBBLESTONE_ARCH);
            blocks.put("sandstone_arch", SANDSTONE_ARCH);
            blocks.put("red_sandstone_arch", RED_SANDSTONE_ARCH);
            blocks.put("brick_arch", BRICK_ARCH);
            blocks.put("mossy_cobblestone_arch", MOSSY_COBBLESTONE_ARCH);
            blocks.put("stone_brick_arch", STONE_BRICK_ARCH);
            blocks.put("mossy_stone_brick_arch", MOSSY_STONE_BRICK_ARCH);
            blocks.put("deepslate_brick_arch", DEEPSLATE_BRICK_ARCH);
            blocks.put("deepslate_tile_arch", DEEPSLATE_TILE_ARCH);
            blocks.put("nether_brick_arch", NETHER_BRICK_ARCH);
            blocks.put("red_nether_brick_arch", RED_NETHER_BRICK_ARCH);
            blocks.put("end_stone_brick_arch", END_STONE_BRICK_ARCH);
            blocks.put("smooth_quartz_arch", SMOOTH_QUARTZ_ARCH);
            blocks.put("prismarine_brick_arch", PRISMARINE_BRICK_ARCH);
            blocks.put("blackstone_arch", BLACKSTONE_ARCH);
            blocks.put("polished_blackstone_brick_arch",POLISHED_BLACKSTONE_BRICK_ARCH);
            blocks.put("polished_blackstone_arch", POLISHED_BLACKSTONE_ARCH);
            blocks.put("oak_beam", OAK_BEAM);
            blocks.put("spruce_beam", SPRUCE_BEAM);
            blocks.put("birch_beam", BIRCH_BEAM);
            blocks.put("jungle_beam", JUNGLE_BEAM);
            blocks.put("acacia_beam", ACACIA_BEAM);
            blocks.put("dark_oak_beam", DARK_OAK_BEAM);
            blocks.put("mangrove_beam", MANGROVE_BEAM);
            blocks.put("crimson_beam", CRIMSON_BEAM);
            blocks.put("warped_beam", WARPED_BEAM);
            blocks.put("iron_h_beam", IRON_H_BEAM);
            blocks.put("oak_fence_post", OAK_FENCE_POST);
            blocks.put("spruce_fence_post", SPRUCE_FENCE_POST);
            blocks.put("birch_fence_post", BIRCH_FENCE_POST);
            blocks.put("jungle_fence_post", JUNGLE_FENCE_POST);
            blocks.put("acacia_fence_post", ACACIA_FENCE_POST);
            blocks.put("dark_oak_fence_post", DARK_OAK_FENCE_POST);
            blocks.put("mangrove_fence_post", MANGROVE_FENCE_POST);
            blocks.put("crimson_fence_post", CRIMSON_FENCE_POST);
            blocks.put("warped_fence_post", WARPED_FENCE_POST);
            blocks.put("oak_joist", OAK_JOIST);
            blocks.put("spruce_joist", SPRUCE_JOIST);
            blocks.put("birch_joist", BIRCH_JOIST);
            blocks.put("jungle_joist", JUNGLE_JOIST);
            blocks.put("acacia_joist", ACACIA_JOIST);
            blocks.put("dark_oak_joist", DARK_OAK_JOIST);
            blocks.put("mangrove_joist", MANGROVE_JOIST);
            blocks.put("crimson_joist", CRIMSON_JOIST);
            blocks.put("warped_joist", WARPED_JOIST);
            blocks.put("oak_crown_molding", OAK_CROWN_MOLDING);
            blocks.put("spruce_crown_molding", SPRUCE_CROWN_MOLDING);
            blocks.put("birch_crown_molding", BIRCH_CROWN_MOLDING);
            blocks.put("jungle_crown_molding", JUNGLE_CROWN_MOLDING);
            blocks.put("acacia_crown_molding", ACACIA_CROWN_MOLDING);
            blocks.put("dark_oak_crown_molding", DARK_OAK_CROWN_MOLDING);
            blocks.put("mangrove_crown_molding", MANGROVE_CROWN_MOLDING);
            blocks.put("crimson_crown_molding", CRIMSON_CROWN_MOLDING);
            blocks.put("warped_crown_molding", WARPED_CROWN_MOLDING);
            blocks.put("oak_post_cap", OAK_POST_CAP);
            blocks.put("oak_post_lantern", OAK_POST_LANTERN);
            blocks.put("spruce_post_cap", SPRUCE_POST_CAP);
            blocks.put("spruce_post_lantern", SPRUCE_POST_LANTERN);
            blocks.put("birch_post_cap", BIRCH_POST_CAP);
            blocks.put("birch_post_lantern", BIRCH_POST_LANTERN);
            blocks.put("jungle_post_cap", JUNGLE_POST_CAP);
            blocks.put("jungle_post_lantern", JUNGLE_POST_LANTERN);
            blocks.put("acacia_post_cap", ACACIA_POST_CAP);
            blocks.put("acacia_post_lantern", ACACIA_POST_LANTERN);
            blocks.put("dark_oak_post_cap", DARK_OAK_POST_CAP);
            blocks.put("dark_oak_post_lantern", DARK_OAK_POST_LANTERN);
            blocks.put("mangrove_post_cap", MANGROVE_POST_CAP);
            blocks.put("mangrove_post_lantern", MANGROVE_POST_LANTERN);
            blocks.put("crimson_post_cap", CRIMSON_POST_CAP);
            blocks.put("crimson_post_lantern", CRIMSON_POST_LANTERN);
            blocks.put("warped_post_cap", WARPED_POST_CAP);
            blocks.put("warped_post_lantern", WARPED_POST_LANTERN);
            blocks.put("bamboo_rod", BAMBOO_ROD);
            blocks.put("copper_rod", COPPER_ROD);
            blocks.put("end_rod_nubless", END_ROD_NUBLESS);
            blocks.put("iron_rod", IRON_ROD);
            blocks.put("debuggy_block", DEBUGGY_BLOCK);
            blocks.put("fake_end_portal_block", FAKE_END_PORTAL_BLOCK);

        // Registering the blocks and corresponding block items.
        for (Map.Entry<String, Block> entry : blocks.entrySet()) {
            Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", entry.getKey()), entry.getValue());
            Registry.register(Registry.ITEM, new Identifier("architecture_extensions", entry.getKey()),
                    new BlockItem(entry.getValue(), new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
        }
    }

    public static void init() {}
}
