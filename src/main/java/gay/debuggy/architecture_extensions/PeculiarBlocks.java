package gay.debuggy.architecture_extensions;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.EndRodBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class PeculiarBlocks {
	public static final Block END_ROD_NUBLESS = new EndRodBlock(AbstractBlock.Settings.create().strength(1f).luminance(state -> 14).nonOpaque().toolRequired());

	public static final Block DEBUGGY_BLOCK = new Block(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.WOOL).toolRequired());

	public static final Block FAKE_END_PORTAL_BLOCK = new Block(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.WOOL).toolRequired());

	private static <T extends Block> T registerBlock(Identifier id, T block) {
		T registeredBlock = Registry.register(Registries.BLOCK, id, block);
		var item = Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
		ItemGroupUtil.pull(ArchitectureExtensions.ITEM_GROUP, null, null, item);
		return registeredBlock;
	}

	public static void register() {
		registerBlock(ArchitectureExtensions.id("end_rod_nubless"), END_ROD_NUBLESS);
		registerBlock(ArchitectureExtensions.id("debuggy_block"), DEBUGGY_BLOCK);
		registerBlock(ArchitectureExtensions.id("fake_end_portal_block"), FAKE_END_PORTAL_BLOCK);
	}
}
