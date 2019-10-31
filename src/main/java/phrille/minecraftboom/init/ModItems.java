package phrille.minecraftboom.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.item.ItemPrismarineArrow;
import phrille.minecraftboom.lib.Names;
import phrille.minecraftboom.util.Utils;

@ObjectHolder(MinecraftBoom.MOD_ID)
public class ModItems
{
    public static final Item MAGMA_BRICK = Utils._null();
    public static final Item WITHER_BONE = Utils._null();
    public static final Item PINECONE = Utils._null();
    public static final Item POLAR_BEAR_FUR = Utils._null();
    public static final Item RAW_POLAR_BEAR_MEAT = Utils._null();
    public static final Item POLAR_BEAR_STEAK = Utils._null();
    public static final Item PUMPKIN_SLICE = Utils._null();
    public static final Item COOKED_EGG = Utils._null();
    public static final Item DROWNED_FLESH = Utils._null();
    public static final Item PRISMARINE_ARROW = Utils._null();

    @Mod.EventBusSubscriber(modid = MinecraftBoom.MOD_ID, bus = Bus.MOD)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void onRegisterItems(RegistryEvent.Register<Item> event)
        {
            IForgeRegistry<Item> registry = event.getRegistry();
            registerItemBlocks(registry);

            registerItem(registry, setup(new Item(new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.MAGMA_BRICK));
            registerItem(registry, setup(new Item(new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.WITHER_BONE));
            registerItem(registry, setup(new ItemFood(3, 2.4F, false, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.PINECONE));
            registerItem(registry, setup(new Item(new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.POLAR_BEAR_FUR));
            registerItem(registry, setup(new ItemFood(3, 1.8F, true, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.RAW_POLAR_BEAR_MEAT));
            registerItem(registry, setup(new ItemFood(8, 12.8F, false, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.POLAR_BEAR_STEAK));
            registerItem(registry, setup(new ItemFood(2, 1.2F, false, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.PUMPKIN_SLICE));
            registerItem(registry, setup(new ItemFood(6, 2.8F, false, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.COOKED_EGG));
            registerItem(registry, setup(new ItemFood(4, 0.1F, true, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F).setPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 600, 0), 0.5F), Names.DROWNED_FLESH));
            registerItem(registry, setup(new ItemPrismarineArrow(), Names.PRISMARINE_ARROW));
        }

        private static void registerItem(IForgeRegistry<Item> registry, Item item)
        {
            registerItem(registry, item, false);
        }

        private static void registerItem(IForgeRegistry<Item> registry, Item item, boolean stairSlab)
        {
            registry.register(item);

            if (stairSlab)
            {
                MinecraftBoomTab.MINECRAFTBOOM_STAIRS_AND_SLAB_TAB_LIST.add(item);
            }
            else
            {
                MinecraftBoomTab.MINECRAFTBOOM_TAB_LIST.add(item);
            }
        }
        
        private static void registerItemBlocks(IForgeRegistry<Item> registry) 
        {
            for (Block block : ForgeRegistries.BLOCKS.getValues())
            {
                ResourceLocation blockRegistryName = block.getRegistryName();

                if (!blockRegistryName.getNamespace().equals(MinecraftBoom.MOD_ID))
                {
                    continue;
                }

                boolean stairSlab = (block instanceof BlockSlab || block instanceof BlockStairs);
                Item.Properties properties = new Item.Properties().group(stairSlab ? MinecraftBoomTab.MINECRAFTBOOM_STAIRS_AND_SLAB_TAB : MinecraftBoomTab.MINECRAFTBOOM_TAB);
                ItemBlock blockItem = new ItemBlock(block, properties);
                registerItem(registry, setup(blockItem, blockRegistryName), stairSlab);
            }
        }

        public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name)
        {
            return setup(entry, new ResourceLocation(MinecraftBoom.MOD_ID, name));
        }

        public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName)
        {
            entry.setRegistryName(registryName);
            return entry;
        }
    }
}
