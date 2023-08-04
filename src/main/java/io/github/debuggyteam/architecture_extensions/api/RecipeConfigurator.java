package io.github.debuggyteam.architecture_extensions.api;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.quiltmc.loader.api.QuiltLoader;

public interface RecipeConfigurator extends BiConsumer<BlockType, Consumer<RecipeConfigurator.RecipeTemplate>> {
	static RecipeConfigurator simple(String id) {
		return (type, templateConsumer) -> templateConsumer.accept(new RecipeTemplate(id, true, false));
	}

	static final RecipeConfigurator STONECUTTER = (type, templateConsumer) -> {
		switch (type) {
			case FENCE_POST:
				RecipeConfigurator.CRAFTING.accept(type, templateConsumer);
				templateConsumer.accept(new RecipeTemplate("stonecutting", false));
				break;
			case WALL_POST:
				RecipeConfigurator.CRAFTING.accept(type, templateConsumer);
				templateConsumer.accept(new RecipeTemplate("stonecutting", false));
				break;
			default:
				templateConsumer.accept(new RecipeTemplate("stonecutting", false));
				break;
		}
	};

	static final RecipeConfigurator SAWING = (type, templateConsumer) -> {
		if (!QuiltLoader.isModLoaded("tablesaw")) {
			RecipeConfigurator.STONECUTTER.accept(type, templateConsumer);
			return;
		}

		switch (type) {
			case FENCE_POST:
				RecipeConfigurator.CRAFTING.accept(type, templateConsumer);
			default:
				templateConsumer.accept(new RecipeTemplate("sawing", true));
				break;
		}
	};

	static final RecipeConfigurator CRAFTING = (type, templateConsumer) -> {
		switch (type) {
			case FENCE_POST:
				templateConsumer.accept(new RecipeTemplate("fence_to_post", false));
				templateConsumer.accept(new RecipeTemplate("post_to_fence", false));
				break;
			case WALL_POST:
				templateConsumer.accept(new RecipeTemplate("wall_to_post", false));
				templateConsumer.accept(new RecipeTemplate("post_to_wall", false));
				break;
			case H_BEAM:
				templateConsumer.accept(new RecipeTemplate("h_beam", false));
				break;
			case I_BEAM:
				templateConsumer.accept(new RecipeTemplate("i_beam", false));
				break;
			case TUBE_METAL:
				templateConsumer.accept(new RecipeTemplate("tube_metal", false));
				break;
			default:
				break;
		}
	};
	
	static final RecipeConfigurator CREATIVE = (type, templateConsumer) -> {};

	static record RecipeTemplate(String id, boolean simple, boolean tablesaw) {
		RecipeTemplate(String id, boolean tablesaw) {
			this(id, false, tablesaw);
		}
	}
}
