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
            generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, getFeature(ModConfiguredFeatures.ORE_PERIDOTITE));
            generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, getFeature(ModConfiguredFeatures.ORE_FINE_GRAVEL));
            generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, getFeature(ModConfiguredFeatures.ROSE_PATCHES));
        }

        if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.NETHER))
        {
            generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, getFeature(ModConfiguredFeatures.ORE_INFERNAL_ROCK));

            if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.FOREST))
            {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, getFeature(ModConfiguredFeatures.RED_NETHER_BRICK_WELL));
            }
            else
            {
                if (event.getName() != null)
                {
                    String biomeName = event.getName().getPath();

                    if (biomeName.equals("soul_sand_valley"))
                    {
                        generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, getFeature(ModConfiguredFeatures.BLACKSTONE_WELL));
                    }
                    else if (!biomeName.equals("basalt_deltas"))
                    {
                        generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, getFeature(ModConfiguredFeatures.NETHER_BRICK_WELL));
                    }
                }
                else 
                {
                    VanillaBoom.LOGGER.warn("A biome name returned as null, this could lead to problems with world generation");
                }
            }
        }
    }

    private static ConfiguredFeature<?, ?> getFeature(RegistryKey<ConfiguredFeature<?, ?>> key)
    {
        return WorldGenRegistries.CONFIGURED_FEATURE.getOrThrow(key);
    }
}