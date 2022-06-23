import json
import os

from python_scripts.anApiThingy import ROOT_DIR, post_lanterns_blockstate, post_lanterns_item, post_lanterns_model, \
    post_lanterns_recipe

# block_category = input("Input category name: ")
arch_ex_block = input("Input Arch-Ex block name: ")
first_minecraft_block = input("Input Minecraft block name: ")
second_minecraft_block = input("Input Minecraft block name: ")
namespace = input("Input mod namespace or skip if you're using the \"minecraft:\" namespace: ")
first_recipe_item = input("Input recipe item name: ")
second_recipe_item = input("Input recipe item name: ")

if len(namespace) == 0:
    namespace = "minecraft"

files = [post_lanterns_blockstate(arch_ex_block),
         post_lanterns_model(first_minecraft_block, second_minecraft_block, namespace),
         post_lanterns_item(arch_ex_block),
         post_lanterns_recipe(arch_ex_block, first_recipe_item, second_recipe_item, namespace)]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\block\\post_caps",
    "assets\\architecture_extensions\\models\\item",
    "data\\architecture_extensions\\recipes"
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_post_lantern.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()
print(f"Files for {arch_ex_block.title()} Rod have been generated")
