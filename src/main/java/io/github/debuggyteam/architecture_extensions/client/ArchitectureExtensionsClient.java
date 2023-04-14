package io.github.debuggyteam.architecture_extensions.client;

import io.github.debuggyteam.architecture_extensions.ArchitectureExtensions;
import io.github.debuggyteam.architecture_extensions.resource.DataGeneration;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceType;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.quiltmc.qsl.resource.loader.api.ResourcePackRegistrationContext;

public class ArchitectureExtensionsClient implements ClientModInitializer, ResourcePackRegistrationContext.Callback {
	@Override
	public void onInitializeClient(ModContainer mod) {
		DataGeneration.BLOCKS.forEach(block -> BlockRenderLayerMap.put(block.type().renderLayer().get(), Registries.BLOCK.get(block.id())));

		ResourceLoader.get(ResourceType.CLIENT_RESOURCES).getRegisterDefaultResourcePackEvent().register(this);
	}

	@Override
	public void onRegisterPack(@NotNull ResourcePackRegistrationContext context) {
		DataGeneration.generate(ResourceType.CLIENT_RESOURCES);
		context.addResourcePack(ArchitectureExtensions.RESOURCE_PACK);
	}
}
