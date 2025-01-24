package gay.debuggy.architecture_extensions.util;

import net.minecraft.client.render.RenderLayer;

import java.util.function.Supplier;

// This code is to be run on the client only.
public enum SafeRenderLayer implements Supplier<RenderLayer> {
	SOLID(0),
	TRANSLUCENT(2),
	CUTOUT(1);

	private final int priority;

	SafeRenderLayer(int priority) {
		this.priority = priority;
	}

	// This code is to be run on the client only.
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
