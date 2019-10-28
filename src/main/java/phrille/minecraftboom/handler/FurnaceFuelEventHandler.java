package phrille.minecraftboom.handler;

import net.minecraft.init.Items;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FurnaceFuelEventHandler
{
    @SubscribeEvent
    public void onBlockDropItems(FurnaceFuelBurnTimeEvent event)
    {
        if (event.getItemStack().getItem() == Items.BLAZE_POWDER) 
        {
            event.setBurnTime(1200);
        }
    }
}
