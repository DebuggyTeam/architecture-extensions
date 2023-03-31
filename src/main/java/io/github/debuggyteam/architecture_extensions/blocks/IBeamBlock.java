package io.github.debuggyteam.architecture_extensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class IBeamBlock extends PillarBlock {
	public static final BooleanProperty BOLTED = BooleanProperty.of("bolted");
	public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;

	protected static final VoxelShape X_AXIS_BOX = Block.createCuboidShape(0.0, 2.0, 2.0, 16.0, 14.0, 14.0);
	protected static final VoxelShape Y_AXIS_BOX = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
	protected static final VoxelShape Z_AXIS_BOX = Block.createCuboidShape(2.0, 2.0, 0.0, 14.0, 14.0, 16.0);

	boolean shouldHaveBolts(World world, BlockPos pos, BlockState state) {
		Direction.Axis axis = state.get(AXIS);

		for (Direction dir : Direction.values()) {
			if (axis.test(dir)) {
				BlockPos neighbor = pos.offset(dir, 1);


				if (world.getBlockState(neighbor).isSideSolidFullSquare(world, pos, dir)) {
					System.out.println("actually has bolts");
					return true;
				}

				System.out.println(world.getBlockState(neighbor));
				System.out.println(":thonk:");
			}
		}
		System.out.println("no bolts");
		System.out.println();
		return false;
	}

	public IBeamBlock(Settings settings) {
		super(settings);
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

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		Direction.Axis cardinalDir = state.get(AXIS);
		return switch (cardinalDir) {
			case X -> X_AXIS_BOX;
			case Y -> Y_AXIS_BOX;
			case Z -> Z_AXIS_BOX;
		};
	}

	// Deals with placing the block properly in accordance to direction.
	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		World world = context.getWorld();
		BlockPos pos = context.getBlockPos();

		BlockState initialState = this.getDefaultState().with(AXIS, context.getPlayerLookDirection().getAxis());
		return initialState.with(BOLTED, shouldHaveBolts(world, pos, initialState));
	}

	//return this.getDefaultState().with(Properties.AXIS, context.getPlayerFacing()).with(CAPPED, world.getBlockState(pos.up()).getBlock() != this).with(WATERLOGGED, context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER);


	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
		builder.add(BOLTED);
	}
}
