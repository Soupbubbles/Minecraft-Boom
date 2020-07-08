package phrille.vanillaboom.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PaintingItem extends Item
{
    private final PaintingType paintingType;

    public PaintingItem(PaintingType type, Properties properties)
    {
        super(properties);
        paintingType = type;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context)
    {
        BlockPos blockpos = context.getPos();
        Direction direction = context.getFace();
        BlockPos blockpos1 = blockpos.offset(direction);
        PlayerEntity playerentity = context.getPlayer();
        ItemStack itemstack = context.getItem();

        if (playerentity != null && !canPlace(playerentity, direction, itemstack, blockpos1))
        {
            return ActionResultType.FAIL;
        }
        else
        {
            World world = context.getWorld();
            PaintingEntity painting = new PaintingEntity(world, blockpos1, direction, paintingType);
            CompoundNBT compoundnbt = itemstack.getTag();

            if (compoundnbt != null)
            {
                EntityType.applyItemNBT(world, playerentity, painting, compoundnbt);
            }

            if (painting.onValidSurface())
            {
                if (!world.isRemote)
                {
                    painting.playPlaceSound();
                    world.addEntity(painting);
                }

                itemstack.shrink(1);
            }

            return ActionResultType.SUCCESS;
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag)
    {
        tooltip.add(getPaintingDescription().func_240699_a_(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    public IFormattableTextComponent getPaintingDescription()
    {
        return new TranslationTextComponent(getTranslationKey() + ".desc");
    }

    protected boolean canPlace(PlayerEntity player, Direction direction, ItemStack stack, BlockPos pos)
    {
        return !direction.getAxis().isVertical() && player.canPlayerEdit(pos, direction, stack);
    }
}
