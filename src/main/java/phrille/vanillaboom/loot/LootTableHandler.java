package phrille.vanillaboom.loot;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.TableLootEntry;
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

    private static final RegistryObject<LootTableDropModifier.Serializer> SILVERFISH = GLM.register("silverfish", LootTableDropModifier.Serializer::new);
    private static final RegistryObject<LootTableDropModifier.Serializer> DROWNED = GLM.register("drowned", LootTableDropModifier.Serializer::new);
    private static final RegistryObject<LootTableDropModifier.Serializer> WITHER_SKELTON = GLM.register("wither_skeleton", LootTableDropModifier.Serializer::new);
    private static final RegistryObject<LootTableDropModifier.Serializer> POLAR_BEAR = GLM.register("polar_bear", LootTableDropModifier.Serializer::new);
    private static final RegistryObject<LootTableDropModifier.Serializer> SPRUCE_LEAVES = GLM.register("spruce_leaves", LootTableDropModifier.Serializer::new);
    private static final RegistryObject<LootTableDropModifier.Serializer> PUMPKIN = GLM.register("pumpkin", LootTableDropModifier.Serializer::new);

    public static void init(IEventBus modEventBus)
    {
        GLM.register(modEventBus);
    }

    public static class LootTableDropModifier extends LootModifier
    {
        private final TableLootEntry table;
        private final Item[] overwriteItems;

        public LootTableDropModifier(ILootCondition[] conditions, TableLootEntry lootTable, Item... overwrite)
        {
            super(conditions);
            table = lootTable;
            overwriteItems = overwrite;
        }

        @Nonnull
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context)
        {
            for (Item item : overwriteItems)
            {
                generatedLoot = generatedLoot.stream().filter(stack -> stack.getItem() != item).collect(Collectors.toList());
            }
            
            table.func_216154_a(generatedLoot::add, context);

            return generatedLoot;
        }

        public static class Serializer extends GlobalLootModifierSerializer<LootTableDropModifier>
        {
            @Override
            public LootTableDropModifier read(ResourceLocation location, JsonObject object, ILootCondition[] lootConditions)
            {
                String resLoc = JSONUtils.getString(object, "table");
                TableLootEntry table = (TableLootEntry) TableLootEntry.builder(new ResourceLocation(resLoc)).build();
                JsonArray overwrites = JSONUtils.getJsonArray(object, "overwrites");
                Item[] items = new Item[overwrites.size()];

                for (int i = 0; i < items.length; i++)
                {
                    JsonElement element = overwrites.get(i);

                    if (element.isJsonObject())
                    {
                        JsonObject obj = element.getAsJsonObject();
                        items[i] = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(obj, "item")));
                    }
                }
                
                return new LootTableDropModifier(lootConditions, table, items);
            }

            @Override
            public JsonObject write(LootTableDropModifier instance)
            {
                JsonObject json = makeConditions(instance.conditions);
                JsonArray overwrites = new JsonArray();
                
                for (int i = 0; i < instance.overwriteItems.length; i++)
                {
                    JsonObject obj = new JsonObject();
                    obj.addProperty("item", ForgeRegistries.ITEMS.getKey(instance.overwriteItems[i]).toString());
                    overwrites.add(obj);
                }

                json.addProperty("table", instance.table.table.toString());
                json.add("overwrites", overwrites);
                
                return json;
            }
        }
    }
}