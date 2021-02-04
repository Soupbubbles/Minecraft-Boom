package phrille.vanillaboom.client.renderer;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.PaintingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.init.ModBlocks;
import phrille.vanillaboom.init.ModEntities;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
public class ModRenderers
{
    @SubscribeEvent
    public static void register(FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PRISMARINE_ARROW, renderManager -> new PrismarineArrowRenderer(renderManager, new ResourceLocation(VanillaBoom.MOD_ID, "textures/entity/prismarine_arrow.png")));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.CUSTOM_PAINTING, renderManager -> new PaintingRenderer(renderManager));
        setRenderLayers();
    }

    public static void setRenderLayers()
    {
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGMA_CREAM_BLOCK, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_SOUL_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.SPRUCE_LADDER, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BIRCH_LADDER, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.JUNGLE_LADDER, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ACACIA_LADDER, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DARK_OAK_LADDER, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CRIMSON_LADDER, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.WARPED_LADDER, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_BARS, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ROSE, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_ROSE, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.TOMATO_PLANT, RenderType.getCutout());
    }
}