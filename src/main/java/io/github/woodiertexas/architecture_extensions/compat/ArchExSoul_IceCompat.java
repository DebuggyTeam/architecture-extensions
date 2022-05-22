package io.github.woodiertexas.architecture_extensions.compat;

import io.github.woodiertexas.architecture_extensions.blocks.ColumnBlock;
import io.github.woodiertexas.architecture_extensions.blocks.PostBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ArchExSoul_IceCompat {
    // Columns
    public static final ColumnBlock HARDENED_LIGHTSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final ColumnBlock LIGHTSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final ColumnBlock LIGHTSTONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final ColumnBlock POLISHED_LIGHTSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final ColumnBlock SOUL_ICE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));
    public static final ColumnBlock SOUL_ICE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));
    public static final ColumnBlock POLISHED_SOUL_ICE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));

    // Post Blocks
    public static final PostBlock HARDENED_LIGHTSTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final PostBlock LIGHTSTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final PostBlock LIGHTSTONE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final PostBlock POLISHED_LIGHTSTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final PostBlock SOUL_ICE_POST = new PostBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));
    public static final PostBlock SOUL_ICE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));
    public static final PostBlock POLISHED_SOUL_ICE_POST = new PostBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));

    // Roof Blocks


    static {

        // Block string names
        String[] blocksArray = {
                "hardened_lightstone_column", "lightstone_column", "lightstone_brick_column", "polished_lightstone_column",
                "polished_soul_ice_column", "soul_ice_column", "soul_ice_brick_column", "hardened_lightstone_post",
                "lightstone_post", "lightstone_brick_post", "polished_lightstone_post", "soul_ice_post", "soul_ice_brick_post",
                "polished_soul_ice_post"
        };

        // Block literal names
        Block[] anotherBlocksArray = {
                HARDENED_LIGHTSTONE_COLUMN, LIGHTSTONE_COLUMN, LIGHTSTONE_BRICK_COLUMN, POLISHED_LIGHTSTONE_COLUMN,
                POLISHED_SOUL_ICE_COLUMN, SOUL_ICE_COLUMN, SOUL_ICE_BRICK_COLUMN, HARDENED_LIGHTSTONE_POST, LIGHTSTONE_POST,
                LIGHTSTONE_BRICK_POST, POLISHED_LIGHTSTONE_POST, SOUL_ICE_POST, SOUL_ICE_BRICK_POST, POLISHED_SOUL_ICE_POST
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
