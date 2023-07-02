package io.github.debuggyteam.architecture_extensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class OctagonalColumnBlock extends PillarBlock implements Waterloggable {
	public static final BooleanProperty MIN_CAP = BooleanProperty.of("min_cap");
	public static final BooleanProperty MAX_CAP = BooleanProperty.of("max_cap");
	public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	
	protected static final VoxelShape X_AXIS_BOX = Block.createCuboidShape(0.0, 4.0, 4.0, 16.0, 12.0, 12.0);
	protected static final VoxelShape Y_AXIS_BOX = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
	protected static final VoxelShape Z_AXIS_BOX = Block.createCuboidShape(4.0, 4.0, 0.0, 12.0, 12.0, 16.0);
	
	public OctagonalColumnBlock(Settings settings) {
		super(settings);
		this.setDefaultState(
				this.getDefaultState()
				.with(WATERLOGGED, false)
				.with(AXIS, Direction.Axis.Y)
				.with(MIN_CAP, false)
				.with(MAX_CAP, false)
			); // Thanks LambdAurora!
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
	
	// The following block of code below deals with block collision.
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
		BlockState initialState = this.getDefaultState().with(AXIS, context.getSide().getAxis());
		return getUpdatedState(context.getWorld(), context.getBlockPos(), initialState);
	}
	
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
	}
	
	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		if (state.get(WATERLOGGED)) world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		
		return getUpdatedState(world, pos, state);
	}
	
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(AXIS, MIN_CAP, MAX_CAP, WATERLOGGED);
	}
	
	public BlockState getUpdatedState(WorldAccess world, BlockPos pos, BlockState state) {
		Direction.Axis selfAxis = state.get(AXIS);
		
		BlockState minNeighbor = world.getBlockState(pos.offset(selfAxis, -1));
		boolean minCap = !(minNeighbor.getBlock() instanceof OctagonalColumnBlock &&
				minNeighbor.get(AXIS) == selfAxis);
		
		BlockState maxNeighbor = world.getBlockState(pos.offset(selfAxis, 1));
		boolean maxCap = !(maxNeighbor.getBlock() instanceof OctagonalColumnBlock &&
				maxNeighbor.get(AXIS) == selfAxis);
		
		return state.with(MIN_CAP, minCap).with(MAX_CAP, maxCap);
	}
}
