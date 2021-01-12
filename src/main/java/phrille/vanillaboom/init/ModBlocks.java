package phrille.vanillaboom.init;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.MagmaBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.BookshelfBlock;
import phrille.vanillaboom.block.GunpowderBlock;
import phrille.vanillaboom.block.ModSlabBlock;
import phrille.vanillaboom.block.ModStairBlock;
import phrille.vanillaboom.block.ModWallBlock;
import phrille.vanillaboom.lib.Names;
import phrille.vanillaboom.util.Utils;

@ObjectHolder(VanillaBoom.MOD_ID)
public class ModBlocks
{
    //Bricks
    public static final Block COBBLESTONE_BRICKS = Utils._null();
    public static final Block MOSSY_COBBLESTONE_BRICKS = Utils._null();
    public static final Block MAGMA_BRICKS = Utils._null();
    public static final Block OBSIDIAN_BRICKS = Utils._null();
    public static final Block SNOW_BRICKS = Utils._null();
    public static final Block TERRACOTTA_BRICKS = Utils._null();
    public static final Block WHITE_TERRACOTTA_BRICKS = Utils._null();
    public static final Block ORANGE_TERRACOTTA_BRICKS = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_BRICKS = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS = Utils._null();
    public static final Block YELLOW_TERRACOTTA_BRICKS = Utils._null();
    public static final Block LIME_TERRACOTTA_BRICKS = Utils._null();
    public static final Block PINK_TERRACOTTA_BRICKS = Utils._null();
    public static final Block GRAY_TERRACOTTA_BRICKS = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS = Utils._null();
    public static final Block CYAN_TERRACOTTA_BRICKS = Utils._null();
    public static final Block PURPLE_TERRACOTTA_BRICKS = Utils._null();
    public static final Block BLUE_TERRACOTTA_BRICKS = Utils._null();
    public static final Block BROWN_TERRACOTTA_BRICKS = Utils._null();
    public static final Block GREEN_TERRACOTTA_BRICKS = Utils._null();
    public static final Block RED_TERRACOTTA_BRICKS = Utils._null();
    public static final Block BLACK_TERRACOTTA_BRICKS = Utils._null();

    //Rocks
    public static final Block PERIDOTITE = Utils._null();
    public static final Block INFERNAL_ROCK = Utils._null();

    //Sand and Gravel
    public static final Block BONE_SAND = Utils._null();
    public static final Block FINE_GRAVEL = Utils._null();
    public static final Block GRAVEL_STONE = Utils._null();
    public static final Block FINE_GRAVEL_STONE = Utils._null();
    public static final Block GRAVEL_BRICKS = Utils._null();

    //Polished
    public static final Block POLISHED_PERIDOTITE = Utils._null();
    public static final Block POLISHED_PRISMARINE = Utils._null();
    public static final Block POLISHED_DARK_PRISMARINE = Utils._null();
    public static final Block POLISHED_END_STONE = Utils._null();
    public static final Block POLISHED_NETHERRACK = Utils._null();

    //Chiseled and cracked
    public static final Block CRACKED_RED_NETHER_BRICKS = Utils._null();
    public static final Block CHISELED_RED_NETHER_BRICKS = Utils._null();
    public static final Block CHISELED_PURPUR_BLOCK = Utils._null();
    public static final Block CHISELED_OBSIDIAN = Utils._null();

    //Pillars
    public static final Block GRANITE_PILLAR = Utils._null();
    public static final Block DIORITE_PILLAR = Utils._null();
    public static final Block ANDESITE_PILLAR = Utils._null();
    public static final Block PERIDOTITE_PILLAR = Utils._null();
    public static final Block PRISMARINE_PILLAR = Utils._null();
    public static final Block DARK_PRISMARINE_PILLAR = Utils._null();
    public static final Block END_STONE_PILLAR = Utils._null();
    public static final Block NETHERRACK_PILLAR = Utils._null();
    public static final Block RED_NETHER_PILLAR = Utils._null();
    public static final Block OBSIDIAN_PILLAR = Utils._null();

    //Wood Variations
    public static final Block SPRUCE_BOOKSHELF = Utils._null();
    public static final Block BIRCH_BOOKSHELF = Utils._null();
    public static final Block JUNGLE_BOOKSHELF = Utils._null();
    public static final Block ACACIA_BOOKSHELF = Utils._null();
    public static final Block DARK_OAK_BOOKSHELF = Utils._null();
    public static final Block CRIMSON_BOOKSHELF = Utils._null();
    public static final Block WARPED_BOOKSHELF = Utils._null();
    public static final Block SPRUCE_LADDER = Utils._null();
    public static final Block BIRCH_LADDER = Utils._null();
    public static final Block JUNGLE_LADDER = Utils._null();
    public static final Block ACACIA_LADDER = Utils._null();
    public static final Block DARK_OAK_LADDER = Utils._null();
    public static final Block CRIMSON_LADDER = Utils._null();
    public static final Block WARPED_LADDER = Utils._null();

    //Storage
    public static final Block CHARCOAL_BLOCK = Utils._null();
    public static final Block SUGAR_BLOCK = Utils._null();
    public static final Block SUGAR_CANE_BLOCK = Utils._null();
    public static final Block GUNPOWDER_BLOCK = Utils._null();
    public static final Block BLAZE_POWDER_BLOCK = Utils._null();
    public static final Block MAGMA_CREAM_BLOCK = Utils._null();
    public static final Block PRISMARINE_CRYSTAL_BLOCK = Utils._null();
    public static final Block WITHER_BONE_BLOCK = Utils._null();
    public static final Block WHITE_DYE_BLOCK = Utils._null();
    public static final Block ORANGE_DYE_BLOCK = Utils._null();
    public static final Block MAGENTA_DYE_BLOCK = Utils._null();
    public static final Block LIGHT_BLUE_DYE_BLOCK = Utils._null();
    public static final Block YELLOW_DYE_BLOCK = Utils._null();
    public static final Block LIME_DYE_BLOCK = Utils._null();
    public static final Block PINK_DYE_BLOCK = Utils._null();
    public static final Block GRAY_DYE_BLOCK = Utils._null();
    public static final Block LIGHT_GRAY_DYE_BLOCK = Utils._null();
    public static final Block CYAN_DYE_BLOCK = Utils._null();
    public static final Block PURPLE_DYE_BLOCK = Utils._null();
    public static final Block BLUE_DYE_BLOCK = Utils._null();
    public static final Block BROWN_DYE_BLOCK = Utils._null();
    public static final Block GREEN_DYE_BLOCK = Utils._null();
    public static final Block RED_DYE_BLOCK = Utils._null();
    public static final Block BLACK_DYE_BLOCK = Utils._null();

