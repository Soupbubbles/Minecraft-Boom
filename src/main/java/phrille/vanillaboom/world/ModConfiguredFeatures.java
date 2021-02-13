package phrille.vanillaboom.world;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

public class ModConfiguredFeatures
{
    //OverWorld
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PERIDOTITE = key("ore_peridotite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_FINE_GRAVEL = key("ore_fine_gravel");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DISK_HYDRO_ROCK = key("disk_hydro_rock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ROSE_PATCHES = key("rose_patches");

    //Nether
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_INFERNAL_ROCK = key("ore_infernal_rock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_BONE_SAND = key("ore_bone_sand");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_WITHER_BONE_SAND = key("ore_wither_bone_sand");

    public static final RuleTest SOUL_SOIL_FILLER = new BlockMatchRuleTest(Blocks.SOUL_SOIL);

    private static RegistryKey<ConfiguredFeature<?, ?>> key(final String name)
    {
        return RegistryKey.getOrCreateKey(Registry.CONFIGURED_FEATURE_KEY, new ResourceLocation(VanillaBoom.MOD_ID, name));
    }

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Bus.MOD)
    public static class RegistrationHandler
    {
        @SubscribeEvent(priority = EventPriority.LOW)
        public static void register(final RegistryEvent.Register<Feature<?>> event)
        {
            //OverWorld
            register(ORE_PERIDOTITE, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.PERIDOTITE.getDefaultState(), 33)).range(80).square().func_242731_b(10));
            register(ORE_FINE_GRAVEL, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.FINE_GRAVEL.getDefaultState(), 33)).range(256).square().func_242731_b(8));
            register(DISK_HYDRO_ROCK, Feature.DISK.withConfiguration(new SphereReplaceConfig(ModBlocks.HYDRO_ROCK.getDefaultState(), FeatureSpread.func_242253_a(2, 1), 1, ImmutableList.of(Blocks.STONE.getDefaultState(), Blocks.GRAVEL.getDefaultState()))).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));
            register(ROSE_PATCHES, Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.ROSE.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32).build()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT));

            //Nether
            register(ORE_INFERNAL_ROCK, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.INFERNAL_ROCK.getDefaultState(), 33)).withPlacement(Placement.MAGMA.configure(NoPlacementConfig.INSTANCE)).square().func_242731_b(4));
            register(ORE_BONE_SAND, Feature.ORE.withConfiguration(new OreFeatureConfig(SOUL_SOIL_FILLER, ModBlocks.BONE_SAND.getDefaultState(), 26)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).square().func_242731_b(16));
            register(ORE_WITHER_BONE_SAND, Feature.ORE.withConfiguration(new OreFeatureConfig(SOUL_SOIL_FILLER, ModBlocks.WITHER_BONE_SAND.getDefaultState(), 12)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).square().func_242731_b(10));
        }

        private static void register(final RegistryKey<ConfiguredFeature<?, ?>> key, final ConfiguredFeature<?, ?> configuredFeature)
        {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key.getLocation(), configuredFeature);
        }
    }
}