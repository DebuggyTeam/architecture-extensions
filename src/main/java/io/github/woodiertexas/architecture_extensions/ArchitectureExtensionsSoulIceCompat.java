package io.github.woodiertexas.architecture_extensions;

import io.github.woodiertexas.architecture_extensions.blocks.ColumnBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ArchitectureExtensionsSoulIceCompat {
    // Columns
    public static final ColumnBlock SOUL_ICE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).nonOpaque());
    public static final ColumnBlock SOUL_ICE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).nonOpaque());
    public static final ColumnBlock POLISHED_SOUL_ICE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).nonOpaque());

    // Post Blocks

    // Roof Blocks


    static {

        // Block string names
        String[] blocksArray = {
                "polished_soul_ice_column", "soul_ice_column", "soul_ice_brick_column"
        };

        // Block literal names
        Block[] anotherBlocksArray = {
                POLISHED_SOUL_ICE_COLUMN, SOUL_ICE_COLUMN, SOUL_ICE_BRICK_COLUMN
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