    //Glass
    public static final Block SOUL_GLASS = Utils._null();
    public static final Block WHITE_STAINED_SOUL_GLASS = Utils._null();
    public static final Block ORANGE_STAINED_SOUL_GLASS = Utils._null();
    public static final Block MAGENTA_STAINED_SOUL_GLASS = Utils._null();
    public static final Block LIGHT_BLUE_STAINED_SOUL_GLASS = Utils._null();
    public static final Block YELLOW_STAINED_SOUL_GLASS = Utils._null();
    public static final Block LIME_STAINED_SOUL_GLASS = Utils._null();
    public static final Block PINK_STAINED_SOUL_GLASS = Utils._null();
    public static final Block GRAY_STAINED_SOUL_GLASS = Utils._null();
    public static final Block LIGHT_GRAY_STAINED_SOUL_GLASS = Utils._null();
    public static final Block CYAN_STAINED_SOUL_GLASS = Utils._null();
    public static final Block PURPLE_STAINED_SOUL_GLASS = Utils._null();
    public static final Block BLUE_STAINED_SOUL_GLASS = Utils._null();
    public static final Block BROWN_STAINED_SOUL_GLASS = Utils._null();
    public static final Block GREEN_STAINED_SOUL_GLASS = Utils._null();
    public static final Block RED_STAINED_SOUL_GLASS = Utils._null();
    public static final Block BLACK_STAINED_SOUL_GLASS = Utils._null();
    public static final Block SOUL_GLASS_PANE = Utils._null();
    public static final Block WHITE_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block ORANGE_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block MAGENTA_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block LIGHT_BLUE_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block YELLOW_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block LIME_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block PINK_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block GRAY_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block LIGHT_GRAY_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block CYAN_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block PURPLE_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block BLUE_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block BROWN_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block GREEN_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block RED_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block BLACK_STAINED_SOUL_GLASS_PANE = Utils._null();

    //Misc
    public static final Block GOLD_BARS = Utils._null();
    public static final Block ROSE = Utils._null();
    public static final Block POTTED_ROSE = Utils._null();

    //VanillaBoom Stairs
    public static final Block COBBLESTONE_BRICK_STAIRS = Utils._null();
    public static final Block MOSSY_COBBLESTONE_BRICK_STAIRS = Utils._null();
    public static final Block MAGMA_BRICK_STAIRS = Utils._null();
    public static final Block OBSIDIAN_BRICK_STAIRS = Utils._null();
    public static final Block SNOW_BRICK_STAIRS = Utils._null();
    public static final Block TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block WHITE_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block ORANGE_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block YELLOW_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block LIME_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block PINK_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block GRAY_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block CYAN_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block PURPLE_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block BLUE_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block BROWN_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block GREEN_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block RED_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block BLACK_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block PERIDOTITE_STAIRS = Utils._null();
    public static final Block INFERNAL_ROCK_STAIRS = Utils._null();
    public static final Block GRAVEL_STONE_STAIRS = Utils._null();
    public static final Block FINE_GRAVEL_STONE_STAIRS = Utils._null();
    public static final Block GRAVEL_BRICK_STAIRS = Utils._null();
    public static final Block POLISHED_PERIDOTITE_STAIRS = Utils._null();
    public static final Block POLISHED_PRISMARINE_STAIRS = Utils._null();
    public static final Block POLISHED_DARK_PRISMARINE_STAIRS = Utils._null();
    public static final Block POLISHED_END_STONE_STAIRS = Utils._null();
    public static final Block POLISHED_NETHERRACK_STAIRS = Utils._null();
    public static final Block CRACKED_RED_NETHER_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_RED_NETHER_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_PURPUR_BLOCK_STAIRS = Utils._null();
    public static final Block CHISELED_OBSIDIAN_STAIRS = Utils._null();

