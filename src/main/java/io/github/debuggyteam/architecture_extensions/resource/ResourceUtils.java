package io.github.debuggyteam.architecture_extensions.resource;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

import org.jetbrains.annotations.Nullable;
import org.quiltmc.loader.api.ModContainer;

import com.google.common.collect.Sets;

import io.github.debuggyteam.architecture_extensions.ArchitectureExtensions;
import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;

public class ResourceUtils {
	// Field to get around weird java crap with lambdas
	private static Exception exception;

	private static final Object2ReferenceOpenHashMap<String, Cache> CACHES = new Object2ReferenceOpenHashMap<>();

	static void refreshCaches() {
		HashSet<String> removing = Sets.newHashSet();
		CACHES.keySet().forEach(resourceName -> {
			final var refreshedCache = CACHES.get(resourceName).getRefreshed();
			if (refreshedCache == null) removing.add(resourceName);
			CACHES.replace(resourceName, refreshedCache);
		});
		removing.forEach(resourceName -> CACHES.remove(resourceName));
	}

	static String getResourceAsString(ModContainer resourceOwner, String resourceName) throws Exception {
		final var cache = createOrGetCache(resourceOwner, resourceName);
		if (exception != null) throw exception;
		return new String(cache.data, StandardCharsets.UTF_8);
	}

	private static Cache createOrGetCache(ModContainer resourceOwner, String resourceName) throws Exception {
		exception = null;

		// use computeIfAbsent to avoid unnecessary object creation
		return CACHES.computeIfAbsent(resourceName, k -> {
			final var resourcePath = resourceOwner.getPath(resourceName).toAbsolutePath();
			try {
				return new Cache(resourceOwner, resourcePath, Files.readAllBytes(resourcePath));
			} catch (Exception e) {
				exception = e;
			}
			return null;
		});
	}

	private static record Cache(ModContainer resourceOwner, Path resourcePath, byte[] data) {
		public @Nullable Cache getRefreshed() {
			try {
				return new Cache(resourceOwner, resourcePath, Files.readAllBytes(resourcePath));
			} catch (FileNotFoundException e) {
				return null;
			} catch (Exception e) {
				ArchitectureExtensions.LOGGER.error("Exception while refreshing resource cache, falling back to old data : ", e);
				return this;
			}
		}
	}
}
