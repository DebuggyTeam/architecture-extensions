package io.github.debuggyteam.architecture_extensions.api;

import org.jetbrains.annotations.ApiStatus;

import net.minecraft.block.Block;

public interface ArchExIntegration {
	final String ENTRYPOINT_KEY = "architecture_extensions";

	/**
	 * Called by Architecture Extensions when it's ready to create blocks on behalf of a mod.
	 * @param ctx A Context object which can honor block creation requests
	 */
	void integrate(Context ctx);
	
	/**
	 * Called by Architecture Extensions when it creates a block that was requested by this integration class. You can
	 * use this function to add the new block to an ItemGroup, generate additional data, or emit diagnostic information.
	 * @param group     The group the newly created block is in
	 * @param blockType The type of block that was created
	 * @param base      The "base" block defining the material that the new block was made from
	 * @param created   The block that was created
	 */
	void onBlockCreated(BlockGroup group, BlockType blockType, Block base, Block created);

	/**
	 * Holds commands that Architecture Extensions makes available to mods for integration. At this point only block
	 * creation is supported.
	 */
	@ApiStatus.NonExtendable
	interface Context {
		/**
		 * Creates blocks of a particular BlockType and one or more BlockGroups
		 * @param type   the type of block, for example BlockType.FENCE_POST
		 * @param groups one or more BlockGroups to create blocks for.
		 */
		void makeArchExBlocks(BlockType type, BlockGroup... groups);
	}
}
