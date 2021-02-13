package phrille.vanillaboom.util;

import java.util.Map;
import java.util.Objects;

import javax.annotation.Nonnull;

import com.google.common.collect.Maps;

import net.minecraft.block.CakeBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
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

    public static boolean isCake(Item item)
    {
        return item instanceof BlockItem && ((BlockItem) item).getBlock() instanceof CakeBlock;
    }

    public static boolean isFood(Item item)
    {
        return item.isFood() || isCake(item);
    }

    public static final Map<EntityType<?>, SpawnEggItem> EGG_MAP = Maps.newHashMap();
    
    
    public static void addSpawnEggs()
    {
        try
        {
            Map<EntityType<?>, SpawnEggItem> map = (Map<EntityType<?>, SpawnEggItem>) ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
            map.keySet().removeIf(Objects::isNull);
            map.putAll(EGG_MAP);
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException("Failed to spawn eggs to map", e);
        }
    }
}
