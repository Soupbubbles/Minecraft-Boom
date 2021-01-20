package phrille.vanillaboom.init;

import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.world.feature.NetherWellConfig;
import phrille.vanillaboom.world.feature.NetherWellFeature;

public class ModFeatures
{
    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, VanillaBoom.MOD_ID);

    private static boolean isInitialised;

    public static final RegistryObject<NetherWellFeature> NETHER_WELL = FEATURES.register("nether_well", () -> new NetherWellFeature(NetherWellConfig.CODEC));

    public static void initialise(IEventBus modEventBus)
    {
        if (isInitialised)
        {
            throw new IllegalStateException("Already initialised");
        }

        FEATURES.register(modEventBus);

        isInitialised = true;
    }
}