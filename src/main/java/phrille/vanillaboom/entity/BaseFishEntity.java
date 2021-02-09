package phrille.vanillaboom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public abstract class BaseFishEntity extends AbstractGroupFishEntity
{
    public BaseFishEntity(EntityType<? extends AbstractGroupFishEntity> type, World world)
    {
        super(type, world);
    }

    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public EntityType<?> getType()
    {
        return getEntityType();
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return getBucketItem();
    }

    @Override
    protected ItemStack getFishBucket()
    {
        return getBucketItem();
    }

    protected abstract ItemStack getBucketItem();

    protected abstract EntityType<?> getEntityType();

    @Override
    protected SoundEvent getFlopSound()
    {
        return SoundEvents.ENTITY_COD_FLOP;
    }
    
    public boolean isMoving() 
    {
        return !(getMotion().x == 0.0F && getMotion().z == 0.0F && getMotion().y == 0.0F);
    }
    
    public FishSize getFishSize() 
    {
        return FishSize.MEDIUM;
    }

    public static AttributeModifierMap.MutableAttribute getAttributes()
    {
        return AbstractFishEntity.func_234176_m_();
    }
    
    public static enum FishSize
    {
        SMALL,
        MEDIUM,
        LARGE,
        EEL;
    }
}
