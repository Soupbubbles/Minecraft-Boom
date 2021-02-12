package phrille.vanillaboom.entity.fish;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phrille.vanillaboom.init.ModEntities;
import phrille.vanillaboom.init.ModItems;

public class EelEntity extends BaseFishEntity
{
    public EelEntity(EntityType<? extends BaseFishEntity> type, World world)
    {
        super(type, world);
    }

    @Override
    protected ItemStack getBucketItem()
    {
        return new ItemStack(ModItems.EEL_BUCKET);
    }

    @Override
    protected EntityType<?> getEntityType()
    {
        return ModEntities.EEL;
    }
}
