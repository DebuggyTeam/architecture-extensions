package me.maximumpower55.objectify;

import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

abstract class BaseTemplateJson<T> {

	private static final Gson GSON = new Gson();

	private final String raw;

	private final Object2ObjectMap<String, String> constants = new Object2ObjectArrayMap<>();

	protected BaseTemplateJson(String raw) {
		this.raw = raw;
	}

	@SuppressWarnings("unchecked")
	public T addConstant(String id, String value) {
		this.constants.putIfAbsent(id, value);
		return (T) this;
	}

	public JsonObject serialize() {
		String modifiedRaw = raw.stripIndent();
		for (Object2ObjectMap.Entry<String, String> entry : constants.object2ObjectEntrySet()) {
			modifiedRaw = modifiedRaw.replaceAll(Pattern.quote("{" + entry.getKey() + "}"), entry.getValue());
		}
		return deserialize(modifiedRaw);
	}

	protected static JsonObject deserialize(String raw) {
		try {
			return GSON.getAdapter(JsonObject.class).read(new JsonReader(new StringReader(raw)));
		} catch (IOException e) {
			throw new JsonParseException(e);
		}
	}

}
