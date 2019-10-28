package phrille.minecraftboom.util;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
    
    public static void spawnEntityItem(World world, BlockPos pos, Item item)
    {
        spawnEntityItem(world, pos, new ItemStack(item));
    }

    public static void spawnEntityItem(World world, BlockPos pos, ItemStack stack)
    {
        if (!world.isRemote)
        {
            world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack));
        }
    }
}
