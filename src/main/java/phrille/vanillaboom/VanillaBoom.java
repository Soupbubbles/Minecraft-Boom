package phrille.vanillaboom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import phrille.vanillaboom.client.renderer.ModRenderers;
import phrille.vanillaboom.config.ConfigHandler;
import phrille.vanillaboom.init.ModBlocks;
import phrille.vanillaboom.init.ModFeatures;
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
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);

        ModFeatures.initialise(modEventBus);

        //modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHandler.CLIENT_SPEC);
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC);
    }

    public void setup(FMLCommonSetupEvent event)
    {
        JsonAssetsGenerator.init();
        JsonDataGenerator.init();

        Utils.addCompostMaterial(0.35F, ModItems.PINECONE);
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
}
