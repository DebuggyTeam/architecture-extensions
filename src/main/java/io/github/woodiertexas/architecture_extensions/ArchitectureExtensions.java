package io.github.woodiertexas.architecture_extensions;

import io.github.woodiertexas.architecture_extensions.api.ArchExIntegration;
import net.minecraft.util.Identifier;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.loader.api.entrypoint.EntrypointContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArchitectureExtensions implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Architecture Extensions");

	@Override
	public void onInitialize(ModContainer mod) {
		PeculiarBlocks.register();

		VanillaIntegration.INSTANCE.integrate(new ArchExIntegrationContextImpl(VanillaIntegration.INSTANCE));

		for (EntrypointContainer<ArchExIntegration> entrypoint : QuiltLoader.getEntrypointContainers(ArchExIntegration.ENTRYPOINT_KEY, ArchExIntegration.class)) {
			try {
				entrypoint.getEntrypoint().integrate(new ArchExIntegrationContextImpl(entrypoint.getEntrypoint()));
			} catch (Exception e) {
				LOGGER.error("Mod '" + entrypoint.getProvider().metadata().id() + "' threw an exception when trying to integrate with Architecture Extensions");
			}
		}
	}

	public static Identifier id(String path) {
		return new Identifier("architecture_extensions", path);
	}
}
