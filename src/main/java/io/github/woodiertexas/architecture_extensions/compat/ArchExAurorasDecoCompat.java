package io.github.woodiertexas.architecture_extensions.compat;

import io.github.woodiertexas.architecture_extensions.blocks.BeamBlock;
import io.github.woodiertexas.architecture_extensions.blocks.FencePostBlock;
import io.github.woodiertexas.architecture_extensions.blocks.JoistBlock;
import io.github.woodiertexas.architecture_extensions.blocks.MoldingBlock;
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

public class ArchExAurorasDecoCompat {
    // Beam Blocks
    public static final BeamBlock AZALEA_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final BeamBlock JACARANDA_BEAM = new BeamBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());

    // Fence Post Blocks
    public static final FencePostBlock AZALEA_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final FencePostBlock JACARANDA_FENCE_POST = new FencePostBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());

    // Joist Blocks
    public static final JoistBlock AZALEA_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final JoistBlock JACARANDA_JOIST = new JoistBlock(QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    
    // Molding Blocks
    public static final MoldingBlock AZALEA_CROWN_MOLDING = new MoldingBlock(Blocks.ACACIA_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());
    public static final MoldingBlock JACARANDA_CROWN_MOLDING = new MoldingBlock(Blocks.ACACIA_PLANKS.getDefaultState(), QuiltBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD).requiresTool());


    static {
        /*
        List of blocks to be registered in key, value pairs.
        For example, "cobblestone_column, COBBLESTONE_COLUMN"
         */
        Map<String, Block> blocks = new LinkedHashMap<>();
            blocks.put("azalea_beam", AZALEA_BEAM);
            blocks.put("jacaranda_beam", JACARANDA_BEAM);
            blocks.put("azalea_fence_post", AZALEA_FENCE_POST);
            blocks.put("jacaranda_fence_post", JACARANDA_FENCE_POST);
            blocks.put("azalea_joist", AZALEA_JOIST);
            blocks.put("jacaranda_joist", JACARANDA_JOIST);
            blocks.put("azalea_crown_molding", AZALEA_CROWN_MOLDING);
            blocks.put("jacaranda_crown_molding", JACARANDA_CROWN_MOLDING);

        // Registering the blocks and corresponding block items.
        for (Map.Entry<String, Block> entry : blocks.entrySet()) {
            Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", entry.getKey()), entry.getValue());
            Registry.register(Registry.ITEM, new Identifier("architecture_extensions", entry.getKey()),
                    new BlockItem(entry.getValue(), new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
        }
    }

    public static void init() {}
}
