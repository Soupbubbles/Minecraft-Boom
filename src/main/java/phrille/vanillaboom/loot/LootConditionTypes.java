package phrille.vanillaboom.loot;

import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootConditionType;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import phrille.vanillaboom.VanillaBoom;

public class LootConditionTypes
{
    public static final LootConditionType MOON_PHASE = register("moon_phase_check", new MoonPhaseCheck.Serializer());

    public static void registerLootConditions()
    {
    }

    private static LootConditionType register(final String name, final ILootSerializer<? extends ILootCondition> serializer)
    {
        return Registry.register(Registry.LOOT_CONDITION_TYPE, new ResourceLocation(VanillaBoom.MOD_ID, name), new LootConditionType(serializer));
    }
}
