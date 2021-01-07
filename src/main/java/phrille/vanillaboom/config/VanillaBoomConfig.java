package phrille.vanillaboom.config;

import net.minecraftforge.fml.config.ModConfig;

public class VanillaBoomConfig
{
    //General
    public static boolean blazePowderAsBonemeal;
    
    //Worldgen
    public static boolean roseGenEnabled;
    public static boolean netherWellGenEnabled;
    
    public static void bakeClient(ModConfig config)
    {
    }

    public static void bakeCommon(ModConfig config)
    {
        blazePowderAsBonemeal = ConfigHandler.COMMON.blazePowderAsBonemeal.get();
        roseGenEnabled = ConfigHandler.COMMON.roseGenEnabled.get();
        netherWellGenEnabled = ConfigHandler.COMMON.netherWellGenEnabled.get();
    }
}