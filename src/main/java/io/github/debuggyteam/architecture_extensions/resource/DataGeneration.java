package io.github.debuggyteam.architecture_extensions.resource;

import java.io.FileNotFoundException;
import java.util.Set;

import org.jetbrains.annotations.Nullable;
import org.quiltmc.loader.api.minecraft.MinecraftQuiltLoader;
import org.quiltmc.qsl.block.content.registry.api.BlockContentRegistries;

import com.google.common.collect.Sets;

import io.github.debuggyteam.architecture_extensions.ArchitectureExtensions;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import io.github.debuggyteam.architecture_extensions.api.TextureTemplate;
import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import me.maximumpower55.objectify.JBlockStateTemplate;
import me.maximumpower55.objectify.JLootTableTemplate;
import me.maximumpower55.objectify.JModelTemplate;
import me.maximumpower55.objectify.JTagTemplate;
import me.maximumpower55.objectify.JLootTableTemplate.JPool;
import me.maximumpower55.objectify.JLootTableTemplate.JPool.JCondition;
import net.fabricmc.api.EnvType;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

public final class DataGeneration {
	private static final Set<BlockType.TypedGroupedBlock> BLOCKS = Sets.newHashSet();

	private static final String MODEL_PLACEHOLDER = "model";

	private static @Nullable String getModelTemplate(BlockType type, String variant) {
		try {
			return ResourceUtils.getResourceAsString(ArchitectureExtensions.MOD_CONTAINER, "assets/architecture_extensions/templates/model/block/" + "template_" + type.toString() + variant + ".json");
		} catch (FileNotFoundException e) {
			ArchitectureExtensions.LOGGER.error("Model template for the " + type.toString() + " block type can not be found");
			return null;
		} catch (Exception e) {
			ArchitectureExtensions.LOGGER.error("Exception while trying to load the model template for the " + type.toString() + " block type : ", e);
			return null;
		}
	}

	private static @Nullable String getBlockStateTemplate(BlockType type) {
		try {
			return  ResourceUtils.getResourceAsString(ArchitectureExtensions.MOD_CONTAINER, "assets/architecture_extensions/templates/blockstates/" + "template_" + type.toString() + ".json");
		} catch (FileNotFoundException e) {
			ArchitectureExtensions.LOGGER.error("blockstate template for the " + type.toString() + " block type can not be found");
			return null;
		} catch (Exception e) {
			ArchitectureExtensions.LOGGER.error("Exception while trying to load the blockstate template for the " + type.toString() + " block type : ", e);
			return null;
		}
	}

	private static void generateModels(TypedGroupedBlock block) {
		var modelId = new Identifier(block.id().getNamespace(), "models/block/" + block.id().getPath());

		for (String variant : block.type().variants()) {
			if (!variant.isBlank()) variant = "_" + variant;
			var rawModel = getModelTemplate(block.type(), variant);
			if (rawModel == null) continue;

			var model = new JModelTemplate(rawModel);

			var textureTemplate = block.groupedBlock().textureTemplate();

			for (String textureId : TextureTemplate.TEXTURE_IDS) {
				if (rawModel.contains(textureId)) model.addTexture(textureId, textureTemplate.apply(block.type(), textureId));
			}

			ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.CLIENT_RESOURCES, new Identifier(modelId.getNamespace(), modelId.getPath() + variant + ".json"), path -> model.serialize().toString());
		}

		var itemModel = "{\"parent\":\"" + modelId.toString().replaceFirst("models/", "") + "\"}";
		ArchitectureExtensions.RESOURCE_PACK.putText(ResourceType.CLIENT_RESOURCES, new Identifier(modelId.getNamespace(), modelId.getPath().replaceFirst("block", "item") + ".json"), itemModel);
	}

	private static void generateBlockState(TypedGroupedBlock block) {
		var rawBlockState = getBlockStateTemplate(block.type());
		if (rawBlockState == null) return;
		var blockState = new JBlockStateTemplate(rawBlockState);
		blockState.addConstant(MODEL_PLACEHOLDER, new Identifier(block.id().getNamespace(), "block/" + block.id().getPath()).toString());
		ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.CLIENT_RESOURCES, new Identifier(block.id().getNamespace(), "blockstates/" + block.id().getPath() + ".json"), path -> blockState.serialize().toString());
	}

	private static void generateMineableByPickaxeTag() {
		var tag = JTagTemplate.DEFAULT.get();
		BLOCKS.forEach(block -> { if (BlockContentRegistries.STRIPPABLE.get(block.groupedBlock().baseBlock()).isEmpty()) tag.addValue(block.id().toString()); });
		ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.SERVER_DATA, new Identifier("tags/blocks/mineable/pickaxe.json"), path -> tag.serialize().toString());
	}

	private static void generateMineableByAxeTag() {
		var tag = JTagTemplate.DEFAULT.get();
		BLOCKS.forEach(block -> { if (BlockContentRegistries.STRIPPABLE.get(block.groupedBlock().baseBlock()).isPresent()) tag.addValue(block.id().toString()); });
		ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.SERVER_DATA, new Identifier("tags/blocks/mineable/axe.json"), path -> tag.serialize().toString());
	}

	private static void generateNeedsStoneToolTag() {
		var tag = JTagTemplate.DEFAULT.get();
		BLOCKS.forEach(block -> tag.addValue(block.id().toString()));
		ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.SERVER_DATA, new Identifier("tags/blocks/needs_stone_tool.json"), path -> tag.serialize().toString());
	}

	private static void generateLootTables() {
		for (TypedGroupedBlock block : BLOCKS) {
			var lootTable = JLootTableTemplate.BLOCK_BREAK.get();
			lootTable.addPool(JPool.ofItems(block.id()).addCondition(JCondition.SURVIVES_EXPLOSION.get()));
			ArchitectureExtensions.RESOURCE_PACK.putTextAsync(ResourceType.SERVER_DATA, new Identifier(block.id().getNamespace(), "loot_tables/blocks/" + block.id().getPath() + ".json"), path -> lootTable.serialize().toString());
		}
	}

	public static void generate() {
		generateMineableByPickaxeTag();
		generateMineableByAxeTag();
		generateNeedsStoneToolTag();
		generateLootTables();

		// we don't need asset generation on the server
		if (MinecraftQuiltLoader.getEnvironmentType() == EnvType.CLIENT) {
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
