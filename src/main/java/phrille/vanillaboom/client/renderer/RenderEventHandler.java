package phrille.vanillaboom.client.renderer;

import net.minecraft.entity.passive.PigEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import phrille.vanillaboom.VanillaBoom;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class RenderEventHandler
{

    @SubscribeEvent
    public static void onRenderLiving(RenderLivingEvent event)
    {
        if (event.getEntity() instanceof PigEntity) 
        {
        }
    }
}
