package phrille.minecraftboom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import phrille.minecraftboom.handler.FurnaceFuelEventHandler;
import phrille.minecraftboom.handler.PlayerEventHandler;
import phrille.minecraftboom.init.ModBlocks;
import phrille.minecraftboom.init.ModItems;
import phrille.minecraftboom.util.JsonDataGenerator;
import phrille.minecraftboom.util.Utils;

@Mod(MinecraftBoom.MOD_ID)
public class MinecraftBoom
{
    public static final String MOD_ID = "minecraftboom";
    public static final Logger LOGGER = LogManager.getLogger();

    public MinecraftBoom()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
    }

    public void setup(FMLCommonSetupEvent event)
    {
        JsonDataGenerator.init();

        MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
        MinecraftForge.EVENT_BUS.register(new FurnaceFuelEventHandler());
        
        Utils.addCompostMaterial(0.35F, ModItems.PINECONE);
        Utils.addCompostMaterial(0.5F, ModItems.PUMPKIN_SLICE);
        Utils.addCompostMaterial(0.65F, ModBlocks.ROSE);
    }

    private void clientSetup(FMLClientSetupEvent event)
    {
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
