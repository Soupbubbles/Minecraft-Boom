package phrille.minecraftboom.client.renderer;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.entity.PrismarineArrowEntity;

@Mod.EventBusSubscriber(modid = MinecraftBoom.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
public class ModRenderers
{
    @SubscribeEvent
    public static void register(FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(PrismarineArrowEntity.class, renderManager -> new PrismarineArrowRenderer(renderManager, new ResourceLocation(MinecraftBoom.MOD_ID, "textures/entity/prismarine_arrow.png")));
    }
}