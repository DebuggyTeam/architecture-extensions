import json
import os

ROOT_DIR = os.path.realpath(os.path.join(os.path.dirname(__file__), '..'))

arch_ex_block = input("Input Arch-Ex block name: ")
minecraft_block = input("Input Minecraft block name: ")
namespace = input("Input mod namespace or skip if you're using the \"minecraft:\" namespace: ")

if len(namespace) == 0:
    namespace = "minecraft"

blockstate_dict = {
    "variants": {
        "": {"model": f"architecture_extensions:block/full_blocks/{arch_ex_block}_block"}
    }
}

block_model = {
    "parent": "minecraft:block/cube_all",
    "textures": {
        "all": f"{namespace}:block/{minecraft_block}"
    }
}

item_dict = {
    "parent": f"architecture_extensions:block/full_blocks/{arch_ex_block}_block"
}

files = [blockstate_dict, block_model, item_dict]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\block\\full_blocks",
    "assets\\architecture_extensions\\models\\item"
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_block.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()
print(f"Files for {arch_ex_block.title()} Block have been generated")
