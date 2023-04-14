package io.github.debuggyteam.architecture_extensions;

import io.github.debuggyteam.architecture_extensions.api.BlockGroup;
import io.github.debuggyteam.architecture_extensions.api.BlockType;
import net.minecraft.block.Block;

public record RenameThisLater(BlockType type, BlockGroup group, Block block) {

}
