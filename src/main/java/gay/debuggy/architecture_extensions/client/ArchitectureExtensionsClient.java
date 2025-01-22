package gay.debuggy.architecture_extensions.client;

import gay.debuggy.architecture_extensions.ArchitectureExtensions;
import gay.debuggy.architecture_extensions.resource.DataGeneration;
import gay.debuggy.architecture_extensions.util.SafeRenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceType;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.quiltmc.qsl.resource.loader.api.PackRegistrationContext;

public class ArchitectureExtensionsClient implements ClientModInitializer, PackRegistrationContext.Callback {
	@Override
	public void onInitializeClient(ModContainer mod) {
		DataGeneration.BLOCKS.forEach(block -> {
			SafeRenderLayer renderLayer = SafeRenderLayer.choose(
					block.type().renderLayer(),
					block.groupedBlock().renderLayer()
					);
			if (renderLayer != SafeRenderLayer.SOLID) {
				BlockRenderLayerMap.put(renderLayer.get(), Registries.BLOCK.get(block.id()));
			}
		});

		ResourceLoader.get(ResourceType.CLIENT_RESOURCES).getRegisterDefaultPackEvent().register(this);
	}

	@Override
	public void onRegisterPack(@NotNull PackRegistrationContext context) {
		DataGeneration.generate(ResourceType.CLIENT_RESOURCES);
		context.addResourcePack(ArchitectureExtensions.RESOURCE_PACK);
	}
}
