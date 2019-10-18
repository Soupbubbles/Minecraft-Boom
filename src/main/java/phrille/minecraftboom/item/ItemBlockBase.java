package phrille.minecraftboom.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import phrille.minecraftboom.util.IFuelBlock;

public class ItemBlockBase extends ItemBlock
{
    protected int burnTime;
    
    public ItemBlockBase(Block block, Properties properties)
    {
        super(block, properties);
        
        if (block instanceof IFuelBlock) 
        {
            burnTime = ((IFuelBlock) block).getBurnTime();
        }
    }
    
    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        return burnTime;
    }
}
