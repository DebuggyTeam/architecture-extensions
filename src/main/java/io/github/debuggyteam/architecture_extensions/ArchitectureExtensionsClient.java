package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.blocks.TransomBlock;
import net.minecraft.client.render.RenderLayer;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.quiltmc.qsl.resource.loader.api.ResourcePackRegistrationContext;

import io.github.debuggyteam.architecture_extensions.resource.DataGeneration;
import net.minecraft.resource.ResourceType;

public class ArchitectureExtensionsClient implements ClientModInitializer, ResourcePackRegistrationContext.Callback {
	@Override
	public void onInitializeClient(ModContainer mod) {
		ResourceLoader.get(ResourceType.CLIENT_RESOURCES).getRegisterDefaultResourcePackEvent().register(this);

		// This will be a pain in the ass
		//BlockRenderLayerMap.put(RenderLayer.getCutout(), TransomBlock);
	}

	@Override
	public void onRegisterPack(@NotNull ResourcePackRegistrationContext context) {
		DataGeneration.generate(ResourceType.CLIENT_RESOURCES);
		context.addResourcePack(ArchitectureExtensions.RESOURCE_PACK);
	}
}
