package io.github.debuggyteam.architecture_extensions.api;

import java.util.Locale;
import java.util.function.BiFunction;

import io.github.debuggyteam.architecture_extensions.blocks.FacadeBlock;
import io.github.debuggyteam.architecture_extensions.blocks.IBeamBlock;
import io.github.debuggyteam.architecture_extensions.blocks.LatticeBlock;
import io.github.debuggyteam.architecture_extensions.blocks.OctoColumnBlock;
import io.github.debuggyteam.architecture_extensions.blocks.TransomBlock;
import io.github.debuggyteam.architecture_extensions.blocks.TubeSteelBlock;
import io.github.debuggyteam.architecture_extensions.util.SafeRenderLayer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import io.github.debuggyteam.architecture_extensions.ArchitectureExtensions;
import io.github.debuggyteam.architecture_extensions.BlockCreationCallback;
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
	ARCH((baseBlock, settings) -> new ArchBlock(baseBlock.getDefaultState(), settings), 2.5f, variantsOf("", "inner", "outer"), SafeRenderLayer.SOLID),
	BEAM((baseBlock, settings) -> new BeamBlock(settings), 1.5f, noVariants(), SafeRenderLayer.SOLID),
	H_BEAM((baseBlock, settings) -> new BeamBlock(settings), 8f, noVariants(), SafeRenderLayer.SOLID),
	WALL_COLUMN((baseBlock, settings) -> new WallColumnBlock(settings), 2.5f, variantsOf("", "cap"), SafeRenderLayer.SOLID),
	FENCE_POST((baseBlock, settings) -> new FencePostBlock(settings), 1.5f, noVariants(), SafeRenderLayer.SOLID),
	JOIST((baseBlock, settings) -> new JoistBlock(settings), 1.5f, noVariants(), SafeRenderLayer.SOLID),
	CROWN_MOLDING((baseBlock, settings) -> new CrownMoldingBlock(baseBlock.getDefaultState(), settings), 1.5f, variantsOf("", "inner", "outer"), SafeRenderLayer.SOLID),
	POST_CAP((baseBlock, settings) -> new PostCapBlock(settings), 1.5f, noVariants(), SafeRenderLayer.SOLID),
	POST_LANTERN((baseBlock, settings) -> new PostLanternBlock(settings), 1.5f, variantsOf("", "hanging"), SafeRenderLayer.SOLID),
	ROD((baseBlock, settings) -> new ArchExRodBlock(settings), 1f, noVariants(), SafeRenderLayer.SOLID),
	ROOF((baseBlock, settings) -> new RoofBlock(baseBlock.getDefaultState(), settings), 2.5f, variantsOf("", "inner", "outer"), SafeRenderLayer.SOLID),
	WALL_POST((baseBlock, settings) -> new WallPostBlock(settings), 2.5f, noVariants(), SafeRenderLayer.SOLID),
	LATTICE((baseBlock, settings) -> new LatticeBlock(settings), 1.5f, noVariants(), SafeRenderLayer.SOLID),
	FACADE((baseBlock, settings) -> new FacadeBlock(settings), 1.5f, noVariants(), SafeRenderLayer.SOLID),
	TUBE_STEEL((baseBlock, settings) -> new TubeSteelBlock(settings), 8f, noVariants(), SafeRenderLayer.SOLID),
	I_BEAM((baseBlock, settings) -> new IBeamBlock(settings), 8f, noVariants(), SafeRenderLayer.SOLID),
	TRANSOM((baseBlock, settings) -> new TransomBlock(settings), 1.5f, noVariants(), SafeRenderLayer.TRANSLUCENT),
	OCTOGONAL_COLUMN((baseBlock, settings) -> new OctoColumnBlock(settings), 1.5f, noVariants(), SafeRenderLayer.SOLID);

	private final BiFunction<Block, QuiltBlockSettings, Block> creator;
	private final float strength;
	private final String[] variants;
	private final SafeRenderLayer renderLayer;

	BlockType(BiFunction<Block, QuiltBlockSettings, Block> creator, float strength, String[] variants, SafeRenderLayer renderLayer) {
		this.creator = creator;
		this.strength = strength;
		this.variants = variants;
		this.renderLayer = renderLayer;
	}


	public String[] variants() {
		return variants;
	}

	public SafeRenderLayer renderLayer() {
		return renderLayer;
	}

	@Override
	public String toString() {
		return name().toLowerCase(Locale.ROOT);
	}

	public TypedGroupedBlock register(BlockGroup group, BlockGroup.GroupedBlock groupedBlock, BlockCreationCallback callback, String modId) {
		// Note: the mod id parameter isn't used here by purpose, that parameter is there so we can easily debug where registration is coming from.
		Identifier id = new Identifier(ArchitectureExtensions.MOD_CONTAINER.metadata().id(), groupedBlock.id().getPath() + "_" + this);
		var baseBlock = groupedBlock.baseBlock().get();

		var blockSettings = QuiltBlockSettings.copyOf(baseBlock).strength(strength);
		groupedBlock.mapColor().map(mapColor -> blockSettings.mapColor(mapColor));
		var block = Registry.register(Registries.BLOCK, id, creator.apply(baseBlock, blockSettings));

		Registry.register(Registries.ITEM, id, new BlockItem(block, new QuiltItemSettings()));

		if (callback != null) callback.onBlockCreated(group, this, baseBlock, block);

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
