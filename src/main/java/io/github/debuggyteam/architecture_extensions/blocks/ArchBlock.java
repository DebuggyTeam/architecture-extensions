package io.github.debuggyteam.architecture_extensions.blocks;

import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class ArchBlock extends StairsBlock implements TypedGrouped {
	protected final TypedGroupedBlock typedGroupedBlock;
	
	// This is a super class of settings.
	public ArchBlock(BlockState blockState, Settings settings, TypedGroupedBlock typedGrouped) {
		super(blockState, settings);
		this.typedGroupedBlock = typedGrouped;
	}

	@Override
	public TypedGroupedBlock getTypedGroupedBlock() {
		return typedGroupedBlock;
	}
}
