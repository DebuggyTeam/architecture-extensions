package io.github.debuggyteam.architecture_extensions.api;

import java.util.Iterator;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.MapColor;

public final class BlockGroup implements Iterable<BlockGroup.GroupedBlock> {
	private final Set<BlockGroup.GroupedBlock> groupedBlocks;

	private BlockGroup(Set<BlockGroup.GroupedBlock> groupedBlocks) {
		this.groupedBlocks = groupedBlocks;
	}

	public static BlockGroup of(BlockGroup.GroupedBlock... groupedBlocks) {
		if (groupedBlocks.length == 0) throw new IllegalArgumentException("BlockGroup.of requires at least one grouped block.");
		return new BlockGroup(Set.of(groupedBlocks));
	}

	@Override
	public Iterator<BlockGroup.GroupedBlock> iterator() {
		return groupedBlocks.iterator();
	}

	public record GroupedBlock(String id, Block baseBlock, TextureTemplate textureTemplate, MapColor mapColor) {}
}
