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


    protected static final VoxelShape NORTH_BOX_TOP = Block.createCuboidShape(0.0, 8.0, 0.0, 16.0, 16.0, 8.0);
    protected static final VoxelShape SOUTH_BOX_TOP = Block.createCuboidShape(0.0, 8.0, 8.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape EAST_BOX_TOP = Block.createCuboidShape(8.0, 8.0, 0.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape WEST_BOX_TOP = Block.createCuboidShape(0.0, 8.0, 0.0, 8.0, 16.0, 16.0);

    protected static final VoxelShape NORTH_BOX_BOTTOM = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 8.0);
    protected static final VoxelShape SOUTH_BOX_BOTTOM = Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 8.0, 16.0);
    protected static final VoxelShape EAST_BOX_BOTTOM = Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 8.0, 16.0);
    protected static final VoxelShape WEST_BOX_BOTTOM = Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 8.0, 16.0);

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
                case NORTH -> NORTH_BOX_TOP;
                case SOUTH -> SOUTH_BOX_TOP;
                case EAST -> EAST_BOX_TOP;
                case WEST -> WEST_BOX_TOP;
                default -> VoxelShapes.fullCube();
            };
            case BOTTOM -> switch (cardinalDir) {
                case NORTH -> NORTH_BOX_BOTTOM;
                case SOUTH -> SOUTH_BOX_BOTTOM;
                case EAST -> EAST_BOX_BOTTOM;
                case WEST -> WEST_BOX_BOTTOM;
                default -> VoxelShapes.fullCube();
            };
            //throw new IllegalStateException("Unexpected value: " + upOrDown);
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction cardinalDir = state.get(FACING);
        BlockHalf upOrDown = state.get(HALF);
        return switch (upOrDown) {
            case TOP -> switch (cardinalDir) {
                case NORTH -> NORTH_BOX_TOP;
                case SOUTH -> SOUTH_BOX_TOP;
                case EAST -> EAST_BOX_TOP;
                case WEST -> WEST_BOX_TOP;
                default -> VoxelShapes.fullCube();
            };
            case BOTTOM -> switch (cardinalDir) {
                case NORTH -> NORTH_BOX_BOTTOM;
                case SOUTH -> SOUTH_BOX_BOTTOM;
                case EAST -> EAST_BOX_BOTTOM;
                case WEST -> WEST_BOX_BOTTOM;
                default -> VoxelShapes.fullCube();
            };
            //throw new IllegalStateException("Unexpected value: " + upOrDown);
        };
    }
}
