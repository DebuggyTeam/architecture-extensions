package io.github.woodiertexas.architecture_extensions;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArchitectureExtensions implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Architecture Extensions");

	public static final Block STONE_BRICK_ARCH = new Block(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
	public static final StoneBrickHalfPillar STONE_BRICK_HALF_PILLAR = new StoneBrickHalfPillar(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
	public static final StoneBrickHalfPillarCap STONE_BRICK_HALF_PILLAR_CAP = new StoneBrickHalfPillarCap(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
	public static final StoneBrickCircleCorner STONE_BRICK_CIRCLE_CORNER = new StoneBrickCircleCorner(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {} v{}!", mod.metadata().name(), mod.metadata().version().raw());

		/*
    	Creating items/blocks/etc and defining their properties
    	*/
		Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", "stone_brick_arch"), STONE_BRICK_ARCH);
		Registry.register(Registry.ITEM, new Identifier("architecture_extensions", "stone_brick_arch"),
				new BlockItem(STONE_BRICK_ARCH, new QuiltItemSettings().group(ItemGroup.DECORATIONS)));

		Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", "stone_brick_half_pillar"), STONE_BRICK_HALF_PILLAR);
		Registry.register(Registry.ITEM, new Identifier("architecture_extensions", "stone_brick_half_pillar"),
				new BlockItem(STONE_BRICK_HALF_PILLAR, new QuiltItemSettings().group(ItemGroup.DECORATIONS)));

		Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", "stone_brick_half_pillar_cap"), STONE_BRICK_HALF_PILLAR_CAP);
		Registry.register(Registry.ITEM, new Identifier("architecture_extensions", "stone_brick_half_pillar_cap"),
				new BlockItem(STONE_BRICK_HALF_PILLAR_CAP, new QuiltItemSettings().group(ItemGroup.DECORATIONS)));

		Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", "stone_brick_circle_corner"), STONE_BRICK_CIRCLE_CORNER);
		Registry.register(Registry.ITEM, new Identifier("architecture_extensions", "stone_brick_circle_corner"),
				new BlockItem(STONE_BRICK_CIRCLE_CORNER, new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
	}
}
