package io.github.woodiertexas.architecture_extensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RodBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class RodBlockTwo extends RodBlock {
    protected static final VoxelShape X_AXIS_BOX = Block.createCuboidShape(0.0, 6.0, 6.0, 16.0, 10.0, 10.0);
    protected static final VoxelShape Y_AXIS_BOX = Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
    protected static final VoxelShape Z_AXIS_BOX = Block.createCuboidShape(6.0, 6.0, 0.0, 10.0, 10.0, 16.0);

    public RodBlockTwo(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.UP));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction dir = ctx.getSide();
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(dir.getOpposite()));
        return blockState.isOf(this) && blockState.get(FACING) == dir
                ? this.getDefaultState().with(FACING, dir.getOpposite())
                : this.getDefaultState().with(FACING, dir);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING).getAxis()) {
            case X -> X_AXIS_BOX;
            case Y -> Y_AXIS_BOX;
            case Z -> Z_AXIS_BOX;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING).getAxis()) {
            case X -> X_AXIS_BOX;
            case Y -> Y_AXIS_BOX;
            case Z -> Z_AXIS_BOX;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.NORMAL;
    }
}
