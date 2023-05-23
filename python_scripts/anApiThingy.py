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
    "prismarine_post", "prismarine_brick_post", "blackstone_post", "polished_blackstone_brick_post", "polished_blackstone_post",

    "granite_roof", "diorite_roof", "andesite_roof", "cobbled_deepslate_roof", "polished_deepslate_roof", "cobblestone_roof",
    "sandstone_roof", "red_sandstone_roof", "brick_roof", "mossy_cobblestone_roof", "stone_brick_roof", "mossy_stone_brick_roof",
    "deepslate_brick_roof", "deepslate_tile_roof", "nether_brick_roof", "red_nether_brick_roof", "end_stone_brick_roof",
    "smooth_quartz_roof", "prismarine_brick_roof", "blackstone_roof", "polished_blackstone_brick_roof", "polished_blackstone_roof",

    "granite_arch", "diorite_arch", "andesite_arch", "cobbled_deepslate_arch", "polished_deepslate_arch", "cobblestone_arch",
    "sandstone_arch", "red_sandstone_arch", "brick_arch", "mossy_cobblestone_arch", "stone_brick_arch", "mossy_stone_brick_arch",
    "deepslate_brick_arch", "deepslate_tile_arch", "nether_brick_arch", "red_nether_brick_arch", "end_stone_brick_arch",
    "smooth_quartz_arch", "prismarine_brick_arch", "blackstone_arch", "polished_blackstone_brick_arch", "polished_blackstone_arch",

    "oak_beam", "spruce_beam", "birch_beam", "jungle_beam", "acacia_beam", "dark_oak_beam", "mangrove_beam",
    "crimson_beam", "warped_beam", "iron_h_beam",

    "oak_fence_post", "spruce_fence_post", "birch_fence_post", "jungle_fence_post", "acacia_fence_post", "dark_oak_fence_post",
    "mangrove_fence_post", "crimson_fence_post", "warped_fence_post",

    "oak_joist", "spruce_joist", "birch_joist", "jungle_joist", "acacia_joist", "dark_oak_joist", "mangrove_joist", "crimson_joist",
    "warped_joist",

    "oak_crown_molding", "spruce_crown_molding", "birch_crown_molding", "jungle_crown_molding", "acacia_crown_molding",
    "dark_oak_crown_molding", "mangrove_crown_molding", "crimson_crown_molding", "warped_crown_molding",

    "bamboo_rod", "copper_rod", "end_rod_nubless", "iron_rod", "debuggy_block", "fake_end_portal_block",

    "oak_post_cap", "oak_post_lantern", "spruce_post_cap", "spruce_post_lantern", "birch_post_cap", "birch_post_lantern",
    "jungle_post_cap", "jungle_post_lantern", "acacia_post_cap", "acacia_post_lantern", "dark_oak_post_cap", "dark_oak_post_lantern",
    "mangrove_post_cap", "mangrove_post_lantern", "crimson_post_cap", "crimson_post_lantern", "warped_post_cap", "warped_post_lantern",

    # Soul Ice Blocks
    "soul_ice_column", "polished_soul_ice_column", "soul_ice_brick_column", "lightstone_column",
    "polished_lightstone_column", "lightstone_brick_column", "hardened_lightstone_column",

    "soul_ice_post", "polished_soul_ice_post", "soul_ice_brick_post", "lightstone_post",
    "polished_lightstone_post", "lightstone_brick_post", "hardened_lightstone_post",

    "soul_ice_arch", "polished_soul_ice_arch", "soul_ice_brick_arch", "lightstone_arch",
    "polished_lightstone_arch", "lightstone_brick_arch", "hardened_lightstone_arch",

    # Aurora's Deco Blocks
    "azalea_beam", "jacaranda_beam", "azalea_fence_post", "jacaranda_fence_post", "azalea_joist", "jacaranda_joist",
    "azalea_crown_molding", "jacaranda_crown_molding", "azalea_post_cap", "azalea_post_lantern", "jacaranda_post_cap", "jacaranda_post_lantern",
]

