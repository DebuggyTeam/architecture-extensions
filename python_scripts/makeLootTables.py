import json
import os

from python_scripts.anApiThingy import ROOT_DIR, block_ids

os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\data\\architecture_extensions\\loot_tables\\blocks")

for i in block_ids:
    loot_table = {
        "type": "minecraft:block",
        "pools": [
            {
                "rolls": 1,
                "entries": [
                    {
                        "type": "minecraft:item",
                        "name": f"architecture_extensions:{i}"
                    }
                ],
                "conditions": [
                    {
                        "condition": "minecraft:survives_explosion"
                    }
                ]
            }
        ]
    }

    with open(f"{i}.json", "w") as file:
        json.dump(loot_table, file, indent=4)
        file.close()