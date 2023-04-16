package io.github.debuggyteam.architecture_extensions.resource;

import java.util.Map;

import io.github.debuggyteam.architecture_extensions.api.BlockType;
import net.minecraft.util.Identifier;

public final class LanguageGeneration {
	private static String getLangKey(Identifier id) {
		return "block." + id.getNamespace() + "." + id.getPath();
	}

	public static void generate(Map<String, String> langEntries) {
		for (BlockType.TypedGroupedBlock block : DataGeneration.BLOCKS) {
			final var groupedBlockComponent = Component.GROUPED_BLOCK.translate(langEntries, block.groupedBlock().id().getPath());
			final var blockTypeComponent = Component.BLOCK_TYPE.translate(langEntries, block.type().toString());

			langEntries.put(getLangKey(block.id()), String.format(langEntries.get("architecture_extensions.block_type_block"), groupedBlockComponent, blockTypeComponent));
		}
	}

	private static enum Component {
		GROUPED_BLOCK("architecture_extensions.grouped_block"),
		BLOCK_TYPE("architecture_extensions.block_type");

		private final String key;

		Component(String key) {
			this.key = key;
		}

		public String translate(Map<String, String> langEntries, String id) {
			return langEntries.get(key + "." + id);
		}
	}
}
