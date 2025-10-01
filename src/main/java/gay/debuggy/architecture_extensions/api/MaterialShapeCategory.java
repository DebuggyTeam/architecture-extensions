package gay.debuggy.architecture_extensions.api;

public enum MaterialShapeCategory {
	WOOD(
			BlockShape.FACADE, BlockShape.ROUND_FENCE_POST, BlockShape.ROUND_ARCH, BlockShape.CURVE, BlockShape.OCTAGONAL_COLUMN,
			BlockShape.BEAM, BlockShape.FENCE_POST, BlockShape.JOIST, BlockShape.CROWN_MOLDING, BlockShape.POST_CAP,
			BlockShape.POST_LANTERN, BlockShape.LATTICE, BlockShape.TRANSOM
			),
	STONE(
			BlockShape.ARCH, BlockShape.PILASTER, BlockShape.ROOF, BlockShape.WALL_POST, BlockShape.FACADE,
			BlockShape.ROUND_FENCE_POST, BlockShape.ROUND_ARCH, BlockShape.CURVE, BlockShape.OCTAGONAL_COLUMN
			),
	AQUATIC_STONE(
			BlockShape.ARCH, BlockShape.PILASTER, BlockShape.WALL_POST, BlockShape.FACADE, BlockShape.ROUND_FENCE_POST,
			BlockShape.ROUND_ARCH, BlockShape.CURVE, BlockShape.OCTAGONAL_COLUMN
			),
	PROCESSED_STONE(
			BlockShape.ARCH, BlockShape.PILASTER, BlockShape.ROOF, BlockShape.WALL_POST, BlockShape.FACADE,
			BlockShape.ROUND_FENCE_POST, BlockShape.ROUND_ARCH, BlockShape.CURVE, BlockShape.OCTAGONAL_COLUMN
			),
	BRICK(
			BlockShape.ARCH, BlockShape.PILASTER, BlockShape.ROOF, BlockShape.WALL_POST, BlockShape.FACADE,
			BlockShape.ROUND_FENCE_POST, BlockShape.ROUND_ARCH, BlockShape.CURVE, BlockShape.OCTAGONAL_COLUMN
			),
	TILE(
			BlockShape.ARCH, BlockShape.PILASTER, BlockShape.ROOF, BlockShape.WALL_POST, BlockShape.FACADE,
			BlockShape.ROUND_FENCE_POST, BlockShape.ROUND_ARCH, BlockShape.CURVE, BlockShape.OCTAGONAL_COLUMN
			),
	CRYSTAL(
			BlockShape.ARCH, BlockShape.PILASTER, BlockShape.ROOF, BlockShape.WALL_POST, BlockShape.FACADE,
			BlockShape.ROUND_FENCE_POST, BlockShape.ROUND_ARCH, BlockShape.CURVE, BlockShape.OCTAGONAL_COLUMN
			),
	TERRACOTTA(BlockShape.FACADE),
	CONCRETE(BlockShape.FACADE),
	METAL(
			BlockShape.ROD, BlockShape.FACADE, BlockShape.I_BEAM, BlockShape.SQUARE_TUBE
			)
	;
	
	private final BlockShape[] blockTypes;
	
	MaterialShapeCategory(BlockShape...blockTypes) {
		this.blockTypes = blockTypes;
	}
	
	public BlockShape[] blockTypes() {
		return this.blockTypes;
	}
}
