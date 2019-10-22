package phrille.minecraftboom.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.block.BlockGunpowder;
import phrille.minecraftboom.block.BlockMagmaBricks;
import phrille.minecraftboom.block.BlockMagmaCream;
import phrille.minecraftboom.block.BlockRose;
import phrille.minecraftboom.block.base.BlockBase;
import phrille.minecraftboom.block.base.BlockFallingBase;
import phrille.minecraftboom.block.base.BlockPillarBase;
import phrille.minecraftboom.block.base.BlockStairBase;
import phrille.minecraftboom.item.ItemBlockBase;
import phrille.minecraftboom.lib.BlockValues;
import phrille.minecraftboom.lib.FuelValues;
import phrille.minecraftboom.lib.Names;
import phrille.minecraftboom.util.IStairSlab;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final List<Block> STAIR_SLAB_LIST = new ArrayList<>();

    //Bricks
    public static final Block BLOCK_COBBLESTONE_BRICKS;
    public static final Block BLOCK_MOSSY_COBBLESTONE_BRICKS;
    public static final Block BLOCK_MAGMA_BRICKS;
    public static final Block BLOCK_OBSIDIAN_BRICKS;
    public static final Block BLOCK_TERRACOTTA_BRICKS;
    public static final Block BLOCK_WHITE_TERRACOTTA_BRICKS;
    public static final Block BLOCK_ORANGE_TERRACOTTA_BRICKS;
    public static final Block BLOCK_MAGENTA_TERRACOTTA_BRICKS;
    public static final Block BLOCK_LIGHT_BLUE_TERRACOTTA_BRICKS;
    public static final Block BLOCK_YELLOW_TERRACOTTA_BRICKS;
    public static final Block BLOCK_LIME_TERRACOTTA_BRICKS;
    public static final Block BLOCK_PINK_TERRACOTTA_BRICKS;
    public static final Block BLOCK_GRAY_TERRACOTTA_BRICKS;
    public static final Block BLOCK_LIGHT_GRAY_TERRACOTTA_BRICKS;
    public static final Block BLOCK_CYAN_TERRACOTTA_BRICKS;
    public static final Block BLOCK_PURPLE_TERRACOTTA_BRICKS;
    public static final Block BLOCK_BLUE_TERRACOTTA_BRICKS;
    public static final Block BLOCK_BROWN_TERRACOTTA_BRICKS;
    public static final Block BLOCK_GREEN_TERRACOTTA_BRICKS;
    public static final Block BLOCK_RED_TERRACOTTA_BRICKS;
    public static final Block BLOCK_BLACK_TERRACOTTA_BRICKS;

    //Gravel
    public static final Block BLOCK_FINE_GRAVEL;
    public static final Block BLOCK_GRAVEL_STONE;
    public static final Block BLOCK_FINE_GRAVEL_STONE;
    public static final Block BLOCK_GRAVEL_BRICKS;

    //Polished
    public static final Block BLOCK_POLISHED_PRISMARINE;
    public static final Block BLOCK_POLISHED_DARK_PRISMARINE;
    public static final Block BLOCK_POLISHED_END_STONE;
    public static final Block BLOCK_POLISHED_NETHERRACK;

    //Pillars
    public static final Block BLOCK_GRANITE_PILLAR;
    public static final Block BLOCK_DIORITE_PILLAR;
    public static final Block BLOCK_ANDESITE_PILLAR;
    public static final Block BLOCK_PRISMARINE_PILLAR;
    public static final Block BLOCK_DARK_PRISMARINE_PILLAR;
    public static final Block BLOCK_END_STONE_PILLAR;
    public static final Block BLOCK_NETHERRACK_PILLAR;

    //Storage
    public static final Block BLOCK_CHARCOAL;
    public static final Block BLOCK_SUGAR;
    public static final Block BLOCK_SUGAR_CANE;
    public static final Block BLOCK_GUNPOWDER;
    public static final Block BLOCK_BLAZE_POWDER;
    public static final Block BLOCK_MAGMA_CREAM;
    public static final Block BLOCK_PRISMARINE_CRYSTAL;
    public static final Block BLOCK_WITHER_BONE;
    public static final Block BLOCK_WHITE_DYE;
    public static final Block BLOCK_ORANGE_DYE;
    public static final Block BLOCK_MAGENTA_DYE;
    public static final Block BLOCK_LIGHT_BLUE_DYE;
    public static final Block BLOCK_YELLOW_DYE;
    public static final Block BLOCK_LIME_DYE;
    public static final Block BLOCK_PINK_DYE;
    public static final Block BLOCK_GRAY_DYE;
    public static final Block BLOCK_LIGHT_GRAY_DYE;
    public static final Block BLOCK_CYAN_DYE;
    public static final Block BLOCK_PURPLE_DYE;
    public static final Block BLOCK_BROWN_DYE;
    public static final Block BLOCK_GREEN_DYE;
    public static final Block BLOCK_RED_DYE;
    public static final Block BLOCK_BLACK_DYE;

    public static final Block BLOCK_ROSE;

    static
    {
        BLOCK_COBBLESTONE_BRICKS = registerBlock(new BlockBase(Names.BLOCK_COBBLESTONE_BRICKS, MaterialColor.STONE, BlockValues.COBBLESTONE_HARDNESS, BlockValues.COBBLESTONE_RESISTANCE).addStairSlab());
        BLOCK_MOSSY_COBBLESTONE_BRICKS = registerBlock(new BlockBase(Names.BLOCK_MOSSY_COBBLESTONE_BRICKS, MaterialColor.STONE, BlockValues.COBBLESTONE_HARDNESS, BlockValues.COBBLESTONE_RESISTANCE).addStairSlab());
        BLOCK_MAGMA_BRICKS = registerBlock(new BlockMagmaBricks().addStairSlab());
        BLOCK_OBSIDIAN_BRICKS = registerBlock(new BlockBase(Names.BLOCK_OBSIDIAN_BRICKS, Material.ROCK, MaterialColor.OBSIDIAN, BlockValues.OBSIDIAN_HARDNESS, BlockValues.OBSIDIAN_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.ADOBE, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_WHITE_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_WHITE_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.WHITE_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_ORANGE_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_ORANGE_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.ORANGE_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_MAGENTA_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_MAGENTA_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_LIGHT_BLUE_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_LIGHT_BLUE_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.LIGHT_BLUE_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_YELLOW_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_YELLOW_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.YELLOW_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_LIME_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_LIME_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.LIME_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_PINK_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_PINK_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.PINK_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_GRAY_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_GRAY_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.GRAY_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_LIGHT_GRAY_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_LIGHT_GRAY_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.LIGHT_GRAY_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_CYAN_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_CYAN_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.CYAN_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_PURPLE_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_PURPLE_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.PURPLE_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_BLUE_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_BLUE_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.BLUE_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_BROWN_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_BROWN_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.BROWN_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_GREEN_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_GREEN_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.GREEN_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_RED_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_RED_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.RED_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());
        BLOCK_BLACK_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_BLACK_TERRACOTTA_BRICKS, Material.ROCK, MaterialColor.BLACK_TERRACOTTA, BlockValues.TERRACOTTA_HARDNESS, BlockValues.TERRACOTTA_RESISTANCE, SoundType.STONE).addStairSlab());

        BLOCK_FINE_GRAVEL = registerBlock(new BlockFallingBase(Names.BLOCK_FINE_GRAVEL, MaterialColor.STONE, SoundType.GROUND));
        BLOCK_GRAVEL_STONE = registerBlock(new BlockBase(Names.BLOCK_GRAVEL_STONE).addStairSlab());
        BLOCK_FINE_GRAVEL_STONE = registerBlock(new BlockBase(Names.BLOCK_FINE_GRAVEL_STONE).addStairSlab());
        BLOCK_GRAVEL_BRICKS = registerBlock(new BlockBase(Names.BLOCK_GRAVEL_BRICKS).addStairSlab());

        BLOCK_POLISHED_PRISMARINE = registerBlock(new BlockBase(Names.BLOCK_POLISHED_PRISMARINE, MaterialColor.CYAN).addStairSlab());
        BLOCK_POLISHED_DARK_PRISMARINE = registerBlock(new BlockBase(Names.BLOCK_POLISHED_DARK_PRISMARINE, MaterialColor.DIAMOND).addStairSlab());
        BLOCK_POLISHED_END_STONE = registerBlock(new BlockBase(Names.BLOCK_POLISHED_END_STONE, MaterialColor.SAND).addStairSlab());
        BLOCK_POLISHED_NETHERRACK = registerBlock(new BlockBase(Names.BLOCK_POLISHED_NETHERRACK, MaterialColor.NETHERRACK).addStairSlab());

        BLOCK_GRANITE_PILLAR = registerBlock(new BlockPillarBase(Names.BLOCK_GRANITE_PILLAR, Material.ROCK, MaterialColor.DIRT, BlockValues.STONE_HARDNESS, BlockValues.STONE_RESISTANCE, SoundType.STONE));
        BLOCK_DIORITE_PILLAR = registerBlock(new BlockPillarBase(Names.BLOCK_DIORITE_PILLAR, Material.ROCK, MaterialColor.QUARTZ, BlockValues.STONE_HARDNESS, BlockValues.STONE_RESISTANCE, SoundType.STONE));
        BLOCK_ANDESITE_PILLAR = registerBlock(new BlockPillarBase(Names.BLOCK_ANDESITE_PILLAR, Material.ROCK, MaterialColor.STONE, BlockValues.STONE_HARDNESS, BlockValues.STONE_RESISTANCE, SoundType.STONE));
        BLOCK_PRISMARINE_PILLAR = registerBlock(new BlockPillarBase(Names.BLOCK_PRISMARINE_PILLAR, Material.ROCK, MaterialColor.CYAN, BlockValues.STONE_HARDNESS, BlockValues.STONE_RESISTANCE, SoundType.STONE));
        BLOCK_DARK_PRISMARINE_PILLAR = registerBlock(new BlockPillarBase(Names.BLOCK_DARK_PRISMARINE_PILLAR, Material.ROCK, MaterialColor.DIAMOND, BlockValues.STONE_HARDNESS, BlockValues.STONE_RESISTANCE, SoundType.STONE));
        BLOCK_END_STONE_PILLAR = registerBlock(new BlockPillarBase(Names.BLOCK_END_STONE_PILLAR, Material.ROCK, MaterialColor.SAND, BlockValues.END_STONE_HARDNESS, BlockValues.END_STONE_RESISTANCE, SoundType.STONE));
        BLOCK_NETHERRACK_PILLAR = registerBlock(new BlockPillarBase(Names.BLOCK_NETHERRACK_PILLAR, Material.ROCK, MaterialColor.NETHERRACK, BlockValues.NETHER_BRICKS_HARDNESS, BlockValues.NETHERRACK_RESISTANCE, SoundType.STONE));

        BLOCK_CHARCOAL = registerBlock(new BlockBase(Names.BLOCK_CHARCOAL, Material.ROCK, MaterialColor.BLACK, BlockValues.COAL_BLOCK_HARDNESS, BlockValues.COAL_BLOCK_RESISTANCE, SoundType.STONE).setBurnTime(FuelValues.BLOCK_CHARCOAL));
        BLOCK_SUGAR = registerBlock(new BlockFallingBase(Names.BLOCK_SUGAR, MaterialColor.SNOW, SoundType.SAND));
        BLOCK_SUGAR_CANE = registerBlock(new BlockPillarBase(Names.BLOCK_SUGAR_CANE, Material.LEAVES, MaterialColor.GRASS, BlockValues.PLANKS_HARDNESS, BlockValues.PLANT_BLOCK_RESISTANCE, SoundType.PLANT));
        BLOCK_GUNPOWDER = registerBlock(new BlockGunpowder());
        BLOCK_BLAZE_POWDER = registerBlock(new BlockFallingBase(Names.BLOCK_BLAZE_POWDER, MaterialColor.ADOBE, SoundType.SNOW).setBurnTime(FuelValues.BLOCK_BLAZE_POWDER));
        BLOCK_MAGMA_CREAM = registerBlock(new BlockMagmaCream());
        BLOCK_PRISMARINE_CRYSTAL = registerBlock(new BlockBase(Names.BLOCK_PRISMARINE_CRYSTAL, Block.Properties.create(Material.GLASS, MaterialColor.CYAN).hardnessAndResistance(BlockValues.GLASS_HARDNESS, BlockValues.GLASS_RESISTANCE).sound(SoundType.GLASS).lightValue(5)));
        BLOCK_WITHER_BONE = registerBlock(new BlockPillarBase(Names.BLOCK_WITHER_BONE, Material.ROCK, MaterialColor.BLACK, BlockValues.BONE_BLOCK_HARDNESS, BlockValues.BONE_BLOCK_RESISTANCE, SoundType.STONE).setBurnTime(FuelValues.BLOCK_CHARCOAL));
        BLOCK_WHITE_DYE = registerBlock(new BlockBase(Names.BLOCK_WHITE_DYE, MaterialColor.WOOL, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_ORANGE_DYE = registerBlock(new BlockBase(Names.BLOCK_ORANGE_DYE, MaterialColor.ADOBE, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_MAGENTA_DYE = registerBlock(new BlockBase(Names.BLOCK_MAGENTA_DYE, MaterialColor.MAGENTA, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_LIGHT_BLUE_DYE = registerBlock(new BlockBase(Names.BLOCK_LIGHT_BLUE_DYE, MaterialColor.LIGHT_BLUE, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_YELLOW_DYE = registerBlock(new BlockBase(Names.BLOCK_YELLOW_DYE, MaterialColor.YELLOW, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_LIME_DYE = registerBlock(new BlockBase(Names.BLOCK_LIME_DYE, MaterialColor.LIME, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_PINK_DYE = registerBlock(new BlockBase(Names.BLOCK_PINK_DYE, MaterialColor.PINK, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_GRAY_DYE = registerBlock(new BlockBase(Names.BLOCK_GRAY_DYE, MaterialColor.GRAY, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_LIGHT_GRAY_DYE = registerBlock(new BlockBase(Names.BLOCK_LIGHT_GRAY_DYE, MaterialColor.LIGHT_GRAY, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_CYAN_DYE = registerBlock(new BlockBase(Names.BLOCK_CYAN_DYE, MaterialColor.CYAN, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_PURPLE_DYE = registerBlock(new BlockBase(Names.BLOCK_PURPLE_DYE, MaterialColor.PURPLE, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_BROWN_DYE = registerBlock(new BlockBase(Names.BLOCK_BROWN_DYE, MaterialColor.BROWN, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_GREEN_DYE = registerBlock(new BlockBase(Names.BLOCK_GREEN_DYE, MaterialColor.GREEN, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_RED_DYE = registerBlock(new BlockBase(Names.BLOCK_RED_DYE, MaterialColor.RED, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));
        BLOCK_BLACK_DYE = registerBlock(new BlockBase(Names.BLOCK_BLACK_DYE, MaterialColor.BLACK, BlockValues.DYE_BLOCK_HARDNESS, BlockValues.DYE_BLOCK_RESISTANCE));

        BLOCK_ROSE = registerBlock(new BlockRose());

        for (Block block : STAIR_SLAB_LIST) 
        {
            IStairSlab blockBase = (IStairSlab) block;
            BlockStairBase stair = blockBase.setStair(new BlockStairBase(blockBase));
            registerBlock(stair);
        }
    }

    private static Block registerBlock(Block block)
    {
        BLOCKS.add(block);
        return block;
    }

    @Mod.EventBusSubscriber(modid = MinecraftBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register
    {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event)
        {
            for (Block block : BLOCKS)
            {
                event.getRegistry().register(block);
            }
        }

        @SubscribeEvent
        public static void registerItemBlocks(RegistryEvent.Register<Item> event)
        {
            for (Block block : BLOCKS)
            {
                CreativeTabs.ItemGroupBase tab = CreativeTabs.getTab(block);
                ItemBlock itemBlock = new ItemBlockBase(block, tab);
                event.getRegistry().register(itemBlock);
                tab.getList().add(itemBlock);
            }

            registerTileEntities();
        }

        public static void registerTileEntities()
        {
        }
    }
}