    //Vanilla Stairs
    public static final Block CRACKED_STONE_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_STONE_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_SANDSTONE_STAIRS = Utils._null();
    public static final Block CHISELED_RED_SANDSTONE_STAIRS = Utils._null();
    public static final Block IRON_BLOCK_STAIRS = Utils._null();
    public static final Block GOLD_BLOCK_STAIRS = Utils._null();
    public static final Block OBSIDIAN_STAIRS = Utils._null();
    public static final Block BEDROCK_STAIRS = Utils._null();
    public static final Block NETHERRACK_STAIRS = Utils._null();
    public static final Block CRACKED_NETHER_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_NETHER_BRICK_STAIRS = Utils._null();
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_POLISHED_BLACKSTONE_STAIRS = Utils._null();
    public static final Block END_STONE_STAIRS = Utils._null();
    public static final Block CHISELED_QUARTZ_BLOCK_STAIRS = Utils._null();
    public static final Block QUARTZ_BRICK_STAIRS = Utils._null();
    public static final Block TERRACOTTA_STAIRS = Utils._null();
    public static final Block WHITE_TERRACOTTA_STAIRS = Utils._null();
    public static final Block ORANGE_TERRACOTTA_STAIRS = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_STAIRS = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_STAIRS = Utils._null();
    public static final Block YELLOW_TERRACOTTA_STAIRS = Utils._null();
    public static final Block LIME_TERRACOTTA_STAIRS = Utils._null();
    public static final Block PINK_TERRACOTTA_STAIRS = Utils._null();
    public static final Block GRAY_TERRACOTTA_STAIRS = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_STAIRS = Utils._null();
    public static final Block CYAN_TERRACOTTA_STAIRS = Utils._null();
    public static final Block PURPLE_TERRACOTTA_STAIRS = Utils._null();
    public static final Block BLUE_TERRACOTTA_STAIRS = Utils._null();
    public static final Block BROWN_TERRACOTTA_STAIRS = Utils._null();
    public static final Block GREEN_TERRACOTTA_STAIRS = Utils._null();
    public static final Block RED_TERRACOTTA_STAIRS = Utils._null();
    public static final Block BLACK_TERRACOTTA_STAIRS = Utils._null();
    public static final Block WHITE_CONCRETE_STAIRS = Utils._null();
    public static final Block ORANGE_CONCRETE_STAIRS = Utils._null();
    public static final Block MAGENTA_CONCRETE_STAIRS = Utils._null();
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = Utils._null();
    public static final Block YELLOW_CONCRETE_STAIRS = Utils._null();
    public static final Block LIME_CONCRETE_STAIRS = Utils._null();
    public static final Block PINK_CONCRETE_STAIRS = Utils._null();
    public static final Block GRAY_CONCRETE_STAIRS = Utils._null();
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = Utils._null();
    public static final Block CYAN_CONCRETE_STAIRS = Utils._null();
    public static final Block PURPLE_CONCRETE_STAIRS = Utils._null();
    public static final Block BLUE_CONCRETE_STAIRS = Utils._null();
    public static final Block BROWN_CONCRETE_STAIRS = Utils._null();
    public static final Block GREEN_CONCRETE_STAIRS = Utils._null();
    public static final Block RED_CONCRETE_STAIRS = Utils._null();
    public static final Block BLACK_CONCRETE_STAIRS = Utils._null();
    public static final Block OAK_WOOD_STAIRS = Utils._null();
    public static final Block SPRUCE_WOOD_STAIRS = Utils._null();
    public static final Block BIRCH_WOOD_STAIRS = Utils._null();
    public static final Block JUNGLE_WOOD_STAIRS = Utils._null();
    public static final Block ACACIA_WOOD_STAIRS = Utils._null();
    public static final Block DARK_OAK_WOOD_STAIRS = Utils._null();
    public static final Block CRIMSON_HYPHAE_STAIRS = Utils._null();
    public static final Block WARPED_HYPHAE_STAIRS = Utils._null();
    public static final Block STRIPPED_OAK_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_SPRUCE_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_BIRCH_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_JUNGLE_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_ACACIA_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_DARK_OAK_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_CRIMSON_HYPHAE_STAIRS = Utils._null();
    public static final Block STRIPPED_WARPED_HYPHAE_STAIRS = Utils._null();
    public static final Block CUT_SANDSTONE_STAIRS = Utils._null();
    public static final Block CUT_RED_SANDSTONE_STAIRS = Utils._null();
    public static final Block SMOOTH_STONE_STAIRS = Utils._null();

    //VanillaBoom Slabs
    public static final Block COBBLESTONE_BRICK_SLAB = Utils._null();
    public static final Block MOSSY_COBBLESTONE_BRICK_SLAB = Utils._null();
    public static final Block MAGMA_BRICK_SLAB = Utils._null();
    public static final Block OBSIDIAN_BRICK_SLAB = Utils._null();
    public static final Block SNOW_BRICK_SLAB = Utils._null();
    public static final Block TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block WHITE_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block ORANGE_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block YELLOW_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block LIME_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block PINK_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block GRAY_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block CYAN_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block PURPLE_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block BLUE_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block BROWN_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block GREEN_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block RED_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block BLACK_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block PERIDOTITE_SLAB = Utils._null();
    public static final Block INFERNAL_ROCK_SLAB = Utils._null();
    public static final Block GRAVEL_STONE_SLAB = Utils._null();
    public static final Block FINE_GRAVEL_STONE_SLAB = Utils._null();
    public static final Block GRAVEL_BRICK_SLAB = Utils._null();
    public static final Block POLISHED_PERIDOTITE_SLAB = Utils._null();
    public static final Block POLISHED_PRISMARINE_SLAB = Utils._null();
    public static final Block POLISHED_DARK_PRISMARINE_SLAB = Utils._null();
    public static final Block POLISHED_END_STONE_SLAB = Utils._null();
    public static final Block POLISHED_NETHERRACK_SLAB = Utils._null();
    public static final Block CRACKED_RED_NETHER_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_RED_NETHER_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_PURPUR_BLOCK_SLAB = Utils._null();
    public static final Block CHISELED_OBSIDIAN_SLAB = Utils._null();


