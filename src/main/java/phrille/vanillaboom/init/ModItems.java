package phrille.vanillaboom.init;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.SimpleFoiledItem;
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
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.item.EntitySpawnItem;
import phrille.vanillaboom.item.PaintingItem;
import phrille.vanillaboom.item.PrismarineArrowItem;
import phrille.vanillaboom.util.Names;
import phrille.vanillaboom.util.Utils;
import phrille.vanillaboom.util.VanillaBoomTab;

@ObjectHolder(VanillaBoom.MOD_ID)
public class ModItems
{
    public static final Item MAGMA_BRICK = Utils._null();
    public static final Item WITHER_BONE = Utils._null();
    public static final Item WITHER_BONE_MEAL = Utils._null();
    public static final Item PRISMARINE_ARROW = Utils._null();
    public static final Item POLAR_BEAR_FUR = Utils._null();
    public static final Item RAW_POLAR_BEAR_MEAT = Utils._null();
    public static final Item POLAR_BEAR_STEAK = Utils._null();
    public static final Item PUMPKIN_SLICE = Utils._null();
    public static final Item COOKED_EGG = Utils._null();
    public static final Item DROWNED_FLESH = Utils._null();
    public static final Item PINECONE = Utils._null();
    public static final Item CHOCOLATE = Utils._null();
    public static final Item TOMATO = Utils._null();
    public static final Item TOMATO_SEEDS = Utils._null();

    //Regular Fish
    public static final Item TUNA = Utils._null();
    public static final Item COOKED_TUNA = Utils._null();
    public static final Item PERCH = Utils._null();
    public static final Item COOKED_PERCH = Utils._null();
    public static final Item PIKE = Utils._null();
    public static final Item COOKED_PIKE = Utils._null();
    public static final Item EEL = Utils._null();
    public static final Item COOKED_EEL = Utils._null();

    //Biome Specific Fish
    public static final Item SWAMP_DWELLER = Utils._null();
    public static final Item COOKED_SWAMP_DWELLER = Utils._null();

    //Special Fish
    public static final Item SUNFISH = Utils._null();
    public static final Item MOONFISH = Utils._null();
    public static final Item ENDER_FISH = Utils._null();
    public static final Item WITHER_FISH = Utils._null();

    //Fish Buckets
    public static final Item TUNA_BUCKET = Utils._null();
    public static final Item PERCH_BUCKET = Utils._null();
    public static final Item EEL_BUCKET = Utils._null();
    public static final Item SWAMP_DWELLER_BUCKET = Utils._null();

    //Spawn Eggs
    public static final Item TUNA_SPAWN_EGG = Utils._null();
    public static final Item PERCH_SPAWN_EGG = Utils._null();
    public static final Item EEL_SPAWN_EGG = Utils._null();
    public static final Item SWAMP_DWELLER_SPAWN_EGG = Utils._null();

    public static final Item CANVAS = Utils._null();
    public static final Item SMALL_PAINTING = Utils._null();
    public static final Item HORIZONTAL_PAINTING = Utils._null();
    public static final Item VERTICAL_PAINTING = Utils._null();
    public static final Item MEDIUM_PAINTING = Utils._null();
    public static final Item LARGE_HORIZONTAL_PAINTING = Utils._null();
    public static final Item LARGE_PAINTING = Utils._null();

