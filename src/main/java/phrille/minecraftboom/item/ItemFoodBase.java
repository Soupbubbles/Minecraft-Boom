package phrille.minecraftboom.item;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import phrille.minecraftboom.init.CreativeTabs;

public class ItemFoodBase extends ItemFood
{
    protected int burnTime;

    public ItemFoodBase(String name, int healAmountIn, float saturation, boolean meat)
    {
        this(name, healAmountIn, saturation, meat, -1);
    }
    
    public ItemFoodBase(String name, int healAmountIn, float saturation, boolean meat, int burn)
    {
        super(healAmountIn, saturation, meat, new Properties().group(CreativeTabs.MINECRAFTBOOM_TAB));
        setRegistryName(name);
        burnTime = burn;
    }
    
    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        return burnTime;
    }
}