block_names = [
    "Stone Column", "Granite Column", "Diorite Column", "Andesite Column", "Cobbled Deepslate Column",
    "Polished Deepslate Column", "Cobblestone Column", "Sandstone Column", "Red Sandstone Column", "Brick Column",
    "Mossy Cobblestone Column", "Stone Brick Column", "Mossy Stone Brick Column", "Deepslate Brick Column",
    "Deepslate Tile Column",
    "Nether Brick Column", "Red Nether Brick Column", "End Stone Brick Column", "Quartz Column",
    "Prismarine Brick Column",
    "Dark Prismarine Column", "Blackstone Column", "Polished Blackstone Column", "Polished Blackstone Brick Column",

    "Granite Post", "Diorite Post", "Andesite Post", "Cobbled Deepslate Post", "Polished Deepslate Post",
    "Cobblestone Post",
    "Sandstone Post", "Red Sandstone Post", "Brick Post", "Mossy Cobblestone Post", "Stone Brick Post",
    "Mossy Stone Brick Post",
    "Deepslate Brick Post", "Deepslate Tile Post", "Nether Brick Post", "Red Nether Brick Post", "End Stone Brick Post",
    "Prismarine Post", "Prismarine Brick Post", "Blackstone Post", "Polished Blackstone Brick Post",
    "Polished Blackstone Post",

    "Granite Roof", "Diorite Roof", "Andesite Roof", "Cobbled Deepslate Roof", "Polished Deepslate Roof",
    "Cobblestone Roof",
    "Sandstone Roof", "Red Sandstone Roof", "Brick Roof", "Mossy Cobblestone Roof", "Stone Brick Roof",
    "Mossy Stone Brick Roof",
    "Deepslate Brick Roof", "Deepslate Tile Roof", "Nether Brick Roof", "Red Nether Brick Roof", "End Stone Brick Roof",
    "Smooth Quartz Roof", "Prismarine Brick Roof", "Blackstone Roof", "Polished Blackstone Brick Roof",
    "Polished Blackstone Roof",

    "Granite Arch", "Diorite Arch", "Andesite Arch", "Cobbled Deepslate Arch", "Polished Deepslate Arch",
    "Cobblestone Arch",
    "Sandstone Arch", "Red Sandstone Arch", "Brick Arch", "Mossy Cobblestone Arch", "Stone Brick Arch",
    "Mossy Stone Brick Arch",
    "Deepslate Brick Arch", "Deepslate Tile Arch", "Nether Brick Arch", "Red Nether Brick Arch", "End Stone Brick Arch",
    "Smooth Quartz Arch", "Prismarine Brick Arch", "Blackstone Arch", "Polished Blackstone Brick Arch",
    "Polished Blackstone Arch",

    "Oak Beam", "Spruce Beam", "Birch Beam", "Jungle Beam", "Acacia Beam", "Dark Oak Beam", "Mangrove Beam",
    "Crimson Beam", "Warped Beam", "Iron H Beam",

    "Oak Fence Post", "Spruce Fence Post", "Birch Fence Post", "Jungle Fence Post", "Acacia Fence Post",
    "Dark Oak Fence Post",
    "Mangrove Fence Post", "Crimson Fence Post", "Warped Fence Post",

    "Oak Joist", "Spruce Joist", "Birch Joist", "Jungle Joist", "Acacia Joist", "Dark Oak Joist", "Mangrove Joist",
    "Crimson Joist", "Warped Joist",

    "Oak Crown Molding", "Spruce Crown Molding", "Birch Crown Molding", "Jungle Crown Molding", "Acacia Crown Molding",
    "Dark Oak Crown Molding", "Mangrove Crown Molding", "Crimson Crown Molding", "Warped Crown Molding",

    "Bamboo Rod", "Copper Rod", "End Rod Nubless", "Iron Rod", "Oddly Colored Block", "Starry Night Sky Block",

    "Oak Post Cap", "Oak Post Lantern", "Spruce Post Cap", "Spruce Post Lantern", "Birch Post Cap", "Birch Post Lantern",
    "Jungle Post Cap", "Jungle Post Lantern", "Acacia Post Cap", "Acacia Post Lantern", "Dark Oak Post Cap",
    "Dark Oak Post Lantern", "Mangrove Post Cap", "Mangrove Post Lantern", "Crimson Post Cap", "Crimson Post Lantern",
    "Warped Post Cap", "Warped Post Lantern",

    # Soul Ice Blocks
    "Soul Ice Column", "Polished Soul Ice Column", "Soul Ice Brick Column", "Lightstone Column",
    "Polished Lightstone Column", "Lightstone Brick Column", "Hardened Lightstone Column",

    "Soul Ice Post", "Polished Soul Ice Post", "Soul Ice Brick Post", "Lightstone Post", "Polished Lightstone Post",
    "Lightstone Brick Post", "Hardened Lightstone Post",

    "Soul Ice Arch", "Polished Soul Ice Arch", "Soul Ice Brick Arch", "Lightstone Arch", "Polished Lightstone Arch",
    "Lightstone Brick Arch", "Hardened Lightstone Arch",

    # Aurora's Deco Blocks
    "Azalea Beam", "Jacaranda Beam", "Azalea Fence Post", "Jacaranda Fence Post", "Azalea Joist", "Jacaranda Joist",
    "Azalea Crown Molding", "Jacaranda Crown Molding", "Azalea Post Cap", "Azalea Post Lantern",
    "Jacaranda Post Cap", "Jacaranda Post Lantern",
]


