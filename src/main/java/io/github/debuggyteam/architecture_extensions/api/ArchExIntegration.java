package io.github.debuggyteam.architecture_extensions.api;

import java.util.function.Consumer;

import org.jetbrains.annotations.ApiStatus;

import net.minecraft.item.ItemGroup;

public interface ArchExIntegration {
	final String ENTRYPOINT_KEY = "architecture_extensions";

	void integrate(Context ctx);

	void itemGroups(Consumer<ItemGroup> itemGroupConsumer);

	@ApiStatus.NonExtendable
	interface Context {
		void makeArchExBlocks(BlockType type, BlockGroup... groups);
	}
}
