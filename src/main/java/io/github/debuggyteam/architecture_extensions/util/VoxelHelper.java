package io.github.debuggyteam.architecture_extensions.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.shape.VoxelShape;

public class VoxelHelper {
	public static boolean testVoxel(VoxelShape shape, int x, int y, int z) {
		
		List<Boolean> hits = new ArrayList<>();
		shape.forEachBox((x1, y1, z1, x2, y2, z2) -> {
			int x1i = (int) (x1 * 16);
			int y1i = (int) (y1 * 16);
			int z1i = (int) (z1 * 16);
			int x2i = (int) (x2 * 16);
			int y2i = (int) (y2 * 16);
			int z2i = (int) (z2 * 16);
			
			if (x >= x1i && y >= y1i && z >= z1i && x < x2i && y < y2i && z < z2i) {
				hits.add(Boolean.valueOf(true));
			}
		});
		
		return !hits.isEmpty();
	}
}
