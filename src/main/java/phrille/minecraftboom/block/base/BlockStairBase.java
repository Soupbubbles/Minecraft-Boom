package phrille.minecraftboom.block.base;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import phrille.minecraftboom.util.IJsonGenerator;
import phrille.minecraftboom.util.IStairSlab;
import phrille.minecraftboom.util.Utils;

public class BlockStairBase extends BlockStairs implements IJsonGenerator
{
    private String stairName;
    private Block parent;
    private boolean isVanilla;

    public BlockStairBase(IStairSlab block)
    {
        this(block.getBlock(), false);
    }

    public BlockStairBase(Block block, boolean vanilla)
    {
        super(block.getDefaultState(), Properties.from(block));
        stairName = (Utils.getNameFromRegistry(block.getBlock()).replace("bricks", "brick") + "_stairs");
        setRegistryName(stairName);
        parent = block;
        isVanilla = vanilla;
    }

    @Override
    public int quantityDropped(IBlockState state, Random random)
    {
        return parent.quantityDropped(state, random);
    }
    
    @Override
    protected boolean canSilkHarvest()
    {
        return getDefaultState().getMaterial() == Material.GLASS ? true : super.canSilkHarvest();
    }
    
    @Override
    public boolean propagatesSkylightDown(IBlockState state, IBlockReader reader, BlockPos pos)
    {
        return parent.propagatesSkylightDown(state, reader, pos);
    }
    
    public String getStairName()
    {
        return stairName;
    }

    public Block getParent()
    {
        return parent;
    }

    public boolean isVanilla()
    {
        return isVanilla;
    }
}
