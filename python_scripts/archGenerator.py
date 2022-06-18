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
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "y": 270,
            "uvlock": True
        },
        "facing=east,half=bottom,shape=inner_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner"
        },
        "facing=east,half=bottom,shape=outer_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "y": 270,
            "uvlock": True
        },
        "facing=east,half=bottom,shape=outer_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer"
        },
        "facing=east,half=bottom,shape=straight": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch"
        },
        "facing=east,half=top,shape=inner_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "x": 180,
            "uvlock": True
        },
        "facing=east,half=top,shape=inner_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "x": 180,
            "y": 90,
            "uvlock": True
        },
        "facing=east,half=top,shape=outer_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "x": 180,
            "uvlock": True
        },
        "facing=east,half=top,shape=outer_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "x": 180,
            "y": 90,
            "uvlock": True
        },
        "facing=east,half=top,shape=straight": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch",
            "x": 180,
            "uvlock": True
        },
        "facing=north,half=bottom,shape=inner_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "y": 180,
            "uvlock": True
        },
        "facing=north,half=bottom,shape=inner_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "y": 270,
            "uvlock": True
        },
        "facing=north,half=bottom,shape=outer_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "y": 180,
            "uvlock": True
        },
        "facing=north,half=bottom,shape=outer_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "y": 270,
            "uvlock": True
        },
        "facing=north,half=bottom,shape=straight": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch",
            "y": 270,
            "uvlock": True
        },
        "facing=north,half=top,shape=inner_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "x": 180,
            "y": 270,
            "uvlock": True
        },
        "facing=north,half=top,shape=inner_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "x": 180,
            "uvlock": True
        },
        "facing=north,half=top,shape=outer_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "x": 180,
            "y": 270,
            "uvlock": True
        },
        "facing=north,half=top,shape=outer_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "x": 180,
            "uvlock": True
        },
        "facing=north,half=top,shape=straight": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch",
            "x": 180,
            "y": 270,
            "uvlock": True
        },
        "facing=south,half=bottom,shape=inner_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner"
        },
        "facing=south,half=bottom,shape=inner_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "y": 90,
            "uvlock": True
        },
        "facing=south,half=bottom,shape=outer_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer"
        },
        "facing=south,half=bottom,shape=outer_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "y": 90,
            "uvlock": True
        },
        "facing=south,half=bottom,shape=straight": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch",
            "y": 90,
            "uvlock": True
        },
        "facing=south,half=top,shape=inner_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "x": 180,
            "y": 90,
            "uvlock": True
        },
        "facing=south,half=top,shape=inner_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "x": 180,
            "y": 180,
            "uvlock": True
        },
        "facing=south,half=top,shape=outer_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "x": 180,
            "y": 90,
            "uvlock": True
        },
        "facing=south,half=top,shape=outer_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "x": 180,
            "y": 180,
            "uvlock": True
        },
        "facing=south,half=top,shape=straight": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch",
            "x": 180,
            "y": 90,
            "uvlock": True
        },
        "facing=west,half=bottom,shape=inner_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "y": 90,
            "uvlock": True
        },
        "facing=west,half=bottom,shape=inner_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "y": 180,
            "uvlock": True
        },
        "facing=west,half=bottom,shape=outer_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "y": 90,
            "uvlock": True
        },
        "facing=west,half=bottom,shape=outer_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "y": 180,
            "uvlock": True
        },
        "facing=west,half=bottom,shape=straight": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch",
            "y": 180,
            "uvlock": True
        },
        "facing=west,half=top,shape=inner_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "x": 180,
            "y": 180,
            "uvlock": True
        },
        "facing=west,half=top,shape=inner_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_inner",
            "x": 180,
            "y": 270,
            "uvlock": True
        },
        "facing=west,half=top,shape=outer_left": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "x": 180,
            "y": 180,
            "uvlock": True
        },
        "facing=west,half=top,shape=outer_right": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch_outer",
            "x": 180,
            "y": 270,
            "uvlock": True
        },
        "facing=west,half=top,shape=straight": {
            "model": f"architecture_extensions:block/arches/{arch_ex_block}_arch",
            "x": 180,
            "y": 180,
            "uvlock": True
        }
    }
}

arch_straight = {
    "parent": "architecture_extensions:block/templates/template_arch_block",
    "textures": {
        "texture": f"{namespace}:block/{minecraft_block}"
    }
}

arch_inner = {
    "parent": "architecture_extensions:block/templates/template_arch_inner",
    "textures": {
        "texture": f"{namespace}:block/{minecraft_block}"
    }
}

arch_outer = {
    "parent": "architecture_extensions:block/templates/template_arch_outer",
    "textures": {
        "texture": f"{namespace}:block/{minecraft_block}"
    }
}

item_model = {
    "parent": f"architecture_extensions:block/arches/{arch_ex_block}_arch"
}

recipe_dict = {
    "type": "minecraft:stonecutting",
    "ingredient": {
        "item": f"{namespace}:{recipe_item}"
    },
    "result": f"architecture_extensions:{arch_ex_block}_arch",
    "count": 1
}

files = [blockstate_dict, arch_straight, item_model, recipe_dict]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\block\\arches",
    "assets\\architecture_extensions\\models\\item",
    "data\\architecture_extensions\\recipes"
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_arch.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()

os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\assets\\architecture_extensions\\models\\block\\arches")
with open(f"{arch_ex_block}_arch_inner.json", "w") as file:
    json.dump(arch_inner, file, indent=4)
    file.close()
with open(f"{arch_ex_block}_arch_outer.json", "w") as file:
    json.dump(arch_outer, file, indent=4)
    file.close()
print(f"Files for {arch_ex_block.title()} arch have been generated")
