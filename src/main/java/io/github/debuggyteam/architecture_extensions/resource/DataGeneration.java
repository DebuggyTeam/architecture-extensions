package io.github.debuggyteam.architecture_extensions.resource;

import java.io.FileNotFoundException;
import java.util.Set;

import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.block.content.registry.api.BlockContentRegistries;

import com.google.common.collect.Sets;

import io.github.debuggyteam.architecture_extensions.ArchitectureExtensions;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import io.github.debuggyteam.architecture_extensions.api.RecipeConfigurator;
import io.github.debuggyteam.architecture_extensions.api.TextureConfiguration;
import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import io.github.debuggyteam.architecture_extensions.resource.json.BlockStateTemplate;
import io.github.debuggyteam.architecture_extensions.resource.json.LootTableTemplate;
import io.github.debuggyteam.architecture_extensions.resource.json.ModelTemplate;
import io.github.debuggyteam.architecture_extensions.resource.json.RecipeTemplate;
import io.github.debuggyteam.architecture_extensions.resource.json.TagTemplate;
import io.github.debuggyteam.architecture_extensions.resource.json.LootTableTemplate.JPool;
import io.github.debuggyteam.architecture_extensions.resource.json.LootTableTemplate.JPool.JCondition;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

public final class DataGeneration {
	static final Set<BlockType.TypedGroupedBlock> BLOCKS = Sets.newHashSet();

	private static final String GROUP_PLACEHOLDER = "group";
	private static final String BASE_PLACEHOLDER = "base";
	private static final String RESULT_PLACEHOLDER = "result";
	private static int serverLoadCount = -1;

	private static final String MODEL_PLACEHOLDER = "model";
	private static int clientLoadCount = -1;

	private static @Nullable String getModelTemplate(BlockType type, String variant) {
		try {
			return ResourceUtils.getResourceAsString(ArchitectureExtensions.MOD_CONTAINER, ResourceType.CLIENT_RESOURCES,
				"assets/architecture_extensions/templates/model/block/" + "template_" + type.toString() + variant + ".json");
		} catch (FileNotFoundException e) {
			ArchitectureExtensions.LOGGER.error("The model template_transom.json for the " + type.toString() + " block type can not be found");
			return null;
		} catch (Exception e) {
			ArchitectureExtensions.LOGGER.error("Exception while trying to load the model template_transom.json for the " + type.toString() + " block type : ", e);
			return null;
		}
	}

	private static @Nullable String getBlockStateTemplate(BlockType type) {
		try {
			return ResourceUtils.getResourceAsString(ArchitectureExtensions.MOD_CONTAINER, ResourceType.CLIENT_RESOURCES,
				"assets/architecture_extensions/templates/blockstate/" + "template_" + type.toString() + ".json");
		} catch (FileNotFoundException e) {
			ArchitectureExtensions.LOGGER.error("The blockstate template_transom.json for the " + type.toString() + " block type can not be found");
			return null;
		} catch (Exception e) {
			ArchitectureExtensions.LOGGER.error("Exception while trying to load the blockstate template_transom.json for the " + type.toString() + " block type : ", e);
			return null;
		}
	}

	private static @Nullable String getRecipeTemplate(String id) {
		try {
			return ResourceUtils.getResourceAsString(ArchitectureExtensions.MOD_CONTAINER, ResourceType.SERVER_DATA,
				"data/architecture_extensions/templates/recipe/" + id + ".json");
		} catch (FileNotFoundException e) {
			ArchitectureExtensions.LOGGER.error("The recipe template_transom.json for " + id + " can not be found");
			return null;
		} catch (Exception e) {
			ArchitectureExtensions.LOGGER.error("Exception while trying to load the recipe template_transom.json for " + id + " : ", e);
			return null;
		}
	}

	private static void generateModels(TypedGroupedBlock block) {
		var modelId = new Identifier(block.id().getNamespace(), "models/block/" + block.id().getPath());

		for (String variant : block.type().variants()) {
			if (!variant.isBlank()) variant = "_" + variant;
			var rawModel = getModelTemplate(block.type(), variant);
			if (rawModel == null) continue;

			var model = new ModelTemplate(rawModel);

			var textureConfiguration = block.groupedBlock().textureConfiguration();

			for (String textureId : TextureConfiguration.TEXTURE_IDS) {
				if (rawModel.contains(textureId)) model.addTexture(textureId, textureConfiguration.apply(block.type(), textureId));
			}

			ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.CLIENT_RESOURCES, new Identifier(modelId.getNamespace(), modelId.getPath() + variant + ".json"), path -> model.serialize().toString());
		}

