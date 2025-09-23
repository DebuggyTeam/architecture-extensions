package gay.debuggy.architecture_extensions.api;

public enum MetaBlockType {
	WOOD(
			BlockType.FACADE, BlockType.ROUND_FENCE_POST, BlockType.ROUND_ARCH, BlockType.CURVE, BlockType.OCTAGONAL_COLUMN,
			BlockType.BEAM, BlockType.FENCE_POST, BlockType.JOIST, BlockType.CROWN_MOLDING, BlockType.POST_CAP,
			BlockType.POST_LANTERN, BlockType.LATTICE, BlockType.TRANSOM
			),
	STONE(
			BlockType.ARCH, BlockType.PILASTER, BlockType.ROOF, BlockType.WALL_POST, BlockType.FACADE,
			BlockType.ROUND_FENCE_POST, BlockType.ROUND_ARCH, BlockType.CURVE, BlockType.OCTAGONAL_COLUMN
			),
	AQUATIC_STONE(
			BlockType.ARCH, BlockType.PILASTER, BlockType.WALL_POST, BlockType.FACADE, BlockType.ROUND_FENCE_POST,
			BlockType.ROUND_ARCH, BlockType.CURVE, BlockType.OCTAGONAL_COLUMN
			),
	PROCESSED_STONE(
			BlockType.ARCH, BlockType.PILASTER, BlockType.ROOF, BlockType.WALL_POST, BlockType.FACADE,
			BlockType.ROUND_FENCE_POST, BlockType.ROUND_ARCH, BlockType.CURVE, BlockType.OCTAGONAL_COLUMN
			),
	BRICK(
			BlockType.ARCH, BlockType.PILASTER, BlockType.ROOF, BlockType.WALL_POST, BlockType.FACADE,
			BlockType.ROUND_FENCE_POST, BlockType.ROUND_ARCH, BlockType.CURVE, BlockType.OCTAGONAL_COLUMN
			),
	TILE(
			BlockType.ARCH, BlockType.PILASTER, BlockType.ROOF, BlockType.WALL_POST, BlockType.FACADE,
			BlockType.ROUND_FENCE_POST, BlockType.ROUND_ARCH, BlockType.CURVE, BlockType.OCTAGONAL_COLUMN
			),
	CRYSTAL(
			BlockType.ARCH, BlockType.PILASTER, BlockType.ROOF, BlockType.WALL_POST, BlockType.FACADE,
			BlockType.ROUND_FENCE_POST, BlockType.ROUND_ARCH, BlockType.CURVE, BlockType.OCTAGONAL_COLUMN
			),
	TERRACOTTA(BlockType.FACADE),
	CONCRETE(BlockType.FACADE),
	METAL(
			BlockType.ROD, BlockType.FACADE, BlockType.I_BEAM, BlockType.TUBE_METAL
			)
	;
	
	private final BlockType[] blockTypes;
	
	MetaBlockType(BlockType...blockTypes) {
		this.blockTypes = blockTypes;
	}
	
	public BlockType[] blockTypes() {
		return this.blockTypes;
	}
}
