package phrille.vanillaboom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phrille.vanillaboom.init.ModEntities;
import phrille.vanillaboom.init.ModItems;

public class SwampDwellerEntity extends BaseFishEntity
{
    public SwampDwellerEntity(EntityType<? extends BaseFishEntity> type, World world)
    {
        super(type, world);
    }

    @Override
    protected ItemStack getBucketItem()
    {
        return new ItemStack(ModItems.SWAMP_DWELLER_BUCKET);
    }

    @Override
    protected EntityType<?> getEntityType()
    {
        return ModEntities.SWAMP_DWELLER;
    }
}
