package io.github.debuggyteam.architecture_extensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class RoundArchBlock extends HorizontalFacingBlock {
	public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
	public static final EnumProperty<BlockHalf> HALF = Properties.BLOCK_HALF;
	
	public RoundArchBlock(QuiltBlockSettings settings) {
		super(settings);
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
}