# For rod block generation
def rods_blockstate(arch_ex_block):
    rod_blockstate = {
        "variants": {
            "facing=down": {
                "model": f"architecture_extensions:block/rods/{arch_ex_block}_rod",
                "x": 180
            },
            "facing=east": {
                "model": f"architecture_extensions:block/rods/{arch_ex_block}_rod",
                "x": 90,
                "y": 90
            },
            "facing=north": {
                "model": f"architecture_extensions:block/rods/{arch_ex_block}_rod",
                "x": 90
            },
            "facing=south": {
                "model": f"architecture_extensions:block/rods/{arch_ex_block}_rod",
                "x": 90,
                "y": 180
            },
            "facing=up": {
                "model": f"architecture_extensions:block/rods/{arch_ex_block}_rod"
            },
            "facing=west": {
                "model": f"architecture_extensions:block/rods/{arch_ex_block}_rod",
                "x": 90,
                "y": 270
            }
        }
    }
    return rod_blockstate


def rods_model(minecraft_block, namespace):
    rod_model = {
        "parent": "architecture_extensions:block/templates/template_rod_block",
        "textures": {
            "texture": f"{namespace}:/block/{minecraft_block}"
        }
    }
    return rod_model


def rods_item(arch_ex_block):
    rod_item = {
        "parent": f"architecture_extensions:block/rods/{arch_ex_block}_rod"
    }
    return rod_item


# For generating post blocks
def posts_blockstate(arch_ex_block):
    post_blockstate = {
        "variants": {
            "axis=x": {
                "model": f"architecture_extensions:block/posts/{arch_ex_block}_post",
                "x": 90,
                "y": 90
            },
            "axis=y": {
                "model": f"architecture_extensions:block/posts/{arch_ex_block}_post"
            },
            "axis=z": {
                "model": f"architecture_extensions:block/posts/{arch_ex_block}_post",
                "x": 90
            }
        }
    }
    return post_blockstate


def posts_model(minecraft_block, namespace):
    post_model = {
        "parent": "architecture_extensions:block/templates/template_wall_post_block",
        "textures": {
            "texture": f"{namespace}:block/{minecraft_block}"
        }
    }
    return post_model


def posts_item(arch_ex_block):
    post_item = {
        "parent": f"architecture_extensions:block/posts/{arch_ex_block}_post"
    }
    return post_item


def posts_recipe_one(arch_ex_block, minecraft_block, namespace):
    wall_to_post_recipe = {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [
            {
                "item": f"{namespace}:{minecraft_block}_wall"
            }
        ],
        "result": {
            "item": f"architecture_extensions:{arch_ex_block}_post",
            "count": 1
        }
    }
    return wall_to_post_recipe


def posts_recipe_two(arch_ex_block, minecraft_block, namespace):
    post_to_wall_recipe = {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [
            {
                "item": f"architecture_extensions:{arch_ex_block}_post"
            }
        ],
        "result": {
            "item": f"{namespace}:{minecraft_block}_wall",
            "count": 1
        }
    }
    return post_to_wall_recipe


# For generating wall column blocks
def columns_blockstate(arch_ex_block):
    column_blockstate = {
        "variants": {
            "facing=north,cap=false": {
                "model": f"architecture_extensions:block/columns/{arch_ex_block}_column",
                "uvlock": True
            },
            "facing=north,cap=true": {
                "model": f"architecture_extensions:block/columns/{arch_ex_block}_column_cap",
                "uvlock": True
            },
            "facing=east,cap=false": {
                "model": f"architecture_extensions:block/columns/{arch_ex_block}_column",
                "y": 90,
                "uvlock": True
            },
            "facing=east,cap=true": {
                "model": f"architecture_extensions:block/columns/{arch_ex_block}_column_cap",
                "y": 90,
                "uvlock": True
            },
            "facing=south,cap=false": {
                "model": f"architecture_extensions:block/columns/{arch_ex_block}_column",
                "y": 180,
                "uvlock": True
            },
            "facing=south,cap=true": {
                "model": f"architecture_extensions:block/columns/{arch_ex_block}_column_cap",
                "y": 180,
                "uvlock": True
            },
            "facing=west,cap=false": {
                "model": f"architecture_extensions:block/columns/{arch_ex_block}_column",
                "y": 270,
                "uvlock": True
            },
            "facing=west,cap=true": {
                "model": f"architecture_extensions:block/columns/{arch_ex_block}_column_cap",
                "y": 270,
                "uvlock": True
            }
        }
    }
    return column_blockstate


def columns_model_one(minecraft_block, namespace):
    column_model = {
        "parent": "architecture_extensions:block/templates/template_column_block",
        "textures": {
            "texture_up": f"{namespace}:block/{minecraft_block}",
            "texture_down": f"{namespace}:block/{minecraft_block}",
            "texture_side": f"{namespace}:block/{minecraft_block}"
        }
    }
    return column_model


