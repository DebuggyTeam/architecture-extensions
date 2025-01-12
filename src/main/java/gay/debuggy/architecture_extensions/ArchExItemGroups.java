package gay.debuggy.architecture_extensions;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static gay.debuggy.architecture_extensions.ArchitectureExtensions.MOD_ID;
import static gay.debuggy.architecture_extensions.ArchitectureExtensionsBlocks.BIRCH_BEAM;

public class ArchExItemGroups {
	public static RegistryKey<ItemGroup> makeItemGroupKey(String mod_id, String itemGroupPath) {
		return RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(mod_id, itemGroupPath));
	}
	
	public static final RegistryKey<ItemGroup> ARCH_EX_JSON_BLOCKS_KEY = makeItemGroupKey(MOD_ID, "json_blocks");
	public static final RegistryKey<ItemGroup> ARCH_EX_GLTF_BLOCKS_KEY = makeItemGroupKey(MOD_ID, "gltf_blocks");
	
	public static final ItemGroup ARCH_EX_JSON_BLOCKS = FabricItemGroup.builder()
		.icon(() -> new ItemStack(BIRCH_BEAM))
		.name(Text.of("Arch-Ex Building Blocks"))
		.build();
	
	public static final ItemGroup ARCH_EX_GLTF_BLOCKS = FabricItemGroup.builder()
		.icon(() -> new ItemStack(Blocks.ACACIA_LEAVES))
		.name(Text.of("Arch-Ex Building Blocks"))
		.build();
	
	public static void init() {}
}
