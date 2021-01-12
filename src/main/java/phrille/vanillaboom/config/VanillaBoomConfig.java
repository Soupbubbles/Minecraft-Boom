package phrille.vanillaboom.config;

import net.minecraftforge.fml.config.ModConfig;

public class VanillaBoomConfig
{
    //General
    public static boolean blazePowderAsBonemeal;
    public static boolean growWitherRoses;
    public static boolean removeSlimeBallPistons;

    //Worldgen Overworld
    public static boolean peridotiteGenEnabled;
    public static boolean fineGravelGenEnabled;
    public static boolean roseGenEnabled;
    
    //Worldgen Nether
    public static boolean infernalRockGenEnabled;
    public static boolean netherWellGenEnabled;
    
    public static void bakeClient(ModConfig config)
    {
    }

    public static void bakeCommon(ModConfig config)
    {
        blazePowderAsBonemeal = ConfigHandler.COMMON.blazePowderAsBonemeal.get();
        growWitherRoses = ConfigHandler.COMMON.growWitherRoses.get();
        removeSlimeBallPistons = ConfigHandler.COMMON.removeSlimeBallPistons.get();

        peridotiteGenEnabled = ConfigHandler.COMMON.peridotiteGenEnabled.get();
        fineGravelGenEnabled = ConfigHandler.COMMON.fineGravelGenEnabled.get();
        roseGenEnabled = ConfigHandler.COMMON.roseGenEnabled.get();
        
        infernalRockGenEnabled = ConfigHandler.COMMON.infernalRockGenEnabled.get();
        netherWellGenEnabled = ConfigHandler.COMMON.netherWellGenEnabled.get();
    }
}