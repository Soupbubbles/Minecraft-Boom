package phrille.minecraftboom.util;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import phrille.minecraftboom.block.base.BlockStairBase;

public interface IStairSlab
{
    public Block getParentBlock();
    
    public Block addStairSlab();

    public boolean hasStairSlab();

    public BlockStairBase setStair(BlockStairBase stair);

    public BlockStairBase getStair();

    public Properties getProperties();
    
    public String getName();
}
