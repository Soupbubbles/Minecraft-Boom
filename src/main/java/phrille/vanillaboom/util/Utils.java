package phrille.vanillaboom.util;

import java.util.Map;
import java.util.Objects;

import javax.annotation.Nonnull;

import com.google.common.collect.Maps;

import net.minecraft.block.CakeBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
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

    public static boolean isCake(Item item)
    {
        return item instanceof BlockItem && ((BlockItem) item).getBlock() instanceof CakeBlock;
    }

    public static boolean isFood(Item item)
    {
        return item.isFood() || isCake(item);
    }

    public static void spawnParticles(BasicParticleType particle, World world, BlockPos pos, int amount, boolean condition, float height)
    {
        if (amount == 0)
        {
            amount = 15;
        }

        if (!condition)
        {
            for (int i = 0; i < amount; ++i)
            {
                double d0 = world.rand.nextGaussian() * 0.02D;
                double d1 = world.rand.nextGaussian() * 0.02D;
                double d2 = world.rand.nextGaussian() * 0.02D;

                world.addParticle(particle, (double) ((float) pos.getX() + world.rand.nextFloat()), (double) pos.getY() + (double) world.rand.nextFloat() * height, (double) ((float) pos.getZ() + world.rand.nextFloat()), d0, d1, d2);
            }
        }
    }

    public static final Map<EntityType<?>, SpawnEggItem> EGG_MAP = Maps.newHashMap();

    public static void addSpawnEggs()
    {
        try
        {
            Map<EntityType<?>, SpawnEggItem> map = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
            map.keySet().removeIf(Objects::isNull);
            map.putAll(EGG_MAP);

            //They are added to the list after net.minecraft.client.renderer.color.ItemColors.init() is called.
            for (SpawnEggItem spawneggitem : SpawnEggItem.getEggs())
            {
                VanillaBoom.LOGGER.debug(spawneggitem.toString());
            }
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException("Failed to spawn eggs to map", e);
        }
    }
}
