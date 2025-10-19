package gay.debuggy.architecture_extensions.resource;

import java.io.FileNotFoundException;
import java.util.Set;

import gay.debuggy.architecture_extensions.util.IsLog;
import org.jetbrains.annotations.Nullable;

import com.google.common.collect.Sets;

import gay.debuggy.architecture_extensions.ArchitectureExtensions;
import gay.debuggy.architecture_extensions.api.BlockType;
import gay.debuggy.architecture_extensions.api.RecipeConfigurator;
import gay.debuggy.architecture_extensions.api.TextureConfiguration;
import gay.debuggy.architecture_extensions.api.BlockType.TypedGroupedBlock;
import gay.debuggy.architecture_extensions.resource.json.BlockStateTemplate;
import gay.debuggy.architecture_extensions.resource.json.LootTableTemplate;
import gay.debuggy.architecture_extensions.resource.json.ModelTemplate;
import gay.debuggy.architecture_extensions.resource.json.RecipeTemplate;
import gay.debuggy.architecture_extensions.resource.json.TagTemplate;
import gay.debuggy.architecture_extensions.resource.json.LootTableTemplate.JPool;
import gay.debuggy.architecture_extensions.resource.json.LootTableTemplate.JPool.JCondition;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

public final class DataGeneration {
	public static final Set<BlockType.TypedGroupedBlock> BLOCKS = Sets.newHashSet();

	private static final String GROUP_PLACEHOLDER = "group";
	private static final String BASE_PLACEHOLDER = "base";
	private static final String RESULT_PLACEHOLDER = "result";
	private static final String MODEL_PLACEHOLDER = "model";

	private static @Nullable String getModelTemplate(BlockType type, String variant) {
		try {
			return ResourceUtils.getResourceAsString(ArchitectureExtensions.MOD_CONTAINER, ResourceType.CLIENT_RESOURCES,
				"assets/architecture_extensions/templates/model/block/" + "template_" + type.toString() + variant + ".json");
		} catch (FileNotFoundException e) {
			ArchitectureExtensions.LOGGER.error("The model template for the " + type.toString() + " block type can not be found");
			return null;
		} catch (Exception e) {
			ArchitectureExtensions.LOGGER.error("Exception while trying to load the model template for the " + type.toString() + " block type : ", e);
			return null;
		}
	}

	private static @Nullable String getBlockStateTemplate(BlockType type) {
		try {
			return ResourceUtils.getResourceAsString(ArchitectureExtensions.MOD_CONTAINER, ResourceType.CLIENT_RESOURCES,
				"assets/architecture_extensions/templates/blockstate/" + "template_" + type.toString() + ".json");
		} catch (FileNotFoundException e) {
			ArchitectureExtensions.LOGGER.error("The blockstate template for the " + type.toString() + " block type can not be found");
			return null;
		} catch (Exception e) {
			ArchitectureExtensions.LOGGER.error("Exception while trying to load the blockstate template for the " + type.toString() + " block type : ", e);
			return null;
		}
	}

	private static @Nullable String getRecipeTemplate(String id) {
		try {
			return ResourceUtils.getResourceAsString(ArchitectureExtensions.MOD_CONTAINER, ResourceType.SERVER_DATA,
				"data/architecture_extensions/templates/recipe/" + id + ".json");
		} catch (FileNotFoundException e) {
			ArchitectureExtensions.LOGGER.error("The recipe template for " + id + " can not be found");
			return null;
		} catch (Exception e) {
			ArchitectureExtensions.LOGGER.error("Exception while trying to load the recipe template for " + id + " : ", e);
			return null;
		}
	}

	private static void generateModels(TypedGroupedBlock block) {
		var modelId = Identifier.of(block.id().getNamespace(), "models/block/" + block.id().getPath());

		for (String variant : block.type().variants()) {
			if (!variant.isBlank()) variant = "_" + variant;
			var rawModel = getModelTemplate(block.type(), variant);
			if (rawModel == null) continue;

			var model = new ModelTemplate(rawModel);

			var textureConfiguration = block.groupedBlock().textureConfiguration();

			for (String textureId : TextureConfiguration.TEXTURE_IDS) {
				if (rawModel.contains(textureId)) model.addTexture(textureId, textureConfiguration.apply(block.type(), textureId));
			}

			ArchitectureExtensions.RESOURCE_PACK.put(ResourceType.CLIENT_RESOURCES, Identifier.of(modelId.getNamespace(), modelId.getPath() + variant + ".json"), model.serialize().toString());
		}

		var itemModel = "{\"parent\":\"" + modelId.toString().replaceFirst("models/", "") + "\"}";
		ArchitectureExtensions.RESOURCE_PACK.put(ResourceType.CLIENT_RESOURCES, Identifier.of(modelId.getNamespace(), modelId.getPath().replaceFirst("block", "item") + ".json"), itemModel);
	}

