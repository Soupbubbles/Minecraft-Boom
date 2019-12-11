package phrille.minecraftboom.init;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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
import phrille.minecraftboom.item.PaintingItem;
import phrille.minecraftboom.item.PrismarineArrowItem;
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
    public static final Item RICE = Utils._null();

    public static final Item AZTEC_PAINTING = Utils._null();
    public static final Item COURBET_PAINTING = Utils._null();
    public static final Item GRAHAM_PAINTING = Utils._null();
    public static final Item SKULL_AND_ROSES_PAINTING = Utils._null();
    public static final Item FIGHTERS_PAINTING = Utils._null();
    public static final Item POINTER_PAINTING = Utils._null();

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
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PINECONE).group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.PINECONE));
            registerItem(registry, setup(new Item(new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.POLAR_BEAR_FUR));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.RAW_POLAR_BEAR_MEAT).group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.RAW_POLAR_BEAR_MEAT));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.POLAR_BEAR_STEAK).group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.POLAR_BEAR_STEAK));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PUMPKIN_SLICE).group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.PUMPKIN_SLICE));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_EGG).group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.COOKED_EGG));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.DROWNED_FLESH).group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.DROWNED_FLESH));
            registerItem(registry, setup(new PrismarineArrowItem(), Names.PRISMARINE_ARROW));
            registerItem(registry, setup(new BlockNamedItem(ModBlocks.RICE, new Item.Properties().food(ModFoods.RICE).group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.RICE));

            registerItem(registry, setup(new PaintingItem(PaintingType.KEBAB, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.KEBAB_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.AZTEC, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.AZTEC_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.ALBAN, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.ALBAN_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.AZTEC2, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.AZTEC2_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.BOMB, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.BOMB_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.PLANT, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.PLANT_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.WASTELAND, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.WASTELAND_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.POOL, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.POOL_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.COURBET, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.COURBET_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.SEA, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.SEA_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.SUNSET, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.SUNSET_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.CREEBET, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.CREEBET_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.WANDERER, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.WANDERER_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.GRAHAM, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.GRAHAM_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.MATCH, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.MATCH_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.BUST, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.BUST_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.STAGE, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.STAGE_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.VOID, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.VOID_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.SKULL_AND_ROSES, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.SKULL_AND_ROSES_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.WITHER, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.WITHER_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.FIGHTERS, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.FIGHTERS_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.POINTER, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.POINTER_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.PIGSCENE, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.PIGSCENE_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.BURNING_SKULL, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.BURNING_SKULL_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.SKELETON, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.SKELETON_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.DONKEY_KONG, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.DONKEY_KONG_PAINTING));
        }

        private static void registerItem(IForgeRegistry<Item> registry, Item item)
        {
            registerItem(registry, item, false);
        }

        private static void registerItem(IForgeRegistry<Item> registry, Item item, boolean variantBlock)
        {
            registry.register(item);

            if (variantBlock)
            {
                MinecraftBoomTab.MINECRAFTBOOM_VARIANT_BLOCKS_TAB_LIST.add(item);
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

                boolean notAdd = block instanceof FlowerPotBlock || block instanceof CropsBlock;

                if (!notAdd)
                {
                    boolean variantBlock = block instanceof SlabBlock || block instanceof StairsBlock || block instanceof WallBlock || block instanceof FenceBlock || block instanceof FenceGateBlock;
                    Item.Properties properties = new Item.Properties().group(variantBlock ? MinecraftBoomTab.MINECRAFTBOOM_VARIANT_BLOCKS_TAB : MinecraftBoomTab.MINECRAFTBOOM_TAB);
                    BlockItem blockItem = new BlockItem(block, properties);
                    registerItem(registry, setup(blockItem, blockRegistryName), variantBlock);
                }
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

    public static class ModFoods
    {
        public static final Food PINECONE = new Food.Builder().hunger(3).saturation(0.5F).build();
        public static final Food RAW_POLAR_BEAR_MEAT = new Food.Builder().hunger(3).saturation(1.8F).meat().build();
        public static final Food POLAR_BEAR_STEAK = new Food.Builder().hunger(8).saturation(12.8F).meat().build();
        public static final Food PUMPKIN_SLICE = new Food.Builder().hunger(2).saturation(1.2F).build();
        public static final Food COOKED_EGG = new Food.Builder().hunger(6).saturation(2.8F).build();
        public static final Food DROWNED_FLESH = new Food.Builder().hunger(4).saturation(0.1F).effect(new EffectInstance(Effects.HUNGER, 600, 0), 0.8F).effect(new EffectInstance(Effects.WATER_BREATHING, 600, 0), 0.5F).meat().build();
        public static final Food RICE = new Food.Builder().hunger(4).saturation(0.5F).build();
    }
}
