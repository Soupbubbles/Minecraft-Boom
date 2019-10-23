package phrille.minecraftboom.block.base;

import net.minecraft.block.BlockStairs;
import phrille.minecraftboom.util.IJsonGenerator;
import phrille.minecraftboom.util.IStairSlab;
import phrille.minecraftboom.util.Utils;

public class BlockStairBase extends BlockStairs implements IJsonGenerator
{
    private String stairName;
    private IStairSlab parent;

    public BlockStairBase(IStairSlab block)
    {
        super(block.getBlock().getDefaultState(), block.getProperties());
        stairName = Utils.getNameFromRegistry(block.getBlock()).replace("bricks", "brick") + "_stairs";
        setRegistryName(stairName);
        parent = block;
    }

    public String getStairName()
    {
        return stairName;
    }

    public IStairSlab getParent()
    {
        return parent;
    }
}
