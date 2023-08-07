package io.github.debuggyteam.architecture_extensions.blocks;

import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.text.MutableText;

public class RoofBlock extends StairsBlock implements TypedGrouped {
	
	protected final TypedGroupedBlock typedGroupedBlock;
	
	public RoofBlock(BlockState blockState, Settings settings, TypedGroupedBlock typedGroupedBlock) {
		super(blockState, settings);
		this.typedGroupedBlock = typedGroupedBlock;
	}
	
	public RoofBlock(Block baseBlock, Settings settings, TypedGroupedBlock typedGroupedBlock) {
		this (baseBlock.getDefaultState(), settings, typedGroupedBlock);
	}

	@Override
	public TypedGroupedBlock getTypedGroupedBlock() {
		return typedGroupedBlock;
	}
	
	@Override
	public MutableText getName() {
		return getServerTranslation();
	}
}
