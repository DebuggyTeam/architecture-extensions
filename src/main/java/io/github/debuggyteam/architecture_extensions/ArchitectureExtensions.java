package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.api.ArchExIntegration;
import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import io.github.debuggyteam.architecture_extensions.resource.DataGeneration;
import io.github.debuggyteam.architecture_extensions.staticdata.BlockGroupSchema;
import io.github.debuggyteam.architecture_extensions.staticdata.StaticData;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.loader.api.entrypoint.EntrypointContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.resource.loader.api.InMemoryResourcePack;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.quiltmc.qsl.resource.loader.api.ResourcePackRegistrationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ArchitectureExtensions implements ModInitializer, ResourcePackRegistrationContext.Callback {
	public static final Logger LOGGER = LoggerFactory.getLogger("Architecture Extensions");

	// This should probably be fine being public and mutable
	public static ModContainer MOD_CONTAINER;
	public static ItemGroup ITEM_GROUP;
	/**
	 * BlockCreationCallback that adds the created block to the Architecture Extensions "Building Blocks" ItemGroup.
	 */
	public static final BlockCreationCallback CALLBACK_ADD_TO_ITEM_GROUP = (group, blockType, baseBlock, derivedBlock) -> {
		ItemGroupUtil.pull(ArchitectureExtensions.ITEM_GROUP, blockType, baseBlock, derivedBlock.asItem());
	};

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

		VanillaIntegration.INSTANCE.integrate(new ArchExIntegrationContextImpl(VanillaIntegration.INSTANCE, mod.metadata().id()));
		
		//Find and execute entrypoint integrations
		for (EntrypointContainer<ArchExIntegration> entrypoint : QuiltLoader.getEntrypointContainers(ArchExIntegration.ENTRYPOINT_KEY, ArchExIntegration.class)) {
			try {
				entrypoint.getEntrypoint().integrate(new ArchExIntegrationContextImpl(entrypoint.getEntrypoint(), entrypoint.getProvider().metadata().id()));
			} catch (Exception e) {
				LOGGER.error("Mod '" + entrypoint.getProvider().metadata().id() + "' threw an exception when trying to integrate with Architecture Extensions");
			}
		}
		
		// Find and register staticdata blocks
		List<StaticData.Item> dataRegistrations = StaticData.getData(new Identifier("architecture_extensions", ""));
		Gson gson = new GsonBuilder().create();
		for(StaticData.Item item : dataRegistrations) {
			try {
				BlockGroupSchema data = gson.fromJson(item.getAsString(), BlockGroupSchema.class);
				
				String requiredMod = data.only_if_present;
				if (requiredMod != null && !requiredMod.isBlank()) {
					// Should only be loaded when the indicated mod is present
					if (!QuiltLoader.isModLoaded(requiredMod)) continue;
				}
				
				BlockGroup group = data.createBlockGroup();
				Set<BlockType> blockTypes = data.getBlockTypes();
				for(BlockGroup.GroupedBlock groupedBlock : group) {
					DeferredRegistration.register(item.modId(), group, groupedBlock, blockTypes, CALLBACK_ADD_TO_ITEM_GROUP);
				}
			} catch (IOException ex) {
				throw new RuntimeException("There was a problem getting staticdata for mod container '"+item.modId()+"' with resource id '"+item.resourceId()+"'.", ex);
			}
		}
		
		// Start resolving deferred blocks when their base-blocks appear
		DeferredRegistration.init();
		
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
