package phrille.minecraftboom.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.init.ModBlocks;
import phrille.minecraftboom.init.ModItems;

public class JsonDataGenerator
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final String RESOURCE_DIR = "F:\\Programming\\Minecraft\\1.14.4\\Minecraft-Boom\\src\\main\\resources\\";
    public static final String DATA_DIR = RESOURCE_DIR + "data\\minecraftboom\\";

    //TEMP CODE
    public static void init()
    {
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.COBBLESTONE_BRICKS), Blocks.COBBLESTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.COBBLESTONE_BRICK_STAIRS), Blocks.COBBLESTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.COBBLESTONE_BRICK_SLAB, 2), Blocks.COBBLESTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.COBBLESTONE_BRICK_STAIRS), ModBlocks.COBBLESTONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.COBBLESTONE_BRICK_SLAB, 2), ModBlocks.COBBLESTONE_BRICKS);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICKS), Blocks.MOSSY_COBBLESTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS), Blocks.MOSSY_COBBLESTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICK_SLAB, 2), Blocks.MOSSY_COBBLESTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS), ModBlocks.MOSSY_COBBLESTONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICK_SLAB, 2), ModBlocks.MOSSY_COBBLESTONE_BRICKS);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.MAGMA_BRICK_STAIRS), ModBlocks.MAGMA_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.MAGMA_BRICK_SLAB, 2), ModBlocks.MAGMA_BRICKS);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.OBSIDIAN_BRICKS), Blocks.OBSIDIAN);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.OBSIDIAN_BRICK_STAIRS), Blocks.OBSIDIAN);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.OBSIDIAN_BRICK_SLAB, 2), Blocks.OBSIDIAN);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.OBSIDIAN_STAIRS), Blocks.OBSIDIAN);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.OBSIDIAN_SLAB, 2), Blocks.OBSIDIAN);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.OBSIDIAN_BRICK_STAIRS), ModBlocks.OBSIDIAN_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.OBSIDIAN_BRICK_SLAB, 2), ModBlocks.OBSIDIAN_BRICKS);

        addStoneCutterRecipes(ModBlocks.TERRACOTTA_BRICKS, ModBlocks.TERRACOTTA_BRICK_SLAB, ModBlocks.TERRACOTTA_BRICK_STAIRS, Blocks.TERRACOTTA, ModBlocks.TERRACOTTA_SLAB, ModBlocks.TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.WHITE_TERRACOTTA_BRICKS, ModBlocks.WHITE_TERRACOTTA_BRICK_SLAB, ModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS, Blocks.WHITE_TERRACOTTA, ModBlocks.WHITE_TERRACOTTA_SLAB, ModBlocks.WHITE_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.ORANGE_TERRACOTTA_BRICKS, ModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB, ModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS, Blocks.ORANGE_TERRACOTTA, ModBlocks.ORANGE_TERRACOTTA_SLAB, ModBlocks.ORANGE_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.MAGENTA_TERRACOTTA_BRICKS, ModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB, ModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS, Blocks.MAGENTA_TERRACOTTA, ModBlocks.MAGENTA_TERRACOTTA_SLAB, ModBlocks.MAGENTA_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS, ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB, ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB, ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.YELLOW_TERRACOTTA_BRICKS, ModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB, ModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS, Blocks.YELLOW_TERRACOTTA, ModBlocks.YELLOW_TERRACOTTA_SLAB, ModBlocks.YELLOW_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.LIME_TERRACOTTA_BRICKS, ModBlocks.LIME_TERRACOTTA_BRICK_SLAB, ModBlocks.LIME_TERRACOTTA_BRICK_STAIRS, Blocks.LIME_TERRACOTTA, ModBlocks.LIME_TERRACOTTA_SLAB, ModBlocks.LIME_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.PINK_TERRACOTTA_BRICKS, ModBlocks.PINK_TERRACOTTA_BRICK_SLAB, ModBlocks.PINK_TERRACOTTA_BRICK_STAIRS, Blocks.PINK_TERRACOTTA, ModBlocks.PINK_TERRACOTTA_SLAB, ModBlocks.PINK_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.GRAY_TERRACOTTA_BRICKS, ModBlocks.GRAY_TERRACOTTA_BRICK_SLAB, ModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS, Blocks.GRAY_TERRACOTTA, ModBlocks.GRAY_TERRACOTTA_SLAB, ModBlocks.GRAY_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS, ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB, ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB, ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.CYAN_TERRACOTTA_BRICKS, ModBlocks.CYAN_TERRACOTTA_BRICK_SLAB, ModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS, Blocks.CYAN_TERRACOTTA, ModBlocks.CYAN_TERRACOTTA_SLAB, ModBlocks.CYAN_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.PURPLE_TERRACOTTA_BRICKS, ModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB, ModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS, Blocks.PURPLE_TERRACOTTA, ModBlocks.PURPLE_TERRACOTTA_SLAB, ModBlocks.PURPLE_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.BLUE_TERRACOTTA_BRICKS, ModBlocks.BLUE_TERRACOTTA_BRICK_SLAB, ModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS, Blocks.BLUE_TERRACOTTA, ModBlocks.BLUE_TERRACOTTA_SLAB, ModBlocks.BLUE_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.BROWN_TERRACOTTA_BRICKS, ModBlocks.BROWN_TERRACOTTA_BRICK_SLAB, ModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS, Blocks.BROWN_TERRACOTTA, ModBlocks.BROWN_TERRACOTTA_SLAB, ModBlocks.BROWN_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.GREEN_TERRACOTTA_BRICKS, ModBlocks.GREEN_TERRACOTTA_BRICK_SLAB, ModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS, Blocks.GREEN_TERRACOTTA, ModBlocks.GREEN_TERRACOTTA_SLAB, ModBlocks.GREEN_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.RED_TERRACOTTA_BRICKS, ModBlocks.RED_TERRACOTTA_BRICK_SLAB, ModBlocks.RED_TERRACOTTA_BRICK_STAIRS, Blocks.RED_TERRACOTTA, ModBlocks.RED_TERRACOTTA_SLAB, ModBlocks.RED_TERRACOTTA_STAIRS);
        addStoneCutterRecipes(ModBlocks.BLACK_TERRACOTTA_BRICKS, ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB, ModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS, Blocks.BLACK_TERRACOTTA, ModBlocks.BLACK_TERRACOTTA_SLAB, ModBlocks.BLACK_TERRACOTTA_STAIRS);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRAVEL_BRICKS), ModBlocks.GRAVEL_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRAVEL_BRICK_STAIRS), ModBlocks.GRAVEL_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRAVEL_BRICK_SLAB, 2), ModBlocks.GRAVEL_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRAVEL_STONE_STAIRS), ModBlocks.GRAVEL_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRAVEL_STONE_SLAB, 2), ModBlocks.GRAVEL_STONE);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRAVEL_BRICKS), ModBlocks.FINE_GRAVEL_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRAVEL_BRICK_STAIRS), ModBlocks.FINE_GRAVEL_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRAVEL_BRICK_SLAB, 2), ModBlocks.FINE_GRAVEL_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.FINE_GRAVEL_STONE_STAIRS), ModBlocks.FINE_GRAVEL_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.FINE_GRAVEL_STONE_SLAB, 2), ModBlocks.FINE_GRAVEL_STONE);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRAVEL_BRICK_STAIRS), ModBlocks.GRAVEL_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRAVEL_BRICK_SLAB, 2), ModBlocks.GRAVEL_BRICKS);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_PRISMARINE), Blocks.PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_PRISMARINE_STAIRS), Blocks.PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_PRISMARINE_SLAB, 2), Blocks.PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.PRISMARINE_PILLAR), Blocks.PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_PRISMARINE), Blocks.PRISMARINE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_PRISMARINE_STAIRS), Blocks.PRISMARINE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_PRISMARINE_SLAB, 2), Blocks.PRISMARINE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.PRISMARINE_PILLAR), Blocks.PRISMARINE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_DARK_PRISMARINE), Blocks.DARK_PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_DARK_PRISMARINE_STAIRS), Blocks.DARK_PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_DARK_PRISMARINE_SLAB, 2), Blocks.DARK_PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.DARK_PRISMARINE_PILLAR), Blocks.DARK_PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_PRISMARINE_STAIRS), ModBlocks.POLISHED_PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_PRISMARINE_SLAB, 2), ModBlocks.POLISHED_PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_DARK_PRISMARINE_STAIRS), ModBlocks.POLISHED_DARK_PRISMARINE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_DARK_PRISMARINE_SLAB, 2), ModBlocks.POLISHED_DARK_PRISMARINE);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.NETHERRACK_STAIRS), Blocks.NETHERRACK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.NETHERRACK_SLAB, 2), Blocks.NETHERRACK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_NETHERRACK), Blocks.NETHERRACK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_NETHERRACK_STAIRS), Blocks.NETHERRACK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_NETHERRACK_SLAB, 2), Blocks.NETHERRACK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.NETHERRACK_PILLAR), Blocks.NETHERRACK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_NETHERRACK_STAIRS), ModBlocks.POLISHED_NETHERRACK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_NETHERRACK_SLAB, 2), ModBlocks.POLISHED_NETHERRACK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.NETHERRACK_PILLAR), ModBlocks.POLISHED_NETHERRACK);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.END_STONE_STAIRS), Blocks.END_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.END_STONE_SLAB, 2), Blocks.END_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_END_STONE), Blocks.END_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_END_STONE_STAIRS), Blocks.END_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_END_STONE_SLAB, 2), Blocks.END_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.END_STONE_PILLAR), Blocks.END_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_END_STONE), Blocks.END_STONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_END_STONE_STAIRS), Blocks.END_STONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_END_STONE_SLAB, 2), Blocks.END_STONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.END_STONE_PILLAR), Blocks.END_STONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_END_STONE_STAIRS), ModBlocks.POLISHED_END_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.POLISHED_END_STONE_SLAB, 2), ModBlocks.POLISHED_END_STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.END_STONE_PILLAR), ModBlocks.POLISHED_END_STONE);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRANITE_PILLAR), Blocks.GRANITE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GRANITE_PILLAR), Blocks.POLISHED_GRANITE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.DIORITE_PILLAR), Blocks.DIORITE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.DIORITE_PILLAR), Blocks.POLISHED_DIORITE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.ANDESITE_PILLAR), Blocks.ANDESITE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.ANDESITE_PILLAR), Blocks.POLISHED_ANDESITE);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CRACKED_STONE_BRICK_STAIRS), Blocks.CRACKED_STONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CRACKED_STONE_BRICK_SLAB, 2), Blocks.CRACKED_STONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_STONE_BRICK_STAIRS), Blocks.CHISELED_STONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_STONE_BRICK_SLAB, 2), Blocks.CHISELED_STONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_STONE_BRICK_STAIRS), Blocks.STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_STONE_BRICK_SLAB, 2), Blocks.STONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_STONE_BRICK_STAIRS), Blocks.STONE_BRICKS);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_STONE_BRICK_SLAB, 2), Blocks.STONE_BRICKS);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_SANDSTONE_STAIRS), Blocks.SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_SANDSTONE_SLAB, 2), Blocks.SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CUT_SANDSTONE_STAIRS), Blocks.SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CUT_SANDSTONE_STAIRS), Blocks.CUT_SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_SANDSTONE_STAIRS), Blocks.CHISELED_SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_SANDSTONE_SLAB, 2), Blocks.CHISELED_SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS), Blocks.RED_SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_RED_SANDSTONE_SLAB, 2), Blocks.RED_SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CUT_RED_SANDSTONE_STAIRS), Blocks.RED_SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CUT_RED_SANDSTONE_STAIRS), Blocks.CUT_RED_SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS), Blocks.CHISELED_RED_SANDSTONE);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_RED_SANDSTONE_SLAB, 2), Blocks.CHISELED_RED_SANDSTONE);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.IRON_BLOCK_STAIRS), Blocks.IRON_BLOCK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.IRON_BLOCK_SLAB, 2), Blocks.IRON_BLOCK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GOLD_BLOCK_STAIRS), Blocks.GOLD_BLOCK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.GOLD_BLOCK_SLAB, 2), Blocks.GOLD_BLOCK);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_QUARTZ_BLOCK_STAIRS), Blocks.QUARTZ_BLOCK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_QUARTZ_BLOCK_SLAB, 2), Blocks.QUARTZ_BLOCK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_QUARTZ_BLOCK_STAIRS), Blocks.CHISELED_QUARTZ_BLOCK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.CHISELED_QUARTZ_BLOCK_SLAB, 2), Blocks.CHISELED_QUARTZ_BLOCK);

        addStoneCutterRecipes(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_CONCRETE_SLAB, ModBlocks.WHITE_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_CONCRETE_SLAB, ModBlocks.ORANGE_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_CONCRETE_SLAB, ModBlocks.MAGENTA_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_CONCRETE_SLAB, ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_CONCRETE_SLAB, ModBlocks.YELLOW_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.LIME_CONCRETE, ModBlocks.LIME_CONCRETE_SLAB, ModBlocks.LIME_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.PINK_CONCRETE, ModBlocks.PINK_CONCRETE_SLAB, ModBlocks.PINK_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_CONCRETE_SLAB, ModBlocks.GRAY_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_CONCRETE_SLAB, ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_CONCRETE_SLAB, ModBlocks.CYAN_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_CONCRETE_SLAB, ModBlocks.PURPLE_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_CONCRETE_SLAB, ModBlocks.BLUE_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_CONCRETE_SLAB, ModBlocks.BROWN_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_CONCRETE_SLAB, ModBlocks.GREEN_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.RED_CONCRETE, ModBlocks.RED_CONCRETE_SLAB, ModBlocks.RED_CONCRETE_STAIRS);
        addStoneCutterRecipes(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_CONCRETE_SLAB, ModBlocks.BLACK_CONCRETE_STAIRS);

        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.SMOOTH_STONE_STAIRS), Blocks.SMOOTH_STONE);

        RecipeGenerator.addBlastingRecipe(new ItemStack(ModItems.MAGMA_BRICK), Blocks.MAGMA_BLOCK, 0.1F);
        RecipeGenerator.addBlastingRecipe(new ItemStack(ModBlocks.GRAVEL_STONE), Blocks.GRAVEL, 0.1F);
        RecipeGenerator.addBlastingRecipe(new ItemStack(ModBlocks.FINE_GRAVEL_STONE), ModBlocks.FINE_GRAVEL, 0.1F);
        RecipeGenerator.addBlastingRecipe(new ItemStack(ModBlocks.SOUL_GLASS), Blocks.SOUL_SAND, 0.1F);

        RecipeGenerator.addShapelessRecipe(new ItemStack(Items.BLACK_DYE, 3), ModItems.WITHER_BONE);
        RecipeGenerator.addShapedRecipe(new ItemStack(ModBlocks.SNOW_BRICKS, 4), "xx", "xx", 'x', Blocks.SNOW_BLOCK);
        
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.SNOW_BRICKS), Blocks.SNOW_BLOCK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.SNOW_BRICK_STAIRS), Blocks.SNOW_BLOCK);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(ModBlocks.SNOW_BRICK_SLAB, 2), Blocks.SNOW_BLOCK);
    }

    public static void addStoneCutterRecipes(Block vanilla, Block vanillaSlab, Block vanillaStairs)
    {
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(vanillaStairs), vanilla);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(vanillaSlab, 2), vanilla);
    }

    public static void addStoneCutterRecipes(Block bricks, Block slab, Block stairs, Block vanilla, Block vanillaSlab, Block vanillaStairs)
    {
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(bricks), vanilla);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(stairs), vanilla);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(slab, 2), vanilla);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(vanillaStairs), vanilla);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(vanillaSlab, 2), vanilla);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(stairs), bricks);
        RecipeGenerator.addStoneCuttingRecipe(new ItemStack(slab, 2), bricks);
    }

    public static class RecipeGenerator
    {
        private static final File RECIPES_DIR = new File(DATA_DIR + "recipes");

        public static void addShapedRecipe(ItemStack result, Object... components)
        {
            Map<String, Object> json = new HashMap<>();
            List<String> pattern = new ArrayList<>();
            int i = 0;

            while (i < components.length && components[i] instanceof String)
            {
                pattern.add((String) components[i]);
                i++;
            }

            json.put("pattern", pattern);

            Map<String, Map<String, Object>> key = new HashMap<>();
            Character curKey = null;

            for (; i < components.length; i++)
            {
                Object obj = components[i];

                if (obj instanceof Character)
                {
                    if (curKey != null)
                    {
                        throw new IllegalArgumentException("Provided two char keys in a row");
                    }

                    curKey = (Character) obj;
                }
                else
                {
                    if (curKey == null)
                    {
                        throw new IllegalArgumentException("Providing object without a char key");
                    }

                    key.put(Character.toString(curKey), serializeItem(obj));
                    curKey = null;
                }
            }

            json.put("key", key);
            json.put("type", "minecraft:crafting_shaped");
            json.put("result", serializeItem(result));
            writeFile(json, RECIPES_DIR, result.getItem().getRegistryName().getPath());
        }

        public static void addShapelessRecipe(ItemStack result, Object... components)
        {
            Map<String, Object> json = new HashMap<>();
            List<Map<String, Object>> ingredients = new ArrayList<>();

            for (Object obj : components)
            {
                ingredients.add(serializeItem(obj));
            }

            json.put("ingredients", ingredients);
            json.put("type", "minecraft:crafting_shapeless");
            json.put("result", serializeItem(result));
            writeFile(json, RECIPES_DIR, result.getItem().getRegistryName().getPath());
        }

        public static void addStoneCuttingRecipe(ItemStack result, Object ingredient)
        {
            Map<String, Object> json = new LinkedHashMap<>();
            json.put("type", "minecraft:stonecutting");
            json.put("ingredient", serializeItem(ingredient));
            json.put("result", result.getItem().getRegistryName().toString());
            json.put("count", result.getCount());
            writeFile(json, RECIPES_DIR, result.getItem().getRegistryName().getPath() + "_from_" + getStack(ingredient).getItem().getRegistryName().getPath() + "_stonecutting");
        }

        private static void addCookingRecipe(String type, ItemStack result, Object ingredient, float exp)
        {
            Map<String, Object> json = new LinkedHashMap<>();
            json.put("type", type);
            json.put("ingredient", serializeItem(ingredient));
            json.put("result", result.getItem().getRegistryName().toString());
            json.put("experience", exp);
            json.put("cookingtime", getCookingTimeFromType(type));
            writeFile(json, RECIPES_DIR, result.getItem().getRegistryName().getPath() + "_from_" + type);
        }

        public static void addSmeltingRecipe(ItemStack result, Object ingredient, float exp)
        {
            addCookingRecipe("smelting", result, ingredient, exp);
        }

        public static void addCampFireRecipe(ItemStack result, Object ingredient, float exp)
        {
            addCookingRecipe("campfire_cooking", result, ingredient, exp);
        }

        public static void addSmokingRecipe(ItemStack result, Object ingredient, float exp)
        {
            addCookingRecipe("smoking", result, ingredient, exp);
        }

        public static void addBlastingRecipe(ItemStack result, Object ingredient, float exp)
        {
            addCookingRecipe("blasting", result, ingredient, exp);
        }

        private static int getCookingTimeFromType(String type)
        {
            if (type.matches("smelting"))
            {
                return 200;
            }
            else if (type.matches("campfire_cooking"))
            {
                return 600;
            }
            else if (type.matches("smoking"))
            {
                return 100;
            }
            else if (type.matches("blasting"))
            {
                return 100;
            }

            throw new IllegalArgumentException("Invalid cooking type");
        }

        private static ItemStack getStack(Object obj)
        {
            if (obj instanceof ItemStack)
            {
                return (ItemStack) obj;
            }
            else if (obj instanceof Item)
            {
                return new ItemStack((Item) obj);
            }
            else if (obj instanceof Block)
            {
                return new ItemStack((Block) obj);
            }

            throw new IllegalArgumentException("Not a Block or an Item");
        }

        private static Map<String, Object> serializeItem(Object obj)
        {
            if (obj instanceof Item || obj instanceof Block)
            {
                return serializeItem(getStack(obj));
            }
            else if (obj instanceof String)
            {
                String tag = (String) obj;
                Map<String, Object> result = new HashMap<>();
                result.put("tag", tag);

                return result;
            }
            else if (obj instanceof ItemStack)
            {
                ItemStack stack = (ItemStack) obj;
                Map<String, Object> result = new HashMap<>();
                result.put("item", stack.getItem().getRegistryName().toString());

                if (stack.getCount() > 1)
                {
                    result.put("count", stack.getCount());
                }

                return result;
            }

            throw new IllegalArgumentException("Not a Block, Item or ItemStack");
        }
    }

    public static class LootTableGenerator
    {
        private static final File LOOT_TABLES_DIR = new File(DATA_DIR + "loot_tables/blocks");

        public static void basicBlockLootTable(String name)
        {
            Map<String, Object> json = new LinkedHashMap();

            Map<String, Object> pools = new LinkedHashMap();
            pools.put("rolls", 1);

            Map<String, Object> entries = new LinkedHashMap();
            entries.put("type", "minecraft:item");
            entries.put("name", MinecraftBoom.MOD_ID + ":" + name);

            List<Map> list1 = new ArrayList<Map>();
            list1.add(entries);
            pools.put("entries", list1);

            Map<String, Object> conditions = new LinkedHashMap();
            conditions.put("condition", "minecraft:survives_explosion");

            List<Map> list2 = new ArrayList<Map>();
            list2.add(conditions);
            pools.put("conditions", list2);

            List<Map> list3 = new ArrayList<Map>();
            list3.add(pools);

            json.put("type", "minecraft:block");
            json.put("pools", list3);

            writeFile(json, LOOT_TABLES_DIR, name);
        }
    }

    private static void writeFile(Map map, File dir, String name)
    {
        File f = new File(dir, name + ".json");

        if (f.exists())
        {
            return;
        }

        try (FileWriter w = new FileWriter(f))
        {
            MinecraftBoom.LOGGER.info("Generating file: " + name + ".json");
            GSON.toJson(map, w);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
