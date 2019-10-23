package phrille.minecraftboom.init;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Ordering;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.block.base.BlockSlabBase;
import phrille.minecraftboom.block.base.BlockStairBase;
import phrille.minecraftboom.util.IStairSlab;

public class CreativeTabs
{
    private static Comparator<ItemStack> tabSorter;

    public static ItemGroupBase getTab(Block block)
    {
        if (block instanceof BlockStairBase || block instanceof BlockSlabBase)
        {
            return STAIRS_AND_SLABS_TAB;
        }

        return MINECRAFTBOOM_TAB;
    }

    public static final ItemGroupBase MINECRAFTBOOM_TAB = new ItemGroupBase(MinecraftBoom.MOD_ID + "_tab")
    {
        public List<Item> minecraftBoomList = new ArrayList();

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

            tabSorter = Ordering.explicit(minecraftBoomList).onResultOf(ItemStack::getItem);
            list.sort(tabSorter);
        }

        @Override
        public List<Item> getList()
        {
            return minecraftBoomList;
        }

    };

    public static final ItemGroupBase STAIRS_AND_SLABS_TAB = new ItemGroupBase(MinecraftBoom.MOD_ID + "_stairs_and_slab_tab")
    {
        public List<Item> stairsAndSlabList = new ArrayList();

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(((IStairSlab) ModBlocks.BLOCK_COBBLESTONE_BRICKS).getStair());
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public void fill(NonNullList<ItemStack> list)
        {
            super.fill(list);

            tabSorter = Ordering.explicit(stairsAndSlabList).onResultOf(ItemStack::getItem);
            list.sort(tabSorter);
        }

        @Override
        public List<Item> getList()
        {
            return stairsAndSlabList;
        }
    };

    public static abstract class ItemGroupBase extends ItemGroup
    {
        public ItemGroupBase(String label)
        {
            super(label);
        }

        public abstract List<Item> getList();
    }
}
