package phrille.vanillaboom.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phrille.vanillaboom.VanillaBoomTab;
import phrille.vanillaboom.entity.PrismarineArrowEntity;

public class PrismarineArrowItem extends ArrowItem
{
    public PrismarineArrowItem()
    {
        super(new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB));
    }

    @Override
    public AbstractArrowEntity createArrow(World world, ItemStack stack, LivingEntity shooter)
    {
        return new PrismarineArrowEntity(world, shooter);
    }
}
