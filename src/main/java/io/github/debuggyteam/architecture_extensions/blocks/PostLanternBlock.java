package io.github.debuggyteam.architecture_extensions.blocks;

import io.github.debuggyteam.architecture_extensions.util.VoxelHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class PostLanternBlock extends Block {
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	public static final BooleanProperty HANGING = Properties.HANGING;
	
	private static final VoxelShape LANTERN_BODY = Block.createCuboidShape(5, 0, 5, 11, 6, 11);
	private static final VoxelShape LANTERN_CAP = Block.createCuboidShape(4, 5, 4, 12, 6, 12);
	private static final VoxelShape LANTERN_FINIAL = Block.createCuboidShape(6, 6, 6, 10, 7, 10);
	
	private static final VoxelShape POST_LANTERN_SHAPE = VoxelShapes.combine(
			VoxelShapes.combine(LANTERN_BODY, LANTERN_CAP, BooleanBiFunction.OR),
			LANTERN_FINIAL, BooleanBiFunction.OR);
	
	private static final VoxelShape HANGING_LANTERN_BODY = Block.createCuboidShape(5, 9, 5, 11, 15, 11);
	private static final VoxelShape HANGING_LANTERN_CAP = Block.createCuboidShape(4, 14, 4, 12, 15, 12);
	private static final VoxelShape HANGING_LANTERN_FINIAL = Block.createCuboidShape(6, 15, 6, 10, 16, 10);
	
	private static final VoxelShape HANGING_POST_LANTERN_SHAPE = VoxelShapes.combine(
			VoxelShapes.combine(HANGING_LANTERN_BODY, HANGING_LANTERN_CAP, BooleanBiFunction.OR),
			HANGING_LANTERN_FINIAL, BooleanBiFunction.OR);

	public PostLanternBlock(Settings settings) {
		super(settings.luminance(state -> 15));
		this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false)); // Thanks LambdAurora!
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		return state.get(HANGING) ? HANGING_POST_LANTERN_SHAPE : POST_LANTERN_SHAPE;
	}
	
	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		BlockState placementState = this.getDefaultState();
		
		if (context.getSide().equals(Direction.DOWN)) {
			placementState = placementState.with(HANGING, canHang(context.getWorld(), context.getBlockPos()));
		} else {
			placementState = placementState.with(HANGING, false);
		}
		
		// Deals with waterlogging. Thanks acikek!
		return placementState.with(WATERLOGGED, context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		if (state.get(WATERLOGGED)) world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		
		if (state.get(HANGING)) {
			//Make sure we can still hang from the block above us, and if not, do not hang
			if (!canHang(world, pos)) {
				return state.with(HANGING, false);
			}
		} else {
			/*
			 * This is more complicated because we kind of favor the non-hanging status. If we're not ahnging, but the
			 * block below us is completely air, and we discover that there's something to hang from, go ahead and hang.
			 */
			if (world.getBlockState(pos.down()).isAir()) {
				if (canHang(world, pos)) {
					return state.with(HANGING, true);
				}
			}
		}
		
		return state;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED).add(HANGING);
	}
	
	public static boolean canHang(BlockView world, BlockPos pos) {
		BlockPos above = pos.up();
		VoxelShape shape = world.getBlockState(above).getCollisionShape(world, above);
		
		if (!VoxelHelper.testVoxel(shape, 7, 0, 7)) return false;
		if (!VoxelHelper.testVoxel(shape, 7, 0, 8)) return false;
		if (!VoxelHelper.testVoxel(shape, 8, 0, 7)) return false;
		if (!VoxelHelper.testVoxel(shape, 8, 0, 8)) return false;
		
		return true;
	}
}
