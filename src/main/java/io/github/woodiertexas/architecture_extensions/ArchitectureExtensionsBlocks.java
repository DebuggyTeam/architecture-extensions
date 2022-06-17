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
    public static final CircleCorner STONE_BRICK_CIRCLE_CORNER = new CircleCorner(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());

    // Columns
    public static final ColumnBlock ANDESITE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock BLACKSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock COBBLED_DEEPSLATE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.DEEPSLATE));
    public static final ColumnBlock COBBLESTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock DARK_PRISMARINE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock DEEPSLATE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.DEEPSLATE_BRICKS));
    public static final ColumnBlock DEEPSLATE_TILE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final ColumnBlock DIORITE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock END_STONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock GRANITE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock MOSSY_COBBLESTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock MOSSY_STONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock NETHER_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final ColumnBlock POLISHED_BLACKSTONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock POLISHED_BLACKSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock POLISHED_DEEPSLATE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final ColumnBlock PRISMARINE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock QUARTZ_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock RED_NETHER_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final ColumnBlock RED_SANDSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock ROSE_QUARTZ_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock SANDSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final ColumnBlock STONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(4f));

    // Post Blocks
    public static final WallPostBlock ANDESITE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock BLACKSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock COBBLED_DEEPSLATE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.DEEPSLATE));
    public static final WallPostBlock COBBLESTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock DEEPSLATE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.DEEPSLATE_BRICKS));
    public static final WallPostBlock DEEPSLATE_TILE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final WallPostBlock DIORITE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock END_STONE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock GRANITE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock MOSSY_COBBLESTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock MOSSY_STONE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock NETHER_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final WallPostBlock POLISHED_BLACKSTONE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock POLISHED_BLACKSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock POLISHED_DEEPSLATE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final WallPostBlock PRISMARINE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock RED_NETHER_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final WallPostBlock RED_SANDSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock SANDSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f));
    public static final WallPostBlock STONE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.STONE).strength(4f));

    // Beam Blocks
    public static final BeamBlock OAK_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final BeamBlock SPRUCE_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final BeamBlock BIRCH_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final BeamBlock JUNGLE_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final BeamBlock ACACIA_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final BeamBlock DARK_OAK_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final BeamBlock CRIMSON_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final BeamBlock WARPED_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final BeamBlock IRON_H_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.METAL).strength(8f).sounds(BlockSoundGroup.ANVIL));

    // Fence Post Blocks
    public static final FencePostBlock OAK_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final FencePostBlock SPRUCE_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final FencePostBlock BIRCH_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final FencePostBlock JUNGLE_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final FencePostBlock ACACIA_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final FencePostBlock DARK_OAK_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final FencePostBlock CRIMSON_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final FencePostBlock WARPED_FENCE_POST= new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));

    // Joist Blocks
    public static final JoistBlock OAK_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final JoistBlock SPRUCE_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final JoistBlock BIRCH_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final JoistBlock JUNGLE_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final JoistBlock ACACIA_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final JoistBlock DARK_OAK_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final JoistBlock CRIMSON_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final JoistBlock WARPED_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));

    // Roof Blocks
    public static final RoofBlock COBBLESTONE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(4f));
    public static final RoofBlock NETHER_BRICK_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(4f));
    public static final RoofBlock RED_NETHER_BRICK_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(4f));
    public static final RoofBlock SMOOTH_QUARTZ_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(4f));
    public static final RoofBlock SMOOTH_RED_SANDSTONE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(4f));
    public static final RoofBlock SMOOTH_SANDSTONE_ROOF = new RoofBlock(Blocks.COBBLESTONE.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(4f));
    public static final RoofBlock STONE_BRICK_ROOF = new RoofBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(4f));
    public static final RoofBlock DEEPSLATE_BRICK_ROOF = new RoofBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(4f));

    // Arch Blocks
    public static final ArchBlock STONE_BRICK_ARCH = new ArchBlock(Blocks.STONE_BRICKS.getDefaultState(), QuiltBlockSettings.of(Material.STONE).strength(4f));

    // Crown Molding Blocks
    public static final MoldingBlock OAK_CROWN_MOLDING = new MoldingBlock(Blocks.OAK_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final MoldingBlock SPRUCE_CROWN_MOLDING = new MoldingBlock(Blocks.SPRUCE_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final MoldingBlock BIRCH_CROWN_MOLDING = new MoldingBlock(Blocks.BIRCH_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final MoldingBlock JUNGLE_CROWN_MOLDING = new MoldingBlock(Blocks.JUNGLE_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final MoldingBlock ACACIA_CROWN_MOLDING = new MoldingBlock(Blocks.ACACIA_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final MoldingBlock DARK_OAK_CROWN_MOLDING = new MoldingBlock(Blocks.DARK_OAK_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final MoldingBlock CRIMSON_CROWN_MOLDING = new MoldingBlock(Blocks.CRIMSON_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final MoldingBlock WARPED_CROWN_MOLDING = new MoldingBlock(Blocks.WARPED_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));

    //Rod Blocks
    public static final RodBlockTwo BAMBOO_ROD = new RodBlockTwo(QuiltBlockSettings.of(Material.BAMBOO).strength(1f).sounds(BlockSoundGroup.BAMBOO).nonOpaque());
    public static final RodBlockTwo COPPER_ROD = new RodBlockTwo(QuiltBlockSettings.of(Material.METAL).strength(1f).sounds(BlockSoundGroup.COPPER).nonOpaque());
    public static final RodBlockTwo END_ROD_NUBLESS = new RodBlockTwo(QuiltBlockSettings.of(Material.STONE).strength(1f).luminance(14).nonOpaque());

    //Peculiar Blocks
    public static final Block DEBUGGY_BLOCK = new Block(QuiltBlockSettings.of(Material.WOOL).strength(1f).sounds(BlockSoundGroup.WOOL));
    public static final Block FAKE_END_PORTAL_BLOCK = new Block(QuiltBlockSettings.of(Material.WOOL).strength(1f).sounds(BlockSoundGroup.WOOL));

    static {

        // Block string names
        String[] blocksArray = {
                "andesite_column", "blackstone_column", "brick_column", "cobbled_deepslate_column",
                "cobblestone_column", "dark_prismarine_column", "deepslate_brick_column", "deepslate_tile_column", "diorite_column",
                "end_stone_brick_column", "granite_column", "mossy_cobblestone_column", "mossy_stone_brick_column", "nether_brick_column",
                "polished_blackstone_brick_column", "polished_blackstone_column", "polished_deepslate_column", "prismarine_brick_column",
                "quartz_column", "red_nether_brick_column", "red_sandstone_column", "rose_quartz_column", "sandstone_column",
                "stone_brick_column", "andesite_post", "blackstone_post", "brick_post", "cobbled_deepslate_post", "cobblestone_post",
                "deepslate_brick_post", "deepslate_tile_post", "diorite_post", "end_stone_brick_post", "granite_post",
                "mossy_cobblestone_post", "mossy_stone_brick_post", "nether_brick_post", "polished_blackstone_brick_post",
                "polished_blackstone_post", "polished_deepslate_post", "prismarine_brick_post", "red_nether_brick_post",
                "red_sandstone_post", "sandstone_post", "stone_brick_post", "stone_brick_arch", "stone_brick_circle_corner",
                "acacia_beam", "birch_beam", "dark_oak_beam", "jungle_beam", "oak_beam", "spruce_beam", "crimson_beam", "warped_beam",
                "iron_h_beam", "cobblestone_roof", "nether_brick_roof", "red_nether_brick_roof", "smooth_quartz_roof",
                "smooth_red_sandstone_roof", "smooth_sandstone_roof", "stone_brick_roof", "debuggy_block", "fake_end_portal_block",
                "bamboo_rod", "copper_rod", "end_rod_nubless", "acacia_fence_post", "birch_fence_post", "dark_oak_fence_post",
                "jungle_fence_post", "oak_fence_post", "spruce_fence_post", "crimson_fence_post", "warped_fence_post",
                "acacia_joist", "birch_joist", "dark_oak_joist", "jungle_joist", "oak_joist", "spruce_joist", "crimson_joist",
                "warped_joist", "acacia_crown_molding", "birch_crown_molding", "dark_oak_crown_molding", "jungle_crown_molding",
                "oak_crown_molding", "spruce_crown_molding", "crimson_crown_molding", "warped_crown_molding", "deepslate_brick_roof"
        };

        // Block literal names
        Block[] anotherBlocksArray = {
                ANDESITE_COLUMN, BLACKSTONE_COLUMN, BRICK_COLUMN, COBBLED_DEEPSLATE_COLUMN, COBBLESTONE_COLUMN,
                DARK_PRISMARINE_COLUMN, DEEPSLATE_BRICK_COLUMN, DEEPSLATE_TILE_COLUMN, DIORITE_COLUMN, END_STONE_BRICK_COLUMN,
                GRANITE_COLUMN, MOSSY_COBBLESTONE_COLUMN, MOSSY_STONE_BRICK_COLUMN, NETHER_BRICK_COLUMN,
                POLISHED_BLACKSTONE_BRICK_COLUMN, POLISHED_BLACKSTONE_COLUMN, POLISHED_DEEPSLATE_COLUMN, PRISMARINE_BRICK_COLUMN,
                QUARTZ_COLUMN, RED_NETHER_BRICK_COLUMN, RED_SANDSTONE_COLUMN, ROSE_QUARTZ_COLUMN, SANDSTONE_COLUMN,
                STONE_BRICK_COLUMN, ANDESITE_POST, BLACKSTONE_POST, BRICK_POST, COBBLED_DEEPSLATE_POST, COBBLESTONE_POST,
                DEEPSLATE_BRICK_POST, DEEPSLATE_TILE_POST, DIORITE_POST, END_STONE_BRICK_POST, GRANITE_POST,
                MOSSY_COBBLESTONE_POST, MOSSY_STONE_BRICK_POST, NETHER_BRICK_POST, POLISHED_BLACKSTONE_BRICK_POST,
                POLISHED_BLACKSTONE_POST, POLISHED_DEEPSLATE_POST, PRISMARINE_BRICK_POST, RED_NETHER_BRICK_POST,
                RED_SANDSTONE_POST, SANDSTONE_POST, STONE_BRICK_POST, STONE_BRICK_ARCH, STONE_BRICK_CIRCLE_CORNER,
                ACACIA_BEAM, BIRCH_BEAM, DARK_OAK_BEAM, JUNGLE_BEAM, OAK_BEAM, SPRUCE_BEAM, CRIMSON_BEAM, WARPED_BEAM,
                IRON_H_BEAM, COBBLESTONE_ROOF, NETHER_BRICK_ROOF, RED_NETHER_BRICK_ROOF, SMOOTH_QUARTZ_ROOF, SMOOTH_RED_SANDSTONE_ROOF,
                SMOOTH_SANDSTONE_ROOF, STONE_BRICK_ROOF, DEBUGGY_BLOCK, FAKE_END_PORTAL_BLOCK, BAMBOO_ROD, COPPER_ROD, END_ROD_NUBLESS,
                ACACIA_FENCE_POST, BIRCH_FENCE_POST, DARK_OAK_FENCE_POST, JUNGLE_FENCE_POST, OAK_FENCE_POST, SPRUCE_FENCE_POST,
                CRIMSON_FENCE_POST, WARPED_FENCE_POST, ACACIA_JOIST, BIRCH_JOIST, DARK_OAK_JOIST, JUNGLE_JOIST, OAK_JOIST,
                SPRUCE_JOIST, CRIMSON_JOIST, WARPED_JOIST, ACACIA_CROWN_MOLDING, BIRCH_CROWN_MOLDING, DARK_OAK_CROWN_MOLDING,
                JUNGLE_CROWN_MOLDING, OAK_CROWN_MOLDING, SPRUCE_CROWN_MOLDING, CRIMSON_CROWN_MOLDING, WARPED_CROWN_MOLDING,
                DEEPSLATE_BRICK_ROOF
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
