package phrille.vanillaboom.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import phrille.vanillaboom.VanillaBoom;

public class ModConfiguredStructures
{
    public static final StructureFeature<?, ?> NETHER_WELL = ModStructures.NETHER_WELL.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
    public static final StructureFeature<?, ?> GRAVE = ModStructures.GRAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);

    public static void registerConfiguredStructures()
    {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        
        Registry.register(registry, new ResourceLocation(VanillaBoom.MOD_ID, "nether_well"), NETHER_WELL);
        Registry.register(registry, new ResourceLocation(VanillaBoom.MOD_ID, "grave"), GRAVE);

        FlatGenerationSettings.STRUCTURES.put(ModStructures.NETHER_WELL.get(), NETHER_WELL);
        FlatGenerationSettings.STRUCTURES.put(ModStructures.GRAVE.get(), GRAVE);
    }
}
