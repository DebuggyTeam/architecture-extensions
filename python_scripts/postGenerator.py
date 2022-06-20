import json
import os

from python_scripts.anApiThingy import ROOT_DIR
from python_scripts.anApiThingy import posts_blockstate, posts_model, posts_item, posts_recipe_one, posts_recipe_two

# block_category = input("Input category name: ")
arch_ex_block = input("Input Arch-Ex block name: ")
minecraft_block = input("Input Minecraft block name: ")
namespace = input("Input mod namespace or skip if you're using the \"minecraft:\" namespace: ")

if len(namespace) == 0:
    namespace = "minecraft"

files = [posts_blockstate(arch_ex_block), posts_model(minecraft_block, namespace), posts_item(arch_ex_block)]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\block\\posts",
    "assets\\architecture_extensions\\models\\item",
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_post.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()

os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\data\\architecture_extensions\\recipes")
with open(f"{arch_ex_block}_wall_to_post.json", "w") as file:
    json.dump(posts_recipe_one(arch_ex_block, minecraft_block, namespace), file, indent=4)
    file.close()
with open(f"{arch_ex_block}_post_to_wall.json", "w") as file:
    json.dump(posts_recipe_two(arch_ex_block, minecraft_block, namespace), file, indent=4)
    file.close()
print(f"Files for {arch_ex_block.title()} Post have been generated")
