package io.github.woodiertexas.architecture_extensions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class PostBlock extends PillarBlock {
    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;

    public PostBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(new Property[]{AXIS});
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

    // Both of the following blocks of code below deals with block collision.
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction.Axis cardinal_dir = state.get(AXIS);
        return switch (cardinal_dir) {
            case X -> VoxelShapes.cuboid(0f, 0.25f, 0.25f, 1f, 0.75f, 0.75f);
            case Y -> VoxelShapes.cuboid(0.25f, 0f, 0.25f, 0.75f, 1f, 0.75f);
            case Z -> VoxelShapes.cuboid(0.25f, 0.25f, 0f, 0.75f, 0.75f, 1f);
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction.Axis cardinal_dir = state.get(AXIS);
        return switch (cardinal_dir) {
            case X -> VoxelShapes.cuboid(0f, 0.25f, 0.25f, 1f, 0.75f, 0.75f);
            case Y -> VoxelShapes.cuboid(0.25f, 0f, 0.25f, 0.75f, 1f, 0.75f);
            case Z -> VoxelShapes.cuboid(0.25f, 0.25f, 0f, 0.75f, 0.75f, 1f);
        };
    }

    // Deals with placing the block properly in accordance to direction.
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(AXIS, context.getSide().getAxis());
    }
}
