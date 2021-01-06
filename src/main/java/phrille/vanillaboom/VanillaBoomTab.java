package phrille.vanillaboom;

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
import phrille.vanillaboom.init.ModBlocks;

public class VanillaBoomTab extends ItemGroup
{
    public static final List<Item> VANILLABOOM_TAB_LIST = new ArrayList<Item>();
    public static final List<Item> VANILLABOOM_VARIANT_BLOCKS_TAB_LIST = new ArrayList<Item>();
    
    public static final ItemGroup VANILLABOOM_TAB = new VanillaBoomTab(VanillaBoom.MOD_ID + "_tab", () -> new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICKS), VANILLABOOM_TAB_LIST);
    public static final ItemGroup VANILLABOOM_VARIANT_BLOCKS_TAB = new VanillaBoomTab(VanillaBoom.MOD_ID + "_variant_blocks_tab", () -> new ItemStack(ModBlocks.MAGMA_BRICK_STAIRS), VANILLABOOM_VARIANT_BLOCKS_TAB_LIST);

    private final Supplier<ItemStack> iconSupplier;
    private final List<Item> tabList;
    private static Comparator<ItemStack> tabSorter;
    
    public VanillaBoomTab(String name, Supplier<ItemStack> icon, List<Item> list)
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
