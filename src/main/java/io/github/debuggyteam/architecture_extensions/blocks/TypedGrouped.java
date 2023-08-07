package io.github.debuggyteam.architecture_extensions.blocks;

import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public interface TypedGrouped {
	public static final String GROUPED_BLOCK_PREFIX = "architecture_extensions.grouped_block";
	
	public TypedGroupedBlock getTypedGroupedBlock();
	
	public default MutableText getServerTranslation() {
		Identifier blockId = getTypedGroupedBlock().groupedBlock().id();
		
		boolean isVanilla = blockId.getNamespace().equals("minecraft") || blockId.getNamespace().equals("");
		
		if (isVanilla) {
			//Our vanillaIntegration is legacy
			String lessIdeal = GROUPED_BLOCK_PREFIX + "." + blockId.getPath();
			return Text.translatable(lessIdeal);
		} else {
			//Assume everyone else is not legacy
			String ideal = GROUPED_BLOCK_PREFIX + "." + blockId.getNamespace() + "." + blockId.getPath();
			return Text.translatable(ideal);
		}
	}
}
