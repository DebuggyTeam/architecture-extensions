package me.maximumpower55.objectify;

import com.google.gson.JsonObject;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

public final class JModelTemplate extends BaseTemplateJson<JModelTemplate> {

	private final Object2ObjectMap<String, String> textures = new Object2ObjectArrayMap<>();

	public JModelTemplate(String raw) {
		super(raw);
	}

	public JModelTemplate addTexture(String textureId, String texture) {
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
