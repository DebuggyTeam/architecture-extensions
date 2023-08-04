package io.github.debuggyteam.architecture_extensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TransomBlock extends HorizontalFacingBlock {
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

	protected static final VoxelShape NORTH_BOX = Block.createCuboidShape(2.0, 0.0, 0.0, 14.0, 16.0, 4.0);
	protected static final VoxelShape SOUTH_BOX = Block.createCuboidShape(2.0, 0.0, 12.0, 14.0, 16.0, 16.0);
	protected static final VoxelShape EAST_BOX = Block.createCuboidShape(12.0, 0.0, 2.0, 16.0, 16.0, 14.0);
	protected static final VoxelShape WEST_BOX = Block.createCuboidShape(0.0, 0.0, 2.0, 4.0, 16.0, 14.0);

	public TransomBlock(Settings settings) {
		super(settings);
		setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
	}

	// Both of the following blocks of code below deals with block collision.
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		Direction cardinalDir = state.get(FACING);
		return switch (cardinalDir) {
			case NORTH -> NORTH_BOX;
			case SOUTH -> SOUTH_BOX;
			case EAST -> EAST_BOX;
			case WEST -> WEST_BOX;
			default -> VoxelShapes.fullCube();
		};
	}

	// Deals with placing the block properly in accordance to direction.
	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getPlayerFacing()).with(WATERLOGGED, context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER);
	}

	// Deals with block waterlogging. Thanks acikek!
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(Properties.HORIZONTAL_FACING, WATERLOGGED);
	}
}
