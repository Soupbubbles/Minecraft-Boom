package phrille.vanillaboom.util;

import java.util.List;

import com.google.gson.JsonObject;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;

public class LootTableHandler
{
    private static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, VanillaBoom.MOD_ID);
    private static final RegistryObject<SilverFishModifier.Serializer> SILVERFISH = GLM.register("silverfish", SilverFishModifier.Serializer::new);

    public static void initialise(IEventBus modEventBus)
    {
        GLM.register(modEventBus);
    }
    
    private static class SilverFishModifier extends LootModifier
    {
        private final Item dropItem;

        private SilverFishModifier(ILootCondition[] conditionsIn, Item drop)
        {
            super(conditionsIn);
            dropItem = drop;
        }

        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context)
        {
            generatedLoot.add(new ItemStack(dropItem));
            return generatedLoot;
        }

        private static class Serializer extends GlobalLootModifierSerializer<SilverFishModifier>
        {
            @Override
            public SilverFishModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition)
            {
                Item drop = ForgeRegistries.ITEMS.getValue(new ResourceLocation((JSONUtils.getString(object, "dropItem"))));

                return new SilverFishModifier(ailootcondition, drop);
            }

            @Override
            public JsonObject write(SilverFishModifier instance)
            {
                JsonObject json = makeConditions(instance.conditions);
                json.addProperty("dropItem", ForgeRegistries.ITEMS.getKey(instance.dropItem).toString());
                return json;
            }
        }
    }
}
