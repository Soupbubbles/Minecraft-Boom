package phrille.minecraftboom.item;

import net.minecraft.item.Item;
import phrille.minecraftboom.init.CreativeTabs;

public class ItemBase extends Item
{
    public ItemBase(String name)
    {
        super(new Properties().group(CreativeTabs.MINECRAFTBOOM_TAB));
        setRegistryName(name);
    }
}
