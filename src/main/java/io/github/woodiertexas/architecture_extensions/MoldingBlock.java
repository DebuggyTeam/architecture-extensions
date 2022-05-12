package io.github.woodiertexas.architecture_extensions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class MoldingBlock extends StairsBlock {
    /*
    NE -> Northeast
    NW -> Northwest
    SE -> Southeast
    SW -> Southwest
     */
    protected static final VoxelShape NE_CORNER_FIRST = Block.createCuboidShape(0.0, 8.0, 0.0, 16.0, 16.0, 8.0);
    protected static final VoxelShape NE_CORNER_SECOND = Block.createCuboidShape(8.0, 8.0, 8.0, 16.0, 16.0, 16.0);

    protected static final VoxelShape SE_CORNER_FIRST = Block.createCuboidShape(8.0, 8.0, 0.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape SE_CORNER_SECOND = Block.createCuboidShape(0.0, 8.0, 8.0, 8.0, 16.0, 16.0);

    private static final VoxelShape northEast = VoxelShapes.union(NE_CORNER_FIRST, NE_CORNER_SECOND);
    private static final VoxelShape southEast = VoxelShapes.union(SE_CORNER_FIRST, SE_CORNER_SECOND);

    public MoldingBlock(BlockState blockState, Settings settings) {
        super(blockState, settings);
    }

    // Both of the following blocks of code below deals with block collision.
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction cardinalDir = state.get(FACING);
        BlockHalf upOrDown = state.get(HALF);
        StairShape whichCorner = state.get(SHAPE);
        return switch (upOrDown) {
            case TOP -> switch (cardinalDir) {
                case NORTH -> northEast; //VoxelShapes.cuboid(0f, 0.5f, 0f, 1f, 1f, 0.5f);
                case SOUTH -> southEast; //VoxelShapes.cuboid(0f, 0.5f, 0.5f, 1f, 1f, 1f);
                case EAST -> VoxelShapes.cuboid(0.5f, 0.5f, 0f, 1f, 1f, 1f);
                case WEST -> VoxelShapes.cuboid(0f, 0.5f, 0f, 0.5f, 1f, 1f);
                default -> VoxelShapes.fullCube();
            };
            case BOTTOM -> switch (cardinalDir) {
                case NORTH -> VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.5f, 0.5f);
                case SOUTH -> VoxelShapes.cuboid(0f, 0f, 0.5f, 1f, 0.5f, 1f);
                case EAST -> VoxelShapes.cuboid(0.5f, 0f, 0f, 1f, 0.5f, 1f);
                case WEST -> VoxelShapes.cuboid(0f, 0f, 0f, 0.5f, 0.5f, 1f);
                default -> VoxelShapes.fullCube();
            };
            //throw new IllegalStateException("Unexpected value: " + upOrDown);
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction cardinal_dir = state.get(FACING);
        BlockHalf upOrDown = state.get(HALF);
        return switch (upOrDown) {
            case TOP -> switch (cardinal_dir) {
                case NORTH -> VoxelShapes.cuboid(0f, 0.5f, 0f, 1f, 1f, 0.5f);
                case SOUTH -> VoxelShapes.cuboid(0f, 0.5f, 0.5f, 1f, 1f, 1f);
                case EAST -> VoxelShapes.cuboid(0.5f, 0.5f, 0f, 1f, 1f, 1f);
                case WEST -> VoxelShapes.cuboid(0f, 0.5f, 0f, 0.5f, 1f, 1f);
                default -> VoxelShapes.fullCube();
            };
            case BOTTOM -> switch (cardinal_dir) {
                case NORTH -> VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.5f, 0.5f);
                case SOUTH -> VoxelShapes.cuboid(0f, 0f, 0.5f, 1f, 0.5f, 1f);
                case EAST -> VoxelShapes.cuboid(0.5f, 0f, 0f, 1f, 0.5f, 1f);
                case WEST -> VoxelShapes.cuboid(0f, 0f, 0f, 0.5f, 0.5f, 1f);
                default -> VoxelShapes.fullCube();
            };
            //throw new IllegalStateException("Unexpected value: " + upOrDown);
        };
    }
}
