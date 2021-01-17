package phrille.vanillaboom.world.gen;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.init.ModConfiguredFeatures;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class WorldGenEventHandler
{

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void addFeaturesToBiomes(BiomeLoadingEvent event)
    {
        RegistryKey<Biome> biomeRegistryKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(event.getName(), "Biome registry name was null"));

        if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.OVERWORLD))
        {
            generate(event, GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.ORE_PERIDOTITE, VanillaBoomConfig.peridotiteGenEnabled);
            generate(event, GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.ORE_FINE_GRAVEL, VanillaBoomConfig.fineGravelGenEnabled);
            generate(event, GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.ROSE_PATCHES, VanillaBoomConfig.roseGenEnabled);
        }

        if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.NETHER))
        {
            generate(event, GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.ORE_INFERNAL_ROCK, VanillaBoomConfig.infernalRockGenEnabled);
        }
    }

    /**
     * Add later when the structures have been implemented
     */
    
    //@SubscribeEvent(priority = EventPriority.NORMAL)
    public static void addDimensionalSpacing(WorldEvent.Load event)
    {
        if (event.getWorld() instanceof ServerWorld)
        {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();

            if (serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator && serverWorld.getDimensionKey().equals(World.OVERWORLD))
            {
                return;
            }

            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());

            //tempMap.put(ModStructures.NETHER_WELL.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.NETHER_WELL.get()));
            //serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
        }
    }

    public static void generate(BiomeLoadingEvent event, GenerationStage.Decoration decorationStage, RegistryKey<ConfiguredFeature<?, ?>> key, boolean config)
    {
        if (config)
        {
            event.getGeneration().withFeature(decorationStage, getFeature(key));
        }
    }

    private static ConfiguredFeature<?, ?> getFeature(RegistryKey<ConfiguredFeature<?, ?>> key)
    {
        return WorldGenRegistries.CONFIGURED_FEATURE.getOrThrow(key);
    }
}