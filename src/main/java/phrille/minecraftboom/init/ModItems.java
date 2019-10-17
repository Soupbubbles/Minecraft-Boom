package phrille.minecraftboom.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.item.ItemBase;
import phrille.minecraftboom.lib.Names;

public class ModItems
{
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item ITEM_MAGMA_BRICK;
    public static final Item ITEM_WITHER_BONE;

    static
    {
        ITEM_MAGMA_BRICK = registerItem(new ItemBase(Names.ITEM_MAGMA_BRICK));
        ITEM_WITHER_BONE = registerItem(new ItemBase(Names.ITEM_WITHER_BONE));
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
