package phrille.minecraftboom;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockMagma;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlime;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import phrille.minecraftboom.block.BlockGoldBars;
import phrille.minecraftboom.block.BlockGunpowder;
import phrille.minecraftboom.block.BlockStairBase;
import phrille.minecraftboom.init.MinecraftBoomTab;
import phrille.minecraftboom.lib.Names;
import phrille.minecraftboom.util.Utils;

@EventBusSubscriber(modid = MinecraftBoom.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber
{
    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();

        //Bricks
        createSpecialBlock(registry, Properties.from(Blocks.COBBLESTONE), Names.COBBLESTONE_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.MOSSY_COBBLESTONE), Names.MOSSY_COBBLESTONE_BRICKS);
        createSpecialBlock(registry, new BlockMagma(Properties.from(Blocks.MAGMA_BLOCK)), Names.MAGMA_BRICKS, false);
        createSpecialBlock(registry, Properties.from(Blocks.OBSIDIAN), Names.OBSIDIAN_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.TERRACOTTA), Names.TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.WHITE_TERRACOTTA), Names.WHITE_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.ORANGE_TERRACOTTA), Names.ORANGE_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.MAGENTA_TERRACOTTA), Names.MAGENTA_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.LIGHT_BLUE_TERRACOTTA), Names.LIGHT_BLUE_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.YELLOW_TERRACOTTA), Names.YELLOW_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.LIME_TERRACOTTA), Names.LIME_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.PINK_TERRACOTTA), Names.PINK_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.GRAY_TERRACOTTA), Names.GRAY_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.LIGHT_GRAY_TERRACOTTA), Names.LIGHT_GRAY_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.CYAN_TERRACOTTA), Names.CYAN_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.PURPLE_TERRACOTTA), Names.PURPLE_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.BLUE_TERRACOTTA), Names.BLUE_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.BROWN_TERRACOTTA), Names.BROWN_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.GREEN_TERRACOTTA), Names.GREEN_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.RED_TERRACOTTA), Names.RED_TERRACOTTA_BRICKS);
        createSpecialBlock(registry, Properties.from(Blocks.BLACK_TERRACOTTA), Names.BLACK_TERRACOTTA_BRICKS);

        //Gravel
        registry.register(setup(new BlockFalling(Properties.from(Blocks.GRAVEL)), Names.FINE_GRAVEL));
        createSpecialBlock(registry, Properties.from(Blocks.STONE), Names.GRAVEL_STONE);
        createSpecialBlock(registry, Properties.from(Blocks.STONE), Names.FINE_GRAVEL_STONE);
        createSpecialBlock(registry, Properties.from(Blocks.STONE_BRICKS), Names.GRAVEL_BRICKS);

        //Polished
        createSpecialBlock(registry, Properties.from(Blocks.PRISMARINE), Names.POLISHED_PRISMARINE);
        createSpecialBlock(registry, Properties.from(Blocks.DARK_PRISMARINE), Names.POLISHED_DARK_PRISMARINE);
        createSpecialBlock(registry, Properties.from(Blocks.END_STONE), Names.POLISHED_END_STONE);
        createSpecialBlock(registry, Properties.from(Blocks.NETHERRACK), Names.POLISHED_NETHERRACK);

        //Pillars
        registry.register(setup(new BlockRotatedPillar(Properties.from(Blocks.GRANITE)), Names.GRANITE_PILLAR));
        registry.register(setup(new BlockRotatedPillar(Properties.from(Blocks.DIORITE)), Names.DIORITE_PILLAR));
        registry.register(setup(new BlockRotatedPillar(Properties.from(Blocks.ANDESITE)), Names.ANDESITE_PILLAR));
        registry.register(setup(new BlockRotatedPillar(Properties.from(Blocks.PRISMARINE)), Names.PRISMARINE_PILLAR));
        registry.register(setup(new BlockRotatedPillar(Properties.from(Blocks.DARK_PRISMARINE)), Names.DARK_PRISMARINE_PILLAR));
        registry.register(setup(new BlockRotatedPillar(Properties.from(Blocks.END_STONE)), Names.END_STONE_PILLAR));
        registry.register(setup(new BlockRotatedPillar(Properties.from(Blocks.NETHERRACK)), Names.NETHERRACK_PILLAR));

        //Storage Blocks
        registry.register(setup(new Block(Properties.from(Blocks.COAL_BLOCK)), Names.CHARCOAL_BLOCK));
        registry.register(setup(new BlockFalling(Properties.create(Material.SAND, MaterialColor.SNOW).hardnessAndResistance(0.5F, 0.0F).sound(SoundType.SAND)), Names.SUGAR_BLOCK));
        registry.register(setup(new BlockRotatedPillar(Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.5F, 0.0F)), Names.SUGAR_CANE_BLOCK));
        registry.register(setup(new BlockGunpowder(), Names.GUNPOWDER_BLOCK));
        registry.register(setup(new BlockFalling(Properties.from(Blocks.SAND).sound(SoundType.SNOW)), Names.BLAZE_POWDER_BLOCK));
        registry.register(setup(new BlockSlime(Properties.from(Blocks.SLIME_BLOCK)), Names.MAGMA_CREAM_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.GLASS, MaterialColor.CYAN).hardnessAndResistance(0.3F, 0.5F).sound(SoundType.GLASS).lightValue(5)), Names.PRISMARINE_CRYSTAL_BLOCK));
        registry.register(setup(new BlockRotatedPillar(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.8F, 3.33F)), Names.WITHER_BONE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.WOOL).hardnessAndResistance(3.0F, 5.0F)), Names.WHITE_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.ADOBE).hardnessAndResistance(3.0F, 5.0F)), Names.ORANGE_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.MAGENTA).hardnessAndResistance(3.0F, 5.0F)), Names.MAGENTA_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE).hardnessAndResistance(3.0F, 5.0F)), Names.LIGHT_BLUE_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.YELLOW).hardnessAndResistance(3.0F, 5.0F)), Names.YELLOW_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.LIME).hardnessAndResistance(3.0F, 5.0F)), Names.LIME_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.PINK).hardnessAndResistance(3.0F, 5.0F)), Names.PINK_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(3.0F, 5.0F)), Names.GRAY_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 5.0F)), Names.LIGHT_GRAY_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.CYAN).hardnessAndResistance(3.0F, 5.0F)), Names.CYAN_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(3.0F, 5.0F)), Names.PURPLE_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(3.0F, 5.0F)), Names.BROWN_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.GREEN).hardnessAndResistance(3.0F, 5.0F)), Names.GREEN_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(3.0F, 5.0F)), Names.RED_DYE_BLOCK));
        registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(3.0F, 5.0F)), Names.BLACK_DYE_BLOCK));

        //Glass
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.WHITE, Properties.from(Blocks.GLASS)), Names.SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.WHITE, Properties.from(Blocks.WHITE_STAINED_GLASS)), Names.WHITE_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.ORANGE, Properties.from(Blocks.ORANGE_STAINED_GLASS)), Names.ORANGE_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.MAGENTA, Properties.from(Blocks.MAGENTA_STAINED_GLASS)), Names.MAGENTA_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.LIGHT_BLUE, Properties.from(Blocks.LIGHT_BLUE_STAINED_GLASS)), Names.LIGHT_BLUE_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.YELLOW, Properties.from(Blocks.YELLOW_STAINED_GLASS)), Names.YELLOW_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.LIME, Properties.from(Blocks.LIME_STAINED_GLASS)), Names.LIME_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.PINK, Properties.from(Blocks.PINK_STAINED_GLASS)), Names.PINK_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.GRAY, Properties.from(Blocks.GRAY_STAINED_GLASS)), Names.GRAY_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.LIGHT_GRAY, Properties.from(Blocks.LIGHT_GRAY_STAINED_GLASS)), Names.LIGHT_GRAY_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.CYAN, Properties.from(Blocks.CYAN_STAINED_GLASS)), Names.CYAN_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.PURPLE, Properties.from(Blocks.PURPLE_STAINED_GLASS)), Names.PURPLE_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.BLUE, Properties.from(Blocks.BLUE_STAINED_GLASS)), Names.BLUE_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.BROWN, Properties.from(Blocks.BROWN_STAINED_GLASS)), Names.BROWN_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.GREEN, Properties.from(Blocks.GREEN_STAINED_GLASS)), Names.GREEN_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.RED, Properties.from(Blocks.RED_STAINED_GLASS)), Names.RED_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlass(EnumDyeColor.BLACK, Properties.from(Blocks.BLACK_STAINED_GLASS)), Names.BLACK_STAINED_SOUL_GLASS));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.WHITE, Properties.from(Blocks.GLASS_PANE)), Names.SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.WHITE, Properties.from(Blocks.WHITE_STAINED_GLASS_PANE)), Names.WHITE_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.ORANGE, Properties.from(Blocks.ORANGE_STAINED_GLASS_PANE)), Names.ORANGE_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.MAGENTA, Properties.from(Blocks.MAGENTA_STAINED_GLASS_PANE)), Names.MAGENTA_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.LIGHT_BLUE, Properties.from(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE)), Names.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.YELLOW, Properties.from(Blocks.YELLOW_STAINED_GLASS_PANE)), Names.YELLOW_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.LIME, Properties.from(Blocks.LIME_STAINED_GLASS_PANE)), Names.LIME_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.PINK, Properties.from(Blocks.PINK_STAINED_GLASS_PANE)), Names.PINK_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.GRAY, Properties.from(Blocks.GRAY_STAINED_GLASS_PANE)), Names.GRAY_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.LIGHT_GRAY, Properties.from(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE)), Names.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.CYAN, Properties.from(Blocks.CYAN_STAINED_GLASS_PANE)), Names.CYAN_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.PURPLE, Properties.from(Blocks.PURPLE_STAINED_GLASS_PANE)), Names.PURPLE_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.BLUE, Properties.from(Blocks.BLUE_STAINED_GLASS_PANE)), Names.BLUE_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.BROWN, Properties.from(Blocks.BROWN_STAINED_GLASS_PANE)), Names.BROWN_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.GREEN, Properties.from(Blocks.GREEN_STAINED_GLASS_PANE)), Names.GREEN_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.RED, Properties.from(Blocks.RED_STAINED_GLASS_PANE)), Names.RED_STAINED_SOUL_GLASS_PANE));
        registry.register(setup(new BlockStainedGlassPane(EnumDyeColor.BLACK, Properties.from(Blocks.BLACK_STAINED_GLASS_PANE)), Names.BLACK_STAINED_SOUL_GLASS_PANE));

        //Misc
        registry.register(setup(new BlockGoldBars(), Names.GOLD_BARS));
        registry.register(setup(new BlockFlower(Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F).doesNotBlockMovement().sound(SoundType.PLANT)), Names.ROSE));

        //Vanilla Stairs and Slabs
        createSpecialBlock(registry, Blocks.STONE, "stone", true);
        createSpecialBlock(registry, Blocks.GRANITE, "granite", true);
        createSpecialBlock(registry, Blocks.POLISHED_GRANITE, "polished_granite", true);
        createSpecialBlock(registry, Blocks.DIORITE, "diorite", true);
        createSpecialBlock(registry, Blocks.POLISHED_DIORITE, "polished_diorite", true);
        createSpecialBlock(registry, Blocks.ANDESITE, "andesite", true);
        createSpecialBlock(registry, Blocks.POLISHED_ANDESITE, "polished_andesite", true);
        createSpecialBlock(registry, Blocks.MOSSY_COBBLESTONE, "mossy_cobblestone", true);
        createSpecialBlock(registry, Blocks.MOSSY_STONE_BRICKS, "mossy_stone_bricks", true);
        createSpecialBlock(registry, Blocks.CRACKED_STONE_BRICKS, "cracked_stone_bricks", true);
        createSpecialBlock(registry, Blocks.CHISELED_STONE_BRICKS, "chiseled_stone_bricks", true);
        createSpecialBlock(registry, Blocks.CUT_SANDSTONE, "cut_sandstone", true);
        createSpecialBlock(registry, Blocks.CHISELED_SANDSTONE, "chiseled_sandstone", true);
        createSpecialBlock(registry, Blocks.SMOOTH_SANDSTONE, "smooth_sandstone", true);
        createSpecialBlock(registry, Blocks.CUT_RED_SANDSTONE, "cut_red_sandstone", true);
        createSpecialBlock(registry, Blocks.CHISELED_RED_SANDSTONE, "chiseled_red_sandstone", true);
        createSpecialBlock(registry, Blocks.SMOOTH_RED_SANDSTONE, "smooth_red_sandstone", true);
        createSpecialBlock(registry, Blocks.OAK_WOOD, "oak_wood", true);
        createSpecialBlock(registry, Blocks.SPRUCE_WOOD, "spruce_wood", true);
        createSpecialBlock(registry, Blocks.BIRCH_WOOD, "birch_wood", true);
        createSpecialBlock(registry, Blocks.JUNGLE_WOOD, "jungle_wood", true);
        createSpecialBlock(registry, Blocks.ACACIA_WOOD, "acacia_wood", true);
        createSpecialBlock(registry, Blocks.DARK_OAK_WOOD, "dark_oak_wood", true);
        createSpecialBlock(registry, Blocks.IRON_BLOCK, "iron_block", true);
        createSpecialBlock(registry, Blocks.GOLD_BLOCK, "gold_block", true);
        createSpecialBlock(registry, Blocks.OBSIDIAN, "obsidian", true);
        createSpecialBlock(registry, Blocks.NETHERRACK, "netherrack", true);
        createSpecialBlock(registry, Blocks.RED_NETHER_BRICKS, "red_nether_bricks", true);
        createSpecialBlock(registry, Blocks.END_STONE, "end_stone", true);
        createSpecialBlock(registry, Blocks.END_STONE_BRICKS, "end_stone_bricks", true);
        createSpecialBlock(registry, Blocks.CHISELED_QUARTZ_BLOCK, "chiseled_quartz_block", true);
        createSpecialBlock(registry, Blocks.TERRACOTTA, "terracotta", true);
        createSpecialBlock(registry, Blocks.WHITE_TERRACOTTA, "white_terracotta", true);
        createSpecialBlock(registry, Blocks.ORANGE_TERRACOTTA, "orange_terracotta", true);
        createSpecialBlock(registry, Blocks.MAGENTA_TERRACOTTA, "magenta_terracotta", true);
        createSpecialBlock(registry, Blocks.LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta", true);
        createSpecialBlock(registry, Blocks.YELLOW_TERRACOTTA, "yellow_terracotta", true);
        createSpecialBlock(registry, Blocks.LIME_TERRACOTTA, "lime_terracotta", true);
        createSpecialBlock(registry, Blocks.PINK_TERRACOTTA, "pink_terracotta", true);
        createSpecialBlock(registry, Blocks.GRAY_TERRACOTTA, "gray_terracotta", true);
        createSpecialBlock(registry, Blocks.LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta", true);
        createSpecialBlock(registry, Blocks.CYAN_TERRACOTTA, "cyan_terracotta", true);
        createSpecialBlock(registry, Blocks.PURPLE_TERRACOTTA, "purple_terracotta", true);
        createSpecialBlock(registry, Blocks.BLUE_TERRACOTTA, "blue_terracotta", true);
        createSpecialBlock(registry, Blocks.BROWN_TERRACOTTA, "brown_terracotta", true);
        createSpecialBlock(registry, Blocks.GREEN_TERRACOTTA, "green_terracotta", true);
        createSpecialBlock(registry, Blocks.RED_TERRACOTTA, "red_terracotta", true);
        createSpecialBlock(registry, Blocks.BLACK_TERRACOTTA, "black_terracotta", true);
        createSpecialBlock(registry, Blocks.WHITE_CONCRETE, "white_concrete", true);
        createSpecialBlock(registry, Blocks.ORANGE_CONCRETE, "orange_concrete", true);
        createSpecialBlock(registry, Blocks.MAGENTA_CONCRETE, "magenta_concrete", true);
        createSpecialBlock(registry, Blocks.LIGHT_BLUE_CONCRETE, "light_blue_concrete", true);
        createSpecialBlock(registry, Blocks.YELLOW_CONCRETE, "yellow_concrete", true);
        createSpecialBlock(registry, Blocks.LIME_CONCRETE, "lime_concrete", true);
        createSpecialBlock(registry, Blocks.PINK_CONCRETE, "pink_concrete", true);
        createSpecialBlock(registry, Blocks.GRAY_CONCRETE, "gray_concrete", true);
        createSpecialBlock(registry, Blocks.LIGHT_GRAY_CONCRETE, "light_gray_concrete", true);
        createSpecialBlock(registry, Blocks.CYAN_CONCRETE, "cyan_concrete", true);
        createSpecialBlock(registry, Blocks.PURPLE_CONCRETE, "purple_concrete", true);
        createSpecialBlock(registry, Blocks.BLUE_CONCRETE, "blue_concrete", true);
        createSpecialBlock(registry, Blocks.BROWN_CONCRETE, "brown_concrete", true);
        createSpecialBlock(registry, Blocks.GREEN_CONCRETE, "green_concrete", true);
        createSpecialBlock(registry, Blocks.RED_CONCRETE, "red_concrete", true);
        createSpecialBlock(registry, Blocks.BLACK_CONCRETE, "black_concrete", true);
        registry.register(setup(new BlockStairBase(Blocks.SMOOTH_STONE), "smooth_stone_stairs"));
    }

    private static void createSpecialBlock(IForgeRegistry<Block> registry, Properties builder, String name)
    {
        createSpecialBlock(registry, new Block(builder), name, false);
    }

    private static void createSpecialBlock(IForgeRegistry<Block> registry, Block block, String name, boolean vanilla)
    {
        if (!vanilla)
        {
            registry.register(setup(block, name));
        }

        registry.register(setup(new BlockStairBase(block), Utils.getStairName(name)));
        registry.register(setup(new BlockSlab(Properties.from(block)), Utils.getSlabName(name)));
    }

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();

        for (Block block : ForgeRegistries.BLOCKS.getValues())
        {
            ResourceLocation blockRegistryName = block.getRegistryName();

            if (!blockRegistryName.getNamespace().equals(MinecraftBoom.MOD_ID))
            {
                continue;
            }

            ItemGroup group = MinecraftBoomTab.MINECRAFTBOOM_TAB;

            if (block instanceof BlockSlab || block instanceof BlockStairs)
            {
                group = MinecraftBoomTab.MINECRAFTBOOM_STAIRS_AND_SLAB_TAB;
            }

            Item.Properties properties = new Item.Properties().group(group);
            ItemBlock blockItem = new ItemBlock(block, properties);
            registry.register(setup(blockItem, blockRegistryName));
        }

        registry.register(setup(new Item(new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.MAGMA_BRICK));
        registry.register(setup(new Item(new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.WITHER_BONE));
        registry.register(setup(new ItemFood(3, 2.4F, false, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.PINECONE));
        registry.register(setup(new Item(new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.POLAR_BEAR_FUR));
        registry.register(setup(new ItemFood(3, 1.8F, true, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.RAW_POLAR_BEAR_MEAT));
        registry.register(setup(new ItemFood(8, 12.8F, false, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.POLAR_BEAR_STEAK));
        registry.register(setup(new ItemFood(2, 1.2F, false, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.PUMPKIN_SLICE));
        registry.register(setup(new ItemFood(6, 2.8F, false, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.COOKED_EGG));
        registry.register(setup(new ItemFood(4, 0.1F, true, new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F).setPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 600, 0), 0.5F), Names.DROWNED_FLESH));
        registry.register(setup(new Item(new Item.Properties().group(MinecraftBoomTab.MINECRAFTBOOM_TAB)), Names.PRISMARINE_ARROW));
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