    public static final Item KEBAB_PAINTING = Utils._null();
    public static final Item AZTEC_PAINTING = Utils._null();
    public static final Item ALBAN_PAINTING = Utils._null();
    public static final Item AZTEC2_PAINTING = Utils._null();
    public static final Item BOMB_PAINTING = Utils._null();
    public static final Item PLANT_PAINTING = Utils._null();
    public static final Item WASTELAND_PAINTING = Utils._null();
    public static final Item POOL_PAINTING = Utils._null();
    public static final Item COURBET_PAINTING = Utils._null();
    public static final Item SEA_PAINTING = Utils._null();
    public static final Item SUNSET_PAINTING = Utils._null();
    public static final Item CREEBET_PAINTING = Utils._null();
    public static final Item WANDERER_PAINTING = Utils._null();
    public static final Item GRAHAM_PAINTING = Utils._null();
    public static final Item MATCH_PAINTING = Utils._null();
    public static final Item BUST_PAINTING = Utils._null();
    public static final Item STAGE_PAINTING = Utils._null();
    public static final Item VOID_PAINTING = Utils._null();
    public static final Item SKULL_AND_ROSES_PAINTING = Utils._null();
    public static final Item WITHER_PAINTING = Utils._null();
    public static final Item FIGHTERS_PAINTING = Utils._null();
    public static final Item POINTER_PAINTING = Utils._null();
    public static final Item PIGSCENE_PAINTING = Utils._null();
    public static final Item BURNING_SKULL_PAINTING = Utils._null();
    public static final Item SKELETON_PAINTING = Utils._null();
    public static final Item DONKEY_KONG_PAINTING = Utils._null();

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Bus.MOD)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void onRegisterItems(RegistryEvent.Register<Item> event)
        {
            IForgeRegistry<Item> registry = event.getRegistry();
            registerItemBlocks(registry);

            registerItem(registry, setup(new Item(new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), Names.MAGMA_BRICK));
            registerItem(registry, setup(new Item(new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), Names.WITHER_BONE));
            registerItem(registry, setup(new Item(new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), Names.WITHER_BONE_MEAL));
            registerItem(registry, setup(new PrismarineArrowItem(), Names.PRISMARINE_ARROW));
            registerItem(registry, setup(new Item(new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), Names.POLAR_BEAR_FUR));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.RAW_POLAR_BEAR_MEAT).group(VanillaBoomTab.VANILLABOOM_TAB)), Names.RAW_POLAR_BEAR_MEAT));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.POLAR_BEAR_STEAK).group(VanillaBoomTab.VANILLABOOM_TAB)), Names.POLAR_BEAR_STEAK));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PUMPKIN_SLICE).group(VanillaBoomTab.VANILLABOOM_TAB)), Names.PUMPKIN_SLICE));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_EGG).group(VanillaBoomTab.VANILLABOOM_TAB)), Names.COOKED_EGG));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.DROWNED_FLESH).group(VanillaBoomTab.VANILLABOOM_TAB)), Names.DROWNED_FLESH));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PINECONE).group(VanillaBoomTab.VANILLABOOM_TAB)), Names.PINECONE));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.CHOCOLATE).group(VanillaBoomTab.VANILLABOOM_TAB)), "chocolate"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.TOMATO).group(VanillaBoomTab.VANILLABOOM_TAB)), "tomato"));
            registerItem(registry, setup(new BlockNamedItem(ModBlocks.TOMATO_PLANT, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), "tomato_seeds"));

            /* TODO: 
             * Fix fish foods
             * Add tags to fish items
             * Add furnace, smoker and campfire recipes
             */     
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.TUNA).group(VanillaBoomTab.VANILLABOOM_TAB)), "tuna"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_TUNA).group(VanillaBoomTab.VANILLABOOM_TAB)), "cooked_tuna"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PERCH).group(VanillaBoomTab.VANILLABOOM_TAB)), "perch"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_PERCH).group(VanillaBoomTab.VANILLABOOM_TAB)), "cooked_perch"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PIKE).group(VanillaBoomTab.VANILLABOOM_TAB)), "pike"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_PIKE).group(VanillaBoomTab.VANILLABOOM_TAB)), "cooked_pike"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.EEL).group(VanillaBoomTab.VANILLABOOM_TAB)), "eel"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_EEL).group(VanillaBoomTab.VANILLABOOM_TAB)), "cooked_eel"));

            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PERCH).group(VanillaBoomTab.VANILLABOOM_TAB)), "swamp_dweller"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PERCH).group(VanillaBoomTab.VANILLABOOM_TAB)), "cooked_swamp_dweller"));

            registerItem(registry, setup(new SimpleFoiledItem(new Item.Properties().food(ModFoods.PERCH).rarity(Rarity.UNCOMMON).group(VanillaBoomTab.VANILLABOOM_TAB)), "sunfish"));
            registerItem(registry, setup(new SimpleFoiledItem(new Item.Properties().food(ModFoods.PERCH).rarity(Rarity.RARE).group(VanillaBoomTab.VANILLABOOM_TAB)), "moonfish"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PERCH).group(VanillaBoomTab.VANILLABOOM_TAB)), "ender_fish"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PERCH).group(VanillaBoomTab.VANILLABOOM_TAB)), "wither_fish"));

            registerItem(registry, setup(new FishBucketItem(() -> ModEntities.TUNA, () -> Fluids.WATER, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), "tuna_bucket"));
            registerItem(registry, setup(new FishBucketItem(() -> ModEntities.PERCH, () -> Fluids.WATER, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), "perch_bucket"));
            registerItem(registry, setup(new FishBucketItem(() -> ModEntities.EEL, () -> Fluids.WATER, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), "eel_bucket"));
            registerItem(registry, setup(new FishBucketItem(() -> ModEntities.SWAMP_DWELLER, () -> Fluids.WATER, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), "swamp_dweller_bucket"));

            registerItem(registry, setup(new EntitySpawnItem(() -> ModEntities.TUNA, 0x33495E, 0x8D8C9F, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), "tuna_spawn_egg"));
            registerItem(registry, setup(new EntitySpawnItem(() -> ModEntities.PERCH, 0x464614, 0xFD5100, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), "perch_spawn_egg"));
            registerItem(registry, setup(new EntitySpawnItem(() -> ModEntities.EEL, 0x443522, 0xCABBA3, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), "eel_spawn_egg"));
            registerItem(registry, setup(new EntitySpawnItem(() -> ModEntities.SWAMP_DWELLER, 0x7E9160, 0x31441C, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), "swamp_dweller_spawn_egg"));

            registerItem(registry, setup(new Item(new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB)), Names.CANVAS));
            registerItem(registry, setup(new PaintingItem(null, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.SMALL_PAINTING));
            registerItem(registry, setup(new PaintingItem(null, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.HORIZONTAL_PAINTING));
            registerItem(registry, setup(new PaintingItem(null, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.VERTICAL_PAINTING));
            registerItem(registry, setup(new PaintingItem(null, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.MEDIUM_PAINTING));
            registerItem(registry, setup(new PaintingItem(null, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.LARGE_HORIZONTAL_PAINTING));
            registerItem(registry, setup(new PaintingItem(null, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.LARGE_PAINTING));

            registerItem(registry, setup(new PaintingItem(PaintingType.KEBAB, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.KEBAB_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.AZTEC, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.AZTEC_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.ALBAN, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.ALBAN_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.AZTEC2, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.AZTEC2_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.BOMB, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.BOMB_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.PLANT, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.PLANT_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.WASTELAND, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.WASTELAND_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.POOL, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.POOL_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.COURBET, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.COURBET_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.SEA, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.SEA_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.SUNSET, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.SUNSET_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.CREEBET, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.CREEBET_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.WANDERER, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.WANDERER_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.GRAHAM, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.GRAHAM_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.MATCH, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.MATCH_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.BUST, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.BUST_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.STAGE, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.STAGE_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.VOID, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.VOID_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.SKULL_AND_ROSES, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.SKULL_AND_ROSES_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.WITHER, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.WITHER_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.FIGHTERS, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.FIGHTERS_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.POINTER, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.POINTER_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.PIGSCENE, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.PIGSCENE_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.BURNING_SKULL, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.BURNING_SKULL_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.SKELETON, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.SKELETON_PAINTING));
            registerItem(registry, setup(new PaintingItem(PaintingType.DONKEY_KONG, new Item.Properties().group(VanillaBoomTab.VANILLABOOM_TAB), true), Names.DONKEY_KONG_PAINTING));
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
                VanillaBoomTab.VANILLABOOM_VARIANT_BLOCKS_TAB_LIST.add(item);
            }
            else
            {
                VanillaBoomTab.VANILLABOOM_TAB_LIST.add(item);
            }
        }

        private static void registerItemBlocks(IForgeRegistry<Item> registry)
        {
            for (Block block : ForgeRegistries.BLOCKS.getValues())
            {
                ResourceLocation blockRegistryName = block.getRegistryName();

                if (!blockRegistryName.getNamespace().equals(VanillaBoom.MOD_ID))
                {
                    continue;
                }

                boolean notAdd = block instanceof FlowerPotBlock || block instanceof IGrowable;

                if (!notAdd)
                {
                    boolean variantBlock = block instanceof SlabBlock || block instanceof StairsBlock || block instanceof WallBlock || block instanceof FenceBlock || block instanceof FenceGateBlock;
                    Item.Properties properties = new Item.Properties().group(variantBlock ? VanillaBoomTab.VANILLABOOM_VARIANT_BLOCKS_TAB : VanillaBoomTab.VANILLABOOM_TAB);
                    BlockItem blockItem = new BlockItem(block, properties);
                    registerItem(registry, setup(blockItem, blockRegistryName), variantBlock);
                }
            }
        }

        public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name)
        {
            return setup(entry, new ResourceLocation(VanillaBoom.MOD_ID, name));
        }

        public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName)
        {
            entry.setRegistryName(registryName);
            return entry;
        }
    }

    public static class ModFoods
    {
        public static final Food RAW_POLAR_BEAR_MEAT = new Food.Builder().hunger(3).saturation(0.3F).meat().build();
        public static final Food POLAR_BEAR_STEAK = new Food.Builder().hunger(8).saturation(0.8F).meat().build();
        public static final Food PUMPKIN_SLICE = new Food.Builder().hunger(2).saturation(0.3F).build();
        public static final Food COOKED_EGG = new Food.Builder().hunger(6).saturation(0.6F).build();
        public static final Food DROWNED_FLESH = new Food.Builder().hunger(4).saturation(0.1F).effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 0.8F).effect(() -> new EffectInstance(Effects.WATER_BREATHING, 600, 0), 0.5F).meat().build();
        public static final Food PINECONE = new Food.Builder().hunger(3).saturation(0.2F).build();
        public static final Food CHOCOLATE = new Food.Builder().hunger(5).saturation(0.3F).build();
        public static final Food TOMATO = new Food.Builder().hunger(4).saturation(0.2F).build();

        public static final Food TUNA = new Food.Builder().hunger(3).saturation(0.1F).build();
        public static final Food COOKED_TUNA = new Food.Builder().hunger(7).saturation(0.6F).build();
        public static final Food PERCH = new Food.Builder().hunger(2).saturation(0.1F).build();
        public static final Food COOKED_PERCH = new Food.Builder().hunger(6).saturation(0.6F).build();
        public static final Food PIKE = new Food.Builder().hunger(2).saturation(0.1F).build();
        public static final Food COOKED_PIKE = new Food.Builder().hunger(7).saturation(0.6F).build();
        public static final Food EEL = new Food.Builder().hunger(2).saturation(0.1F).build();
        public static final Food COOKED_EEL = new Food.Builder().hunger(6).saturation(0.6F).build();
    }
}
