package io.github.woodiertexas.architecture_extensions;

import io.github.woodiertexas.architecture_extensions.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

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
    public static final JoistBlock CRIMSON_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final JoistBlock WARPED_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());

    // Crown Molding Blocks
    public static final MoldingBlock OAK_CROWN_MOLDING = new MoldingBlock(Blocks.OAK_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock SPRUCE_CROWN_MOLDING = new MoldingBlock(Blocks.SPRUCE_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock BIRCH_CROWN_MOLDING = new MoldingBlock(Blocks.BIRCH_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock JUNGLE_CROWN_MOLDING = new MoldingBlock(Blocks.JUNGLE_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock ACACIA_CROWN_MOLDING = new MoldingBlock(Blocks.ACACIA_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock DARK_OAK_CROWN_MOLDING = new MoldingBlock(Blocks.DARK_OAK_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock CRIMSON_CROWN_MOLDING = new MoldingBlock(Blocks.CRIMSON_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock WARPED_CROWN_MOLDING = new MoldingBlock(Blocks.WARPED_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());

    // Rod Blocks
    public static final RodBlockTwo BAMBOO_ROD = new RodBlockTwo(QuiltBlockSettings.of(Material.BAMBOO).strength(1f).sounds(BlockSoundGroup.BAMBOO).nonOpaque().requiresTool());
    public static final RodBlockTwo COPPER_ROD = new RodBlockTwo(QuiltBlockSettings.of(Material.METAL).strength(1f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool());
    public static final RodBlockTwo END_ROD_NUBLESS = new RodBlockTwo(QuiltBlockSettings.of(Material.STONE).strength(1f).luminance(14).nonOpaque().requiresTool());
    public static final RodBlockTwo IRON_ROD = new RodBlockTwo(QuiltBlockSettings.of(Material.METAL).strength(1f).nonOpaque().requiresTool());

    // Peculiar Blocks
    public static final Block DEBUGGY_BLOCK = new Block(QuiltBlockSettings.of(Material.WOOL).strength(1f).sounds(BlockSoundGroup.WOOL).requiresTool());
    public static final Block FAKE_END_PORTAL_BLOCK = new Block(QuiltBlockSettings.of(Material.WOOL).strength(1f).sounds(BlockSoundGroup.WOOL).requiresTool());

    static {

        // Block string names
        String[] blocksArray = {
                "stone_column", "granite_column", "diorite_column", "andesite_column", "cobbled_deepslate_column",
                "polished_deepslate_column", "cobblestone_column", "sandstone_column", "red_sandstone_column", "brick_column",
                "mossy_cobblestone_column", "stone_brick_column", "mossy_stone_brick_column", "deepslate_brick_column",
                "deepslate_tile_column", "nether_brick_column", "red_nether_brick_column", "end_stone_brick_column",
                "quartz_column", "prismarine_brick_column", "dark_prismarine_column", "blackstone_column",
                "polished_blackstone_column", "polished_blackstone_brick_column",

                "granite_post", "diorite_post", "andesite_post", "cobbled_deepslate_post", "polished_deepslate_post", "cobblestone_post",
                "sandstone_post", "red_sandstone_post", "brick_post", "mossy_cobblestone_post", "stone_brick_post", "mossy_stone_brick_post",
                "deepslate_brick_post", "deepslate_tile_post", "nether_brick_post", "red_nether_brick_post", "end_stone_brick_post",
                "prismarine_post", "prismarine_brick_post", "blackstone_post", "polished_blackstone_brick_post", "polished_blackstone_post",

                "granite_roof", "diorite_roof", "andesite_roof", "cobbled_deepslate_roof", "polished_deepslate_roof", "cobblestone_roof",
                "sandstone_roof", "red_sandstone_roof", "brick_roof", "mossy_cobblestone_roof", "stone_brick_roof", "mossy_stone_brick_roof",
                "deepslate_brick_roof", "deepslate_tile_roof", "nether_brick_roof", "red_nether_brick_roof", "end_stone_brick_roof",
                "smooth_quartz_roof", "prismarine_brick_roof", "blackstone_roof", "polished_blackstone_brick_roof", "polished_blackstone_roof",

                "granite_arch", "diorite_arch", "andesite_arch", "cobbled_deepslate_arch", "polished_deepslate_arch", "cobblestone_arch",
                "sandstone_arch", "red_sandstone_arch", "brick_arch", "mossy_cobblestone_arch", "stone_brick_arch", "mossy_stone_brick_arch",
                "deepslate_brick_arch", "deepslate_tile_arch", "nether_brick_arch", "red_nether_brick_arch", "end_stone_brick_arch",
                "smooth_quartz_arch", "prismarine_brick_arch", "blackstone_arch", "polished_blackstone_brick_arch", "polished_blackstone_arch",

                "oak_beam", "spruce_beam", "birch_beam", "jungle_beam", "acacia_beam", "dark_oak_beam", "crimson_beam", "warped_beam",
                "iron_h_beam",

                "oak_fence_post", "spruce_fence_post", "birch_fence_post", "jungle_fence_post", "acacia_fence_post", "dark_oak_fence_post",
                "crimson_fence_post", "warped_fence_post",

                "oak_joist", "spruce_joist", "birch_joist", "jungle_joist", "acacia_joist", "dark_oak_joist", "crimson_joist", "warped_joist",

                "oak_crown_molding", "spruce_crown_molding", "birch_crown_molding", "jungle_crown_molding", "acacia_crown_molding",
                "dark_oak_crown_molding", "crimson_crown_molding", "warped_crown_molding",

                "bamboo_rod", "copper_rod", "end_rod_nubless", "iron_rod", "debuggy_block", "fake_end_portal_block",

                "oak_post_cap", "oak_post_lantern", "spruce_post_cap", "spruce_post_lantern", "birch_post_cap", "birch_post_lantern",
                "jungle_post_cap", "jungle_post_lantern", "acacia_post_cap", "acacia_post_lantern", "dark_oak_post_cap", "dark_oak_post_lantern",
                "crimson_post_cap", "crimson_post_lantern", "warped_post_cap", "warped_post_lantern"
        };

        Block[] anotherBlocksArray = {
                STONE_COLUMN, GRANITE_COLUMN, DIORITE_COLUMN, ANDESITE_COLUMN, COBBLED_DEEPSLATE_COLUMN, POLISHED_DEEPSLATE_COLUMN,
                COBBLESTONE_COLUMN, SANDSTONE_COLUMN, RED_SANDSTONE_COLUMN, BRICK_COLUMN, MOSSY_COBBLESTONE_COLUMN,
                STONE_BRICK_COLUMN, MOSSY_STONE_BRICK_COLUMN, DEEPSLATE_BRICK_COLUMN, DEEPSLATE_TILE_COLUMN, NETHER_BRICK_COLUMN,
                RED_NETHER_BRICK_COLUMN, END_STONE_BRICK_COLUMN, QUARTZ_COLUMN, PRISMARINE_BRICK_COLUMN, DARK_PRISMARINE_COLUMN,
                BLACKSTONE_COLUMN, POLISHED_BLACKSTONE_COLUMN, POLISHED_BLACKSTONE_BRICK_COLUMN,

                GRANITE_POST, DIORITE_POST, ANDESITE_POST, COBBLED_DEEPSLATE_POST, POLISHED_DEEPSLATE_POST, COBBLESTONE_POST, SANDSTONE_POST,
                RED_SANDSTONE_POST, BRICK_POST, MOSSY_COBBLESTONE_POST, STONE_BRICK_POST, MOSSY_STONE_BRICK_POST, DEEPSLATE_BRICK_POST,
                DEEPSLATE_TILE_POST, NETHER_BRICK_POST, RED_NETHER_BRICK_POST, END_STONE_BRICK_POST, PRISMARINE_POST, PRISMARINE_BRICK_POST,
                BLACKSTONE_POST, POLISHED_BLACKSTONE_BRICK_POST, POLISHED_BLACKSTONE_POST,

                GRANITE_ROOF, DIORITE_ROOF, ANDESITE_ROOF, COBBLED_DEEPSLATE_ROOF, POLISHED_DEEPSLATE_ROOF, COBBLESTONE_ROOF, SANDSTONE_ROOF,
                RED_SANDSTONE_ROOF, BRICK_ROOF, MOSSY_COBBLESTONE_ROOF, STONE_BRICK_ROOF, MOSSY_STONE_BRICK_ROOF, DEEPSLATE_BRICK_ROOF,
                DEEPSLATE_TILE_ROOF, NETHER_BRICK_ROOF, RED_NETHER_BRICK_ROOF, END_STONE_BRICK_ROOF, SMOOTH_QUARTZ_ROOF, PRISMARINE_BRICK_ROOF,
                BLACKSTONE_ROOF, POLISHED_BLACKSTONE_BRICK_ROOF, POLISHED_BLACKSTONE_ROOF,

                GRANITE_ARCH, DIORITE_ARCH, ANDESITE_ARCH, COBBLED_DEEPSLATE_ARCH, POLISHED_DEEPSLATE_ARCH, COBBLESTONE_ARCH, SANDSTONE_ARCH,
                RED_SANDSTONE_ARCH, BRICK_ARCH, MOSSY_COBBLESTONE_ARCH, STONE_BRICK_ARCH, MOSSY_STONE_BRICK_ARCH, DEEPSLATE_BRICK_ARCH,
                DEEPSLATE_TILE_ARCH, NETHER_BRICK_ARCH, RED_NETHER_BRICK_ARCH, END_STONE_BRICK_ARCH, SMOOTH_QUARTZ_ARCH, PRISMARINE_BRICK_ARCH,
                BLACKSTONE_ARCH, POLISHED_BLACKSTONE_BRICK_ARCH, POLISHED_BLACKSTONE_ARCH,

                OAK_BEAM, SPRUCE_BEAM, BIRCH_BEAM, JUNGLE_BEAM, ACACIA_BEAM, DARK_OAK_BEAM, CRIMSON_BEAM, WARPED_BEAM,
                IRON_H_BEAM,

                OAK_FENCE_POST, SPRUCE_FENCE_POST, BIRCH_FENCE_POST, JUNGLE_FENCE_POST, ACACIA_FENCE_POST, DARK_OAK_FENCE_POST,
                CRIMSON_FENCE_POST, WARPED_FENCE_POST,

                OAK_JOIST, SPRUCE_JOIST, BIRCH_JOIST, JUNGLE_JOIST, ACACIA_JOIST, DARK_OAK_JOIST, CRIMSON_JOIST, WARPED_JOIST,

                OAK_CROWN_MOLDING, SPRUCE_CROWN_MOLDING, BIRCH_CROWN_MOLDING, JUNGLE_CROWN_MOLDING, ACACIA_CROWN_MOLDING,
                DARK_OAK_CROWN_MOLDING, CRIMSON_CROWN_MOLDING, WARPED_CROWN_MOLDING,

                BAMBOO_ROD, COPPER_ROD, END_ROD_NUBLESS, IRON_ROD, DEBUGGY_BLOCK, FAKE_END_PORTAL_BLOCK,

                OAK_POST_CAP, OAK_POST_LANTERN, SPRUCE_POST_CAP, SPRUCE_POST_LANTERN, BIRCH_POST_CAP, BIRCH_POST_LANTERN, JUNGLE_POST_CAP,
                JUNGLE_POST_LANTERN, ACACIA_POST_CAP, ACACIA_POST_LANTERN, DARK_OAK_POST_CAP, DARK_OAK_POST_LANTERN, CRIMSON_POST_CAP,
                CRIMSON_POST_LANTERN, WARPED_POST_CAP, WARPED_POST_LANTERN
        };

        // Checks to see if the arrays are of the same length. If not, stop the Minecraft process.
        if (blocksArray.length != anotherBlocksArray.length) {
            throw new RuntimeException("Mismatched array lengths.\nLength of blocksArray: " + blocksArray.length +
                    "\nLength of anotherBlocksArray: " + anotherBlocksArray.length);
        }

        // Loops through the length of both arrays and registers the blocks found in said arrays.
        for (int i = 0; i < blocksArray.length; i++) {
            Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", blocksArray[i]), anotherBlocksArray[i]);
            Registry.register(Registry.ITEM, new Identifier("architecture_extensions", blocksArray[i]),
                    new BlockItem(anotherBlocksArray[i], new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
        }
    }

    public static void init() {}
}
