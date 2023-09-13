package io.github.debuggyteam.architecture_extensions.api;

import java.util.Locale;

import io.github.debuggyteam.architecture_extensions.blocks.RoundArchBlock;
import io.github.debuggyteam.architecture_extensions.blocks.CurveBlock;
import io.github.debuggyteam.architecture_extensions.blocks.FacadeBlock;
import io.github.debuggyteam.architecture_extensions.blocks.IBeamBlock;
import io.github.debuggyteam.architecture_extensions.blocks.LatticeBlock;
import io.github.debuggyteam.architecture_extensions.blocks.OctagonalColumnBlock;
import io.github.debuggyteam.architecture_extensions.blocks.RoundFencePostBlock;
import io.github.debuggyteam.architecture_extensions.blocks.TransomBlock;
import io.github.debuggyteam.architecture_extensions.blocks.TubeSteelBlock;
import io.github.debuggyteam.architecture_extensions.util.SafeRenderLayer;

import org.apache.commons.lang3.function.TriFunction;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import io.github.debuggyteam.architecture_extensions.ArchitectureExtensions;
import io.github.debuggyteam.architecture_extensions.BlockCreationCallback;
import io.github.debuggyteam.architecture_extensions.TypedGroupedBlockItem;
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
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public enum BlockType {
	ARCH         (ArchBlock::new,        2.5f, variantsOf("", "inner", "outer"), SafeRenderLayer.SOLID),
	BEAM         (BeamBlock::new,        1.5f),
	CURVE   (CurveBlock::new,   1.5f),
	H_BEAM       (BeamBlock::new,        8.0f),
	WALL_COLUMN  (WallColumnBlock::new,  2.5f, variantsOf("", "cap"), SafeRenderLayer.SOLID),
	FENCE_POST   (FencePostBlock::new,   1.5f),
	JOIST        (JoistBlock::new,       1.5f),
	CROWN_MOLDING(CrownMoldingBlock::new,1.5f, variantsOf("", "inner", "outer"), SafeRenderLayer.SOLID),
	POST_CAP     (PostCapBlock::new,     1.5f),
	POST_LANTERN (PostLanternBlock::new, 1.5f, variantsOf("", "hanging"), SafeRenderLayer.SOLID),
	ROD          (ArchExRodBlock::new,   1.0f),
	ROOF         (RoofBlock::new,        2.5f, variantsOf("", "inner", "outer"), SafeRenderLayer.SOLID),
	WALL_POST    (WallPostBlock::new,    2.5f),
	LATTICE      (LatticeBlock::new,     1.5f),
	FACADE       (FacadeBlock::new,      1.5f),
	TUBE_METAL   (TubeSteelBlock::new,   8.0f),
	I_BEAM       (IBeamBlock::new,       8.0f),
	TRANSOM      (TransomBlock::new,     1.5f, noVariants(), SafeRenderLayer.TRANSLUCENT),
	OCTAGONAL_COLUMN(OctagonalColumnBlock::new, 1.5f, variantsOf("", "cap", "double_cap"), SafeRenderLayer.SOLID),
	ROUND_ARCH   (RoundArchBlock::new,   1.5f),
	ROUND_FENCE_POST(RoundFencePostBlock::new,  1.5f);
	
	private final TriFunction<Block, QuiltBlockSettings, TypedGroupedBlock, Block> creator;
	private final float strength;
	private final String[] variants;
	private final SafeRenderLayer renderLayer;

	BlockType(TriFunction<Block, QuiltBlockSettings, TypedGroupedBlock, Block> creator, float strength, String[] variants, SafeRenderLayer renderLayer) {
		this.creator = creator;
		this.strength = strength;
		this.variants = variants;
		this.renderLayer = renderLayer;
	}
	
	/**
	 * Makes a BlockType with no variants and solid RenderLayer
	 * @see #BlockType(TriFunction, float, String[], SafeRenderLayer)
	 */
	BlockType(TriFunction<Block, QuiltBlockSettings, TypedGroupedBlock, Block> creator, float strength) {
		this(creator, strength, noVariants(), SafeRenderLayer.SOLID);
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
		Identifier id = new Identifier(ArchitectureExtensions.MOD_CONTAINER.metadata().id(), String.format("%s/%s", groupedBlock.id().getNamespace(), groupedBlock.id().getPath() + "_" + this));
		var baseBlock = groupedBlock.baseBlock().get();

		var blockSettings = QuiltBlockSettings.copyOf(baseBlock).strength(strength);
		groupedBlock.mapColor().map(blockSettings::mapColor);
		var typedGroupedBlock = new TypedGroupedBlock(this, groupedBlock, id);
		var block = Registry.register(Registries.BLOCK, id, creator.apply(baseBlock, blockSettings, typedGroupedBlock));
		
		Registry.register(Registries.ITEM, id, new TypedGroupedBlockItem(block, typedGroupedBlock, new QuiltItemSettings()));

		// So mobs don't get stuck on arch-ex blocks, and lag the server trying to path-find through them
		// Required since that is the default for non full blocks
		LandPathNodeTypesRegistry.register(block, PathNodeType.BLOCKED, PathNodeType.BLOCKED);
		if (callback != null) callback.onBlockCreated(group, this, baseBlock, block);

		return typedGroupedBlock;
	}

	private static final String[] noVariants() {
		return new String[] {""};
	}

	private static final String[] variantsOf(String... variants) {
		return variants;
	}

	public static record TypedGroupedBlock(BlockType type, BlockGroup.GroupedBlock groupedBlock, Identifier id) {}
}
