package phrille.minecraftboom.block;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import phrille.minecraftboom.block.base.BlockBase;
import phrille.minecraftboom.lib.BlockValues;

public class BlockSoulGlass extends BlockBase
{
    public BlockSoulGlass(String name)
    {
        super(name, Properties.create(Material.GLASS).sound(SoundType.GLASS).hardnessAndResistance(BlockValues.GLASS_HARDNESS, BlockValues.GLASS_RESISTANCE));
    }

    @Override
    public int quantityDropped(IBlockState state, Random random)
    {
        return 0;
    }

    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    protected boolean canSilkHarvest()
    {
        return true;
    }

    @Override
    public boolean propagatesSkylightDown(IBlockState state, IBlockReader reader, BlockPos pos)
    {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean isSideInvisible(IBlockState state, IBlockState adjacentBlockState, EnumFacing side)
    {
        return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
    }
}
