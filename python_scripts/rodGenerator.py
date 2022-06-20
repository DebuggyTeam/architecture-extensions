import json
import os

from python_scripts.anApiThingy import ROOT_DIR, rods_blockstate, rods_item, rods_model

# block_category = input("Input category name: ")
arch_ex_block = input("Input Arch-Ex block name: ")
minecraft_block = input("Input Minecraft block name: ")
namespace = input("Input mod namespace or skip if you're using the \"minecraft:\" namespace: ")

if len(namespace) == 0:
    namespace = "minecraft"

files = [rods_blockstate(arch_ex_block), rods_model(minecraft_block, namespace), rods_item(arch_ex_block)]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\block\\rods",
    "assets\\architecture_extensions\\models\\item",
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_rod.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()
print(f"Files for {arch_ex_block.title()} Rod have been generated")
