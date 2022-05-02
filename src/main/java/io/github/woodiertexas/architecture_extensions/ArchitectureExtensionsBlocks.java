package io.github.woodiertexas.architecture_extensions;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ArchitectureExtensionsBlocks {

    // Creating items/blocks/etc and defining their properties
    public static final ArchBlock STONE_BRICK_ARCH = new ArchBlock(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
    public static final CircleCorner STONE_BRICK_CIRCLE_CORNER = new CircleCorner(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());

    // Columns
    public static final ColumnBlock ANDESITE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock BLACKSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock COBBLED_DEEPSLATE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock COBBLESTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock DARK_PRISMARINE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock DEEPSLATE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock DEEPSLATE_TILE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock DIORITE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock END_STONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock GRANITE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock MOSSY_COBBLESTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock MOSSY_STONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock NETHER_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock POLISHED_BLACKSTONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock POLISHED_BLACKSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock POLISHED_DEEPSLATE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock PRISMARINE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock QUARTZ_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock RED_NETHER_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock RED_SANDSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock ROSE_QUARTZ_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock SANDSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock STONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());

    // Post Blocks
    public static final PostBlock ANDESITE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock BLACKSTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock COBBLED_DEEPSLATE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock COBBLESTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock DEEPSLATE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock DEEPSLATE_TILE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock DIORITE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock END_STONE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock GRANITE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock MOSSY_COBBLESTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock MOSSY_STONE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock NETHER_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock POLISHED_BLACKSTONE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock POLISHED_BLACKSTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock POLISHED_DEEPSLATE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock PRISMARINE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock RED_NETHER_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock RED_SANDSTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock SANDSTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final PostBlock STONE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
    static {

        // Block string names
        String[] blocksArray = {"andesite_column", "blackstone_column", "brick_column", "cobbled_deepslate_column",
                "cobblestone_column", "dark_prismarine_column", "deepslate_brick_column", "deepslate_tile_column", "diorite_column",
                "end_stone_brick_column", "granite_column", "mossy_cobblestone_column", "mossy_stone_brick_column", "nether_brick_column",
                "polished_blackstone_brick_column", "polished_blackstone_column", "polished_deepslate_column", "prismarine_brick_column",
                "quartz_column", "red_nether_brick_column", "red_sandstone_column", "rose_quartz_column", "sandstone_column",
                "stone_brick_column", "andesite_post", "blackstone_post", "brick_post", "cobbled_deepslate_post", "cobblestone_post",
                "deepslate_brick_post", "deepslate_tile_post", "diorite_post", "end_stone_brick_post", "granite_post",
                "mossy_cobblestone_post", "mossy_stone_brick_post", "nether_brick_post", "polished_blackstone_brick_post",
                "polished_blackstone_post", "polished_deepslate_post", "prismarine_brick_post", "red_nether_brick_post",
                "red_sandstone_post", "sandstone_post", "stone_brick_post", "stone_brick_arch", "stone_brick_circle_corner"
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
                RED_SANDSTONE_POST, SANDSTONE_POST, STONE_BRICK_POST, STONE_BRICK_ARCH, STONE_BRICK_CIRCLE_CORNER

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
