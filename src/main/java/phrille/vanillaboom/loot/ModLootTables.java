package phrille.vanillaboom.loot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.loot.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import phrille.vanillaboom.VanillaBoom;

public class ModLootTables
{
    public static final ResourceLocation LOOT_TABLE_TEST = RegistrationHandler.register("chests/grave");

    public static void registerLootTables()
    {
    }

    public static class RegistrationHandler
    {
        private static final Method REGISTER = ObfuscationReflectionHelper.findMethod(LootTables.class, "func_186375_a", ResourceLocation.class);

        public static ResourceLocation register(String name)
        {
            ResourceLocation id = new ResourceLocation(VanillaBoom.MOD_ID, name);

            try
            {
                return (ResourceLocation) REGISTER.invoke(null, id);
            }
            catch (IllegalAccessException | InvocationTargetException e)
            {
                throw new RuntimeException("Failed to register loot table " + id, e);
            }
        }
    }
}