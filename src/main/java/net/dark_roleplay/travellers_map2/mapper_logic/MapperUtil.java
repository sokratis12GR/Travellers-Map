package net.dark_roleplay.travellers_map2.mapper_logic;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

public class MapperUtil {

    public static BlockState getFirstMappableBlock(World world, BlockPos.Mutable pos, int startHeight, int minHeight){
        pos.setY(startHeight);

        MaterialColor color = null;
        while(pos.getY() >= minHeight && color == null){
            if(world.isAirBlock(pos)) {
                pos.move(0, -1, 0);
                continue;
            }

            BlockState state = world.getBlockState(pos);
            color = state.getMaterialColor(world, pos);
            if(color == null) {
                pos.move(0, -1, 0);
                continue;
            }

            return state;
        }

        return null;
    }
}