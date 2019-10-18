package phrille.minecraftboom.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import phrille.minecraftboom.init.CreativeTabs;

public class ItemBase extends Item
{
    protected int burnTime;

    public ItemBase(String name)
    {
        this(name, -1);
    }

    public ItemBase(String name, int burn)
    {
        super(new Properties().group(CreativeTabs.MINECRAFTBOOM_TAB));
        setRegistryName(name);
        burnTime = burn;
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        return burnTime;
    }
}
