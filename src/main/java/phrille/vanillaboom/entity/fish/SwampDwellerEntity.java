package phrille.vanillaboom.entity.fish;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phrille.vanillaboom.entity.ModEntities;
import phrille.vanillaboom.item.ModItems;

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
