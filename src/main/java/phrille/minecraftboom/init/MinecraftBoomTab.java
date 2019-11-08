package phrille.minecraftboom.init;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

import com.google.common.collect.Ordering;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import phrille.minecraftboom.MinecraftBoom;

public class MinecraftBoomTab extends ItemGroup
{
    public static final List<Item> MINECRAFTBOOM_TAB_LIST = new ArrayList<Item>();
    public static final List<Item> MINECRAFTBOOM_VARIANT_BLOCKS_TAB_LIST = new ArrayList<Item>();
    
    public static final ItemGroup MINECRAFTBOOM_TAB = new MinecraftBoomTab(MinecraftBoom.MOD_ID + "_tab", () -> new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICKS), MINECRAFTBOOM_TAB_LIST);
    public static final ItemGroup MINECRAFTBOOM_VARIANT_BLOCKS_TAB = new MinecraftBoomTab(MinecraftBoom.MOD_ID + "_variant_blocks_tab", () -> new ItemStack(ModBlocks.MAGMA_BRICK_STAIRS), MINECRAFTBOOM_VARIANT_BLOCKS_TAB_LIST);

    private final Supplier<ItemStack> iconSupplier;
    private final List<Item> tabList;
    private static Comparator<ItemStack> tabSorter;
    
    public MinecraftBoomTab(String name, Supplier<ItemStack> icon, List<Item> list)
    {
        super(name);
        iconSupplier = icon;
        tabList = list;
    }

    @OnlyIn(Dist.CLIENT)
    public void fill(NonNullList<ItemStack> items) 
    {
        super.fill(items);

        tabSorter = Ordering.explicit(tabList).onResultOf(ItemStack::getItem);
        items.sort(tabSorter);
    }

    @Override
    public ItemStack createIcon()
    {
        return iconSupplier.get();
    }
}