	private static void generateBlockState(TypedGroupedBlock block) {
		var rawBlockState = getBlockStateTemplate(block.type());
		if (rawBlockState == null) return;
		var blockState = new BlockStateTemplate(rawBlockState);
		blockState.addConstant(MODEL_PLACEHOLDER, Identifier.of(block.id().getNamespace(), "block/" + block.id().getPath()).toString());
		ArchitectureExtensions.RESOURCE_PACK.put(ResourceType.CLIENT_RESOURCES, Identifier.of(block.id().getNamespace(), "blockstates/" + block.id().getPath() + ".json"), blockState.serialize().toString());
	}

	private static void generateMineableByPickaxeTag() {
		var tag = TagTemplate.DEFAULT.get();
		
		BLOCKS.forEach(block -> { if (!IsLog.isLog(block.id())) tag.addValue(block.id().toString()); });
		ArchitectureExtensions.RESOURCE_PACK.put(ResourceType.SERVER_DATA, Identifier.parse("tags/block/mineable/pickaxe.json"), tag.serialize().toString());
		ArchitectureExtensions.LOGGER.info("our pickaxe mineable tag: {}", tag.serialize());
	}

	private static void generateMineableByAxeTag() {
		var tag = TagTemplate.DEFAULT.get();
		BLOCKS.forEach(block -> { if (IsLog.isLog(block.id())) tag.addValue(block.id().toString()); });
		ArchitectureExtensions.RESOURCE_PACK.put(ResourceType.SERVER_DATA, Identifier.parse("tags/block/mineable/axe.json"), tag.serialize().toString());
		ArchitectureExtensions.LOGGER.info("our axe mineable tag: {}", tag.serialize());
	}

	private static void generateNeedsStoneToolTag() {
		var tag = TagTemplate.DEFAULT.get();
		BLOCKS.forEach(block -> tag.addValue(block.id().toString()));
		ArchitectureExtensions.RESOURCE_PACK.put(ResourceType.SERVER_DATA, Identifier.parse("tags/block/needs_stone_tool.json"), tag.serialize().toString());
		ArchitectureExtensions.LOGGER.info("our stone tool tag: {}", tag.serialize());
	}

	private static void generateLootTables() {
		for (TypedGroupedBlock block : BLOCKS) {
			var lootTable = LootTableTemplate.BLOCK_BREAK.get();
			lootTable.addPool(JPool.ofItems(block.id()).addCondition(JCondition.SURVIVES_EXPLOSION.get()));
			ArchitectureExtensions.RESOURCE_PACK.put(ResourceType.SERVER_DATA, Identifier.of(block.id().getNamespace(), "loot_table/blocks/" + block.id().getPath() + ".json"), lootTable.serialize().toString());
			ArchitectureExtensions.LOGGER.info("loot table: {}", lootTable.serialize());
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

				final var path = template.tablesaw() ? "custom_recipes/tablesaw/" : "recipe/";
				final var prefix = template.simple() ? "" : block.id().getPath() + "_";
				ArchitectureExtensions.RESOURCE_PACK.put(ResourceType.SERVER_DATA, Identifier.of(block.id().getNamespace(), path + prefix + template.id() + ".json"), recipe.serialize().toString());
				ArchitectureExtensions.LOGGER.info("{} recipe path: {}", template.id(), Identifier.of(block.id().getNamespace(), path + prefix + template.id() + ".json"));
				ArchitectureExtensions.LOGGER.info("{} recipe contents: {}", template.id(), recipe.serialize());
			}
			templates.clear();
		}
	}

	public static void generate(ResourceType resourceType) {
		if (resourceType == ResourceType.SERVER_DATA) {
			ArchitectureExtensions.LOGGER.info("are we going to actually load this stuff?");
			generateMineableByPickaxeTag();
			generateMineableByAxeTag();
			generateNeedsStoneToolTag();
			generateLootTables();
			generateRecipes();
			
			ArchitectureExtensions.LOGGER.info("excuse me, what?");

			return;
		}

		if (resourceType == ResourceType.CLIENT_RESOURCES) {
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
