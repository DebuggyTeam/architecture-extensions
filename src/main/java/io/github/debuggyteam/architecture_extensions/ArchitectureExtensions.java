package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.api.ArchExIntegration;
import io.github.debuggyteam.architecture_extensions.resource.DataGeneration;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.loader.api.entrypoint.EntrypointContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.resource.loader.api.InMemoryResourcePack;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.quiltmc.qsl.resource.loader.api.ResourcePackRegistrationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArchitectureExtensions implements ModInitializer, ResourcePackRegistrationContext.Callback {
	public static final Logger LOGGER = LoggerFactory.getLogger("Architecture Extensions");

	// This should probably be fine being public and mutable
	public static ModContainer MOD_CONTAINER;
	public static ItemGroup ITEM_GROUP;

	public static final InMemoryResourcePack RESOURCE_PACK = new InMemoryResourcePack.Named(id("pack/runtime").toString()) {
		@Override
		protected void dumpResource(Path parentPath, String resourcePath, byte[] resource) {
			super.dumpResource(parentPath, resourcePath.replaceFirst("architecture_extensions:", ""), resource);
		};

		@Override
		protected void dumpAll() {
			dumpTo(Paths.get("debug", "packs", "architecture_extensions"));
		}
	};

	@Override
	public void onInitialize(ModContainer mod) {
		MOD_CONTAINER = mod;

		ITEM_GROUP = FabricItemGroup
			.builder(id("building_blocks"))
			.icon(() -> PeculiarBlocks.DEBUGGY_BLOCK.asItem().getDefaultStack()) // TODO: Better icon?
			.build();

		PeculiarBlocks.register();

		VanillaIntegration.INSTANCE.integrate(new ArchExIntegrationContextImpl(VanillaIntegration.INSTANCE));

		for (EntrypointContainer<ArchExIntegration> entrypoint : QuiltLoader.getEntrypointContainers(ArchExIntegration.ENTRYPOINT_KEY, ArchExIntegration.class)) {
			try {
				entrypoint.getEntrypoint().integrate(new ArchExIntegrationContextImpl(entrypoint.getEntrypoint()));
			} catch (Exception e) {
				LOGGER.error("Mod '" + entrypoint.getProvider().metadata().id() + "' threw an exception when trying to integrate with Architecture Extensions");
			}
		}

		ItemGroupUtil.push();

		ResourceLoader.get(ResourceType.SERVER_DATA).getRegisterDefaultResourcePackEvent().register(this);
	}

	@Override
	public void onRegisterPack(@NotNull ResourcePackRegistrationContext context) {
		DataGeneration.generate(ResourceType.SERVER_DATA);
		context.addResourcePack(RESOURCE_PACK);
	}

	public static Identifier id(String path) {
		return new Identifier("architecture_extensions", path);
	}
}
