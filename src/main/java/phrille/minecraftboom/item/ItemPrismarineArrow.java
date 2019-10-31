package phrille.minecraftboom.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phrille.minecraftboom.entity.EntityPrismarineArrow;
import phrille.minecraftboom.init.MinecraftBoomTab;

public class ItemPrismarineArrow extends ItemArrow
{
    public ItemPrismarineArrow()
    {
        super(new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB));
    }

    @Override
    public EntityArrow createArrow(World world, ItemStack stack, EntityLivingBase shooter)
    {
        return new EntityPrismarineArrow(world, shooter);
    }
}
