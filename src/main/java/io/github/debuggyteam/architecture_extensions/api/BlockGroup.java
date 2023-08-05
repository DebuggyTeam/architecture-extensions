package io.github.debuggyteam.architecture_extensions.api;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import com.google.common.collect.Sets;

import io.github.debuggyteam.architecture_extensions.util.SafeRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
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
		
		public static Builder builder() {
			return new Builder();
		}
		
		public static Builder builder(Identifier id) {
			return new Builder(id);
		}
		
		public static Builder builder(Block block) {
			return new Builder(block);
		}
		
		public static class Builder {
			private Identifier id;
			private Identifier baseBlockId;
			private Supplier<Block> baseBlock;
			private TextureConfiguration textures;
			private RecipeConfigurator recipes = RecipeConfigurator.CREATIVE;
			private Optional<MapColor> mapColor = Optional.empty();
			private SafeRenderLayer renderLayer = SafeRenderLayer.SOLID;
			
			public Builder() {}
			
			public Builder(Identifier id) {
				this.id = id;
				this.baseBlockId = id;
				Block maybeBlock = Registries.BLOCK.get(id);
				if (maybeBlock != Blocks.AIR) baseBlock = () -> maybeBlock;
			}
			
			public Builder(Block block) {
				baseBlock = () -> block;
				this.id = Registries.BLOCK.getId(block);
				this.baseBlockId = this.id;
			}
			
			public Builder id(Identifier id) {
				this.id = id;
				return this;
			}
			
			public Builder baseBlockId(Identifier id) {
				this.baseBlockId = id;
				return this;
			}
			
			public Builder baseBlock(Block block) {
				this.baseBlock = () -> block;
				return this;
			}
			
			public Builder baseBlock(Supplier<Block> blockSupplier) {
				this.baseBlock = blockSupplier;
				return this;
			}
			
			public Builder textures(String singleTexture) {
				this.textures = TextureConfiguration.create(
						(it) -> singleTexture,
						(it) -> singleTexture,
						(it) -> singleTexture,
						(it) -> singleTexture);
				return this;
			}
			
			public Builder textures(TextureConfiguration config) {
				this.textures = config;
				return this;
			}
			
			public Builder creativeOnly() {
				this.recipes = RecipeConfigurator.CREATIVE;
				return this;
			}
			
			public Builder usesTablesaw() {
				this.recipes = RecipeConfigurator.SAWING;
				return this;
			}
			
			public Builder usesStonecutter() {
				this.recipes = RecipeConfigurator.STONECUTTER;
				return this;
			}
			
			public Builder usesCraftingTable() {
				this.recipes = RecipeConfigurator.CRAFTING;
				return this;
			}
			
			public Builder recipes(RecipeConfigurator config) {
				this.recipes = config;
				return this;
			}
			
			public Builder mapColor(DyeColor color) {
				this.mapColor = Optional.of(color.getMapColor());
				return this;
			}
			
			public Builder mapColor(MapColor color) {
				this.mapColor = Optional.of(color);
				return this;
			}
			
			public Builder noMapColor() {
				this.mapColor = Optional.empty();
				return this;
			}
			
			public Builder renderSolid() {
				this.renderLayer = SafeRenderLayer.SOLID;
				return this;
			}
			
			public Builder renderCutout() {
				this.renderLayer = SafeRenderLayer.CUTOUT;
				return this;
			}
			
			public Builder renderTranslucent() {
				this.renderLayer = SafeRenderLayer.TRANSLUCENT;
				return this;
			}
			
			public Builder renderLayer(SafeRenderLayer layer) {
				this.renderLayer = layer;
				return this;
			}
			
			public GroupedBlock build() {
				checkFilled();
				return new GroupedBlock(id, baseBlockId, baseBlock, textures, recipes, mapColor, renderLayer);
			}
			
			private void checkFilled() {
				for(Field f : Builder.class.getDeclaredFields()) {
					try {
						if (f.get(this) == null) {
							throw new IllegalArgumentException("Field '"+f.getName()+" must be set for this GroupedBlock.Builder to be complete.");
						}
					} catch (IllegalArgumentException | IllegalAccessException e) {
						//Should be no access problems from here
					}
				}
			}
		}
	}
}
