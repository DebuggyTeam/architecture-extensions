import os

ROOT_DIR = os.path.realpath(os.path.join(os.path.dirname(__file__), '..'))


# For en_us.json generation

block_ids = [
    "stone_column", "granite_column", "diorite_column", "andesite_column", "cobbled_deepslate_column",
    "polished_deepslate_column", "cobblestone_column", "sandstone_column", "red_sandstone_column", "brick_column",
    "mossy_cobblestone_column", "stone_brick_column", "mossy_stone_brick_column", "deepslate_brick_column",
    "deepslate_tile_column", "nether_brick_column", "red_nether_brick_column", "end_stone_brick_column",
    "quartz_column", "prismarine_brick_column", "dark_prismarine_column", "blackstone_column",
    "polished_blackstone_column", "polished_blackstone_brick_column",

    "granite_post", "diorite_post", "andesite_post", "cobbled_deepslate_post", "polished_deepslate_post", "cobblestone_post",
    "sandstone_post", "red_sandstone_post", "brick_post", "mossy_cobblestone_post", "stone_brick_post", "mossy_stone_brick_post",
    "deepslate_brick_post", "deepslate_tile_post", "nether_brick_post", "red_nether_brick_post", "end_stone_brick_post",
    "prismarine_brick_post", "blackstone_post", "polished_blackstone_brick_post", "polished_blackstone_post",

    "granite_roof", "diorite_roof", "andesite_roof", "cobbled_deepslate_roof", "polished_deepslate_roof", "cobblestone_roof",
    "sandstone_roof", "red_sandstone_roof", "brick_roof", "mossy_cobblestone_roof", "stone_brick_roof", "mossy_stone_brick_roof",
    "deepslate_brick_roof", "deepslate_tile_roof", "nether_brick_roof", "red_nether_brick_roof", "end_stone_brick_roof",
    "smooth_quartz_roof", "prismarine_brick_roof", "blackstone_roof", "polished_blackstone_brick_roof", "polished_blackstone_roof",

    "granite_arch", "diorite_arch", "andesite_arch", "cobbled_deepslate_arch", "polished_deepslate_arch", "cobblestone_arch",
    "sandstone_arch", "red_sandstone_arch", "brick_arch", "mossy_cobblestone_arch", "stone_brick_arch", "mossy_stone_brick_arch",
    "deepslate_brick_arch", "deepslate_tile_arch", "nether_brick_arch", "red_nether_brick_arch", "end_stone_brick_arch",
    "smooth_quartz_arch", "prismarine_brick_arch", "blackstone_arch", "polished_blackstone_brick_arch", "polished_blackstone_arch",

    "oak_beam", "spruce_beam", "birch_beam", "jungle_beam", "acacia_beam", "dark_oak_beam", "crimson_beam", "warped_beam",
    "iron_h_beam",

    "oak_fence_post", "spruce_fence_post", "birch_fence_post", "jungle_fence_post", "acacia_fence_post", "dark_oak_fence_post",
    "crimson_fence_post", "warped_fence_post",
    "oak_joist", "spruce_joist", "birch_joist", "jungle_joist", "acacia_joist", "dark_oak_joist", "crimson_joist", "warped_joist",

    "oak_crown_molding", "spruce_crown_molding", "birch_crown_molding", "jungle_crown_molding", "acacia_crown_molding",
    "dark_oak_crown_molding", "crimson_crown_molding", "warped_crown_molding",

    "bamboo_rod", "copper_rod", "end_rod_nubless", "debuggy_block", "fake_end_portal_block",

    # Soul Ice Blocks
    "soul_ice_column", "polished_soul_ice_column", "soul_ice_brick_column", "lightstone_column",
    "polished_lightstone_column", "lightstone_brick_column", "hardened_lightstone_column",

    "soul_ice_post", "polished_soul_ice_post", "soul_ice_brick_post", "lightstone_post",
    "polished_lightstone_post", "lightstone_brick_post", "hardened_lightstone_post",

    "soul_ice_arch", "polished_soul_ice_arch", "soul_ice_brick_arch", "lightstone_arch",
    "polished_lightstone_arch", "lightstone_brick_arch", "hardened_lightstone_arch",

    # Aurora's Deco Blocks
    "azalea_beam", "jacaranda_beam", "azalea_fence_post", "jacaranda_fence_post", "azalea_joist", "jacaranda_joist",
    "azalea_crown_molding", "jacaranda_crown_molding"
]

