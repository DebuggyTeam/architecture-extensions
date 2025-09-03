package gay.debuggy.architecture_extensions.client;

import gay.debuggy.architecture_extensions.ArchitectureExtensions;
import gay.debuggy.architecture_extensions.resource.DataGeneration;
import gay.debuggy.architecture_extensions.util.SafeRenderLayer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceType;
import org.jetbrains.annotations.NotNull;

public class ArchitectureExtensionsClient implements ClientModInitializer {
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
	}
}
