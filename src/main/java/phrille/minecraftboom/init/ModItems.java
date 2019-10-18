package phrille.minecraftboom.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.item.ItemBase;
import phrille.minecraftboom.item.ItemFoodBase;
import phrille.minecraftboom.lib.FuelValues;
import phrille.minecraftboom.lib.Names;

public class ModItems
{
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item ITEM_MAGMA_BRICK;
    public static final Item ITEM_WITHER_BONE;
    public static final Item ITEM_PINECONE;
    public static final Item ITEM_POLAR_BEAR_FUR;
    public static final Item ITEM_RAW_POLAR_BEAR_MEAT;
    public static final Item ITEM_POLAR_BEAR_STEAK;

    public static final Item ITEM_PUMPKIN_SLICE;
    public static final Item ITEM_COOKED_EGG;

    static
    {
        ITEM_MAGMA_BRICK = registerItem(new ItemBase(Names.ITEM_MAGMA_BRICK));
        ITEM_WITHER_BONE = registerItem(new ItemBase(Names.ITEM_WITHER_BONE, FuelValues.ITEM_WITHER_BONE));
        ITEM_PINECONE = registerItem(new ItemFoodBase(Names.ITEM_PINECONE, 3, 2.4F, false, FuelValues.ITEM_PINECONE));
        ITEM_POLAR_BEAR_FUR = registerItem(new ItemBase(Names.ITEM_POLAR_BEAR_FUR));
        ITEM_RAW_POLAR_BEAR_MEAT = registerItem(new ItemFoodBase(Names.ITEM_RAW_POLAR_BEAR_MEAT, 3, 1.8F, true));
        ITEM_POLAR_BEAR_STEAK = registerItem(new ItemFoodBase(Names.ITEM_POLAR_BEAR_STEAK, 8, 12.8F, false));
        ITEM_PUMPKIN_SLICE = registerItem(new ItemFoodBase(Names.ITEM_PUMPKIN_SLICE, 2, 1.2F, false));
        ITEM_COOKED_EGG = registerItem(new ItemFoodBase(Names.ITEM_COOKED_EGG, 6, 2.8F, false));
    }

    private static Item registerItem(Item item)
    {
        ITEMS.add(item);
        return item;
    }
    
    @Mod.EventBusSubscriber(modid = MinecraftBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register
    {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event)
        {
            for (Item item : ITEMS)
            {
                event.getRegistry().register(item);
                CreativeTabs.tabList.add(item);
            }
        }
    }
}
