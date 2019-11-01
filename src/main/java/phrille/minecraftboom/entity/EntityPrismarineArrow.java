package phrille.minecraftboom.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Particles;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import phrille.minecraftboom.init.ModEntities;
import phrille.minecraftboom.init.ModItems;

public class EntityPrismarineArrow extends EntityTippedArrow
{
    public EntityPrismarineArrow(World world)
    {
        super(world);
    }

    public EntityPrismarineArrow(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    public EntityPrismarineArrow(World world, EntityLivingBase shooter)
    {
        super(world, shooter);
    }

    @Override
    public EntityType<?> getType()
    {
        return ModEntities.PRISMARINE_ARROW;
    }

    @Override
    protected void onHit(RayTraceResult raytrace)
    {
        if (raytrace.entity != null && raytrace.entity.isImmuneToFire())
        {
            setDamage(getDamage() * 1.1F);
        }

        super.onHit(raytrace);
    }

    @Override
    public void tick()
    {
        if (!inGround && inWater)
        {
            for (int i = 0; i < 4; ++i)
            {
                world.spawnParticle(Particles.BUBBLE, posX - motionX * 0.25D, posY - motionY * 0.25D, posZ - motionZ * 0.25D, motionX, motionY, motionZ);
            }
        }

        super.tick();
    }

    @Override
    public boolean isInWater()
    {
        return false;
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(ModItems.PRISMARINE_ARROW);
    }
}
