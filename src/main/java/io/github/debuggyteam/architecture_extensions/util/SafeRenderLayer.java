package io.github.debuggyteam.architecture_extensions.util;

import java.util.function.Supplier;

import org.quiltmc.loader.api.minecraft.ClientOnly;

import net.minecraft.client.render.RenderLayer;

public enum SafeRenderLayer implements @ClientOnly Supplier<RenderLayer> {
	SOLID(0),
	TRANSLUCENT(2),
	CUTOUT(1);

	private final int priority;

	SafeRenderLayer(int priority) {
		this.priority = priority;
	}

	@Override
	public RenderLayer get() {
		return switch (this) {
			case SOLID -> RenderLayer.getSolid();
			case TRANSLUCENT -> RenderLayer.getTranslucent();
			case CUTOUT -> RenderLayer.getCutout();
		};
	}

	public static SafeRenderLayer choose(SafeRenderLayer first, SafeRenderLayer second) {
		if (second.priority > first.priority) return second;
		return first;
	}
}
