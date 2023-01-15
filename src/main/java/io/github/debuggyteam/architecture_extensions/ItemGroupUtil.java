package io.github.debuggyteam.architecture_extensions;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public final class ItemGroupUtil {
	private ItemGroupUtil() { }

	private static final Multimap<ItemGroup, Item> ITEM_GROUP_ITEMS = HashMultimap.create();

	public static void collect(ItemGroup itemGroup, Item item) {
		ITEM_GROUP_ITEMS.put(itemGroup, item);
	}

	private static void pull(ItemGroup itemGroup) {
		ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> ITEM_GROUP_ITEMS.get(itemGroup).forEach(entries::addItem));
	}

	public static void pull() {
		ITEM_GROUP_ITEMS.keySet().forEach(ItemGroupUtil::pull);
	}
}
