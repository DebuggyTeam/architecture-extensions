package io.github.woodiertexas.architecture_extensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class PostCapBlock extends Block {
    public PostCapBlock(Settings settings) {
        super(settings);
    }

    protected static final VoxelShape POST_CAP_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 3.0, 11.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return POST_CAP_SHAPE;
    }
}
