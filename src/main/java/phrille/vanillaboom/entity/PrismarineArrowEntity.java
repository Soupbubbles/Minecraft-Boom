package phrille.vanillaboom.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import phrille.vanillaboom.item.ModItems;

public class PrismarineArrowEntity extends ArrowEntity
{
    public PrismarineArrowEntity(EntityType<? extends PrismarineArrowEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public PrismarineArrowEntity(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    public PrismarineArrowEntity(World world, LivingEntity shooter)
    {
        super(world, shooter);
    }

    @Override
    public EntityType<?> getType()
    {
        return ModEntities.PRISMARINE_ARROW;
    }

    @Override
    protected void onEntityHit(EntityRayTraceResult raytrace)
    {
        if (raytrace.getType() == RayTraceResult.Type.ENTITY)
        {
            Entity entity = ((EntityRayTraceResult) raytrace).getEntity();

            if (entity.isImmuneToFire())
            {
                setDamage(getDamage() * 1.1F);
            }
        }

        super.onEntityHit(raytrace);
    }

    @Override
    public void tick()
    {
        if (!inGround && inWater)
        {
            for (int i = 0; i < 4; ++i)
            {
                world.addParticle(ParticleTypes.BUBBLE, getPosX() - getMotion().x * 0.25D, getPosY() - getMotion().y * 0.25D, getPosZ() - getMotion().z * 0.25D, getMotion().x, getMotion().y, getMotion().z);
            }
        }

        super.tick();
    }

    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
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