    //Vanilla Slabs
    public static final Block CRACKED_STONE_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_STONE_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_SANDSTONE_SLAB = Utils._null();
    public static final Block CHISELED_RED_SANDSTONE_SLAB = Utils._null();
    public static final Block IRON_BLOCK_SLAB = Utils._null();
    public static final Block GOLD_BLOCK_SLAB = Utils._null();
    public static final Block OBSIDIAN_SLAB = Utils._null();
    public static final Block BEDROCK_SLAB = Utils._null();
    public static final Block NETHERRACK_SLAB = Utils._null();
    public static final Block CRACKED_NETHER_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_NETHER_BRICK_SLAB = Utils._null();
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_POLISHED_BLACKSTONE_SLAB = Utils._null();
    public static final Block END_STONE_SLAB = Utils._null();
    public static final Block CHISELED_QUARTZ_BLOCK_SLAB = Utils._null();
    public static final Block QUARTZ_BRICK_SLAB = Utils._null();
    public static final Block TERRACOTTA_SLAB = Utils._null();
    public static final Block WHITE_TERRACOTTA_SLAB = Utils._null();
    public static final Block ORANGE_TERRACOTTA_SLAB = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_SLAB = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_SLAB = Utils._null();
    public static final Block YELLOW_TERRACOTTA_SLAB = Utils._null();
    public static final Block LIME_TERRACOTTA_SLAB = Utils._null();
    public static final Block PINK_TERRACOTTA_SLAB = Utils._null();
    public static final Block GRAY_TERRACOTTA_SLAB = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_SLAB = Utils._null();
    public static final Block CYAN_TERRACOTTA_SLAB = Utils._null();
    public static final Block PURPLE_TERRACOTTA_SLAB = Utils._null();
    public static final Block BLUE_TERRACOTTA_SLAB = Utils._null();
    public static final Block BROWN_TERRACOTTA_SLAB = Utils._null();
    public static final Block GREEN_TERRACOTTA_SLAB = Utils._null();
    public static final Block RED_TERRACOTTA_SLAB = Utils._null();
    public static final Block BLACK_TERRACOTTA_SLAB = Utils._null();
    public static final Block WHITE_CONCRETE_SLAB = Utils._null();
    public static final Block ORANGE_CONCRETE_SLAB = Utils._null();
    public static final Block MAGENTA_CONCRETE_SLAB = Utils._null();
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = Utils._null();
    public static final Block YELLOW_CONCRETE_SLAB = Utils._null();
    public static final Block LIME_CONCRETE_SLAB = Utils._null();
    public static final Block PINK_CONCRETE_SLAB = Utils._null();
    public static final Block GRAY_CONCRETE_SLAB = Utils._null();
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = Utils._null();
    public static final Block CYAN_CONCRETE_SLAB = Utils._null();
    public static final Block PURPLE_CONCRETE_SLAB = Utils._null();
    public static final Block BLUE_CONCRETE_SLAB = Utils._null();
    public static final Block BROWN_CONCRETE_SLAB = Utils._null();
    public static final Block GREEN_CONCRETE_SLAB = Utils._null();
    public static final Block RED_CONCRETE_SLAB = Utils._null();
    public static final Block BLACK_CONCRETE_SLAB = Utils._null();
    public static final Block OAK_WOOD_SLAB = Utils._null();
    public static final Block SPRUCE_WOOD_SLAB = Utils._null();
    public static final Block BIRCH_WOOD_SLAB = Utils._null();
    public static final Block JUNGLE_WOOD_SLAB = Utils._null();
    public static final Block ACACIA_WOOD_SLAB = Utils._null();
    public static final Block DARK_OAK_WOOD_SLAB = Utils._null();
    public static final Block CRIMSON_HYPHAE_SLAB = Utils._null();
    public static final Block WARPED_HYPHAE_SLAB = Utils._null();
    public static final Block STRIPPED_OAK_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_SPRUCE_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_BIRCH_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_JUNGLE_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_ACACIA_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_DARK_OAK_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_CRIMSON_HYPHAE_SLAB = Utils._null();
    public static final Block STRIPPED_WARPED_HYPHAE_SLAB = Utils._null();

    //VanillaBoom Walls
    public static final Block COBBLESTONE_BRICK_WALL = Utils._null();
    public static final Block MOSSY_COBBLESTONE_BRICK_WALL = Utils._null();
    public static final Block MAGMA_BRICK_WALL = Utils._null();
    public static final Block OBSIDIAN_BRICK_WALL = Utils._null();
    public static final Block SNOW_BRICK_WALL = Utils._null();
    public static final Block TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block WHITE_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block ORANGE_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block YELLOW_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block LIME_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block PINK_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block GRAY_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block CYAN_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block PURPLE_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block BLUE_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block BROWN_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block GREEN_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block RED_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block BLACK_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block PERIDOTITE_WALL = Utils._null();
    public static final Block INFERNAL_ROCK_WALL = Utils._null();
    public static final Block GRAVEL_STONE_WALL = Utils._null();
    public static final Block FINE_GRAVEL_STONE_WALL = Utils._null();
    public static final Block GRAVEL_BRICK_WALL = Utils._null();
    public static final Block POLISHED_PERIDOTITE_WALL = Utils._null();
    public static final Block POLISHED_PRISMARINE_WALL = Utils._null();
    public static final Block POLISHED_DARK_PRISMARINE_WALL = Utils._null();
    public static final Block POLISHED_END_STONE_WALL = Utils._null();
    public static final Block POLISHED_NETHERRACK_WALL = Utils._null();
    public static final Block CHISELED_PURPUR_BLOCK_WALL = Utils._null();
    public static final Block CRACKED_RED_NETHER_BRICK_WALL = Utils._null();
    public static final Block CHISELED_RED_NETHER_BRICK_WALL = Utils._null();
    public static final Block CHISELED_OBSIDIAN_WALL = Utils._null();


