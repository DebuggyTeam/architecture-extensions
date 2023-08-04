package io.github.debuggyteam.architecture_extensions;

import org.quiltmc.loader.api.minecraft.ClientOnly;

import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import io.github.debuggyteam.architecture_extensions.blocks.TypedGrouped;
import net.minecraft.block.Block;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class TypedGroupedBlockItem extends BlockItem implements TypedGrouped {
	public static final String BLOCKTYPE_BLOCK_KEY = "architecture_extensions.block_type_block";
	public static final String GROUPED_BLOCK_PREFIX = "architecture_extensions.grouped_block";
	public static final String BLOCK_TYPE_PREFIX = "architecture_extensions.block_type";
	public static final String MISSING_LOCALIZATION_KEY = "architecture_extensions.i18n.missing_key";
	
	protected final TypedGroupedBlock typedGroupedBlock;
	
	@ClientOnly
	protected Text cachedLocalization = null;
	
	public <T extends Block & TypedGrouped> TypedGroupedBlockItem(T block, Settings settings) {
		super(block, settings);
		typedGroupedBlock = block.getTypedGroupedBlock();
	}
	
	public TypedGroupedBlockItem(Block block, TypedGroupedBlock typedGrouped, Settings settings) {
		super(block, settings);
		typedGroupedBlock = typedGrouped;
	}
	
	@ClientOnly
	private Text getBaseTranslationKey() {
		Identifier blockId = typedGroupedBlock.groupedBlock().id();
		
		String ideal = GROUPED_BLOCK_PREFIX + "." + blockId.getNamespace() + "." + blockId.getPath();
		if (I18n.hasTranslation(ideal)) return Text.translatable(ideal);
		
		String lessIdeal = GROUPED_BLOCK_PREFIX + "." + blockId.getPath();
		if (I18n.hasTranslation(lessIdeal)) return Text.translatable(lessIdeal);
		
		//This hover never actually displays since the tooltip is already a hover.
		//But this keeps the Null tradition alive and prevents the tooltip from becoming gigantic.
		return Text.literal("Null")
				.styled(it -> it.withHoverEvent(
						HoverEvent.Action.SHOW_TEXT.buildHoverEvent(Text.translatable(MISSING_LOCALIZATION_KEY, Text.literal(ideal)))
						));
	}

	@Override
	@ClientOnly
	public Text getName() {
		if (cachedLocalization == null) {
			
			String translationKey = Util.createTranslationKey("block", Registries.ITEM.getId(this));
			if (I18n.hasTranslation(translationKey)) {
				cachedLocalization = Text.translatable(translationKey);
			} else {
				Text baseBlock = getBaseTranslationKey();
				String typedGroupedKey = BLOCK_TYPE_PREFIX + "." + typedGroupedBlock.type().toString();
				Text blockType = Text.translatable(typedGroupedKey);
				
				cachedLocalization = Text.translatable(BLOCKTYPE_BLOCK_KEY, baseBlock, blockType);
			}
		}
		
		return cachedLocalization;
	}
	
	@Override
	public Text getName(ItemStack stack) {
		return getName();
	}

	@Override
	public TypedGroupedBlock getTypedGroupedBlock() {
		return this.typedGroupedBlock;
	}
}
