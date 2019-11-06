package phrille.minecraftboom.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MagmaBrickSlabBlock extends SlabBlock
{
    public MagmaBrickSlabBlock(Properties builder)
    {
        super(builder);
    }

    @OnlyIn(Dist.CLIENT)
    public int getPackedLightmapCoords(BlockState state, IWorldReader source, BlockPos pos)
    {
        return Blocks.MAGMA_BLOCK.getPackedLightmapCoords(state, source, pos);
    }
}