    //Vanilla Walls
    public static final Block CRACKED_STONE_BRICK_WALL = Utils._null();
    public static final Block CHISELED_STONE_BRICK_WALL = Utils._null();
    public static final Block CHISELED_SANDSTONE_WALL = Utils._null();
    public static final Block CHISELED_RED_SANDSTONE_WALL = Utils._null();
    public static final Block IRON_BLOCK_WALL = Utils._null();
    public static final Block GOLD_BLOCK_WALL = Utils._null();
    public static final Block OBSIDIAN_WALL = Utils._null();
    public static final Block BEDROCK_WALL = Utils._null();
    public static final Block NETHERRACK_WALL = Utils._null();
    public static final Block CRACKED_NETHER_BRICK_WALL = Utils._null();
    public static final Block CHISELED_NETHER_BRICK_WALL = Utils._null();
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = Utils._null();
    public static final Block CHISELED_POLISHED_BLACKSTONE_WALL = Utils._null();
    public static final Block END_STONE_WALL = Utils._null();
    public static final Block CHISELED_QUARTZ_BLOCK_WALL = Utils._null();
    public static final Block QUARTZ_BRICK_WALL = Utils._null();
    public static final Block TERRACOTTA_WALL = Utils._null();
    public static final Block WHITE_TERRACOTTA_WALL = Utils._null();
    public static final Block ORANGE_TERRACOTTA_WALL = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_WALL = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_WALL = Utils._null();
    public static final Block YELLOW_TERRACOTTA_WALL = Utils._null();
    public static final Block LIME_TERRACOTTA_WALL = Utils._null();
    public static final Block PINK_TERRACOTTA_WALL = Utils._null();
    public static final Block GRAY_TERRACOTTA_WALL = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_WALL = Utils._null();
    public static final Block CYAN_TERRACOTTA_WALL = Utils._null();
    public static final Block PURPLE_TERRACOTTA_WALL = Utils._null();
    public static final Block BLUE_TERRACOTTA_WALL = Utils._null();
    public static final Block BROWN_TERRACOTTA_WALL = Utils._null();
    public static final Block GREEN_TERRACOTTA_WALL = Utils._null();
    public static final Block RED_TERRACOTTA_WALL = Utils._null();
    public static final Block BLACK_TERRACOTTA_WALL = Utils._null();
    public static final Block WHITE_CONCRETE_WALL = Utils._null();
    public static final Block ORANGE_CONCRETE_WALL = Utils._null();
    public static final Block MAGENTA_CONCRETE_WALL = Utils._null();
    public static final Block LIGHT_BLUE_CONCRETE_WALL = Utils._null();
    public static final Block YELLOW_CONCRETE_WALL = Utils._null();
    public static final Block LIME_CONCRETE_WALL = Utils._null();
    public static final Block PINK_CONCRETE_WALL = Utils._null();
    public static final Block GRAY_CONCRETE_WALL = Utils._null();
    public static final Block LIGHT_GRAY_CONCRETE_WALL = Utils._null();
    public static final Block CYAN_CONCRETE_WALL = Utils._null();
    public static final Block PURPLE_CONCRETE_WALL = Utils._null();
    public static final Block BLUE_CONCRETE_WALL = Utils._null();
    public static final Block BROWN_CONCRETE_WALL = Utils._null();
    public static final Block GREEN_CONCRETE_WALL = Utils._null();
    public static final Block RED_CONCRETE_WALL = Utils._null();
    public static final Block BLACK_CONCRETE_WALL = Utils._null();
    public static final Block CUT_SANDSTONE_WALL = Utils._null();
    public static final Block CUT_RED_SANDSTONE_WALL = Utils._null();
    public static final Block SMOOTH_STONE_WALL = Utils._null();
    public static final Block STONE_WALL = Utils._null();
    public static final Block POLISHED_GRANITE_WALL = Utils._null();
    public static final Block POLISHED_DIORITE_WALL = Utils._null();
    public static final Block POLISHED_ANDESITE_WALL = Utils._null();
    public static final Block SMOOTH_SANDSTONE_WALL = Utils._null();
    public static final Block SMOOTH_RED_SANDSTONE_WALL = Utils._null();
    public static final Block PURPUR_BLOCK_WALL = Utils._null();
    public static final Block QUARTZ_BLOCK_WALL = Utils._null();
    public static final Block SMOOTH_QUARTZ_WALL = Utils._null();
    public static final Block PRISMARINE_BRICK_WALL = Utils._null();
    public static final Block DARK_PRISMARINE_WALL = Utils._null();

