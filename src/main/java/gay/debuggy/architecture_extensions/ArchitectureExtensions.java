package gay.debuggy.architecture_extensions;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static gay.debuggy.architecture_extensions.ArchitectureExtensionsBlocks.BIRCH_BEAM;

public class ArchitectureExtensions implements ModInitializer {
	public static final String MOD_ID = "architecture_extensions";
	
	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM_GROUP, ArchExItemGroups.ARCH_EX_JSON_BLOCKS_KEY, ArchExItemGroups.ARCH_EX_JSON_BLOCKS);
		Registry.register(Registries.ITEM_GROUP, ArchExItemGroups.ARCH_EX_GLTF_BLOCKS_KEY, ArchExItemGroups.ARCH_EX_GLTF_BLOCKS);
		
		ItemGroupEvents.modifyEntriesEvent(ArchExItemGroups.ARCH_EX_JSON_BLOCKS_KEY).register(itemGroup -> {
			itemGroup.addItem(BIRCH_BEAM);
		});
		
		ItemGroupEvents.modifyEntriesEvent(ArchExItemGroups.ARCH_EX_GLTF_BLOCKS_KEY).register(itemGroup -> {
			itemGroup.addItem(BIRCH_BEAM);
		});
		
		ArchitectureExtensionsBlocks.init();
		ArchExItemGroups.init();
	}
}
