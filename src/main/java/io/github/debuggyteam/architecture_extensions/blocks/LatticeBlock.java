package io.github.debuggyteam.architecture_extensions.blocks;

import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.MutableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class LatticeBlock extends HorizontalFacingBlock implements Waterloggable, TypedGrouped {
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	
	protected static final VoxelShape X_BOX = Block.createCuboidShape(0.0, 0.0, 7.0, 16.0, 16.0, 9.0);
	protected static final VoxelShape Y_BOX = Block.createCuboidShape(7.0, 0.0, 0.0, 9.0, 16.0, 16.0);
	
	protected final TypedGroupedBlock typedGroupedBlock;
	
	public LatticeBlock(Settings settings, TypedGroupedBlock typedGroupedBlock) {
		super(settings);
		this.typedGroupedBlock = typedGroupedBlock;
	}
	
	public LatticeBlock(Block baseBlock, Settings settings, TypedGroupedBlock typedGroupedBlock) {
		this(settings, typedGroupedBlock);
	}
	
	// The following deals with block rotation
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		Direction cardinalDir = state.get(FACING);
		return switch (cardinalDir) {
			case NORTH, SOUTH -> X_BOX;
			case EAST, WEST -> Y_BOX;
			default -> VoxelShapes.fullCube();
		};
	}
	
	// Deals with placing the block properly in accordance to direction.
	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		//World world = context.getWorld();
		//BlockPos pos = context.getBlockPos();
		return this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getPlayerFacing()).with(WATERLOGGED, context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER);
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
		builder.add(Properties.HORIZONTAL_FACING);
		builder.add(WATERLOGGED);
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