block_names = [
    "Stone Column", "Granite Column", "Diorite Column", "Andesite Column", "Cobbled Deepslate Column",
    "Polished Deepslate Column", "Cobblestone Column", "Sandstone Column", "Red Sandstone Column", "Brick Column",
    "Mossy Cobblestone Column", "Stone Brick Column", "Mossy Stone Brick Column", "Deepslate Brick Column", "Deepslate Tile Column",
    "Nether Brick Column", "Red Nether Brick Column", "End Stone Brick Column", "Quartz Column", "Prismarine Brick Column",
    "Dark Prismarine Column", "Blackstone Column", "Polished Blackstone Column", "Polished Blackstone Brick Column",

    "Granite Post", "Diorite Post", "Andesite Post", "Cobbled Deepslate Post", "Polished Deepslate Post", "Cobblestone Post",
    "Sandstone Post", "Red Sandstone Post", "Brick Post", "Mossy Cobblestone Post", "Stone Brick Post", "Mossy Stone Brick Post",
    "Deepslate Brick Post", "Deepslate Tile Post", "Nether Brick Post", "Red Nether Brick Post", "End Stone Brick Post",
    "Prismarine Brick Post", "Blackstone Post", "Polished Blackstone Brick Post", "Polished Blackstone Post",

    "Granite Roof", "Diorite Roof", "Andesite Roof", "Cobbled Deepslate Roof", "Polished Deepslate Roof", "Cobblestone Roof",
    "Sandstone Roof", "Red Sandstone Roof", "Brick Roof", "Mossy Cobblestone Roof", "Stone Brick Roof", "Mossy Stone Brick Roof",
    "Deepslate Brick Roof", "Deepslate Tile Roof", "Nether Brick Roof", "Red Nether Brick Roof", "End Stone Brick Roof",
    "Smooth Quartz Roof", "Prismarine Brick Roof", "Blackstone Roof", "Polished Blackstone Brick Roof",
    "Polished Blackstone Roof",

    "Granite Arch", "Diorite Arch", "Andesite Arch", "Cobbled Deepslate Arch", "Polished Deepslate Arch", "Cobblestone Arch",
    "Sandstone Arch", "Red Sandstone Arch", "Brick Arch", "Mossy Cobblestone Arch", "Stone Brick Arch", "Mossy Stone Brick Arch",
    "Deepslate Brick Arch", "Deepslate Tile Arch", "Nether Brick Arch", "Red Nether Brick Arch", "End Stone Brick Arch",
    "Smooth Quartz Arch", "Prismarine Brick Arch", "Blackstone Arch", "Polished Blackstone Brick Arch",
    "Polished Blackstone Arch",

    "Oak Beam", "Spruce Beam", "Birch Beam", "Jungle Beam", "Acacia Beam", "Dark Oak Beam", "Crimson Beam", "Warped Beam",
    "Iron H Beam",

    "Oak Fence Post", "Spruce Fence Post", "Birch Fence Post", "Jungle Fence Post", "Acacia Fence Post", "Dark Oak Fence Post",
    "Crimson Fence Post", "Warped Fence Post",

    "Oak Joist", "Spruce Joist", "Birch Joist", "Jungle Joist", "Acacia Joist", "Dark Oak Joist", "Crimson Joist",
    "Warped Joist",

    "Oak Crown Molding", "Spruce Crown Molding", "Birch Crown Molding", "Jungle Crown Molding", "Acacia Crown Molding",
    "Dark Oak Crown Molding", "Crimson Crown Molding", "Warped Crown Molding",

    "Bamboo Rod", "Copper Rod", "End Rod Nubless", "Oddly Colored Block", "Starry Night Sky Block",

    # Soul Ice Blocks
    "Soul Ice Column", "Polished Soul Ice Column", "soul Ice Brick Column", "Lightstone Column",
    "Polished Lightstone Column", "Lightstone Brick Column", "Hardened Lightstone Column",

    "Soul Ice Post", "Polished Soul Ice Post", "Soul Ice Brick Post", "Lightstone Post", "Polished Lightstone Post",
    "Lightstone Brick Post", "Hardened Lightstone Post",

    "Soul Ice Arch", "Polished Soul Ice Arch", "Soul Ice Brick Arch", "Lightstone Arch", "Polished Lightstone Arch",
    "Lightstone Brick Arch", "Hardened Lightstone Arch",

    # Aurora's Deco Blocks
    "Azalea Beam", "Jacaranda Beam", "Azalea Fence Post", "Jacaranda Fence Post", "Azalea Joist", "Jacaranda Joist",
    "Azalea Crown Molding", "Jacaranda Crown Molding"
]