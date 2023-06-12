package io.github.debuggyteam.architecture_extensions.util;

import java.util.Optional;

import net.minecraft.block.MapColor;

public class MapColors {
	public static Optional<MapColor> byName(String name) {
		return switch(name) {
			case "none" -> Optional.empty();

			case "grass" -> Optional.of(MapColor.GRASS);
			case "sand" -> Optional.of(MapColor.SAND);
			case "wool" -> Optional.of(MapColor.WOOL);
			case "fire" -> Optional.of(MapColor.FIRE);
			case "ice" -> Optional.of(MapColor.ICE);
			case "metal" -> Optional.of(MapColor.METAL);
			case "plant" -> Optional.of(MapColor.PLANT);
			case "snow" -> Optional.of(MapColor.SNOW);
			case "clay" -> Optional.of(MapColor.CLAY);
			case "dirt" -> Optional.of(MapColor.DIRT);
			case "stone" -> Optional.of(MapColor.STONE);
			case "water" -> Optional.of(MapColor.WATER);
			case "wood" -> Optional.of(MapColor.WOOD);
			case "quartz" -> Optional.of(MapColor.QUARTZ);
			case "orange" -> Optional.of(MapColor.ORANGE);
			case "magenta" -> Optional.of(MapColor.MAGENTA);
			case "light_blue" -> Optional.of(MapColor.LIGHT_BLUE);
			case "yellow" -> Optional.of(MapColor.YELLOW);
			case "lime" -> Optional.of(MapColor.LIME);
			case "pink" -> Optional.of(MapColor.PINK);
			case "gray" -> Optional.of(MapColor.GRAY);
			case "light_gray" -> Optional.of(MapColor.LIGHT_GRAY);
			case "cyan" -> Optional.of(MapColor.CYAN);
			case "purple" -> Optional.of(MapColor.PURPLE);
			case "blue" -> Optional.of(MapColor.BLUE);
			case "brown" -> Optional.of(MapColor.BROWN);
			case "green" -> Optional.of(MapColor.GREEN);
			case "red" -> Optional.of(MapColor.RED);
			case "black" -> Optional.of(MapColor.BLACK);
			case "gold" -> Optional.of(MapColor.GOLD);
			case "diamond" -> Optional.of(MapColor.DIAMOND);
			case "lapis" -> Optional.of(MapColor.LAPIS);
			case "emerald" -> Optional.of(MapColor.EMERALD);
			case "podzol" -> Optional.of(MapColor.PODZOL);
			case "nether" -> Optional.of(MapColor.NETHER);
			case "white_terracotta" -> Optional.of(MapColor.WHITE_TERRACOTTA);
			case "orange_terracotta" -> Optional.of(MapColor.ORANGE_TERRACOTTA);
			case "magenta_terracotta" -> Optional.of(MapColor.MAGENTA_TERRACOTTA);
			case "light_blue_terracotta" -> Optional.of(MapColor.LIGHT_BLUE_TERRACOTTA);
			case "yellow_terracotta" -> Optional.of(MapColor.YELLOW_TERRACOTTA);
			case "lime_terracotta" -> Optional.of(MapColor.LIME_TERRACOTTA);
			case "pink_terracotta" -> Optional.of(MapColor.PINK_TERRACOTTA);
			case "gray_terracotta" -> Optional.of(MapColor.GRAY_TERRACOTTA);
			case "light_gray_terracotta" -> Optional.of(MapColor.LIGHT_GRAY_TERRACOTTA);
			case "cyan_terracotta" -> Optional.of(MapColor.CYAN_TERRACOTTA);
			case "purple_terracotta" -> Optional.of(MapColor.PURPLE_TERRACOTTA);
			case "blue_terracotta" -> Optional.of(MapColor.BLUE_TERRACOTTA);
			case "brown_terracotta" -> Optional.of(MapColor.BROWN_TERRACOTTA);
			case "green_terracotta" -> Optional.of(MapColor.GREEN_TERRACOTTA);
			case "red_terracotta" -> Optional.of(MapColor.RED_TERRACOTTA);
			case "black_terracotta" -> Optional.of(MapColor.BLACK_TERRACOTTA);
			case "crimson_nylium" -> Optional.of(MapColor.CRIMSON_NYLIUM);
			case "crimson_stem" -> Optional.of(MapColor.CRIMSON_STEM);
			case "crimson_hyphae" -> Optional.of(MapColor.CRIMSON_HYPHAE);
			case "warped_nylium" -> Optional.of(MapColor.WARPED_NYLIUM);
			case "warped_stem" -> Optional.of(MapColor.WARPED_STEM);
			case "warped_hyphae" -> Optional.of(MapColor.WARPED_HYPHAE);
			case "warped_wart_block" -> Optional.of(MapColor.WARPED_WART_BLOCK);
			case "deepslate" -> Optional.of(MapColor.DEEPSLATE);
			case "raw_iron" -> Optional.of(MapColor.RAW_IRON);
			case "glow_lichen" -> Optional.of(MapColor.GLOW_LICHEN);

			default -> Optional.of(MapColor.GRAY);
		};
	}
}
