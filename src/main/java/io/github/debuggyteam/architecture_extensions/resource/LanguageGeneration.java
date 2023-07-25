package io.github.debuggyteam.architecture_extensions.resource;

import java.util.Map;

import com.mojang.datafixers.util.Pair;

import io.github.debuggyteam.architecture_extensions.api.BlockType;
import net.minecraft.util.Identifier;

public final class LanguageGeneration {
	private static String getLangKey(Identifier id) {
		return "block." + id.getNamespace() + "." + id.getPath().replace("/", ".");
	}

	public static void generate(Map<String, String> langEntries) {
		for (BlockType.TypedGroupedBlock block : DataGeneration.BLOCKS) {
			var groupedBlockComponent = Component.GROUPED_BLOCK.translate(langEntries, block.groupedBlock().id().toTranslationKey());
			if (groupedBlockComponent.getSecond()) groupedBlockComponent = Component.GROUPED_BLOCK.translate(langEntries, block.groupedBlock().id().getPath());
			final var blockTypeComponent = Component.BLOCK_TYPE.translate(langEntries, block.type().toString());

			langEntries.put(getLangKey(block.id()), String.format(langEntries.get("architecture_extensions.block_type_block"), groupedBlockComponent.getFirst(), blockTypeComponent.getFirst()));
		}
	}

	private static enum Component {
		GROUPED_BLOCK("architecture_extensions.grouped_block"),
		BLOCK_TYPE("architecture_extensions.block_type");

		private final String key;

		Component(String key) {
			this.key = key;
		}

		public Pair<String, Boolean> translate(Map<String, String> langEntries, String id) {
			final var entryId = key + "." + id;
			final var entry = langEntries.get(entryId);
			if (entry != null) return Pair.of(entry, false);
			return Pair.of(entryId, true);
		}
	}
}
