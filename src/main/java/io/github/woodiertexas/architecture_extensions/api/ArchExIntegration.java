package io.github.woodiertexas.architecture_extensions.api;

import org.jetbrains.annotations.ApiStatus;

import net.minecraft.item.ItemGroup;

public interface ArchExIntegration {
	String ENTRYPOINT_KEY = "architecture_extensions";

	void integrate(Context ctx);

	ItemGroup itemGroup();

	@ApiStatus.NonExtendable
	interface Context {
		void makeArchExBlocks(BlockType type, BlockGroup... groups);
	}
}
