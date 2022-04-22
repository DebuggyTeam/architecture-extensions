package io.github.woodiertexas.architecture_extensions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import static net.minecraft.block.FacingBlock.FACING;

public class StoneBrickCircleCorner extends Block {
    protected StoneBrickCircleCorner(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FACING);
    }

    /*
    Both of the following blocks of code below deals with block collision.
     */
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction cardinal_dir = state.get(FACING);
        return switch (cardinal_dir) {
            case NORTH -> VoxelShapes.cuboid(0f, 0f, 0.25f, 1f, 0.75f, 1f);
            case SOUTH -> VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.75f, 0.75f);
            case EAST -> VoxelShapes.cuboid(0f, 0f, 0f, 0.75f, 0.75f, 1f);
            case WEST -> VoxelShapes.cuboid(0.25f, 0f, 0f, 1f, 0.75f, 1f);
            default -> VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.75f, 0.75f);
        };
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction cardinal_dir = state.get(FACING);
        return switch (cardinal_dir) {
            case NORTH -> VoxelShapes.cuboid(0f, 0f, 0.25f, 1f, 0.75f, 1f);
            case SOUTH -> VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.75f, 0.75f);
            case EAST -> VoxelShapes.cuboid(0f, 0f, 0f, 0.75f, 0.75f, 1f);
            case WEST -> VoxelShapes.cuboid(0.25f, 0f, 0f, 1f, 0.75f, 1f);
            default -> VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.75f, 0.75f);
        };
    }

    /*
    Deals with placing the block properly in accordance to direction.
     */
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction side = context.getSide();
        BlockState blockState = context.getWorld().getBlockState(context.getBlockPos().offset(side));
        return blockState.isOf(this) && blockState.get(FACING) == side
                ? this.getDefaultState().with(FACING, side.getOpposite())
                : this.getDefaultState().with(FACING, side);
    }
}