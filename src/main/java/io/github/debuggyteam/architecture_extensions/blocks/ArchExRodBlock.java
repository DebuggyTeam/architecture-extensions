package io.github.debuggyteam.architecture_extensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RodBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

public class ArchExRodBlock extends RodBlock implements Waterloggable {
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

	public ArchExRodBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(FACING, Direction.UP).with(WATERLOGGED, false)); // Thanks LambdAurora!
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		Direction dir = ctx.getSide();
		BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(dir.getOpposite()));
		return blockState.isOf(this) && blockState.get(FACING) == dir
				? this.getDefaultState().with(FACING, dir.getOpposite()).with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
				: this.getDefaultState().with(FACING, dir).with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
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
		builder.add(FACING, WATERLOGGED);
	}
}