		var itemModel = "{\"parent\":\"" + modelId.toString().replaceFirst("models/", "") + "\"}";
		ArchitectureExtensions.RESOURCE_PACK.putText(ResourceType.CLIENT_RESOURCES, new Identifier(modelId.getNamespace(), modelId.getPath().replaceFirst("block", "item") + ".json"), itemModel);
	}

	private static void generateBlockState(TypedGroupedBlock block) {
		var rawBlockState = getBlockStateTemplate(block.type());
		if (rawBlockState == null) return;
		var blockState = new BlockStateTemplate(rawBlockState);
		blockState.addConstant(MODEL_PLACEHOLDER, new Identifier(block.id().getNamespace(), "block/" + block.id().getPath()).toString());
		ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.CLIENT_RESOURCES, new Identifier(block.id().getNamespace(), "blockstates/" + block.id().getPath() + ".json"), path -> blockState.serialize().toString());
	}

	private static void generateMineableByPickaxeTag() {
		var tag = TagTemplate.DEFAULT.get();
		BLOCKS.forEach(block -> { if (BlockContentRegistries.STRIPPABLE.get(block.groupedBlock().baseBlock().get()).isEmpty()) tag.addValue(block.id().toString()); });
		ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.SERVER_DATA, new Identifier("tags/blocks/mineable/pickaxe.json"), path -> tag.serialize().toString());
	}

	private static void generateMineableByAxeTag() {
		var tag = TagTemplate.DEFAULT.get();
		BLOCKS.forEach(block -> { if (BlockContentRegistries.STRIPPABLE.get(block.groupedBlock().baseBlock().get()).isPresent()) tag.addValue(block.id().toString()); });
		ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.SERVER_DATA, new Identifier("tags/blocks/mineable/axe.json"), path -> tag.serialize().toString());
	}

	private static void generateNeedsStoneToolTag() {
		var tag = TagTemplate.DEFAULT.get();
		BLOCKS.forEach(block -> tag.addValue(block.id().toString()));
		ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.SERVER_DATA, new Identifier("tags/blocks/needs_stone_tool.json"), path -> tag.serialize().toString());
	}

	private static void generateLootTables() {
		for (TypedGroupedBlock block : BLOCKS) {
			var lootTable = LootTableTemplate.BLOCK_BREAK.get();
			lootTable.addPool(JPool.ofItems(block.id()).addCondition(JCondition.SURVIVES_EXPLOSION.get()));
			ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.SERVER_DATA, new Identifier(block.id().getNamespace(), "loot_tables/blocks/" + block.id().getPath() + ".json"), path -> lootTable.serialize().toString());
		}
	}

	private static void generateRecipes() {
		final Set<RecipeConfigurator.RecipeTemplate> templates = Sets.newHashSet();
		for (TypedGroupedBlock block : BLOCKS) {
			block.groupedBlock().recipeConfigurator().accept(block.type(), templates::add);
			for (RecipeConfigurator.RecipeTemplate template : templates) {
				final var rawRecipe = getRecipeTemplate(template.id());
				if (rawRecipe == null) continue;
				final var recipe = new RecipeTemplate(rawRecipe);

				recipe.addConstant(GROUP_PLACEHOLDER, block.groupedBlock().id().toString());
				recipe.addConstant(BASE_PLACEHOLDER, Registries.BLOCK.getId(block.groupedBlock().baseBlock().get()).toString());
				recipe.addConstant(RESULT_PLACEHOLDER, block.id().toString());

				final var path = template.tablesaw() ? "custom_recipes/tablesaw/" : "recipes/";
				final var prefix = template.simple() ? "" : block.id().getPath() + "_";
				ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.SERVER_DATA, new Identifier(block.id().getNamespace(), path + prefix + template.id() + ".json"), blah -> recipe.serialize().toString());
			}
			templates.clear();
		}
	}

	public static void generate(ResourceType resourceType) {
		if (resourceType == ResourceType.SERVER_DATA) {
			// needs to be a count since for some reason server data tries to get generated 4 TIMES??!??!!?!
			++serverLoadCount;
			if (serverLoadCount % 4 == 1) return;
			if (serverLoadCount > 4) ResourceUtils.refreshCaches(ResourceType.SERVER_DATA);

			generateMineableByPickaxeTag();
			generateMineableByAxeTag();
			generateNeedsStoneToolTag();
			generateLootTables();
			generateRecipes();

			return;
		}

		if (resourceType == ResourceType.CLIENT_RESOURCES) {
			// needs to be a count since for some reason client resources try to get generated 2 times!
			++clientLoadCount;
			if (clientLoadCount % 2 == 1) return;
			if (clientLoadCount > 1) ResourceUtils.refreshCaches(ResourceType.CLIENT_RESOURCES);

			for (TypedGroupedBlock block : BLOCKS) {
				generateModels(block);
				generateBlockState(block);
			}
		}
	}

	public static void collect(TypedGroupedBlock block) {
		BLOCKS.add(block);
	}
}
