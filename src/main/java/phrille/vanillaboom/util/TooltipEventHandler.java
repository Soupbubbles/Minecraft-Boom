package phrille.vanillaboom.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.config.VanillaBoomConfig;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class TooltipEventHandler
{
    @SubscribeEvent
    public static void onRenderTooltip(ItemTooltipEvent event)
    {
        ItemStack stack = event.getItemStack();

        if (VanillaBoomConfig.addFoodTooltips && !stack.isEmpty() && (stack.isFood() || stack.getItem() == Items.CAKE))
        {
            int healing = stack.getItem() == Items.CAKE ? 14 : stack.getItem().getFood().getHealing();
            String s = "";

            for (int i = 0; i < healing - healing / 2; i++)
            {
                s += "  ";
            }

            event.getToolTip().add(new StringTextComponent(s));
        }
    }
}
