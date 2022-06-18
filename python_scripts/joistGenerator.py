import json
import os

ROOT_DIR = os.path.realpath(os.path.join(os.path.dirname(__file__), '..'))

# block_category = input("Input category name: ")
arch_ex_block = input("Input Arch-Ex block name: ")
minecraft_block = input("Input Minecraft block name: ")
namespace = input("Input mod namespace or skip if you're using the \"minecraft:\" namespace: ")
recipe_item = input("Input recipe item name: ")

if len(namespace) == 0:
    namespace = "minecraft"

blockstate_dict = {
    "variants": {
        "facing=north": {
            "model": f"architecture_extensions:block/joists/{arch_ex_block}_joist"
        },
        "facing=east": {
            "model": f"architecture_extensions:block/joists/{arch_ex_block}_joist",
            "y": 90
        },
        "facing=south": {
            "model": f"architecture_extensions:block/joists/{arch_ex_block}_joist",
            "y": 180
        },
        "facing=west": {
            "model": f"architecture_extensions:block/joists/{arch_ex_block}_joist",
            "y": 270
        }
    }
}

joist_model = {
    "parent": "architecture_extensions:block/templates/template_joist_block",
    "textures": {
        "texture": f"{namespace}:block/{minecraft_block}"
    }
}

item_dict = {
    "parent": f"architecture_extensions:block/joists/{arch_ex_block}_joist"
}

recipe_dict = {
    "type": "minecraft:stonecutting",
    "ingredient": {
        "item": f"{namespace}:{recipe_item}"
    },
    "result": f"architecture_extensions:{arch_ex_block}_joist",
    "count": 3
}

files = [blockstate_dict, joist_model, item_dict, recipe_dict]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\block\\joists",
    "assets\\architecture_extensions\\models\\item",
    "data\\architecture_extensions\\recipes"
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_joist.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()
print(f"Files for {arch_ex_block.title()} joist have been generated")
