package gay.debuggy.architecture_extensions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gay.debuggy.architecture_extensions.api.ArchExIntegration;
import gay.debuggy.architecture_extensions.api.BlockGroup;
import gay.debuggy.architecture_extensions.api.BlockType;
import gay.debuggy.architecture_extensions.resource.MapBackedPack;
import gay.debuggy.architecture_extensions.staticdata.BlockGroupSchema;
import gay.debuggy.staticdata.api.StaticData;
import gay.debuggy.staticdata.api.StaticDataItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.entrypoint.EntrypointContainer;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ArchitectureExtensions implements ModInitializer {
	public static final String MOD_ID = "architecture_extensions";
	public static final Logger LOGGER = LoggerFactory.getLogger("Architecture Extensions");

	// This should probably be fine being public and mutable
	public static ModContainer MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();
	public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, id("building_blocks"));
	/**
	 * BlockCreationCallback that adds the created block to the Architecture Extensions "Building Blocks" ItemGroup.
	 */
	public static final BlockCreationCallback CALLBACK_ADD_TO_ITEM_GROUP = (group, blockType, baseBlock, derivedBlock) ->
		ItemGroupUtil.pull(ArchitectureExtensions.ITEM_GROUP, blockType, baseBlock, derivedBlock.asItem());

	public static final MapBackedPack RESOURCE_PACK = new MapBackedPack();

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP.getValue(), FabricItemGroup.builder()
			.name(Text.translatable("itemGroup.architecture_extensions.building_blocks"))
			.icon(() -> PeculiarBlocks.DEBUGGY_BLOCK.asItem().getDefaultStack()) // TODO: Better icon?
			.build()
		);
		
		PeculiarBlocks.register();

		VanillaIntegration.INSTANCE.integrate(new ArchExIntegrationContextImpl(VanillaIntegration.INSTANCE, MOD_ID));
		
		//Find and execute entrypoint integrations
		for (EntrypointContainer<ArchExIntegration> entrypoint : FabricLoader.getInstance().getEntrypointContainers(ArchExIntegration.ENTRYPOINT_KEY, ArchExIntegration.class)) {
			try {
				entrypoint.getEntrypoint().integrate(new ArchExIntegrationContextImpl(entrypoint.getEntrypoint(), entrypoint.getProvider().getMetadata().getId()));
			} catch (Exception ex) {
				LOGGER.error("Mod '" + entrypoint.getProvider().getMetadata().getId() + "' threw an exception when trying to integrate with Architecture Extensions");
			}
		}
		
		// Find and register staticdata blocks
		List<StaticDataItem> dataRegistrations = StaticData.getDataInDirectory(Identifier.of("architecture_extensions", ""), true);
		Gson gson = new GsonBuilder().create();
		for(StaticDataItem item : dataRegistrations) {
			try {
				BlockGroupSchema data = gson.fromJson(item.getAsString(), BlockGroupSchema.class);
				
				String requiredMod = data.only_if_present;
				if (requiredMod != null && !requiredMod.isBlank()) {
					// Should only be loaded when the indicated mod is present
					if (!FabricLoader.getInstance().isModLoaded(requiredMod)) continue;
				}
				
				BlockGroup group = data.createBlockGroup();
				Set<BlockType> blockTypes = data.getBlockTypes();
				for(BlockGroup.GroupedBlock groupedBlock : group) {
					DeferredRegistration.register(item.getModId(), group, groupedBlock, blockTypes, CALLBACK_ADD_TO_ITEM_GROUP);
				}
			} catch (IOException ex) {
				LOGGER.warn("There was a problem getting staticdata for mod container '" + item.getModId() + "' with resource id '" + item.getResourceId() + "'.", ex);
			}
		}

		// Start resolving deferred blocks when their base-blocks appear
		DeferredRegistration.init();
		
		ItemGroupUtil.push();
		
		//ResourceManagerHelper.get(ResourceType.SERVER_DATA).getRegisterDefaultPackEvent().register(this);
	}
	
	/*
	@Override
	public void onRegisterPack(@NotNull PackRegistrationContext context) {
		DataGeneration.generate(ResourceType.SERVER_DATA);
		context.addResourcePack(RESOURCE_PACK);
	}
	 */

	public static Identifier id(String path) {
		return Identifier.of("architecture_extensions", path);
	}
}
