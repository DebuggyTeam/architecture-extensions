package io.github.debuggyteam.architecture_extensions.resource.json;

import java.util.Set;
import java.util.function.Supplier;

import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public final class TagTemplate extends BaseTemplateJson<TagTemplate> {

	public static final Supplier<TagTemplate> DEFAULT = () -> new TagTemplate("{\"replace\":false,\"values\":[]}");

	private final Set<String> values = Sets.newHashSet();

	public TagTemplate(String raw) {
		super(raw);
	}

	public TagTemplate addValue(String value) {
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
