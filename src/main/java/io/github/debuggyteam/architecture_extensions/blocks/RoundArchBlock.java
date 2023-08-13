package io.github.debuggyteam.architecture_extensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.MutableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;

public class RoundArchBlock extends HorizontalFacingBlock implements TypedGrouped {
	public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
	public static final EnumProperty<BlockHalf> HALF = Properties.BLOCK_HALF;
	
	protected final TypedGroupedBlock typedGroupedBlock;
	
	protected static final VoxelShape SHAPE_TOP = Block.createCuboidShape(0.0, 8.0, 0.0, 16.0, 16.0, 16.0);
	protected static final VoxelShape SHAPE_BOTTOM = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
	
	public RoundArchBlock(Block baseBlock, QuiltBlockSettings settings, TypedGroupedBlock typedGroupedBlock) {
		super(settings);
		this.typedGroupedBlock = typedGroupedBlock;
	}
	
	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		// Thanks Falkreon
		BlockHalf half = switch(context.getSide()) {
			case UP -> BlockHalf.BOTTOM;
			case DOWN -> BlockHalf.TOP;
			default -> {
				double sideHitHeight = context.getHitPos().getY() - context.getBlockPos().getY();
				if (sideHitHeight > 0.5) {
					yield BlockHalf.TOP;
				} else {
					yield BlockHalf.BOTTOM;
				}
			}
		};
		
		return this.getDefaultState().with(FACING, context.getPlayerFacing()).with(HALF, half);
	}
	
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(FACING, HALF);
	}
	
	@Override
	public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
		return VoxelShapes.empty();
	}
	
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		BlockHalf half = state.get(HALF);
		return switch (half) {
			case TOP -> SHAPE_TOP;
			case BOTTOM -> SHAPE_BOTTOM;
		};
		
	}

	@Override
	public TypedGroupedBlock getTypedGroupedBlock() {
		return typedGroupedBlock;
	}
	
	@Override
	public MutableText getName() {
		return getServerTranslation();
	}
}
