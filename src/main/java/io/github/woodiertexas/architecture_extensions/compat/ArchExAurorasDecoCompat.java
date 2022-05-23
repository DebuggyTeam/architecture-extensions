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

import java.util.LinkedHashMap;
import java.util.Map;

public class ArchExAurorasDecoCompat {
    // Beam Blocks
    public static final BeamBlock AZALEA_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));
    public static final BeamBlock JACARANDA_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOD));


    static {
        /*
        List of blocks to be registered in key, value pairs.
        For example, "cobblestone_column, COBBLESTONE_COLUMN"
         */
        Map<String, Block> blocks = new LinkedHashMap<>();
            blocks.put("azalea_beam", AZALEA_BEAM);
            blocks.put("jacaranda_beam", JACARANDA_BEAM);

        // Registering the blocks and corresponding block items.
        for (Map.Entry<String, Block> entry : blocks.entrySet()) {
            Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", entry.getKey()), entry.getValue());
            Registry.register(Registry.ITEM, new Identifier("architecture_extensions", entry.getKey()),
                    new BlockItem(entry.getValue(), new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
        }
    }

    public static void init() {}
}
