package phrille.minecraftboom.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import phrille.minecraftboom.block.base.BlockBase;
import phrille.minecraftboom.lib.BlockValues;
import phrille.minecraftboom.lib.Names;

public class BlockMagmaBricks extends BlockBase
{
    public BlockMagmaBricks()
    {
        super(Names.BLOCK_MAGMA_BRICKS, Material.ROCK, MaterialColor.NETHERRACK, BlockValues.STONE_HARDNESS, BlockValues.STONE_RESISTANCE, 3);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public int getPackedLightmapCoords(IBlockState state, IWorldReader source, BlockPos pos)
    {
        return Blocks.MAGMA_BLOCK.getDefaultState().getPackedLightmapCoords(source, pos);
    }
}
