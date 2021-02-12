package phrille.vanillaboom.entity.fish;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phrille.vanillaboom.init.ModEntities;
import phrille.vanillaboom.init.ModItems;

public class TunaEntity extends BaseFishEntity
{
    public TunaEntity(EntityType<? extends BaseFishEntity> type, World world)
    {
        super(type, world);
    }

    @Override
    protected ItemStack getBucketItem()
    {
        return new ItemStack(ModItems.TUNA_BUCKET);
    }

    @Override
    protected EntityType<?> getEntityType()
    {
        return ModEntities.TUNA;
    }
}
