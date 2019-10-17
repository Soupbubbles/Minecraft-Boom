package phrille.minecraftboom.init;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Ordering;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import phrille.minecraftboom.MinecraftBoom;

public class CreativeTabs
{
    public static List<Item> tabList = new ArrayList();
    private static Comparator<ItemStack> tabSorter;
    
    public static final ItemGroup MINECRAFTBOOM_TAB = new ItemGroup(MinecraftBoom.MOD_ID + "_tab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.BLOCK_COBBLESTONE_BRICKS);
        }
        
        @OnlyIn(Dist.CLIENT)
        @Override
        public void fill(NonNullList<ItemStack> list)
        {
            super.fill(list);
            
            tabSorter = Ordering.explicit(tabList).onResultOf(ItemStack::getItem);
            list.sort(tabSorter);
        }
    };
}