    //Vanilla Fences
    public static final Block OAK_WOOD_FENCE = Utils._null();
    public static final Block SPRUCE_WOOD_FENCE = Utils._null();
    public static final Block BIRCH_WOOD_FENCE = Utils._null();
    public static final Block JUNGLE_WOOD_FENCE = Utils._null();
    public static final Block ACACIA_WOOD_FENCE = Utils._null();
    public static final Block DARK_OAK_WOOD_FENCE = Utils._null();
    public static final Block CRIMSON_HYPHAE_FENCE = Utils._null();
    public static final Block WARPED_HYPHAE_FENCE = Utils._null();
    public static final Block STRIPPED_OAK_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_SPRUCE_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_BIRCH_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_JUNGLE_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_ACACIA_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_DARK_OAK_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_CRIMSON_HYPHAE_FENCE = Utils._null();
    public static final Block STRIPPED_WARPED_HYPHAE_FENCE = Utils._null();
    public static final Block RED_NETHER_BRICK_FENCE = Utils._null();
    public static final Block OAK_WOOD_FENCE_GATE = Utils._null();
    public static final Block SPRUCE_WOOD_FENCE_GATE = Utils._null();
    public static final Block BIRCH_WOOD_FENCE_GATE = Utils._null();
    public static final Block JUNGLE_WOOD_FENCE_GATE = Utils._null();
    public static final Block ACACIA_WOOD_FENCE_GATE = Utils._null();
    public static final Block DARK_OAK_WOOD_FENCE_GATE = Utils._null();
    public static final Block CRIMSON_HYPHAE_FENCE_GATE = Utils._null();
    public static final Block WARPED_HYPHAE_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_OAK_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_SPRUCE_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_BIRCH_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_JUNGLE_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_ACACIA_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_DARK_OAK_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_CRIMSON_HYPHAE_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_WARPED_HYPHAE_FENCE_GATE = Utils._null();
    public static final Block NETHER_BRICK_FENCE_GATE = Utils._null();
    public static final Block RED_NETHER_BRICK_FENCE_GATE = Utils._null();

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Bus.MOD)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void onRegisterBlocks(RegistryEvent.Register<Block> event)
        {
            IForgeRegistry<Block> registry = event.getRegistry();

            //Bricks
            createSpecialBlock(registry, Properties.from(Blocks.COBBLESTONE), Names.COBBLESTONE_BRICKS);
            createSpecialBlock(registry, Properties.from(Blocks.MOSSY_COBBLESTONE), Names.MOSSY_COBBLESTONE_BRICKS);
            createSpecialBlock(registry, new MagmaBlock(Properties.from(Blocks.MAGMA_BLOCK)), Names.MAGMA_BRICKS);
            createSpecialBlock(registry, Properties.from(Blocks.OBSIDIAN), Names.OBSIDIAN_BRICKS);
            createSpecialBlock(registry, Properties.from(Blocks.SNOW_BLOCK), Names.SNOW_BRICKS);
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

            //Rocks
            createSpecialBlock(registry, Properties.from(Blocks.ANDESITE), Names.PERIDOTITE);
            createSpecialBlock(registry, Properties.from(Blocks.NETHERRACK), Names.INFERNAL_ROCK);

            //Sand and Gravel
            registry.register(setup(new FallingBlock(Properties.create(Material.SAND, MaterialColor.SNOW).hardnessAndResistance(0.5F, 0.0F).sound(SoundType.SOUL_SAND)), Names.BONE_SAND));
            registry.register(setup(new FallingBlock(Properties.from(Blocks.GRAVEL)), Names.FINE_GRAVEL));
            createSpecialBlock(registry, Properties.from(Blocks.STONE), Names.GRAVEL_STONE);
            createSpecialBlock(registry, Properties.from(Blocks.STONE), Names.FINE_GRAVEL_STONE);
            createSpecialBlock(registry, Properties.from(Blocks.STONE_BRICKS), Names.GRAVEL_BRICKS);

            //Polished
            createSpecialBlock(registry, Properties.from(Blocks.POLISHED_ANDESITE), Names.POLISHED_PERIDOTITE);
            createSpecialBlock(registry, Properties.from(Blocks.PRISMARINE), Names.POLISHED_PRISMARINE);
            createSpecialBlock(registry, Properties.from(Blocks.DARK_PRISMARINE), Names.POLISHED_DARK_PRISMARINE);
            createSpecialBlock(registry, Properties.from(Blocks.END_STONE), Names.POLISHED_END_STONE);
            createSpecialBlock(registry, Properties.from(Blocks.NETHERRACK), Names.POLISHED_NETHERRACK);

            //Chiseled and cracked
            createSpecialBlock(registry, Properties.from(Blocks.PURPUR_BLOCK), Names.CHISELED_PURPUR_BLOCK);
            createSpecialBlock(registry, Properties.from(Blocks.RED_NETHER_BRICKS), Names.CRACKED_RED_NETHER_BRICKS);
            createSpecialBlock(registry, Properties.from(Blocks.RED_NETHER_BRICKS), Names.CHISELED_RED_NETHER_BRICKS);
            createSpecialBlock(registry, Properties.from(Blocks.OBSIDIAN), Names.CHISELED_OBSIDIAN);

            //Pillars
            registry.register(setup(new RotatedPillarBlock(Properties.from(Blocks.GRANITE)), Names.GRANITE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(Properties.from(Blocks.DIORITE)), Names.DIORITE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(Properties.from(Blocks.ANDESITE)), Names.ANDESITE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(Properties.from(Blocks.ANDESITE)), Names.PERIDOTITE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(Properties.from(Blocks.PRISMARINE)), Names.PRISMARINE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(Properties.from(Blocks.DARK_PRISMARINE)), Names.DARK_PRISMARINE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(Properties.from(Blocks.END_STONE)), Names.END_STONE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(Properties.from(Blocks.NETHERRACK)), Names.NETHERRACK_PILLAR));
            registry.register(setup(new RotatedPillarBlock(Properties.from(Blocks.RED_NETHER_BRICKS)), Names.RED_NETHER_PILLAR));
            registry.register(setup(new RotatedPillarBlock(Properties.from(Blocks.OBSIDIAN)), Names.OBSIDIAN_PILLAR));

            //Wood Variations
            registry.register(setup(new BookshelfBlock(Properties.from(Blocks.BOOKSHELF)), Names.SPRUCE_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(Properties.from(Blocks.BOOKSHELF)), Names.BIRCH_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(Properties.from(Blocks.BOOKSHELF)), Names.JUNGLE_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(Properties.from(Blocks.BOOKSHELF)), Names.ACACIA_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(Properties.from(Blocks.BOOKSHELF)), Names.DARK_OAK_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(Properties.from(Blocks.BOOKSHELF)), Names.CRIMSON_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(Properties.from(Blocks.BOOKSHELF)), Names.WARPED_BOOKSHELF));

            //Storage Blocks
            registry.register(setup(new Block(Properties.from(Blocks.COAL_BLOCK)), Names.CHARCOAL_BLOCK));
            registry.register(setup(new FallingBlock(Properties.create(Material.SAND, MaterialColor.SNOW).hardnessAndResistance(0.5F, 0.0F).sound(SoundType.SAND)), Names.SUGAR_BLOCK));
            registry.register(setup(new RotatedPillarBlock(Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.5F, 0.0F)), Names.SUGAR_CANE_BLOCK));
            registry.register(setup(new GunpowderBlock(), Names.GUNPOWDER_BLOCK));
            registry.register(setup(new FallingBlock(Properties.from(Blocks.SAND).sound(SoundType.SNOW)), Names.BLAZE_POWDER_BLOCK));
            registry.register(setup(new SlimeBlock(Properties.from(Blocks.SLIME_BLOCK)), Names.MAGMA_CREAM_BLOCK));
            registry.register(setup(new Block(Properties.create(Material.GLASS, MaterialColor.CYAN).hardnessAndResistance(0.3F, 0.5F).sound(SoundType.GLASS).setLightLevel((lightValue) ->
            {
                return 5;
            })), Names.PRISMARINE_CRYSTAL_BLOCK));
            registry.register(setup(new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.BONE).hardnessAndResistance(1.8F, 3.33F)), Names.WITHER_BONE_BLOCK));
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
            registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.BLUE).hardnessAndResistance(3.0F, 5.0F)), Names.BLUE_DYE_BLOCK));
            registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(3.0F, 5.0F)), Names.BROWN_DYE_BLOCK));
            registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.GREEN).hardnessAndResistance(3.0F, 5.0F)), Names.GREEN_DYE_BLOCK));
            registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(3.0F, 5.0F)), Names.RED_DYE_BLOCK));
            registry.register(setup(new Block(Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(3.0F, 5.0F)), Names.BLACK_DYE_BLOCK));

            //Glass
            registry.register(setup(new StainedGlassBlock(DyeColor.WHITE, Properties.from(Blocks.GLASS)), Names.SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.WHITE, Properties.from(Blocks.WHITE_STAINED_GLASS)), Names.WHITE_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.ORANGE, Properties.from(Blocks.ORANGE_STAINED_GLASS)), Names.ORANGE_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.MAGENTA, Properties.from(Blocks.MAGENTA_STAINED_GLASS)), Names.MAGENTA_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.LIGHT_BLUE, Properties.from(Blocks.LIGHT_BLUE_STAINED_GLASS)), Names.LIGHT_BLUE_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.YELLOW, Properties.from(Blocks.YELLOW_STAINED_GLASS)), Names.YELLOW_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.LIME, Properties.from(Blocks.LIME_STAINED_GLASS)), Names.LIME_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.PINK, Properties.from(Blocks.PINK_STAINED_GLASS)), Names.PINK_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.GRAY, Properties.from(Blocks.GRAY_STAINED_GLASS)), Names.GRAY_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.LIGHT_GRAY, Properties.from(Blocks.LIGHT_GRAY_STAINED_GLASS)), Names.LIGHT_GRAY_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.CYAN, Properties.from(Blocks.CYAN_STAINED_GLASS)), Names.CYAN_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.PURPLE, Properties.from(Blocks.PURPLE_STAINED_GLASS)), Names.PURPLE_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.BLUE, Properties.from(Blocks.BLUE_STAINED_GLASS)), Names.BLUE_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.BROWN, Properties.from(Blocks.BROWN_STAINED_GLASS)), Names.BROWN_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.GREEN, Properties.from(Blocks.GREEN_STAINED_GLASS)), Names.GREEN_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.RED, Properties.from(Blocks.RED_STAINED_GLASS)), Names.RED_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.BLACK, Properties.from(Blocks.BLACK_STAINED_GLASS)), Names.BLACK_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.WHITE, Properties.from(Blocks.GLASS_PANE)), Names.SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.WHITE, Properties.from(Blocks.WHITE_STAINED_GLASS_PANE)), Names.WHITE_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.ORANGE, Properties.from(Blocks.ORANGE_STAINED_GLASS_PANE)), Names.ORANGE_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.MAGENTA, Properties.from(Blocks.MAGENTA_STAINED_GLASS_PANE)), Names.MAGENTA_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.LIGHT_BLUE, Properties.from(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE)), Names.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.YELLOW, Properties.from(Blocks.YELLOW_STAINED_GLASS_PANE)), Names.YELLOW_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.LIME, Properties.from(Blocks.LIME_STAINED_GLASS_PANE)), Names.LIME_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.PINK, Properties.from(Blocks.PINK_STAINED_GLASS_PANE)), Names.PINK_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.GRAY, Properties.from(Blocks.GRAY_STAINED_GLASS_PANE)), Names.GRAY_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.LIGHT_GRAY, Properties.from(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE)), Names.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.CYAN, Properties.from(Blocks.CYAN_STAINED_GLASS_PANE)), Names.CYAN_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.PURPLE, Properties.from(Blocks.PURPLE_STAINED_GLASS_PANE)), Names.PURPLE_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.BLUE, Properties.from(Blocks.BLUE_STAINED_GLASS_PANE)), Names.BLUE_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.BROWN, Properties.from(Blocks.BROWN_STAINED_GLASS_PANE)), Names.BROWN_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.GREEN, Properties.from(Blocks.GREEN_STAINED_GLASS_PANE)), Names.GREEN_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.RED, Properties.from(Blocks.RED_STAINED_GLASS_PANE)), Names.RED_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.BLACK, Properties.from(Blocks.BLACK_STAINED_GLASS_PANE)), Names.BLACK_STAINED_SOUL_GLASS_PANE));

            //Misc
            registry.register(setup(new PaneBlock(Properties.from(Blocks.IRON_BARS)), Names.GOLD_BARS));
            registry.register(setup(new LadderBlock(Properties.from(Blocks.LADDER)), Names.SPRUCE_LADDER));
            registry.register(setup(new LadderBlock(Properties.from(Blocks.LADDER)), Names.BIRCH_LADDER));
            registry.register(setup(new LadderBlock(Properties.from(Blocks.LADDER)), Names.JUNGLE_LADDER));
            registry.register(setup(new LadderBlock(Properties.from(Blocks.LADDER)), Names.ACACIA_LADDER));
            registry.register(setup(new LadderBlock(Properties.from(Blocks.LADDER)), Names.DARK_OAK_LADDER));
            registry.register(setup(new LadderBlock(Properties.from(Blocks.LADDER)), Names.CRIMSON_LADDER));
            registry.register(setup(new LadderBlock(Properties.from(Blocks.LADDER)), Names.WARPED_LADDER));
            createFlower(registry, Effects.HASTE, 10, Names.ROSE);

            //Vanilla Stairs, Slabs and Walls
            addVanillaVariants(registry, Blocks.CRACKED_STONE_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_STONE_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_SANDSTONE, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_RED_SANDSTONE, true, true, true);
            addVanillaVariants(registry, Blocks.IRON_BLOCK, true, true, true);
            addVanillaVariants(registry, Blocks.GOLD_BLOCK, true, true, true);
            addVanillaVariants(registry, Blocks.OBSIDIAN, true, true, true);
            addVanillaVariants(registry, Blocks.BEDROCK, true, true, true);
            addVanillaVariants(registry, Blocks.NETHERRACK, true, true, true);
            addVanillaVariants(registry, Blocks.CRACKED_NETHER_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_NETHER_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_POLISHED_BLACKSTONE, true, true, true);
            addVanillaVariants(registry, Blocks.END_STONE, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_QUARTZ_BLOCK, true, true, true);
            addVanillaVariants(registry, Blocks.QUARTZ_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.WHITE_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.ORANGE_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.MAGENTA_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.LIGHT_BLUE_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.YELLOW_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.LIME_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.PINK_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.GRAY_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.LIGHT_GRAY_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.CYAN_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.PURPLE_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.BLUE_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.BROWN_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.GREEN_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.RED_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.BLACK_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.WHITE_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.ORANGE_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.MAGENTA_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.LIGHT_BLUE_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.YELLOW_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.LIME_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.PINK_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.GRAY_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.LIGHT_GRAY_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.CYAN_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.PURPLE_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.BLUE_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.BROWN_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.GREEN_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.RED_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.BLACK_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.OAK_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.SPRUCE_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.BIRCH_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.JUNGLE_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.ACACIA_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.DARK_OAK_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.CRIMSON_HYPHAE, true, true, false);
            addVanillaVariants(registry, Blocks.WARPED_HYPHAE, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_OAK_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_SPRUCE_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_BIRCH_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_JUNGLE_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_ACACIA_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_DARK_OAK_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_CRIMSON_HYPHAE, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_WARPED_HYPHAE, true, true, false);
            addVanillaVariants(registry, Blocks.CUT_SANDSTONE, true, false, true);
            addVanillaVariants(registry, Blocks.CUT_RED_SANDSTONE, true, false, true);
            addVanillaVariants(registry, Blocks.SMOOTH_STONE, true, false, true);
            addVanillaVariants(registry, Blocks.STONE, false, false, true);
            addVanillaVariants(registry, Blocks.POLISHED_GRANITE, false, false, true);
            addVanillaVariants(registry, Blocks.POLISHED_DIORITE, false, false, true);
            addVanillaVariants(registry, Blocks.POLISHED_ANDESITE, false, false, true);
            addVanillaVariants(registry, Blocks.SMOOTH_SANDSTONE, false, false, true);
            addVanillaVariants(registry, Blocks.SMOOTH_RED_SANDSTONE, false, false, true);
            addVanillaVariants(registry, Blocks.PURPUR_BLOCK, false, false, true);
            addVanillaVariants(registry, Blocks.QUARTZ_BLOCK, false, false, true);
            addVanillaVariants(registry, Blocks.SMOOTH_QUARTZ, false, false, true);
            addVanillaVariants(registry, Blocks.PRISMARINE_BRICKS, false, false, true);
            addVanillaVariants(registry, Blocks.DARK_PRISMARINE, false, false, true);

            //Fences
            registry.register(setup(new FenceBlock(Properties.from(Blocks.OAK_FENCE)), Names.OAK_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.SPRUCE_FENCE)), Names.SPRUCE_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.BIRCH_FENCE)), Names.BIRCH_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.JUNGLE_FENCE)), Names.JUNGLE_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.ACACIA_FENCE)), Names.ACACIA_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.DARK_OAK_FENCE)), Names.DARK_OAK_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.CRIMSON_FENCE).sound(SoundType.HYPHAE)), Names.CRIMSON_HYPHAE_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.WARPED_FENCE).sound(SoundType.HYPHAE)), Names.WARPED_HYPHAE_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.OAK_FENCE)), Names.STRIPPED_OAK_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.SPRUCE_FENCE)), Names.STRIPPED_SPRUCE_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.BIRCH_FENCE)), Names.STRIPPED_BIRCH_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.JUNGLE_FENCE)), Names.STRIPPED_JUNGLE_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.ACACIA_FENCE)), Names.STRIPPED_ACACIA_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.DARK_OAK_FENCE)), Names.STRIPPED_DARK_OAK_WOOD_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.CRIMSON_FENCE).sound(SoundType.HYPHAE)), Names.STRIPPED_CRIMSON_HYPHAE_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.WARPED_FENCE).sound(SoundType.HYPHAE)), Names.STRIPPED_WARPED_HYPHAE_FENCE));
            registry.register(setup(new FenceBlock(Properties.from(Blocks.NETHER_BRICK_FENCE)), Names.RED_NETHER_BRICK_FENCE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.OAK_FENCE_GATE)), Names.OAK_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.SPRUCE_FENCE_GATE)), Names.SPRUCE_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.BIRCH_FENCE_GATE)), Names.BIRCH_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.JUNGLE_FENCE_GATE)), Names.JUNGLE_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.ACACIA_FENCE_GATE)), Names.ACACIA_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.DARK_OAK_FENCE_GATE)), Names.DARK_OAK_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.CRIMSON_FENCE_GATE).sound(SoundType.HYPHAE)), Names.CRIMSON_HYPHAE_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.WARPED_FENCE_GATE).sound(SoundType.HYPHAE)), Names.WARPED_HYPHAE_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.OAK_FENCE_GATE)), Names.STRIPPED_OAK_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.SPRUCE_FENCE_GATE)), Names.STRIPPED_SPRUCE_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.BIRCH_FENCE_GATE)), Names.STRIPPED_BIRCH_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.JUNGLE_FENCE_GATE)), Names.STRIPPED_JUNGLE_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.ACACIA_FENCE_GATE)), Names.STRIPPED_ACACIA_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.DARK_OAK_FENCE_GATE)), Names.STRIPPED_DARK_OAK_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.CRIMSON_FENCE_GATE).sound(SoundType.HYPHAE)), Names.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.WARPED_FENCE_GATE).sound(SoundType.HYPHAE)), Names.STRIPPED_WARPED_HYPHAE_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.NETHER_BRICK_FENCE)), Names.NETHER_BRICK_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(Properties.from(Blocks.NETHER_BRICK_FENCE)), Names.RED_NETHER_BRICK_FENCE_GATE));
        }

        private static void addVanillaVariants(IForgeRegistry<Block> registry, Block block, boolean addStair, boolean addSlab, boolean addWall)
        {
            if (addStair)
            {
                registry.register(setup(new ModStairBlock((block)), Utils.getStairName(block.getRegistryName().getPath())));
            }

            if (addSlab)
            {
                registry.register(setup(new ModSlabBlock((block)), Utils.getSlabName(block.getRegistryName().getPath())));
            }

            if (addWall)
            {
                registry.register(setup(new ModWallBlock(block), Utils.getWallName(block.getRegistryName().getPath())));
            }
        }

        private static void createSpecialBlock(IForgeRegistry<Block> registry, Properties builder, String name)
        {
            createSpecialBlock(registry, new Block(builder), name);
        }

        private static void createSpecialBlock(IForgeRegistry<Block> registry, Block block, String name)
        {
            registry.register(setup(block, name));
            registry.register(setup(new ModStairBlock(block), Utils.getStairName(name)));
            registry.register(setup(new ModSlabBlock(block), Utils.getSlabName(name)));
            registry.register(setup(new ModWallBlock(block), Utils.getWallName(name)));
        }

        private static void createFlower(IForgeRegistry<Block> registry, Effect effect, int effectDuration, String name)
        {
            Block flower = new FlowerBlock(effect, effectDuration, Properties.from(Blocks.POPPY));
            registry.register(setup(flower, name));
            registry.register(setup(new FlowerPotBlock(flower, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F)), "potted_" + name));
        }

        public static <T extends IForgeRegistryEntry<T>> T setup(T entry, String name)
        {
            return setup(entry, new ResourceLocation(VanillaBoom.MOD_ID, name));
        }

        public static <T extends IForgeRegistryEntry<T>> T setup(T entry, ResourceLocation registryName)
        {
            entry.setRegistryName(registryName);
            return entry;
        }
    }
}
