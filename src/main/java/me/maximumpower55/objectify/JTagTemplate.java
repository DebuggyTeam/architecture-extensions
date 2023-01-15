package me.maximumpower55.objectify;

import java.util.Set;
import java.util.function.Supplier;

import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public final class JTagTemplate extends BaseTemplateJson<JTagTemplate> {

	public static final Supplier<JTagTemplate> DEFAULT = () -> new JTagTemplate("{\"replace\":false,\"values\":[]}");

	private final Set<String> values = Sets.newHashSet();

	public JTagTemplate(String raw) {
		super(raw);
	}

	public JTagTemplate addValue(String value) {
		values.add(value);
		return this;
	}

	@Override
	public JsonObject serialize() {
		final JsonObject json = super.serialize();
		final JsonArray jsonValues = json.get("values").getAsJsonArray();
		values.forEach(jsonValues::add);
		return json;
	}

}
