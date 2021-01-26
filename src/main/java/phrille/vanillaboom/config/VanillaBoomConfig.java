package phrille.vanillaboom.config;

import net.minecraftforge.fml.config.ModConfig;

public class VanillaBoomConfig
{
    //General
    public static boolean growNetherWarts;
    public static boolean growWitherRoses;
    public static boolean removeSlimeBallPistons;

    //Worldgen Overworld
    public static boolean peridotiteGenEnabled;
    public static boolean fineGravelGenEnabled;
    public static boolean roseGenEnabled;
    
    //Worldgen Nether
    public static boolean infernalRockGenEnabled;
    public static boolean boneSandGenEnabled;
    public static boolean witherBoneSandGenEnabled;
    public static boolean netherWellGenEnabled;
    public static boolean graveGenEnabled;

    public static void bakeClient(ModConfig config)
    {
    }

    public static void bakeCommon(ModConfig config)
    {
        growNetherWarts = ConfigHandler.COMMON.growNetherWarts.get();
        growWitherRoses = ConfigHandler.COMMON.growWitherRoses.get();
        removeSlimeBallPistons = ConfigHandler.COMMON.removeSlimeBallPistons.get();

        peridotiteGenEnabled = ConfigHandler.COMMON.peridotiteGenEnabled.get();
        fineGravelGenEnabled = ConfigHandler.COMMON.fineGravelGenEnabled.get();
        roseGenEnabled = ConfigHandler.COMMON.roseGenEnabled.get();
        
        infernalRockGenEnabled = ConfigHandler.COMMON.infernalRockGenEnabled.get();
        boneSandGenEnabled = ConfigHandler.COMMON.boneSandGenEnabled.get();
        witherBoneSandGenEnabled = ConfigHandler.COMMON.witherBoneSandGenEnabled.get();
        netherWellGenEnabled = ConfigHandler.COMMON.netherWellGenEnabled.get();
        graveGenEnabled = ConfigHandler.COMMON.graveGenEnabled.get();
    }
}