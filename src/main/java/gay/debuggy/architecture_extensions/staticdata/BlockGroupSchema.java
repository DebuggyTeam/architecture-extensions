package gay.debuggy.architecture_extensions.staticdata;

import com.google.gson.GsonBuilder;
import gay.debuggy.architecture_extensions.ArchitectureExtensions;
import gay.debuggy.architecture_extensions.api.BlockGroup;
import gay.debuggy.architecture_extensions.api.BlockShape;
import gay.debuggy.architecture_extensions.api.MaterialShapeCategory;
import gay.debuggy.architecture_extensions.api.RecipeConfigurator;
import gay.debuggy.architecture_extensions.api.TextureConfiguration;
import gay.debuggy.architecture_extensions.util.MapColors;
import gay.debuggy.architecture_extensions.util.SafeRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

public class BlockGroupSchema {
	public String name;
	public String base_block;
	public String textures;
	public String recipes;
	public String map_color;
	public String[] types_to_generate;
	public String only_if_present;
	public String render_layer;
	
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
		// TODO: more "Identifier.of()" wanting two arguments
		Identifier baseBlockId = Identifier.parse(base_block);
		Supplier<Block> getter = () -> {
			Block block = Registries.BLOCK.get(baseBlockId);
			return (block == Blocks.AIR) ? null : block;
		};
		Identifier baseId = baseBlockId;
		if (name != null) baseId = Identifier.of(baseBlockId.getNamespace(), name);

		TextureConfiguration textureConfig = (textures.contains(":")) ? TextureConfiguration.create(it -> textures, it -> textures, it -> textures, it -> textures) :
			BlockGroupSchema.<Function<Identifier, TextureConfiguration>>reflectField(TextureConfiguration.class, textures.toUpperCase(Locale.ROOT))
				.orElse(TextureConfiguration.ALL).apply(baseId);
		RecipeConfigurator recipeConfig = BlockGroupSchema.<RecipeConfigurator>reflectField(RecipeConfigurator.class, recipes.toUpperCase(Locale.ROOT))
			.orElse(RecipeConfigurator.STONECUTTER);
		Optional<MapColor> mapColor = MapColors.byName(map_color);
		
		if (render_layer == null) render_layer = "solid";
		SafeRenderLayer renderLayer = BlockGroupSchema.<SafeRenderLayer>reflectField(SafeRenderLayer.class, render_layer.toUpperCase(Locale.ROOT)).orElse(SafeRenderLayer.SOLID);
		
		return BlockGroup.of(
				new BlockGroup.GroupedBlock(baseId, baseBlockId, getter, textureConfig, recipeConfig, mapColor, renderLayer)
				);
	}
	
	public Set<BlockShape> getBlockTypes() {
		Set<BlockShape> result = new HashSet<>();
		
		for(String typeToGenerate : types_to_generate) {
			if (typeToGenerate.startsWith("#")) {
				typeToGenerate = typeToGenerate.substring(1);
				Optional<MaterialShapeCategory> metaType = BlockGroupSchema.<MaterialShapeCategory>reflectField(MaterialShapeCategory.class, typeToGenerate.toUpperCase(Locale.ROOT));
				if (metaType.isPresent()) {
					for(BlockShape t : metaType.get().blockTypes()) result.add(t);
				} else {
					ArchitectureExtensions.LOGGER.warn("A file requested a nonexistent meta-type '#" + typeToGenerate + "'.");
				}
				continue;
			}
			
			BlockShape blockType = BlockGroupSchema.<BlockShape>reflectField(BlockShape.class, typeToGenerate.toUpperCase(Locale.ROOT)).orElse(null);
			if (blockType != null) {
				result.add(blockType);
			} else {
				ArchitectureExtensions.LOGGER.warn("A file requested a nonexistent block type '" + typeToGenerate + "'.");
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return new GsonBuilder().create().toJson(this);
	}
}
