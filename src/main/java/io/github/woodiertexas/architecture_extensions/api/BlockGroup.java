package io.github.woodiertexas.architecture_extensions.api;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;

public final class BlockGroup implements Iterable<BlockGroup.Block> {
	public static final BlockGroup STONE = BlockGroup.of(new Block("stone", Blocks.STONE, (type, textureId) -> "minecraft:block/stone"),
															new Block("blackstone", Blocks.BLACKSTONE, (type, textureId) -> "minecraft:block/blackstone"),
															new Block("sandstone", Blocks.SANDSTONE, (type, textureId) -> "minecraft:block/sandstone"),
															new Block("red_sandstone", Blocks.RED_SANDSTONE, (type, textureId) -> "minecraft:block/red_sandstone"),
															new Block("granite", Blocks.GRANITE, (type, textureId) -> "minecraft:block/granite"),
															new Block("diorite", Blocks.DIORITE, (type, textureId) -> "minecraft:block/diorite"),
															new Block("andesite", Blocks.ANDESITE, (type, textureId) -> "minecraft:block/andesite"));

	public static final BlockGroup AQUATIC_STONE = BlockGroup.of(new Block("prismarine", Blocks.PRISMARINE, (type, textureId) -> "minecraft:block/prismarine"));

	public static final BlockGroup PROCESSED_STONE = BlockGroup.of(new Block("cobbled_deepslate", Blocks.COBBLED_DEEPSLATE, (type, textureId) -> "minecraft:block/cobbled_deepslate"),
																	new Block("polished_deepslate", Blocks.POLISHED_DEEPSLATE, (type, textureId) -> "minecraft:block/polished_deepslate"),
																	new Block("polished_blackstone", Blocks.POLISHED_BLACKSTONE, (type, textureId) -> "minecraft:block/polished_blackstone"),
																	new Block("cobblestone", Blocks.COBBLESTONE, (type, textureId) -> "minecraft:block/cobblestone"),
																	new Block("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE, (type, textureId) -> "minecraft:block/mossy_cobblestone"));

	public static final BlockGroup WOOD = BlockGroup.of(new Block("oak", Blocks.OAK_WOOD, (type, textureId) -> "minecraft:block/oak_planks"),
														new Block("spruce", Blocks.SPRUCE_WOOD, (type, textureId) -> "minecraft:block/spruce_planks"),
														new Block("birch", Blocks.BIRCH_WOOD, (type, textureId) -> "minecraft:block/birch_planks"),
														new Block("jungle", Blocks.JUNGLE_WOOD, (type, textureId) -> "minecraft:block/jungle_planks"),
														new Block("acacia", Blocks.ACACIA_WOOD, (type, textureId) -> "minecraft:block/acacia_planks"),
														new Block("dark_oak", Blocks.DARK_OAK_WOOD, (type, textureId) -> "minecraft:block/dark_oak_planks"),
														new Block("mangrove", Blocks.MANGROVE_WOOD, (type, textureId) -> "minecraft:block/mangrove_planks"),
														new Block("crimson", Blocks.CRIMSON_STEM, (type, textureId) -> "minecraft:block/crimson_stem"),
														new Block("warped", Blocks.WARPED_STEM, (type, textureId) -> "minecraft:block/warped_stem"));

	public static final BlockGroup BRICK = BlockGroup.of(new Block("brick", Blocks.STONE, (type, textureId) -> "minecraft:block/bricks"),
														new Block("nether_brick", Blocks.ANDESITE, (type, textureId) -> "minecraft:block/nether_bricks"),
														new Block("red_nether_brick", Blocks.RED_NETHER_BRICKS, (type, textureId) -> "minecraft:block/red_nether_bricks"),
														new Block("stone_brick", Blocks.GRANITE, (type, textureId) -> "minecraft:block/stone_bricks"),
														new Block("blackstone_brick", Blocks.DARK_PRISMARINE, (type, textureId) -> "minecraft:block/dark_prismarine"),
														new Block("mossy_stone_brick", Blocks.DIORITE, (type, textureId) -> "minecraft:block/mossy_stone_bricks"),
														new Block("end_stone_brick", Blocks.END_STONE_BRICKS, (type, textureId) -> "minecraft:block/end_stone_bricks"),
														new Block("deepslate_brick", Blocks.DEEPSLATE_BRICKS, (type, textureId) -> "minecraft:block/deepslate_bricks"),
														new Block("prismarine_brick", Blocks.PRISMARINE_BRICKS, (type, textureId) -> "minecraft:block/prismarine_brick"),
														new Block("dark_prismarine", Blocks.DARK_PRISMARINE, (type, textureId) -> "minecraft:block/dark_prismarine"));

	public static final BlockGroup TILE = BlockGroup.of(new Block("deepslate_tile", Blocks.DEEPSLATE_TILES, (type, textureId) -> "minecraft:block/deepslate_tiles"));

	public static final BlockGroup CRYSTAL = BlockGroup.of(new Block("quartz", Blocks.QUARTZ_BLOCK, (type, textureId) -> "minecraft:block/quartz"));

	private final Set<BlockGroup.Block> blocks;

	private BlockGroup(Set<BlockGroup.Block> blocks) {
		this.blocks = blocks;
	}

	public static BlockGroup of(BlockGroup.Block... blocks) {
		if (blocks.length == 0) throw new IllegalArgumentException("BlockGroup.of requires at least one block.");
		return new BlockGroup(Set.of(blocks));
	}

	public static BlockGroup copyOf(BlockGroup blockGroup) {
		return new BlockGroup(Set.copyOf(Objects.requireNonNull(blockGroup).blocks));
	}

	public static BlockGroup copyOfWith(BlockGroup blockGroup, BlockGroup.Block... blocks) {
		if (blocks.length == 0) throw new IllegalArgumentException("BlockGroup.copyOfWith requires at least one block.");

		Set<BlockGroup.Block> newBlockSet = Set.copyOf(Objects.requireNonNull(blockGroup).blocks);
		newBlockSet.addAll(Set.of(blocks));

		return new BlockGroup(newBlockSet);
	}

	public static BlockGroup copyOfWithout(BlockGroup blockGroup, BlockGroup.Block... blocks) {
		if (blocks.length == 0) throw new IllegalArgumentException("BlockGroup.copyOfWithout requires at least one block.");

		Set<BlockGroup.Block> newBlockSet = Set.copyOf(Objects.requireNonNull(blockGroup).blocks);
		newBlockSet.addAll(Set.of(blocks));

		return new BlockGroup(Objects.requireNonNull(blockGroup).blocks);
	}

	@Override
	public Iterator<BlockGroup.Block> iterator() {
		return blocks.iterator();
	}

	public record Block(String id, net.minecraft.block.Block baseBlock, @Environment(EnvType.CLIENT) BiFunction<BlockType, String, String> textureGetter) {}
}
