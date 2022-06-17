import json
import os

ROOT_DIR = os.path.realpath(os.path.join(os.path.dirname(__file__), '..'))

# block_category = input("Input category name: ")
arch_ex_block = input("Input Arch-Ex block name: ")
minecraft_block = input("Input Minecraft block name: ")
recipe_item = input("Input recipe item name: ")
item_dict = {
    "parent": f"architecture_extensions:block/beams/{arch_ex_block}_beam"
}

blockstate_dict = {
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

model_dict = {
    "parent": "architecture_extensions:block/templates/template_beam_block",
    "textures": {
        "texture_side": f"minecraft:block/{minecraft_block}",
        "texture_up": f"minecraft:block/{minecraft_block}_top"
    }
}

recipe_dict = {
    "type": "minecraft:stonecutting",
    "ingredient": {
        "item": f"minecraft:{recipe_item}"
    },
    "result": f"architecture_extensions:{arch_ex_block}_beam",
    "count": 1
}

files = [blockstate_dict, model_dict, item_dict, recipe_dict]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\block\\beams",
    "assets\\architecture_extensions\\models\\item",
    "data\\architecture_extensions\\recipes"
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_beam.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()
print(f"Files for {arch_ex_block.title()} Beam have been generated")
