package phrille.vanillaboom.world.gen;

import java.util.Objects;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.init.ModConfiguredFeatures;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class ModWorldGen
{

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void addFeaturesToBiomes(BiomeLoadingEvent event)
    {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        RegistryKey<Biome> biomeRegistryKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(event.getName(), "Biome registry name was null"));
        
        if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.OVERWORLD))
        {
            generate(generation, GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.ORE_PERIDOTITE, VanillaBoomConfig.peridotiteGenEnabled);
            generate(generation, GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.ORE_FINE_GRAVEL, VanillaBoomConfig.fineGravelGenEnabled);
            generate(generation, GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.ROSE_PATCHES, VanillaBoomConfig.roseGenEnabled);
        }

        if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.NETHER))
        {
            generate(generation, GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.ORE_INFERNAL_ROCK, VanillaBoomConfig.infernalRockGenEnabled);

            if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.FOREST))
            {
                generate(generation, GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.RED_NETHER_BRICK_WELL, VanillaBoomConfig.netherWellGenEnabled);
            }
            else
            {
                if (event.getName() != null)
                {
                    String biomeName = event.getName().getPath();

                    if (biomeName.equals("soul_sand_valley"))
                    {
                        generate(generation, GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.BLACKSTONE_WELL, VanillaBoomConfig.netherWellGenEnabled);
                    }
                    else if (!biomeName.equals("basalt_deltas"))
                    {
                        generate(generation, GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.NETHER_BRICK_WELL, VanillaBoomConfig.netherWellGenEnabled);
                    }
                }
                else
                {
                    VanillaBoom.LOGGER.warn("A biome name returned as null, this could lead to problems with world generation");
                }
            }
        }
    }

    public static void generate(BiomeGenerationSettingsBuilder generation, GenerationStage.Decoration decorationStage, RegistryKey<ConfiguredFeature<?, ?>> key, boolean config)
    {
        if (config)
        {
            generation.withFeature(decorationStage, getFeature(key));
        }
    }

    private static ConfiguredFeature<?, ?> getFeature(RegistryKey<ConfiguredFeature<?, ?>> key)
    {
        return WorldGenRegistries.CONFIGURED_FEATURE.getOrThrow(key);
    }
}