package phrille.vanillaboom.util;

import java.lang.reflect.Method;

import javax.annotation.Nonnull;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import phrille.vanillaboom.VanillaBoom;

public class Utils
{
    @Nonnull
    public static <T> T _null()
    {
        return null;
    }

    public static final String getStairName(String name)
    {
        return name.replace("bricks", "brick") + "_stairs";
    }

    public static final String getSlabName(String name)
    {
        return name.replace("bricks", "brick") + "_slab";
    }
    
    public static final String getWallName(String name)
    {
        return name.replace("bricks", "brick") + "_wall";
    }

    public static void spawnEntityItem(World world, BlockPos pos, Item item)
    {
        spawnEntityItem(world, pos, new ItemStack(item));
    }

    public static void spawnEntityItem(World world, BlockPos pos, ItemStack stack)
    {
        if (!world.isRemote)
        {
            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
        }
    }

    /**
     * Method for adding items to be used in the Minecraft Composter
     * Uses reflection to get access to registerCompostable
     */
    public static void addCompostMaterial(float chance, IItemProvider item)
    {
        try 
        {
            Class clazz = Class.forName("net.minecraft.block.ComposterBlock");
            Class partypes[] = new Class[2];
            partypes[0] = Float.TYPE;
            partypes[1] = IItemProvider.class;
            Method method = clazz.getDeclaredMethod("registerCompostable", partypes);
            method.setAccessible(true);
            Object arglist[] = new Object[2];
            arglist[0] = chance;
            arglist[1] = item;
            Object retobj = method.invoke(null, arglist);
        }
        catch (Throwable e)
        {
            VanillaBoom.LOGGER.error("Could not add " + item.asItem().getRegistryName().toString() + " to registerCompostable");
            e.printStackTrace();
        }
    }
}
