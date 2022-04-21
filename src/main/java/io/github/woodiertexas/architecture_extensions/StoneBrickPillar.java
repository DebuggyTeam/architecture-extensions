package io.github.woodiertexas.architecture_extensions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class StoneBrickPillar extends Block {
	protected StoneBrickPillar(Settings settings) {
		super(settings);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		return VoxelShapes.cuboid(0.125f, 0f, 0f, 0.875f, 1f, 0.254f);
	}
}
