package phrille.vanillaboom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import phrille.vanillaboom.client.renderer.ModRenderers;
import phrille.vanillaboom.init.ModBlocks;
import phrille.vanillaboom.init.ModItems;
import phrille.vanillaboom.util.JsonAssetsGenerator;
import phrille.vanillaboom.util.JsonDataGenerator;
import phrille.vanillaboom.util.Utils;

@Mod(VanillaBoom.MOD_ID)
public class VanillaBoom
{
    public static final String MOD_ID = "vanillaboom";
    public static final Logger LOGGER = LogManager.getLogger();

    public VanillaBoom()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
    }

    public void setup(FMLCommonSetupEvent event)
    {
        JsonAssetsGenerator.init();
        JsonDataGenerator.init();
        
        Utils.addCompostMaterial(0.35F, ModItems.PINECONE);
        //Utils.addCompostMaterial(0.35F, ModItems.RICE);
        Utils.addCompostMaterial(0.5F, ModItems.PUMPKIN_SLICE);
        Utils.addCompostMaterial(0.65F, ModBlocks.ROSE);
    }

    private void clientSetup(FMLClientSetupEvent event)
    {
        ModRenderers.setRenderLayers();
    }

    private void enqueueIMC(InterModEnqueueEvent event)
    {
    }

    private void processIMC(InterModProcessEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {
    }
}
