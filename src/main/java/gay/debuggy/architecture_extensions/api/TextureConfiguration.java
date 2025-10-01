package gay.debuggy.architecture_extensions.api;

import java.util.function.BiFunction;
import java.util.function.Function;

import net.minecraft.util.Identifier;

import static gay.debuggy.architecture_extensions.ArchitectureExtensions.MOD_ID;

public interface TextureConfiguration extends BiFunction<BlockShape, String, String> {
	public static final String[] TEXTURE_IDS = new String[]{"texture", "texture_side", "texture_up", "texture_down"};

	static final Function<Identifier, TextureConfiguration> WOOD_WITH_LOG = woodId -> create(
		blockType -> {
			return switch (blockType) {
				case JOIST, OCTAGONAL_COLUMN -> woodId.getNamespace() + ":block/stripped_" + woodId.getPath() + "_log";
				default -> woodId.getNamespace() + ":block/" + woodId.getPath() + "_planks";
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> Identifier.of(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_log").toString();
				default -> woodId.getNamespace() + ":block/" + woodId.getPath() + "_planks";
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> Identifier.of(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_log_top").toString();
				default -> woodId.getNamespace() + ":block/" + woodId.getPath() + "_planks";
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> Identifier.of(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_log_top").toString();
				default -> woodId.getNamespace() + ":block/" + woodId.getPath() + "_planks";
			};
		}
	);

	static final Function<Identifier, TextureConfiguration> WOOD_WITH_STEM = woodId -> create(
		blockType -> {
			return switch (blockType) {
				case JOIST, OCTAGONAL_COLUMN -> woodId.getNamespace() + ":block/stripped_" + woodId.getPath() + "_stem";
				default -> woodId.getNamespace() + ":block/" + woodId.getPath() + "_planks";
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> Identifier.of(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_stem").toString();
				default -> woodId.getNamespace() + ":block/" + woodId.getPath() + "_planks";
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> Identifier.of(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_stem_top").toString();
				default -> woodId.getNamespace() + ":block/" + woodId.getPath() + "_planks";
			};
		},
		blockType -> {
			return switch (blockType) {
				case BEAM -> Identifier.of(woodId.getNamespace(), "block/" + "stripped_" + woodId.getPath() + "_stem_top").toString();
				default -> woodId.getNamespace() + ":block/" + woodId.getPath() + "_planks";
			};
		}
	);

	static final Function<Identifier, TextureConfiguration> SIDED = id -> create(
		blockType -> Identifier.parse("block/" + id.getPath() + "_top").toString(),
		blockType -> {
			return Identifier.parse("block/" + id.getPath() + "_side").toString();
		},
		blockType -> {
			return Identifier.parse("block/" + id.getPath() + "_top").toString();
		},
		blockType -> {
			return Identifier.parse("block/" + id.getPath() + "_bottom").toString();
		}
	);

	static final Function<Identifier, TextureConfiguration> TOP = id -> create(
		blockType -> Identifier.parse("block/" + id.getPath()).toString(),
		blockType -> {
			return Identifier.parse("block/" + id.getPath()).toString();
		},
		blockType -> {
			return Identifier.parse("block/" + id.getPath() + "_top").toString();
		},
		blockType -> {
			return Identifier.parse("block/" + id.getPath()).toString();
		}
	);
	
	static final Function<Identifier, TextureConfiguration> END = id -> create(
		blockType -> Identifier.of(MOD_ID, (id.getNamespace()) + "/block/" + id.getPath()).toString(),
		blockType -> {
			return Identifier.of(MOD_ID, (id.getNamespace()) + "/block/" + id.getPath()).toString();
		},
		blockType -> {
			return Identifier.of(MOD_ID, (id.getNamespace()) + "/block/" + id.getPath() + "_end").toString();
		},
		blockType -> {
			return Identifier.of(MOD_ID, (id.getNamespace()) + "/block/" + id.getPath()).toString();
		}
	);

	static final Function<Identifier, TextureConfiguration> TOP_BOTTOM = id -> create(
		blockType -> Identifier.parse("block/" + id.getPath()).toString(),
		blockType -> {
			return Identifier.parse("block/" + id.getPath()).toString();
		},
		blockType -> {
			return Identifier.parse("block/" + id.getPath() + "_top").toString();
		},
		blockType -> {
			return Identifier.parse("block/" + id.getPath() + "_bottom").toString();
		}
	);
	
	static final Function<Identifier, TextureConfiguration> ALL = it -> (type, textureId) -> Identifier.of(MOD_ID, (it.getNamespace()) + "/block/" + it.getPath()).toString();

	static TextureConfiguration create(Function<BlockShape, String> base,
								 Function<BlockShape, String> side,
								 Function<BlockShape, String> up, Function<BlockShape, String> down) {
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
