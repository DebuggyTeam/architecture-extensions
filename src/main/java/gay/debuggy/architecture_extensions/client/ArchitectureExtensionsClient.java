package gay.debuggy.architecture_extensions.client;

import gay.debuggy.architecture_extensions.ArchitectureExtensions;
import gay.debuggy.architecture_extensions.resource.DataGeneration;
import gay.debuggy.architecture_extensions.util.SafeRenderLayer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceType;
import org.jetbrains.annotations.NotNull;

// TODO: more resource loading shenanigans here, mainly pertaining to ReloadableResourceManagerMixin
public class ArchitectureExtensionsClient implements ClientModInitializer, PackRegistrationContext.Callback {
	@Override
	public void onInitializeClient() {
		DataGeneration.BLOCKS.forEach(block -> {
			SafeRenderLayer renderLayer = SafeRenderLayer.choose(
					block.type().renderLayer(),
					block.groupedBlock().renderLayer()
					);
			if (renderLayer != SafeRenderLayer.SOLID) {
				BlockRenderLayerMap.INSTANCE.putBlocks(renderLayer.get(), Registries.BLOCK.get(block.id()));
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