def columns_model_two(minecraft_block, namespace):
    column_cap_model = {
        "parent": "architecture_extensions:block/templates/template_column_cap_block",
        "textures": {
            "texture_up": f"{namespace}:block/{minecraft_block}",
            "texture_down": f"{namespace}:block/{minecraft_block}",
            "texture_side": f"{namespace}:block/{minecraft_block}"
        }
    }
    return column_cap_model


def columns_item(arch_ex_block):
    column_item = {
        "parent": f"architecture_extensions:block/columns/{arch_ex_block}_column_cap"
    }
    return column_item


def columns_recipe(arch_ex_block, recipe_item, namespace):
    column_recipe = {
        "type": "minecraft:stonecutting",
        "ingredient": {
            "item": f"{namespace}:{recipe_item}"
        },
        "result": f"architecture_extensions:{arch_ex_block}_column",
        "count": 4
    }
    return column_recipe


# For generating beam blocks
def beams_blockstate(arch_ex_block):
    beam_blockstate = {
        "variants": {
            "axis=x": {
                "model": f"architecture_extensions:block/beams/{arch_ex_block}_beam",
                "x": 90,
                "y": 90
            },
            "axis=y": {
                "model": f"architecture_extensions:block/beams/{arch_ex_block}_beam"
            },
            "axis=z": {
                "model": f"architecture_extensions:block/beams/{arch_ex_block}_beam",
                "x": 90
            }
        }
    }
    return beam_blockstate


def beams_model(minecraft_block, namespace):
    beam_model = {
        "parent": "architecture_extensions:block/templates/template_beam_block",
        "textures": {
            "texture_side": f"{namespace}:block/{minecraft_block}",
            "texture_up": f"{namespace}:block/{minecraft_block}_top"
        }
    }
    return beam_model


def beams_item(arch_ex_block):
    beam_item = {
        "parent": f"architecture_extensions:block/beams/{arch_ex_block}_beam"
    }
    return beam_item


def beams_recipe(arch_ex_block, recipe_item, namespace):
    beam_recipe = {
        "type": "minecraft:stonecutting",
        "ingredient": {
            "item": f"{namespace}:{recipe_item}"
        },
        "result": f"architecture_extensions:{arch_ex_block}_beam",
        "count": 1
    }
    return beam_recipe


# For generating Post Caps and Post Lanterns
def post_caps_blockstate(arch_ex_block):
    post_cap_blockstate = {
        "variants": {
            "": {"model": f"architecture_extensions:block/post_caps/{arch_ex_block}_post_cap"}
        }
    }
    return post_cap_blockstate


def post_lanterns_blockstate(arch_ex_block):
    post_lantern_blockstate = {
        "variants": {
            "": {"model": f"architecture_extensions:block/post_caps/{arch_ex_block}_post_lantern"}
        }
    }
    return post_lantern_blockstate


def post_caps_model(minecraft_block, namespace):
    post_cap = {
        "parent": "architecture_extensions:block/templates/template_post_cap",
        "textures": {
            "texture": f"{namespace}:block/{minecraft_block}"
        }
    }
    return post_cap


def post_lanterns_model(first_minecraft_block, second_minecraft_block, namespace):
    post_lantern = {
        "parent": "architecture_extensions:block/templates/template_post_lantern",
        "textures": {
            "wood_texture": f"minecraft:block/{first_minecraft_block}",
            "lantern_texture": f"minecraft:block/{second_minecraft_block}"
        }
    }
    return post_lantern


def post_caps_item(arch_ex_block):
    post_cap_item = {
        "parent": f"architecture_extensions:block/post_caps/{arch_ex_block}_post_cap"
    }
    return post_cap_item


def post_lanterns_item(arch_ex_block):
    post_lantern_item = {
        "parent": f"architecture_extensions:block/post_caps/{arch_ex_block}_post_lantern"
    }
    return post_lantern_item


def post_caps_recipe(arch_ex_block, recipe_item, namespace):
    post_cap_recipe = {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [
            {
                "item": f"{namespace}:{recipe_item}"
            }
        ],
        "result": {
            "item": f"architecture_extensions:{arch_ex_block}_post_cap",
            "count": 8
        }
    }
    return post_cap_recipe


def post_lanterns_recipe(arch_ex_block, first_recipe_item, second_recipe_item, namespace):
    post_lantern_recipe = {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [
            {
                "item": f"{namespace}:{first_recipe_item}"
            },
            {
                "item": f"{namespace}:{second_recipe_item}"
            }
        ],
        "result": {
            "item": f"architecture_extensions:{arch_ex_block}_post_lantern",
            "count": 1
        }
    }
    return post_lantern_recipe
