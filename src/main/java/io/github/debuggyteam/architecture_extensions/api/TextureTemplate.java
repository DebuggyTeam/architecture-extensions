package io.github.debuggyteam.architecture_extensions.api;

import java.util.function.BiFunction;
import java.util.function.Function;

import net.minecraft.util.Identifier;

public interface TextureTemplate extends BiFunction<BlockType, String, String> {
	public static final String[] TEXTURE_IDS = new String[]{"texture", "texture_side", "texture_up", "texture_down", "lantern_texture"};

	static final Function<Identifier, TextureTemplate> WOOD_WITH_LOG = woodId -> create(
		blockType -> {
			return switch (blockType) {
				case POST_LANTERN -> new Identifier("block/lantern").toString();
				default -> new Identifier(woodId.getNamespace(), "block/" + woodId.getPath() + "_planks").toString();
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> new Identifier(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_log").toString();
				default -> new Identifier(woodId.getNamespace(), "block/" + woodId.getPath() + "_planks").toString();
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> new Identifier(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_log_top").toString();
				default -> new Identifier(woodId.getNamespace(), "block/" + woodId.getPath() + "_planks").toString();
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> new Identifier(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_log_top").toString();
				default -> new Identifier(woodId.getNamespace(), "block/" + woodId.getPath() + "_planks").toString();
			};
		}
	);

	static final Function<Identifier, TextureTemplate> WOOD_WITH_STEM = woodId -> create(
		blockType -> {
			return switch (blockType) {
				case POST_LANTERN -> new Identifier("block/lantern").toString();
				default -> new Identifier(woodId.getNamespace(), "block/" + woodId.getPath() + "_planks").toString();
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> new Identifier(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_stem").toString();
				default -> new Identifier(woodId.getNamespace(), "block/" + woodId.getPath() + "_planks").toString();
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> new Identifier(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_stem_top").toString();
				default -> new Identifier(woodId.getNamespace(), "block/" + woodId.getPath() + "_planks").toString();
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> new Identifier(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_stem_top").toString();
				default -> new Identifier(woodId.getNamespace(), "block/" + woodId.getPath() + "_planks").toString();
			};
		}
	);

	static final Function<Identifier, TextureTemplate> SIDED = id -> create(
		blockType -> new Identifier(id.getNamespace(), "block/" + id.getPath() + "_top").toString(),
		blockType -> {
			return new Identifier(id.getNamespace(), "block/" + id.getPath() + "_side").toString();
		},
		blockType -> {
			return new Identifier(id.getNamespace(), "block/" + id.getPath() + "_top").toString();
		},
		blockType -> {
			return new Identifier(id.getNamespace(), "block/" + id.getPath() + "_bottom").toString();
		}
	);

	static final Function<Identifier, TextureTemplate> TOP = id -> create(
		blockType -> new Identifier(id.getNamespace(), "block/" + id.getPath()).toString(),
		blockType -> {
			return new Identifier(id.getNamespace(), "block/" + id.getPath()).toString();
		},
		blockType -> {
			return new Identifier(id.getNamespace(), "block/" + id.getPath() + "_top").toString();
		},
		blockType -> {
			return new Identifier(id.getNamespace(), "block/" + id.getPath()).toString();
		}
	);

	static final Function<Identifier, TextureTemplate> TOP_BOTTOM = id -> create(
		blockType -> new Identifier(id.getNamespace(), "block/" + id.getPath()).toString(),
		blockType -> {
			return new Identifier(id.getNamespace(), "block/" + id.getPath()).toString();
		},
		blockType -> {
			return new Identifier(id.getNamespace(), "block/" + id.getPath() + "_top").toString();
		},
		blockType -> {
			return new Identifier(id.getNamespace(), "block/" + id.getPath() + "_bottom").toString();
		}
	);

	static TextureTemplate create(Function<BlockType, String> base,
								 Function<BlockType, String> side,
								 Function<BlockType, String> up, Function<BlockType, String> down) {
		return (type, textureId) -> {
			return switch (textureId) {
				case "texture_side" -> side.apply(type);
				case "texture_up" -> up.apply(type);
				case "texture_down" -> down.apply(type);
				default -> base.apply(type);
			};
		};
	}
}
