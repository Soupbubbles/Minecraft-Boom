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
        //General
        public final ForgeConfigSpec.BooleanValue blazePowderAsBonemeal;
        public final ForgeConfigSpec.BooleanValue growWitherRoses;
        public final ForgeConfigSpec.BooleanValue removeSlimeBallPistons;

        //Worldgen Overworld
        public final ForgeConfigSpec.BooleanValue peridotiteGenEnabled;
        public final ForgeConfigSpec.BooleanValue fineGravelGenEnabled;
        public final ForgeConfigSpec.BooleanValue roseGenEnabled;  
        
        //Worldgen Nether
        public final ForgeConfigSpec.BooleanValue infernalRockGenEnabled;
        public final ForgeConfigSpec.BooleanValue netherWellGenEnabled;
        
        public Common(ForgeConfigSpec.Builder builder)
        {
            builder.push("general");

            blazePowderAsBonemeal = builder.comment("Set this to false to disable Blaze Powder being used as a Bonemeal to Nether Wart.").define("blaze_powder_as_bonemeal", true);
            growWitherRoses = builder.comment("Set this to false to disable Wither Bones being used to grow Roses into Wither Roses.").define("grow_wither_roses", true);
            removeSlimeBallPistons = builder.comment("Set this to false to disable removing a Slime Ball from a Sticky Piston when right clickling and crouching with a Shovel.").define("remove_slime_ball_pistons", true);

            builder.pop();
            
            builder.comment(" Warning: \n Changing world gen config options will require \n the world to be reloaded to take action. \n For servers this means a server restart.");
          
            builder.push("worldgen");

            peridotiteGenEnabled = builder.comment("Set this to false to stop Peridotite being generated in the Overworld.").define("peridotite_gen", true);
            fineGravelGenEnabled = builder.comment("Set this to false to stop Fine Gravel being generated in the Overworld.").define("fine_gravel_gen", true);
            roseGenEnabled = builder.comment("Set this to false to stop Roses being generated in the Overworld.").define("rose_gen", true);
            
            infernalRockGenEnabled = builder.comment("Set this to false to stop Infernal Rock being generated in the Nether.").define("infernal_rock_gen", true);
            netherWellGenEnabled = builder.comment("Set this to false to stop Nether Wells being generated in the Nether.").define("nether_well_gen", true);

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
