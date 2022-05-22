package io.github.woodiertexas.architecture_extensions.compat;

import io.github.woodiertexas.architecture_extensions.blocks.BeamBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ArchExAurorasDecoCompat {
    // Beam Blocks
    public static final BeamBlock AZALEA_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final BeamBlock JACARANDA_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));


    static {

        // Block string names
        String[] blocksArray = {
            "azalea_beam", "jacaranda_beam"
        };

        // Block literal names
        Block[] anotherBlocksArray = {
            AZALEA_BEAM, JACARANDA_BEAM
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
