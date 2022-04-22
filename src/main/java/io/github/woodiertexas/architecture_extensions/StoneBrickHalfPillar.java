package io.github.woodiertexas.architecture_extensions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class StoneBrickHalfPillar extends HorizontalFacingBlock {
	protected StoneBrickHalfPillar(Settings settings) {
		super(settings);
		setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(Properties.HORIZONTAL_FACING);
	}

	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		Direction cardinal_dir = state.get(FACING);
		return switch (cardinal_dir) {
			case NORTH -> VoxelShapes.cuboid(0.125f, 0f, 0f, 0.875f, 1f, 0.254f);
			case SOUTH -> VoxelShapes.cuboid(0.125f, 0f, 0.746f, 0.875f, 1f, 1f);
			case EAST -> VoxelShapes.cuboid(0.746f, 0f, 0.125f, 1f, 1f, 0.875f);
			case WEST -> VoxelShapes.cuboid(0f, 0f, 0.125f, 0.254f, 1f, 0.875f);
			default -> VoxelShapes.fullCube();
		};
	}

	public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		Direction cardinal_dir = state.get(FACING);
		return switch (cardinal_dir) {
			case NORTH -> VoxelShapes.cuboid(0.125f, 0f, 0f, 0.875f, 1f, 0.254f);
			case SOUTH -> VoxelShapes.cuboid(0.125f, 0f, 0.746f, 0.875f, 1f, 1f);
			case EAST -> VoxelShapes.cuboid(0.746f, 0f, 0.125f, 1f, 1f, 0.875f);
			case WEST -> VoxelShapes.cuboid(0f, 0f, 0.125f, 0.254f, 1f, 0.875f);
			default -> VoxelShapes.fullCube();
		};
	}

	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getPlayerFacing());
	}
}
