import json
import os

from python_scripts.anApiThingy import ROOT_DIR, post_caps_blockstate, post_caps_item, post_caps_model, post_caps_recipe

# block_category = input("Input category name: ")
arch_ex_block = input("Input Arch-Ex block name: ")
minecraft_block = input("Input Minecraft block name: ")
namespace = input("Input mod namespace or skip if you're using the \"minecraft:\" namespace: ")
recipe_item = input("Input recipe item name: ")

if len(namespace) == 0:
    namespace = "minecraft"

files = [post_caps_blockstate(arch_ex_block),
         post_caps_model(minecraft_block, namespace),
         post_caps_item(arch_ex_block),
         post_caps_recipe(arch_ex_block, recipe_item, namespace)]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\block\\post_caps",
    "assets\\architecture_extensions\\models\\item",
    "data\\architecture_extensions\\recipes"
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_post_cap.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()
print(f"Files for {arch_ex_block.title()} Rod have been generated")