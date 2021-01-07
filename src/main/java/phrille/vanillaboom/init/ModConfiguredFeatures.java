package phrille.vanillaboom.init;

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
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.world.gen.feature.NetherWellConfig;

public class ModConfiguredFeatures
{
    public static final RegistryKey<ConfiguredFeature<?, ?>> ROSE_PATCHES = key("rose_patches");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_BRICK_WELL = key("nether_brick_well");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_NETHER_BRICK_WELL = key("red_nether_brick_well");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACKSTONE_WELL = key("blackstone_well");

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
            register(ROSE_PATCHES, Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.ROSE.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(32).build()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT));

            register(NETHER_BRICK_WELL, ModFeatures.NETHER_WELL.get().withConfiguration(new NetherWellConfig(Blocks.NETHER_BRICKS.getDefaultState(), Blocks.CHISELED_NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICK_STAIRS.getDefaultState(), Blocks.NETHER_BRICK_SLAB.getDefaultState(), Blocks.NETHER_BRICK_WALL.getDefaultState())).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))).chance(400));
            register(RED_NETHER_BRICK_WELL, ModFeatures.NETHER_WELL.get().withConfiguration(new NetherWellConfig(Blocks.RED_NETHER_BRICKS.getDefaultState(), ModBlocks.CHISELED_RED_NETHER_BRICKS.getDefaultState(), Blocks.RED_NETHER_BRICK_STAIRS.getDefaultState(), Blocks.RED_NETHER_BRICK_SLAB.getDefaultState(), Blocks.RED_NETHER_BRICK_WALL.getDefaultState())).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))).chance(100));
            register(BLACKSTONE_WELL, ModFeatures.NETHER_WELL.get().withConfiguration(new NetherWellConfig(Blocks.POLISHED_BLACKSTONE_BRICKS.getDefaultState(), Blocks.CHISELED_POLISHED_BLACKSTONE.getDefaultState(), Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS.getDefaultState(), Blocks.POLISHED_BLACKSTONE_BRICK_SLAB.getDefaultState(), Blocks.POLISHED_BLACKSTONE_BRICK_WALL.getDefaultState())).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))).chance(50));
        }

        private static void register(final RegistryKey<ConfiguredFeature<?, ?>> key, final ConfiguredFeature<?, ?> configuredFeature)
        {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key.getLocation(), configuredFeature);
        }
    }
}