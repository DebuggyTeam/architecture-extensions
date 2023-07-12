package io.github.debuggyteam.architecture_extensions.staticdata;

import java.util.HashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import com.google.gson.GsonBuilder;

import io.github.debuggyteam.architecture_extensions.ArchitectureExtensions;
import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import io.github.debuggyteam.architecture_extensions.api.RecipeConfigurator;
import io.github.debuggyteam.architecture_extensions.api.TextureConfiguration;
import io.github.debuggyteam.architecture_extensions.util.MapColors;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class BlockGroupSchema {
	public String name;
	public String base_block;
	public String textures;
	public String recipes;
	public String map_color;
	public String[] types_to_generate;
	public String only_if_present;
	
	public BlockGroupSchema() {
		name = null;
		base_block = "minecraft:air";
		types_to_generate = new String[0];
	}

	@SuppressWarnings("unchecked")
	private static <T> Optional<T> reflectField(Class<?> originClass, String name) {
		try {
			return Optional.of((T) originClass.getDeclaredField(name).get(null));
		} catch (Exception ex) {
			return Optional.empty();
		}
	}
	
	public BlockGroup createBlockGroup() {
		Identifier baseBlockId = new Identifier(base_block);
		Supplier<Block> getter = () -> {
			Block block = Registries.BLOCK.get(baseBlockId);
			return (block == Blocks.AIR) ? null : block;
		};
		Identifier baseId = baseBlockId;
		if (name != null) baseId = new Identifier(baseBlockId.getNamespace(), name);

		TextureConfiguration textureConfig = (textures.contains(":")) ? TextureConfiguration.create(it -> textures, it -> textures, it -> textures, it -> textures) :
			BlockGroupSchema.<Function<Identifier, TextureConfiguration>>reflectField(TextureConfiguration.class, textures.toUpperCase(Locale.ROOT))
				.orElse(TextureConfiguration.TOP).apply(baseId);
		RecipeConfigurator recipeConfig = BlockGroupSchema.<RecipeConfigurator>reflectField(RecipeConfigurator.class, recipes.toUpperCase(Locale.ROOT))
			.orElse(RecipeConfigurator.STONECUTTER);
		Optional<MapColor> mapColor = MapColors.byName(map_color);

		return BlockGroup.of(
				new BlockGroup.GroupedBlock(baseId, baseBlockId, getter, textureConfig, recipeConfig, mapColor)
				);
	}
	
	public Set<BlockType> getBlockTypes() {
		Set<BlockType> result = new HashSet<>();
		
		for(String typeToGenerate : types_to_generate) {
			BlockType blockType = BlockGroupSchema.<BlockType>reflectField(BlockType.class, typeToGenerate.toUpperCase(Locale.ROOT)).orElse(null);
			if (blockType != null) {
				result.add(blockType);
			} else {
				ArchitectureExtensions.LOGGER.warn("A file requested an nonexistent block type '" + typeToGenerate + "'.");
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return new GsonBuilder().create().toJson(this);
	}
}
