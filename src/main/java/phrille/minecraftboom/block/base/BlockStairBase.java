package phrille.minecraftboom.block.base;

import net.minecraft.block.BlockStairs;
import phrille.minecraftboom.util.IJsonGenerator;
import phrille.minecraftboom.util.IStairSlab;

public class BlockStairBase extends BlockStairs implements IJsonGenerator
{
    private String stairName;
    private IStairSlab parent;

    public BlockStairBase(IStairSlab block)
    {
        super(block.getParentBlock().getDefaultState(), block.getProperties());
        stairName = block.getName().replace("bricks", "brick") + "_stairs";
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
