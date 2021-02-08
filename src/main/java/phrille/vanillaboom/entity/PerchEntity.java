package phrille.vanillaboom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import phrille.vanillaboom.init.ModEntities;
import phrille.vanillaboom.init.ModItems;

public class PerchEntity extends AbstractGroupFishEntity
{
    public PerchEntity(EntityType<? extends AbstractGroupFishEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public EntityType<?> getType()
    {
        return ModEntities.PERCH;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return getFishBucket();
    }

    @Override
    protected ItemStack getFishBucket()
    {
        return new ItemStack(ModItems.PERCH_BUCKET);
    }

    @Override
    protected SoundEvent getFlopSound()
    {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes()
    {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.5F).createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D);
    }
}
