package io.github.debuggyteam.architecture_extensions.blocks;

import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.text.MutableText;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TubeSteelBlock extends PillarBlock implements TypedGrouped {
	protected static final VoxelShape FIRST_SIDE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
	protected static final VoxelShape SECOND_SIDE = Block.createCuboidShape(0.0, 0.0, 3.0, 3.0, 16.0, 13.0);
	protected static final VoxelShape THIRD_SIDE = Block.createCuboidShape(13.0, 0.0, 3.0, 16.0, 16.0, 13.0);
	protected static final VoxelShape FOURTH_SIDE = Block.createCuboidShape(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);

	protected static final VoxelShape TUBE_UPWARDS = VoxelShapes.union(FIRST_SIDE, SECOND_SIDE, THIRD_SIDE, FOURTH_SIDE);

	protected final TypedGroupedBlock typedGroupedBlock;
	
	public TubeSteelBlock(Block baseBlock, Settings settings, TypedGroupedBlock typedGroupedBlock) {
		super(settings);
		this.typedGroupedBlock = typedGroupedBlock;
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
		Direction.Axis cardinalDir = state.get(AXIS);
		return switch (cardinalDir) {
			case Y -> TUBE_UPWARDS;
			default -> VoxelShapes.fullCube();
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
