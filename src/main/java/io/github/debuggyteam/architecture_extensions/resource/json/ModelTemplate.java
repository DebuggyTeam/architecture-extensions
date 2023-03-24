package io.github.debuggyteam.architecture_extensions.resource.json;

import com.google.gson.JsonObject;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

public final class ModelTemplate extends BaseTemplateJson<ModelTemplate> {

	private final Object2ObjectMap<String, String> textures = new Object2ObjectArrayMap<>();

	public ModelTemplate(String raw) {
		super(raw);
	}

	public ModelTemplate addTexture(String textureId, String texture) {
		textures.putIfAbsent(textureId, texture);
		return this;
	}

	@Override
	public JsonObject serialize() {
		final JsonObject json = super.serialize();
		final JsonObject jsonTextures = json.get("textures").getAsJsonObject();
		textures.object2ObjectEntrySet().forEach(entry -> jsonTextures.addProperty(entry.getKey(), entry.getValue()));
		return json;
	}

}
