package io.github.woodiertexas.architecture_extensions;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class ArchExBlockSettings {
    public static QuiltBlockSettings baseSettings(Material material) {
        return QuiltBlockSettings.of(material).requiresTool();
    }

    public static final AbstractBlock.Settings COLUMNS = baseSettings(Material.STONE).strength(2.5f);
}
