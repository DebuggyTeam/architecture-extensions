package io.github.woodiertexas.architecture_extensions.api;

import java.util.Locale;
import java.util.function.BiFunction;

import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import io.github.woodiertexas.architecture_extensions.ArchitectureExtensions;
import io.github.woodiertexas.architecture_extensions.blocks.ArchBlock;
import io.github.woodiertexas.architecture_extensions.blocks.BeamBlock;
import io.github.woodiertexas.architecture_extensions.blocks.ColumnBlock;
import io.github.woodiertexas.architecture_extensions.blocks.FencePostBlock;
import io.github.woodiertexas.architecture_extensions.blocks.JoistBlock;
import io.github.woodiertexas.architecture_extensions.blocks.MoldingBlock;
import io.github.woodiertexas.architecture_extensions.blocks.PostCapBlock;
import io.github.woodiertexas.architecture_extensions.blocks.PostLanternBlock;
import io.github.woodiertexas.architecture_extensions.blocks.ArchExRodBlock;
import io.github.woodiertexas.architecture_extensions.blocks.RoofBlock;
import io.github.woodiertexas.architecture_extensions.blocks.WallPostBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum BlockType {
	ARCH((baseBlock, settings) -> new ArchBlock(baseBlock.getDefaultState(), settings), 2.5f),
	BEAM((baseBlock, settings) -> new BeamBlock(settings), 1.5f),
	COLUMN((baseBlock, settings) -> new ColumnBlock(settings), 2.5f),
	FENCE_POST((baseBlock, settings) -> new FencePostBlock(settings), 1.5f),
	JOIST((baseBlock, settings) -> new JoistBlock(settings), 1.5f),
	MOLDING((baseBlock, settings) -> new MoldingBlock(baseBlock.getDefaultState(), settings), 1.5f),
	POST_CAP((baseBlock, settings) -> new PostCapBlock(settings), 1.5f),
	POST_LANTERN((baseBlock, settings) -> new PostLanternBlock(settings), 1.5f),
	ROD((baseBlock, settings) -> new ArchExRodBlock(settings), 1f),
	ROOF((baseBlock, settings) -> new RoofBlock(baseBlock.getDefaultState(), settings), 2.5f),
	WALL_POST((baseBlock, settings) -> new WallPostBlock(settings), 2.5f);

	private final BiFunction<Block, QuiltBlockSettings, Block> creator;
	private final float strength;

	BlockType(BiFunction<Block, QuiltBlockSettings, Block> creator, float strength) {
		this.creator = creator;
		this.strength = strength;
	}

	@Override
	public String toString() {
		return name().toLowerCase(Locale.ROOT);
	}

	public void register(String id, Block baseBlock, ItemGroup itemGroup) {
		Identifier registryKey = ArchitectureExtensions.id(id + "_" + this);
		Block block = Registry.register(Registry.BLOCK, registryKey, creator.apply(baseBlock, QuiltBlockSettings.copyOf(baseBlock).strength(strength)));
		Registry.register(Registry.ITEM, registryKey, new BlockItem(block, new QuiltItemSettings().group(itemGroup)));
	}
}
