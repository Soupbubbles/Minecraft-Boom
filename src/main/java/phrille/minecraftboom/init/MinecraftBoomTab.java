package phrille.minecraftboom.init;

import java.util.function.Supplier;

import net.minecraft.init.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import phrille.minecraftboom.MinecraftBoom;

public class MinecraftBoomTab extends ItemGroup
{
    public static final ItemGroup MINECRAFTBOOM_TAB = new MinecraftBoomTab(MinecraftBoom.MOD_ID + "_tab", () -> new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICKS));
    public static final ItemGroup MINECRAFTBOOM_STAIRS_AND_SLAB_TAB = new MinecraftBoomTab(MinecraftBoom.MOD_ID + "_stairs_and_slab_tab", () -> new ItemStack(ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB));

    private final Supplier<ItemStack> iconSupplier;

    public MinecraftBoomTab(String name, Supplier<ItemStack> icon)
    {
        super(name);
        iconSupplier = icon;
    }

    @Override
    public ItemStack createIcon()
    {
        return iconSupplier.get();
    }
}
