package phrille.minecraftboom.block.base;

import net.minecraft.block.BlockSlab;
import phrille.minecraftboom.util.IJsonGenerator;
import phrille.minecraftboom.util.IStairSlab;
import phrille.minecraftboom.util.Utils;

public class BlockSlabBase extends BlockSlab implements IJsonGenerator
{
    private String slabName;
    private IStairSlab parent;
    
    public BlockSlabBase(IStairSlab block)
    {
        super(block.getProperties());
        slabName = Utils.getNameFromRegistry(block.getBlock()).replace("bricks", "brick") + "_slab";
        setRegistryName(slabName);
        parent = block;
    }
    
    public String getSlabName()
    {
        return slabName;
    }

    public IStairSlab getParent()
    {
        return parent;
    }
}
