package phrille.minecraftboom.block;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockMagmaBrickSlab extends BlockSlab
{
    public BlockMagmaBrickSlab(Properties builder)
    {
        super(builder);
    }

    @OnlyIn(Dist.CLIENT)
    public int getPackedLightmapCoords(IBlockState state, IWorldReader source, BlockPos pos)
    {
        return Blocks.MAGMA_BLOCK.getPackedLightmapCoords(state, source, pos);
    }
}
