package io.github.debuggyteam.architecture_extensions.resource;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.jetbrains.annotations.Nullable;
import org.quiltmc.loader.api.ModContainer;

import com.google.common.collect.Sets;

import io.github.debuggyteam.architecture_extensions.ArchitectureExtensions;
import io.github.debuggyteam.architecture_extensions.util.LRUHashMap;
import net.minecraft.resource.ResourceType;

public final class ResourceUtils {
	// Field to get around weird java crap with lambdas
	private static Exception exception;

	private static final LRUHashMap<CacheKey, Cache> CACHES = new LRUHashMap<>(400);

	static void refreshCaches(ResourceType resourceType) {
		final var removing = Sets.newHashSet();
		CACHES.keySet().forEach(key -> {
			if (key.resourceType == resourceType) {
				final var refreshedCache = CACHES.get(key).getRefreshed();
				if (refreshedCache == null) removing.add(key);
				CACHES.replace(key, refreshedCache);
			}
		});
		removing.forEach(CACHES::remove);
	}

	static String getResourceAsString(ModContainer resourceOwner, ResourceType resourceType, String resourceName) throws Exception {
		final var cache = loadOrGetCache(resourceOwner, resourceType, resourceName);
		if (exception != null) throw exception;
		return cache.content;
	}

	private static Cache loadOrGetCache(ModContainer resourceOwner, ResourceType resourceType, String resourceName) throws Exception {
		exception = null;

		// use computeIfAbsent to avoid unnecessary object creation
		return CACHES.computeIfAbsent(new CacheKey(resourceOwner, resourceType, resourceName), k -> {
			try {
				return Cache.withInitialContent(resourceOwner.getPath(resourceName).toAbsolutePath());
			} catch (Exception e) {
				exception = e;
			}
			return null;
		});
	}

	private static record CacheKey(ModContainer resourceOwner, ResourceType resourceType, String resourceName) { }

	private static record Cache(Path resourcePath, String content) {
		public static Cache withInitialContent(Path resourcePath) throws Exception {
			return new Cache(resourcePath, Files.readString(resourcePath));
		}

		public @Nullable Cache getRefreshed() {
			try {
				return new Cache(resourcePath, Files.readString(resourcePath));
			} catch (FileNotFoundException e) {
				return null;
			} catch (Exception e) {
				ArchitectureExtensions.LOGGER.error("Exception while refreshing resource cache, falling back to old data : ", e);
				return this;
			}
		}
	}
}
