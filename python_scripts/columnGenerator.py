import json
import os

from python_scripts.anApiThingy import ROOT_DIR
from python_scripts.anApiThingy import columns_blockstate, columns_item, columns_recipe, columns_model_one, \
    columns_model_two

# block_category = input("Input category name: ")
arch_ex_block = input("Input Arch-Ex block name: ")
minecraft_block = input("Input Minecraft block name: ")
namespace = input("Input mod namespace or skip if you're using the \"minecraft:\" namespace: ")
recipe_item = input("Input recipe item name: ")

if len(namespace) == 0:
    namespace = "minecraft"

files = [
    columns_blockstate(arch_ex_block),
    columns_item(arch_ex_block),
    columns_recipe(arch_ex_block, recipe_item, namespace)
]

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
    json.dump(columns_model_one(minecraft_block, namespace), file, indent=4)
    file.close()
with open(f"{arch_ex_block}_column_cap.json", "w") as file:
    json.dump(columns_model_two(minecraft_block, namespace), file, indent=4)
    file.close()
print(f"Files for {arch_ex_block.title()} Column have been generated")
