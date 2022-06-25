package io.github.woodiertexas.architecture_extensions.compat;

import io.github.woodiertexas.architecture_extensions.blocks.ArchBlock;
import io.github.woodiertexas.architecture_extensions.blocks.ColumnBlock;
import io.github.woodiertexas.architecture_extensions.blocks.WallPostBlock;
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

import java.util.LinkedHashMap;
import java.util.Map;

public class ArchExSoul_IceCompat {
    // Columns
    public static final ColumnBlock SOUL_ICE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(1.5f).sounds(BlockSoundGroup.GLASS).requiresTool());
    public static final ColumnBlock POLISHED_SOUL_ICE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(1.5f).sounds(BlockSoundGroup.GLASS).requiresTool());
    public static final ColumnBlock SOUL_ICE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(1.5f).sounds(BlockSoundGroup.GLASS).requiresTool());
    public static final ColumnBlock LIGHTSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final ColumnBlock POLISHED_LIGHTSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final ColumnBlock LIGHTSTONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final ColumnBlock HARDENED_LIGHTSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());

    // Posts
    public static final WallPostBlock SOUL_ICE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.ICE).strength(1.5f).sounds(BlockSoundGroup.GLASS).requiresTool());
    public static final WallPostBlock POLISHED_SOUL_ICE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.ICE).strength(1.5f).sounds(BlockSoundGroup.GLASS).requiresTool());
    public static final WallPostBlock SOUL_ICE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.ICE).strength(1.5f).sounds(BlockSoundGroup.GLASS).requiresTool());
    public static final WallPostBlock LIGHTSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final WallPostBlock POLISHED_LIGHTSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final WallPostBlock LIGHTSTONE_BRICK_POST = new WallPostBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final WallPostBlock HARDENED_LIGHTSTONE_POST = new WallPostBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());

    // Arches
    public static final ArchBlock SOUL_ICE_ARCH = new ArchBlock(Blocks.BLUE_ICE.getDefaultState(), QuiltBlockSettings.of(Material.ICE).strength(1.5f).sounds(BlockSoundGroup.GLASS).requiresTool());
    public static final ArchBlock POLISHED_SOUL_ICE_ARCH = new ArchBlock(Blocks.BLUE_ICE.getDefaultState(), QuiltBlockSettings.of(Material.ICE).strength(1.5f).sounds(BlockSoundGroup.GLASS).requiresTool());
    public static final ArchBlock SOUL_ICE_BRICK_ARCH = new ArchBlock(Blocks.BLUE_ICE.getDefaultState(), QuiltBlockSettings.of(Material.ICE).strength(1.5f).sounds(BlockSoundGroup.GLASS).requiresTool());
    public static final ArchBlock LIGHTSTONE_ARCH = new ArchBlock(Blocks.DEEPSLATE.getDefaultState(), QuiltBlockSettings.of(Material.ICE).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final ArchBlock POLISHED_LIGHTSTONE_ARCH = new ArchBlock(Blocks.DEEPSLATE.getDefaultState(), QuiltBlockSettings.of(Material.ICE).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final ArchBlock LIGHTSTONE_BRICK_ARCH = new ArchBlock(Blocks.DEEPSLATE.getDefaultState(), QuiltBlockSettings.of(Material.ICE).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());
    public static final ArchBlock HARDENED_LIGHTSTONE_ARCH = new ArchBlock(Blocks.DEEPSLATE.getDefaultState(), QuiltBlockSettings.of(Material.ICE).strength(2.5f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool());


    static {
        /*
        List of blocks to be registered in key, value pairs.
        For example, "cobblestone_column, COBBLESTONE_COLUMN"
         */
        Map<String, Block> blocks = new LinkedHashMap<>();
        blocks.put("soul_ice_column", SOUL_ICE_COLUMN);
        blocks.put("polished_soul_ice_column", POLISHED_SOUL_ICE_COLUMN);
        blocks.put("soul_ice_brick_column", SOUL_ICE_BRICK_COLUMN);
        blocks.put("lightstone_column", LIGHTSTONE_COLUMN);
        blocks.put("polished_lightstone_column", POLISHED_LIGHTSTONE_COLUMN);
        blocks.put("lightstone_brick_column", LIGHTSTONE_BRICK_COLUMN);
        blocks.put("hardened_lightstone_column", HARDENED_LIGHTSTONE_COLUMN);

        blocks.put("soul_ice_post", SOUL_ICE_POST);
        blocks.put("polished_soul_ice_post", POLISHED_SOUL_ICE_POST);
        blocks.put("soul_ice_brick_post", SOUL_ICE_BRICK_POST);
        blocks.put("lightstone_post", LIGHTSTONE_POST);
        blocks.put("polished_lightstone_post", POLISHED_LIGHTSTONE_POST);
        blocks.put("lightstone_brick_post", LIGHTSTONE_BRICK_POST);
        blocks.put("hardened_lightstone_post", HARDENED_LIGHTSTONE_POST);

        blocks.put("soul_ice_arch", SOUL_ICE_ARCH);
        blocks.put("polished_soul_ice_arch", POLISHED_SOUL_ICE_ARCH);
        blocks.put("soul_ice_brick_arch", SOUL_ICE_BRICK_ARCH);
        blocks.put("lightstone_arch", LIGHTSTONE_ARCH);
        blocks.put("polished_lightstone_arch", POLISHED_LIGHTSTONE_ARCH);
        blocks.put("lightstone_brick_arch", LIGHTSTONE_BRICK_ARCH);
        blocks.put("hardened_lightstone_arch", HARDENED_LIGHTSTONE_ARCH);

        // Registering the blocks and corresponding block items.
        for (Map.Entry<String, Block> entry : blocks.entrySet()) {
            Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", entry.getKey()), entry.getValue());
            Registry.register(Registry.ITEM, new Identifier("architecture_extensions", entry.getKey()),
                    new BlockItem(entry.getValue(), new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
        }

    }

    public static void init() {}
}
