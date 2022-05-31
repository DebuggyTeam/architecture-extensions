package io.github.woodiertexas.architecture_extensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class JoistBlock extends HorizontalFacingBlock {
    protected static final VoxelShape X_BOX = Block.createCuboidShape(4.0, 4.0, 0.0, 12.0, 16.0, 16.0);
    protected static final VoxelShape Y_BOX = Block.createCuboidShape(0.0, 4.0, 4.0, 16.0, 16.0, 12.0);

    public JoistBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
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
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getPlayerFacing());
    }
}
