package io.github.debuggyteam.architecture_extensions.staticdata;

import java.util.HashSet;
import java.util.Set;
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
	public String base_block;
	public String textures;
	public String recipes;
	public String map_color;
	public String[] types_to_generate;
	
	public BlockGroupSchema() {
		base_block = "minecraft:air";
		types_to_generate = new String[0];
	}
	
	public BlockGroup createBlockGroup() {
		Identifier baseId = new Identifier(base_block);
		Supplier<Block> getter = () -> {
			Block b = Registries.BLOCK.get(baseId);
			return (b == Blocks.AIR) ? null : b;
		};
		
		TextureConfiguration textureConfig = (textures.contains(":")) ?
				TextureConfiguration.create(it->textures, it->textures, it->textures, it->textures) :
				switch(textures) {
					case "sided"          -> TextureConfiguration.SIDED.apply(baseId);
					case "wood_with_log"  -> TextureConfiguration.WOOD_WITH_LOG.apply(baseId);
					case "wood_with_stem" -> TextureConfiguration.WOOD_WITH_STEM.apply(baseId);
					case "top"            -> TextureConfiguration.TOP.apply(baseId);
					case "top_bottom"     -> TextureConfiguration.TOP_BOTTOM.apply(baseId);
					default -> TextureConfiguration.TOP.apply(baseId);
				};
		RecipeConfigurator recipeConfig = switch(recipes) {
			case "stonecutting"   -> RecipeConfigurator.STONECUTTER;
			case "sawing"         -> RecipeConfigurator.SAWING;
			case "crafting"       -> RecipeConfigurator.CRAFTING;
			default -> RecipeConfigurator.STONECUTTER;
		};
		MapColor mapColor = MapColors.byName(map_color);
		
		return BlockGroup.of(
				new BlockGroup.GroupedBlock(baseId, getter, textureConfig, recipeConfig, mapColor)
				);
	}
	
	public Set<BlockType> getBlockTypes() {
		Set<BlockType> result = new HashSet<>();
		
		for(String s : types_to_generate) {
			BlockType blockType = switch(s) {
				case "arch" -> BlockType.ARCH;
				case "beam" -> BlockType.BEAM;
				case "h_beam" -> BlockType.H_BEAM;
				case "wall_column" -> BlockType.WALL_COLUMN;
				case "fence_post" -> BlockType.FENCE_POST;
				case "joist" -> BlockType.JOIST;
				case "crown_molding" -> BlockType.CROWN_MOLDING;
				case "post_cap" -> BlockType.POST_CAP;
				case "post_lantern" -> BlockType.POST_LANTERN;
				case "lantern" -> BlockType.POST_LANTERN;
				case "rod" -> BlockType.ROD;
				case "roof" -> BlockType.ROOF;
				case "wall_post" -> BlockType.WALL_POST;
				default -> null;
			};
			if (blockType != null) {
				result.add(blockType);
			} else {
				ArchitectureExtensions.LOGGER.warn("A file requested the nonexistant block type '"+s+"'.");
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return new GsonBuilder().create().toJson(this);
	}
}
