package phrille.vanillaboom.item;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;

public class EntitySpawnItem extends SpawnEggItem
{
    private final Supplier<? extends EntityType<?>> entityType;

    public EntitySpawnItem(Supplier<? extends EntityType<?>> type, int primaryColorIn, int secondaryColorIn, Properties builder)
    {
        super(null, primaryColorIn, secondaryColorIn, builder);
        entityType = type;
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT nbt)
    {
        return entityType.get();
    }
}
