package io.github.debuggyteam.architecture_extensions.blocks;

import io.github.debuggyteam.architecture_extensions.util.VoxelHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.datafixer.fix.ChunkPalettedStorageFix.Facing;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class PostLanternBlock extends Block {
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	public static final BooleanProperty HANGING = Properties.HANGING;

	protected static final VoxelShape POST_CAP_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);
	protected static final VoxelShape POST_CAP_HANGING_SHAPE = Block.createCuboidShape(5, 9, 5, 11, 15, 11);

	public PostLanternBlock(Settings settings) {
		super(settings.luminance(state -> 15));
		this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false)); // Thanks LambdAurora!
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		return state.get(HANGING) ? POST_CAP_HANGING_SHAPE : POST_CAP_SHAPE;
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
