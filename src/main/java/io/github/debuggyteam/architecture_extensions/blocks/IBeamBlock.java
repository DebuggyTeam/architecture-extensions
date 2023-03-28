package io.github.debuggyteam.architecture_extensions.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

public class IBeamBlock extends PillarBlock {
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
}
