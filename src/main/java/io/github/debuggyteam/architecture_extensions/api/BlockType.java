package io.github.debuggyteam.architecture_extensions.api;

import java.util.Locale;
import java.util.function.BiFunction;

import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import io.github.debuggyteam.architecture_extensions.ArchExIntegrationContextImpl;
import io.github.debuggyteam.architecture_extensions.ArchitectureExtensions;
import io.github.debuggyteam.architecture_extensions.blocks.ArchBlock;
import io.github.debuggyteam.architecture_extensions.blocks.BeamBlock;
import io.github.debuggyteam.architecture_extensions.blocks.WallColumnBlock;
import io.github.debuggyteam.architecture_extensions.blocks.FencePostBlock;
import io.github.debuggyteam.architecture_extensions.blocks.JoistBlock;
import io.github.debuggyteam.architecture_extensions.blocks.CrownMoldingBlock;
import io.github.debuggyteam.architecture_extensions.blocks.PostCapBlock;
import io.github.debuggyteam.architecture_extensions.blocks.PostLanternBlock;
import io.github.debuggyteam.architecture_extensions.blocks.ArchExRodBlock;
import io.github.debuggyteam.architecture_extensions.blocks.RoofBlock;
import io.github.debuggyteam.architecture_extensions.blocks.WallPostBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public enum BlockType {
	ARCH((baseBlock, settings) -> new ArchBlock(baseBlock.getDefaultState(), settings), 2.5f, variantsOf("", "inner", "outer")),
	BEAM((baseBlock, settings) -> new BeamBlock(settings), 1.5f, noVariants()),
	H_BEAM((baseBlock, settings) -> new BeamBlock(settings), 8f, noVariants()),
	WALL_COLUMN((baseBlock, settings) -> new WallColumnBlock(settings), 2.5f, variantsOf("", "cap")),
	FENCE_POST((baseBlock, settings) -> new FencePostBlock(settings), 1.5f, noVariants()),
	JOIST((baseBlock, settings) -> new JoistBlock(settings), 1.5f, noVariants()),
	CROWN_MOLDING((baseBlock, settings) -> new CrownMoldingBlock(baseBlock.getDefaultState(), settings), 1.5f, variantsOf("", "inner", "outer")),
	POST_CAP((baseBlock, settings) -> new PostCapBlock(settings), 1.5f, noVariants()),
	POST_LANTERN((baseBlock, settings) -> new PostLanternBlock(settings), 1.5f, noVariants()),
	ROD((baseBlock, settings) -> new ArchExRodBlock(settings), 1f, noVariants()),
	ROOF((baseBlock, settings) -> new RoofBlock(baseBlock.getDefaultState(), settings), 2.5f, variantsOf("", "inner", "outer")),
	WALL_POST((baseBlock, settings) -> new WallPostBlock(settings), 2.5f, noVariants());

	private final BiFunction<Block, QuiltBlockSettings, Block> creator;
	private final float strength;
	private final String[] variants;

	BlockType(BiFunction<Block, QuiltBlockSettings, Block> creator, float strength, String[] variants) {
		this.creator = creator;
		this.strength = strength;
		this.variants = variants;
	}

	public String[] variants() {
		return variants;
	}

	@Override
	public String toString() {
		return name().toLowerCase(Locale.ROOT);
	}

	public TypedGroupedBlock register(BlockGroup group, BlockGroup.GroupedBlock groupedBlock, ArchExIntegrationContextImpl.BlockCreationCallback onBlockCreated) {
		var id = ArchitectureExtensions.id(groupedBlock.id().getPath() + "_" + this);
		var baseBlock = groupedBlock.baseBlock().get();
		var block = Registry.register(Registries.BLOCK, id, creator.apply(baseBlock, QuiltBlockSettings.copyOf(baseBlock).mapColorProvider(state -> groupedBlock.mapColor()).strength(strength)));

		Registry.register(Registries.ITEM, id, new BlockItem(block, new QuiltItemSettings()));
		
		onBlockCreated.onBlockCreated(group, this, baseBlock, block);

		return new TypedGroupedBlock(this, groupedBlock, id);
	}

	private static final String[] noVariants() {
		return new String[] {""};
	}

	private static final String[] variantsOf(String... variants) {
		return variants;
	}

	public static record TypedGroupedBlock(BlockType type, BlockGroup.GroupedBlock groupedBlock, Identifier id) {}
}
