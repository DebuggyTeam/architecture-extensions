package io.github.debuggyteam.architecture_extensions.resource.json;

import java.util.Set;
import java.util.function.Supplier;

import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.util.Identifier;

public final class LootTableTemplate extends BaseTemplateJson<LootTableTemplate> {

	public static final Supplier<LootTableTemplate> BLOCK_BREAK = () -> new LootTableTemplate("{\"type\":\"minecraft:block\",\"pools\":[]}");

	private final Set<JPool> pools = Sets.newHashSet();

	private LootTableTemplate(String raw) {
		super(raw);
	}

	public LootTableTemplate addPool(JPool pool) {
		pools.add(pool);
		return this;
	}

	@Override
	public JsonObject serialize() {
		final JsonObject json = super.serialize();
		final JsonArray jsonPools = json.get("pools").getAsJsonArray();
		pools.forEach(pool -> jsonPools.add(pool.serialize()));
		return json;
	}

	public static final class JPool extends BaseTemplateJson<JPool> {

		private int rolls = 1;
		private final Set<JEntry> entries = Sets.newHashSet();
		private final Set<JCondition> conditions = Sets.newHashSet();

		private JPool(String raw) {
			super(raw);
		}

		public static JPool ofItems(Identifier... ids) {
			var pool = new JPool("{\"entries\":[],\"conditions\":[]}");
			for (Identifier id : ids) { pool.addEntry(JEntry.ofItem(id)); }
			return pool;
		}

		public JPool addEntry(JEntry entry) {
			entries.add(entry);
			return this;
		}

		public JPool addCondition(JCondition condition) {
			conditions.add(condition);
			return this;
		}

		public JPool setRolls(int rolls) {
			if (rolls < 0) rolls = 0;
			this.rolls = rolls;
			return this;
		}

		@Override
		public JsonObject serialize() {
			final JsonObject json = super.serialize();
			final JsonArray jsonEntries = json.get("entries").getAsJsonArray();
			final JsonArray jsonConditions = json.get("conditions").getAsJsonArray();
			json.addProperty("rolls", rolls);
			entries.forEach(entry -> jsonEntries.add(entry.serialize()));
			conditions.forEach(condition -> jsonConditions.add(condition.serialize()));
			return json;
		}

		public static final class JEntry extends BaseTemplateJson<JEntry> {

			private JEntry(String raw) {
				super(raw);
			}

			public static JEntry ofItem(Identifier id) {
				return new JEntry("{\"type\":\"minecraft:item\",\"name\":\"" + id.toString() + "\"}");
			}

		}

		public static final class JCondition extends BaseTemplateJson<JCondition> {

			public static final Supplier<JCondition> SURVIVES_EXPLOSION = () -> new JCondition("{\"condition\":\"minecraft:survives_explosion\"}");

			private JCondition(String raw) {
				super(raw);
			}

		}

	}

}
