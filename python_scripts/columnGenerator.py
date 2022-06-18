import json
import os

from python_scripts.anApiThingy import ROOT_DIR

# block_category = input("Input category name: ")
arch_ex_block = input("Input Arch-Ex block name: ")
minecraft_block = input("Input Minecraft block name: ")
namespace = input("Input mod namespace or skip if you're using the \"{namespace}:\" namespace: ")
recipe_item = input("Input recipe item name: ")

if len(namespace) == 0:
    namespace = "minecraft"

blockstate_dict = {
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

column = {
    "parent": "architecture_extensions:block/templates/template_column_block",
    "textures": {
        "texture_up": f"{namespace}:block/{minecraft_block}",
        "texture_down": f"{namespace}:block/{minecraft_block}",
        "texture_side": f"{namespace}:block/{minecraft_block}"
    }
}

column_cap = {
    "parent": "architecture_extensions:block/templates/template_column_cap_block",
    "textures": {
        "texture_up": f"{namespace}:block/{minecraft_block}",
        "texture_down": f"{namespace}:block/{minecraft_block}",
        "texture_side": f"{namespace}:block/{minecraft_block}"
    }
}

item_dict = {
    "parent": f"architecture_extensions:block/columns/{arch_ex_block}_column_cap"
}

recipe_dict = {
    "type": "minecraft:stonecutting",
    "ingredient": {
        "item": f"{namespace}:{recipe_item}"
    },
    "result": f"architecture_extensions:{arch_ex_block}_column",
    "count": 4
}

files = [blockstate_dict, item_dict, recipe_dict]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\item",
    "data\\architecture_extensions\\recipes"
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_column.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()

os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\assets\\architecture_extensions\\models\\block\\columns")
with open(f"{arch_ex_block}_column.json", "w") as file:
    json.dump(column, file, indent=4)
    file.close()
with open(f"{arch_ex_block}_column_cap.json", "w") as file:
    json.dump(column_cap, file, indent=4)
    file.close()
print(f"Files for {arch_ex_block.title()} Beam have been generated")