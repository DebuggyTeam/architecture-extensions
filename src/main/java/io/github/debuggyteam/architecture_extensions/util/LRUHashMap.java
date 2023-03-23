package io.github.debuggyteam.architecture_extensions.util;

import java.util.LinkedHashMap;
import java.util.Map;

public final class LRUHashMap<K, V> extends LinkedHashMap<K, V> {
	private final int maxSize;

	public LRUHashMap(int maxSize) {
		super((int) Math.ceil(maxSize / .75f) + 1, .75f);
		this.maxSize = maxSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
		return size() > maxSize;
	}
}
