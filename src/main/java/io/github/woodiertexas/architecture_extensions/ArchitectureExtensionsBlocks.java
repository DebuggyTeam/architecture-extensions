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
    public static final Block STONE_BRICK_ARCH = new Block(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
    public static final HalfPillar STONE_BRICK_HALF_PILLAR = new HalfPillar(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
    public static final HalfPillarCap STONE_BRICK_HALF_PILLAR_CAP = new HalfPillarCap(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
    public static final CircleCorner STONE_BRICK_CIRCLE_CORNER = new CircleCorner(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
    public static final HalfPillar SANDSTONE_HALF_PILLAR = new HalfPillar(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final HalfPillarCap SANDSTONE_HALF_PILLAR_CAP = new HalfPillarCap(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final HalfPillar QUARTS_HALF_PILLAR = new HalfPillar(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final HalfPillarCap QUARTS_HALF_PILLAR_CAP = new HalfPillarCap(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());

    static {

        String[] blocksArray = {"stone_brick_arch", "stone_brick_half_pillar", "stone_brick_half_pillar_cap", "stone_brick_circle_corner",
                "sandstone_half_pillar", "sandstone_half_pillar_cap", "quarts_half_pillar", "quarts_half_pillar_cap"
        };

        Block[] anotherBlocksArray = {STONE_BRICK_ARCH, STONE_BRICK_HALF_PILLAR, STONE_BRICK_HALF_PILLAR_CAP, STONE_BRICK_CIRCLE_CORNER,
                SANDSTONE_HALF_PILLAR, SANDSTONE_HALF_PILLAR_CAP, QUARTS_HALF_PILLAR, QUARTS_HALF_PILLAR_CAP
        };

        // Checks to see if the arrays are of the same length. If not, stop the Minecraft process.
        if (blocksArray.length != anotherBlocksArray.length) {
            throw new RuntimeException("Mismatched array lengths.\nLength of blocksArray: " + blocksArray.length +
                    "\nLength of anotherBlocksArray: " + anotherBlocksArray.length);
        }

        for (int i = 0; i < blocksArray.length; i++) {
            Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", blocksArray[i]), anotherBlocksArray[i]);
            Registry.register(Registry.ITEM, new Identifier("architecture_extensions", blocksArray[i]),
                    new BlockItem(anotherBlocksArray[i], new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
        }
    }

    public static void init() {}
}
