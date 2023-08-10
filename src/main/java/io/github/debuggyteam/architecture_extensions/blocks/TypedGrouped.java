package io.github.debuggyteam.architecture_extensions.blocks;

import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public interface TypedGrouped {
	public static final String GROUPED_BLOCK_PREFIX = "architecture_extensions.grouped_block";
	public static final String BLOCKTYPE_BLOCK_KEY = "architecture_extensions.block_type_block";
	public static final String BLOCK_TYPE_PREFIX = "architecture_extensions.block_type";
	
	public TypedGroupedBlock getTypedGroupedBlock();
	
	public default MutableText getServerTranslation() {
		String typeId = getTypedGroupedBlock().type().toString();
		Identifier blockId = getTypedGroupedBlock().groupedBlock().id();
		
		boolean isVanilla = blockId.getNamespace().equals("minecraft") || blockId.getNamespace().equals("");
		
		MutableText baseBlockName = (isVanilla) ?
			//Our VanillaIntegration keys are all legacy ones
			Text.translatable(GROUPED_BLOCK_PREFIX + "." + blockId.getPath()) :
			//Assume everyone else is not legacy
			Text.translatable(GROUPED_BLOCK_PREFIX + "." + blockId.getNamespace() + "." + blockId.getPath());
		
		MutableText blockTypeName = Text.translatable(BLOCK_TYPE_PREFIX + "." + typeId);
		
		return Text.translatable(BLOCKTYPE_BLOCK_KEY, baseBlockName, blockTypeName);
		
	}
}
