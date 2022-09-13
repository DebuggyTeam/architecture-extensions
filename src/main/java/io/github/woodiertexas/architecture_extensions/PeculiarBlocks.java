package io.github.woodiertexas.architecture_extensions;

import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import net.minecraft.block.Block;
import net.minecraft.block.EndRodBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PeculiarBlocks {
	public static final EndRodBlock END_ROD_NUBLESS = registerBlock(ArchitectureExtensions.id("end_rod_nubless"),
																	new EndRodBlock(QuiltBlockSettings.of(Material.STONE).strength(1f).luminance(14).nonOpaque().requiresTool()));

	public static final Block DEBUGGY_BLOCK = registerBlock(ArchitectureExtensions.id("debuggy_block"),
															new Block(QuiltBlockSettings.of(Material.WOOL).strength(1f).sounds(BlockSoundGroup.WOOL).requiresTool()));

	public static final Block FAKE_END_PORTAL_BLOCK = registerBlock(ArchitectureExtensions.id("fake_end_portal_block"),
																	new Block(QuiltBlockSettings.of(Material.WOOL).strength(1f).sounds(BlockSoundGroup.WOOL).requiresTool()));

	private static <T extends Block> T registerBlock(Identifier id, T block) {
		T registeredBlock = Registry.register(Registry.BLOCK, id, block);
		Registry.register(Registry.ITEM, id, new BlockItem(registeredBlock, new QuiltItemSettings().group(VanillaIntegration.INSTANCE.itemGroup())));
		return registeredBlock;
	}

	public static void register() {}
}
