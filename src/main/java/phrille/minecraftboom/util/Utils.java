package phrille.minecraftboom.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import phrille.minecraftboom.MinecraftBoom;

public class Utils
{
    public static final String getNameFromRegistry(Block block) 
    {
        return block.getRegistryName().toString().replace(MinecraftBoom.MOD_ID + ":", "").replace("minecraft:", "");
    }
    
    public static final String getNameFromRegistry(Item item) 
    {
        return item.getRegistryName().toString().replace(MinecraftBoom.MOD_ID + ":", "");
    }
}
