package phrille.vanillaboom;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.config.ConfigHandler;
import phrille.vanillaboom.entity.ModEntities;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.loot.LootConditionTypes;
import phrille.vanillaboom.loot.LootTableHandler;
import phrille.vanillaboom.temp.JsonAssetsGenerator;
import phrille.vanillaboom.temp.JsonDataGenerator;
import phrille.vanillaboom.tileentity.ModTileEntities;
import phrille.vanillaboom.util.Utils;
import phrille.vanillaboom.world.ModConfiguredStructures;
import phrille.vanillaboom.world.structures.ModStructures;

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
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);

        ModStructures.init(modEventBus);
        LootTableHandler.init(modEventBus);
        ModTileEntities.init(modEventBus);

        modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHandler.CLIENT_SPEC);
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC);
    }

    public void setup(FMLCommonSetupEvent event)
    {
        JsonAssetsGenerator.init();
        JsonDataGenerator.init();

        event.enqueueWork(() ->
        {
            ModStructures.setupStructures();
            ModConfiguredStructures.registerConfiguredStructures();
            ModBlocks.registerFlowerPots();
            ModEntities.registerAttributes();
            LootConditionTypes.registerLootConditions();

            addSpawnEgg(ModItems.PERCH_SPAWN_EGG);
            addSpawnEgg(ModItems.EEL_SPAWN_EGG);
            addSpawnEgg(ModItems.PIKE_SPAWN_EGG);
            addSpawnEgg(ModItems.TUNA_SPAWN_EGG);
            addSpawnEgg(ModItems.SWAMP_DWELLER_SPAWN_EGG);
            Utils.addSpawnEggs();
            
            addCompostMaterial(0.35F, ModItems.PINECONE);
            addCompostMaterial(0.5F, ModItems.PUMPKIN_SLICE);
            addCompostMaterial(0.65F, ModBlocks.ROSE);
            addCompostMaterial(0.6F, ModItems.TOMATO);
            addCompostMaterial(0.3F, ModItems.TOMATO_SEEDS);
        });
    }

    private static void addSpawnEgg(Item item)
    {
        if (item instanceof SpawnEggItem)
        {
            Utils.EGG_MAP.put(((SpawnEggItem) item).getType(null), (SpawnEggItem) item);
        }
    }

    private static void addCompostMaterial(float chance, IItemProvider item)
    {
        ComposterBlock.CHANCES.put(item, chance);
    }

    private void enqueueIMC(InterModEnqueueEvent event)
    {
    }

    private void processIMC(InterModProcessEvent event)
    {
    }
}
