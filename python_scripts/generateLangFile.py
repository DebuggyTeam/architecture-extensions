import os

from python_scripts.anApiThingy import ROOT_DIR, block_ids, block_names

yes_or_no = input("Have you checked to make sure that \"en_us.json\" is empty before running this script?: ")

if yes_or_no.lower() == "yes":
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\assets\\architecture_extensions\\lang")
    with open("en_us.json", "a") as file:
        file.write("{\n")
        for block_id, block_name in zip(block_ids, block_names):
            file.write(f'    "block.architecture_extensions.{block_id}": "{block_name}",\n')
        file.write("}")
        file.close()
    print("\"en_us.json\" has been generated. Make sure there are no trailing commas or it will not work.")
else:
    print("Go empty the \"en_us.json\" of its contents then run this script again.")
