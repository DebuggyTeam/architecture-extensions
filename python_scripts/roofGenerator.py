import json
import os

from python_scripts.anApiThingy import ROOT_DIR

# block_category = input("Input category name: ")
arch_ex_block = input("Input Arch-Ex block name: ")
minecraft_block = input("Input Minecraft block name: ")
namespace = input("Input mod namespace or skip if you're using the \"minecraft:\" namespace: ")
recipe_item = input("Input recipe item name: ")

if len(namespace) == 0:
    namespace = "minecraft"

blockstate_dict = {
    "variants": {
        "facing=east,half=bottom,shape=inner_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "y": 270,
            "uvlock": True
        },
        "facing=east,half=bottom,shape=inner_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner"
        },
        "facing=east,half=bottom,shape=outer_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "y": 270,
            "uvlock": True
        },
        "facing=east,half=bottom,shape=outer_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer"
        },
        "facing=east,half=bottom,shape=straight": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof"
        },
        "facing=east,half=top,shape=inner_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "x": 180,
            "uvlock": True
        },
        "facing=east,half=top,shape=inner_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "x": 180,
            "y": 90,
            "uvlock": True
        },
        "facing=east,half=top,shape=outer_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "x": 180,
            "uvlock": True
        },
        "facing=east,half=top,shape=outer_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "x": 180,
            "y": 90,
            "uvlock": True
        },
        "facing=east,half=top,shape=straight": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof",
            "x": 180,
            "uvlock": True
        },
        "facing=north,half=bottom,shape=inner_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "y": 180,
            "uvlock": True
        },
        "facing=north,half=bottom,shape=inner_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "y": 270,
            "uvlock": True
        },
        "facing=north,half=bottom,shape=outer_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "y": 180,
            "uvlock": True
        },
        "facing=north,half=bottom,shape=outer_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "y": 270,
            "uvlock": True
        },
        "facing=north,half=bottom,shape=straight": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof",
            "y": 270,
            "uvlock": True
        },
        "facing=north,half=top,shape=inner_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "x": 180,
            "y": 270,
            "uvlock": True
        },
        "facing=north,half=top,shape=inner_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "x": 180,
            "uvlock": True
        },
        "facing=north,half=top,shape=outer_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "x": 180,
            "y": 270,
            "uvlock": True
        },
        "facing=north,half=top,shape=outer_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "x": 180,
            "uvlock": True
        },
        "facing=north,half=top,shape=straight": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof",
            "x": 180,
            "y": 270,
            "uvlock": True
        },
        "facing=south,half=bottom,shape=inner_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner"
        },
        "facing=south,half=bottom,shape=inner_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "y": 90,
            "uvlock": True
        },
        "facing=south,half=bottom,shape=outer_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer"
        },
        "facing=south,half=bottom,shape=outer_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "y": 90,
            "uvlock": True
        },
        "facing=south,half=bottom,shape=straight": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof",
            "y": 90,
            "uvlock": True
        },
        "facing=south,half=top,shape=inner_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "x": 180,
            "y": 90,
            "uvlock": True
        },
        "facing=south,half=top,shape=inner_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "x": 180,
            "y": 180,
            "uvlock": True
        },
        "facing=south,half=top,shape=outer_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "x": 180,
            "y": 90,
            "uvlock": True
        },
        "facing=south,half=top,shape=outer_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "x": 180,
            "y": 180,
            "uvlock": True
        },
        "facing=south,half=top,shape=straight": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof",
            "x": 180,
            "y": 90,
            "uvlock": True
        },
        "facing=west,half=bottom,shape=inner_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "y": 90,
            "uvlock": True
        },
        "facing=west,half=bottom,shape=inner_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "y": 180,
            "uvlock": True
        },
        "facing=west,half=bottom,shape=outer_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "y": 90,
            "uvlock": True
        },
        "facing=west,half=bottom,shape=outer_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "y": 180,
            "uvlock": True
        },
        "facing=west,half=bottom,shape=straight": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof",
            "y": 180,
            "uvlock": True
        },
        "facing=west,half=top,shape=inner_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "x": 180,
            "y": 180,
            "uvlock": True
        },
        "facing=west,half=top,shape=inner_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_inner",
            "x": 180,
            "y": 270,
            "uvlock": True
        },
        "facing=west,half=top,shape=outer_left": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "x": 180,
            "y": 180,
            "uvlock": True
        },
        "facing=west,half=top,shape=outer_right": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof_outer",
            "x": 180,
            "y": 270,
            "uvlock": True
        },
        "facing=west,half=top,shape=straight": {
            "model": f"architecture_extensions:block/roofs/{arch_ex_block}_roof",
            "x": 180,
            "y": 180,
            "uvlock": True
        }
    }
}

roof_straight = {
    "parent": "architecture_extensions:block/templates/template_roof_straight",
    "textures": {
        "tiles": f"{namespace}:block/{minecraft_block}",
        "sides": f"{namespace}:block/{minecraft_block}"
    }
}

roof_inner = {
    "parent": "architecture_extensions:block/templates/template_roof_inner",
    "textures": {
        "tiles": f"{namespace}:block/{minecraft_block}",
        "sides": f"{namespace}:block/{minecraft_block}"
    }
}

roof_outer = {
    "parent": "architecture_extensions:block/templates/template_roof_outer",
    "textures": {
        "tiles": f"{namespace}:block/{minecraft_block}",
        "sides": f"{namespace}:block/{minecraft_block}"
    }
}

item_model = {
    "parent": f"architecture_extensions:block/roofs/{arch_ex_block}_roof"
}

recipe_dict = {
    "type": "minecraft:stonecutting",
    "ingredient": {
        "item": f"{namespace}:{recipe_item}"
    },
    "result": f"architecture_extensions:{arch_ex_block}_roof",
    "count": 1
}

files = [blockstate_dict, roof_straight, item_model, recipe_dict]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\block\\roofs",
    "assets\\architecture_extensions\\models\\item",
    "data\\architecture_extensions\\recipes"
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_roof.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()

os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\assets\\architecture_extensions\\models\\block\\roofs")
with open(f"{arch_ex_block}_roof_inner.json", "w") as file:
    json.dump(roof_inner, file, indent=4)
    file.close()
with open(f"{arch_ex_block}_roof_outer.json", "w") as file:
    json.dump(roof_outer, file, indent=4)
    file.close()
print(f"Files for {arch_ex_block.title()} Roof have been generated")
