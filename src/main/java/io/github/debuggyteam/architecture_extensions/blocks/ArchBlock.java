package io.github.debuggyteam.architecture_extensions.blocks;

import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.text.MutableText;

public class ArchBlock extends StairsBlock implements TypedGrouped {
	protected final TypedGroupedBlock typedGroupedBlock;
	
	// This is a super class of settings.
	public ArchBlock(BlockState blockState, Settings settings, TypedGroupedBlock typedGroupedBlock) {
		super(blockState, settings);
		this.typedGroupedBlock = typedGroupedBlock;
	}
	
	public ArchBlock(Block block, QuiltBlockSettings settings, TypedGroupedBlock typedGroupedBlock) {
		this(block.getDefaultState(), settings, typedGroupedBlock);
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
