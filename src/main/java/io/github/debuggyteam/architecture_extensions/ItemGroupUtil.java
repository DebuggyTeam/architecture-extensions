package io.github.debuggyteam.architecture_extensions;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import io.github.debuggyteam.architecture_extensions.api.BlockType;
import it.unimi.dsi.fastutil.Pair;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

public final class ItemGroupUtil {
	private ItemGroupUtil() { }

	private static final Multimap<RegistryKey<ItemGroup>, TypedGroupedItem> ITEM_GROUP_ITEMS = LinkedHashMultimap.create();

	public static void pull(RegistryKey<ItemGroup> itemGroup, @Nullable BlockType type, @Nullable Block baseBlock, Item item) {
		ITEM_GROUP_ITEMS.put(itemGroup, new TypedGroupedItem(type, baseBlock, item));
	}

	// TODO: Maybe try sorting without all these allocations?
	private static Collection<Item> typedGroupingSort(Collection<TypedGroupedItem> unsorted) {
		final LinkedHashSet<Item> sorted = Sets.newLinkedHashSetWithExpectedSize(unsorted.size());

		final Multimap<Block, Pair<BlockType, Item>> transit = LinkedHashMultimap.create();
		for (TypedGroupedItem typedGroupedItem : unsorted) { transit.put(typedGroupedItem.baseBlock, Pair.of(typedGroupedItem.type, typedGroupedItem.item)); }
		for (Block block : transit.keySet()) {
			for (Pair<BlockType, Item> entry : transit.get(block)) {
				sorted.add(entry.value());
			}
		}

		return sorted;
	}

	private static void pushInto(RegistryKey<ItemGroup> itemGroup) {
		ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> typedGroupingSort(ITEM_GROUP_ITEMS.get(itemGroup)).forEach(entries::addItem));
	}

	public static void push() {
		ITEM_GROUP_ITEMS.keySet().forEach(ItemGroupUtil::pushInto);
	}

	private static record TypedGroupedItem(@Nullable BlockType type, @Nullable Block baseBlock, Item item) { }
}
