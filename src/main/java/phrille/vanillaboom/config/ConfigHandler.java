package phrille.vanillaboom.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import phrille.vanillaboom.VanillaBoom;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ConfigHandler
{
    public static class Client
    {
        public Client(ForgeConfigSpec.Builder builder)
        {
        }
    }

    public static final Client CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static
    {
        Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static class Common
    {
        public final ForgeConfigSpec.BooleanValue blazePowderAsBonemeal;

        public final ForgeConfigSpec.BooleanValue roseGenEnabled;
        public final ForgeConfigSpec.BooleanValue netherWellGenEnabled;

        public Common(ForgeConfigSpec.Builder builder)
        {
            builder.push("general");

            blazePowderAsBonemeal = builder.comment("Set this to false to disable Blaze Powder being used as a Bonemeal to Nether Wart").define("blaze_powder_as_bonemeal", true);

            builder.pop();
            builder.push("worldgen");

            roseGenEnabled = builder.comment("Set this to false to stop Roses being generated in the Overworld").define("rose_gen", true);
            netherWellGenEnabled = builder.comment("Set this to false to stop Nether Wells being generated in the Nether").define("nether_well_gen", true);

            builder.pop();
        }
    }

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static
    {
        Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    @SubscribeEvent
    public static void onModConfigEvent(ModConfig.ModConfigEvent event)
    {
        ModConfig config = event.getConfig();
        
        if (config.getSpec() == CLIENT_SPEC)
        {
            VanillaBoomConfig.bakeClient(config);
            VanillaBoom.LOGGER.debug("Baked client config");
        }
        else if (config.getSpec() == COMMON_SPEC)
        {
            VanillaBoomConfig.bakeCommon(config);
            VanillaBoom.LOGGER.debug("Baked common config");
        }
    }
}
