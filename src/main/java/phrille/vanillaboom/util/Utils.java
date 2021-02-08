package phrille.vanillaboom.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.annotation.Nonnull;

import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

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

    public static void addCompostMaterial(float chance, IItemProvider item)
    {
        try
        {
            Class partypes[] = new Class[2];
            partypes[0] = Float.TYPE;
            partypes[1] = IItemProvider.class;
            Method method = ObfuscationReflectionHelper.findMethod(ComposterBlock.class, "func_220290_a", partypes);
            Object arglist[] = new Object[2];
            arglist[0] = chance;
            arglist[1] = item;
            Object retobj = method.invoke(null, arglist);

        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            throw new RuntimeException("Could not add " + item.asItem().getRegistryName().toString() + " to func_220290_a (registerCompostable)", e);
        }
    }
}
