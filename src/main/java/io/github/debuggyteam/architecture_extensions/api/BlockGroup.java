package io.github.debuggyteam.architecture_extensions.api;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import com.google.common.collect.Sets;

import io.github.debuggyteam.architecture_extensions.util.SafeRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public final class BlockGroup implements Iterable<BlockGroup.GroupedBlock> {
	private final Set<BlockGroup.GroupedBlock> groupedBlocks;

	private BlockGroup(Set<BlockGroup.GroupedBlock> groupedBlocks) {
		this.groupedBlocks = groupedBlocks;
	}

	public static BlockGroup of(BlockGroup.GroupedBlock... groupedBlocks) {
		if (groupedBlocks.length == 0) throw new IllegalArgumentException("BlockGroup.of requires at least one grouped block.");

		// Use a linked hash set to make sure the ordering of blocks stays the same between launches for the item group
		final Set<BlockGroup.GroupedBlock> set = Sets.newLinkedHashSet();
		for (BlockGroup.GroupedBlock groupedBlock : groupedBlocks) { set.add(groupedBlock); };
		return new BlockGroup(set);
	}

	@Override
	public Iterator<BlockGroup.GroupedBlock> iterator() {
		return groupedBlocks.iterator();
	}

	public record GroupedBlock(Identifier id, Identifier baseBlockId, Supplier<Block> baseBlock, TextureConfiguration textureConfiguration, RecipeConfigurator recipeConfigurator, Optional<MapColor> mapColor, SafeRenderLayer renderLayer) {
		public GroupedBlock(Identifier id, Identifier baseBlockId, Supplier<Block> baseBlock, TextureConfiguration textureConfiguration, RecipeConfigurator recipeConfigurator, Optional<MapColor> mapColor) {
			this(id, baseBlockId, baseBlock, textureConfiguration, recipeConfigurator, mapColor, SafeRenderLayer.SOLID);
		}
		
		public GroupedBlock(String id, Identifier baseBlockId, Supplier<Block> baseBlock, TextureConfiguration textureConfiguration, RecipeConfigurator recipeConfigurator, MapColor mapColor) {
			this(new Identifier(id), baseBlockId, baseBlock, textureConfiguration, recipeConfigurator, Optional.of(mapColor));
		}
		
		public GroupedBlock(String id, Block baseBlock, TextureConfiguration textureConfiguration, RecipeConfigurator recipeConfigurator, MapColor mapColor) {
			this(new Identifier(id), Registries.BLOCK.getId(baseBlock), ()->baseBlock, textureConfiguration, recipeConfigurator, Optional.of(mapColor));
		}

		public GroupedBlock(Identifier id, Identifier baseBlockId, Supplier<Block> baseBlock, TextureConfiguration textureConfiguration, RecipeConfigurator recipeConfigurator, MapColor mapColor) {
			this(id, baseBlockId, baseBlock, textureConfiguration, recipeConfigurator, Optional.of(mapColor));
		}

		public GroupedBlock(String id, Identifier baseBlockId, Supplier<Block> baseBlock, TextureConfiguration textureConfiguration, RecipeConfigurator recipeConfigurator) {
			this(new Identifier(id), baseBlockId, baseBlock, textureConfiguration, recipeConfigurator, Optional.empty());
		}
		
		public GroupedBlock(String id, Block baseBlock, TextureConfiguration textureConfiguration, RecipeConfigurator recipeConfigurator) {
			this(new Identifier(id), Registries.BLOCK.getId(baseBlock), ()->baseBlock, textureConfiguration, recipeConfigurator, Optional.empty());
		}

		public GroupedBlock(Identifier id, Identifier baseBlockId, Supplier<Block> baseBlock, TextureConfiguration textureConfiguration, RecipeConfigurator recipeConfigurator) {
			this(id, baseBlockId, baseBlock, textureConfiguration, recipeConfigurator, Optional.empty());
		}
	}
}
