package phrille.vanillaboom.loot;

import javax.annotation.Nullable;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;

import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootConditionType;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;

public class MoonPhaseCheck implements ILootCondition
{
    private final float moonPhase;

    private MoonPhaseCheck(float moon)
    {
        moonPhase = moon;
    }

    @Override
    public boolean test(LootContext context)
    {
        return moonPhase == context.getWorld().getMoonFactor();
    }

    @Override
    public LootConditionType func_230419_b_()
    {
        return LootConditionTypes.MOON_PHASE;
    }

    public static class Serializer implements ILootSerializer<MoonPhaseCheck>
    {
        public MoonPhaseCheck deserialize(JsonObject object, JsonDeserializationContext context)
        {
            return new MoonPhaseCheck(JSONUtils.getFloat(object, "moon_phase"));
        }

        public void serialize(JsonObject object, MoonPhaseCheck instance, JsonSerializationContext context)
        {
            object.addProperty("moon_phase", instance.moonPhase);
        }
    }
}
