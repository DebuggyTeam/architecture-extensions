package io.github.debuggyteam.architecture_extensions.blocks;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class BeamBlock extends PillarBlock implements Waterloggable {
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

	protected static final VoxelShape X_AXIS_BOX = Block.createCuboidShape(0.0, 2.0, 2.0, 16.0, 14.0, 14.0);
	protected static final VoxelShape Y_AXIS_BOX = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
	protected static final VoxelShape Z_AXIS_BOX = Block.createCuboidShape(2.0, 2.0, 0.0, 14.0, 14.0, 16.0);

	public BeamBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y).with(WATERLOGGED, false)); // Thanks LambdAurora!
	}

	// The following deals with block rotation
	@Override
	public BlockState rotate(BlockState state, BlockRotation rotation)  {
		return changeRotation(state, rotation);
	}

	public static BlockState changeRotation(BlockState state, BlockRotation rotation) {
		return switch (rotation) {
			case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.get(AXIS)) {
				case X -> state.with(AXIS, Direction.Axis.Z);
				case Z -> state.with(AXIS, Direction.Axis.X);
				default -> state;
			};
			default -> state;
		};
	}

	// Both of the following blocks of code below deals with block collision.
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		Direction.Axis cardinalDir = state.get(AXIS);
		return switch (cardinalDir) {
			case X -> X_AXIS_BOX;
			case Y -> Y_AXIS_BOX;
			case Z -> Z_AXIS_BOX;
		};
	}

	// Deals with placing the block properly in accordance to direction.
	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(AXIS, context.getSide().getAxis()).with(WATERLOGGED, context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER);
	}

	// Deals with block waterlogging. Thanks acikek!
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		if (state.get(WATERLOGGED)) world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));

		return state;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(AXIS, WATERLOGGED);
	}
}
