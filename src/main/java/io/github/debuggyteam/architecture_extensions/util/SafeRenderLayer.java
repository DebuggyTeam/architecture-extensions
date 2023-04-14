package io.github.debuggyteam.architecture_extensions.util;

public enum SafeRenderLayer {
	SOLID,
	TRANSLUCENT,
	CUTOUT;

	public static SafeRenderLayer combine(SafeRenderLayer first, SafeRenderLayer second) {
		if (first == TRANSLUCENT || second == TRANSLUCENT) return TRANSLUCENT;
		if (first == CUTOUT || second == CUTOUT) return CUTOUT;
		return SOLID;
	}
}
