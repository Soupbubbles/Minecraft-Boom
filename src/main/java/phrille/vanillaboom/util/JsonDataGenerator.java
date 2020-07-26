package phrille.vanillaboom.util;

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
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.init.ModBlocks;

public class JsonDataGenerator
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final String RESOURCE_DIR = "F:\\Programming\\Minecraft\\1.16.1\\Vanilla-Boom\\src\\main\\resources\\";
    public static final String DATA_DIR = RESOURCE_DIR + "data\\vanillaboom\\";

    public static void init()
    {
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
            entries.put("name", VanillaBoom.MOD_ID + ":" + name);

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

    public static class TagGenerator
    {
        public static final List<String> WALLS = new ArrayList<String>();
        private static final File TAGS_DIR = new File(RESOURCE_DIR + "data/minecraft/tags/blocks");

        /**
         * Method for generating tags in data/minecraft/tags/block/walls.json Do
         * not call since it will override the file with an empty one
         */
        public static void wallTags()
        {
            Map<String, Object> json = new LinkedHashMap();
            json.put("replace", false);
            json.put("values", WALLS);

            writeFile(json, TAGS_DIR, "walls", true);
        }
    }

    private static void writeFile(Map map, File dir, String name)
    {
        writeFile(map, dir, name, false);
    }

    private static void writeFile(Map map, File dir, String name, boolean override)
    {
        File f = new File(dir, name + ".json");

        if (f.exists() && !override)
        {
            return;
        }

        try (FileWriter w = new FileWriter(f))
        {
            VanillaBoom.LOGGER.info("Generating file: " + name + ".json");
            GSON.toJson(map, w);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
