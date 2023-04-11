package io.github.debuggyteam.architecture_extensions.staticdata;

import java.util.Arrays;

public class BlockGroupSchema {
	public String base_block;
	public String[] types_to_generate;
	
	public BlockGroupSchema() {
		base_block = "minecraft:air";
		types_to_generate = new String[0];
	}
	
	@Override
	public String toString() {
		return base_block+"->"+Arrays.toString(types_to_generate);
	}
}
