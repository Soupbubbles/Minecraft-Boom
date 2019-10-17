package phrille.minecraftboom.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.item.ItemBase;
import phrille.minecraftboom.lib.Names;

public class ModItems
{
    public static final Set<Item> ITEMS = new HashSet<>();

    public static final Item ITEM_MAGMA_BRICK;

    static
    {
        ITEM_MAGMA_BRICK = registerItem(new ItemBase(Names.ITEM_MAGMA_BRICK));
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
            }
        }
    }
}
