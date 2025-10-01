package gay.debuggy.architecture_extensions.api;

import gay.debuggy.architecture_extensions.ArchitectureExtensions;
import gay.debuggy.architecture_extensions.BlockCreationCallback;
import gay.debuggy.architecture_extensions.TypedGroupedBlockItem;
import gay.debuggy.architecture_extensions.blocks.ArchBlock;
import gay.debuggy.architecture_extensions.blocks.ArchExRodBlock;
import gay.debuggy.architecture_extensions.blocks.BeamBlock;
import gay.debuggy.architecture_extensions.blocks.CrownMoldingBlock;
import gay.debuggy.architecture_extensions.blocks.CurveBlock;
import gay.debuggy.architecture_extensions.blocks.FacadeBlock;
import gay.debuggy.architecture_extensions.blocks.FencePostBlock;
import gay.debuggy.architecture_extensions.blocks.IBeamBlock;
import gay.debuggy.architecture_extensions.blocks.JoistBlock;
import gay.debuggy.architecture_extensions.blocks.LatticeBlock;
import gay.debuggy.architecture_extensions.blocks.OctagonalColumnBlock;
import gay.debuggy.architecture_extensions.blocks.PostCapBlock;
import gay.debuggy.architecture_extensions.blocks.PostLanternBlock;
import gay.debuggy.architecture_extensions.blocks.RoofBlock;
import gay.debuggy.architecture_extensions.blocks.RoundArchBlock;
import gay.debuggy.architecture_extensions.blocks.RoundFencePostBlock;
import gay.debuggy.architecture_extensions.blocks.SquareTubeBlock;
import gay.debuggy.architecture_extensions.blocks.TransomBlock;
import gay.debuggy.architecture_extensions.blocks.PilasterBlock;
import gay.debuggy.architecture_extensions.blocks.WallPostBlock;
import gay.debuggy.architecture_extensions.util.SafeRenderLayer;
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.function.TriFunction;

import java.util.Locale;

public enum BlockShape {
	ARCH         (ArchBlock::new,        2.5f, variantsOf("", "inner", "outer"), SafeRenderLayer.SOLID),
	BEAM         (BeamBlock::new,        1.5f),
	CURVE   	 (CurveBlock::new,   	 1.5f),
	H_BEAM       (BeamBlock::new,        8.0f),
	PILASTER  	 (PilasterBlock::new, 	 2.5f, variantsOf("", "cap"), SafeRenderLayer.SOLID),
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
	SQUARE_TUBE  (SquareTubeBlock::new,  8.0f),
	I_BEAM       (IBeamBlock::new,       8.0f),
	TRANSOM      (TransomBlock::new,     1.5f, noVariants(), SafeRenderLayer.TRANSLUCENT),
	OCTAGONAL_COLUMN(OctagonalColumnBlock::new, 1.5f, variantsOf("", "cap", "double_cap"), SafeRenderLayer.SOLID),
	ROUND_ARCH   (RoundArchBlock::new,   1.5f),
	ROUND_FENCE_POST(RoundFencePostBlock::new,  1.5f);
	
	private final TriFunction<Block, AbstractBlock.Settings, TypedGroupedBlock, Block> creator;
	private final float strength;
	private final String[] variants;
	private final SafeRenderLayer renderLayer;

	BlockShape(TriFunction<Block, AbstractBlock.Settings, TypedGroupedBlock, Block> creator, float strength, String[] variants, SafeRenderLayer renderLayer) {
		this.creator = creator;
		this.strength = strength;
		this.variants = variants;
		this.renderLayer = renderLayer;
	}
	
	/**
	 * Makes a BlockShape with no variants and solid RenderLayer
	 * @see #BlockShape(TriFunction, float, String[], SafeRenderLayer)
	 */
	BlockShape(TriFunction<Block, AbstractBlock.Settings, TypedGroupedBlock, Block> creator, float strength) {
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

	// TODO: Come up with a better name for "TypedGroupedBlock"
	public TypedGroupedBlock register(BlockGroup group, BlockGroup.GroupedBlock groupedBlock, BlockCreationCallback callback, String modId) {
		// Note: the mod id parameter isn't used here by purpose, that parameter is there so we can easily debug where registration is coming from.
		Identifier id = Identifier.of(ArchitectureExtensions.MOD_ID, String.format("%s/%s", groupedBlock.id().getNamespace(), groupedBlock.id().getPath() + "_" + this));
		var baseBlock = groupedBlock.baseBlock().get();

		var blockSettings = AbstractBlock.Settings.copy(baseBlock).strength(strength);
		groupedBlock.mapColor().map(blockSettings::mapColor);
		var typedGroupedBlock = new TypedGroupedBlock(this, groupedBlock, id);
		var block = Registry.register(Registries.BLOCK, id, creator.apply(baseBlock, blockSettings, typedGroupedBlock));
		
		Registry.register(Registries.ITEM, id, new TypedGroupedBlockItem(block, typedGroupedBlock, new Item.Settings()));

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

	public static record TypedGroupedBlock(BlockShape type, BlockGroup.GroupedBlock groupedBlock, Identifier id) {}
}
