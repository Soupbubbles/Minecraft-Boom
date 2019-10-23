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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.block.base.BlockBase;
import phrille.minecraftboom.block.base.BlockSlabBase;
import phrille.minecraftboom.block.base.BlockStairBase;
import phrille.minecraftboom.init.ModBlocks;
import phrille.minecraftboom.init.ModItems;

public class JsonGenerator
{
    private static final String RESOURCE_DIR = "F:\\Programming\\Minecraft\\1.13.2\\Minecraft-Boom\\src\\main\\resources\\";
    private static final String ASSETS_DIR = RESOURCE_DIR + "assets\\minecraftboom\\";
    private static final String DATA_DIR = RESOURCE_DIR + "data\\minecraftboom\\";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    //Directories
    private static final File BLOCKSTATE_DIR = new File(ASSETS_DIR + "blockstates");
    private static final File BLOCK_MODEL_DIR = new File(ASSETS_DIR + "models/block");
    private static final File ITEM_MODEL_DIR = new File(ASSETS_DIR + "models/item");
    private static final File RECIPES_DIR = new File(DATA_DIR + "recipes");

    //Stairs
    private static final String[] DIRECTIONS = {"east", "west", "south", "north"};
    private static final int[] ROTATIONS = {0, 180, 90, 270, 0, 180, 90, 270, 270, 90, 0, 180, 0, 180, 90, 270, 270, 90, 0, 180, 0, 180, 90, 270, 90, 270, 180, 0, 0, 180, 90, 270, 90, 270, 180, 0, 0, 180, 90, 270};
    private static final String[] SIDE = {"bottom", "top", "side"};
    private static final String[] SHAPE = {"straight", "outer_right", "outer_left", "inner_right", "inner_left"};
    private static final String[] MODEL_SHAPE = {"", "_outer", "_outer", "_inner", "_inner"};

    //Slabs
    private static final String[] TYPE = {"bottom", "top", "double"};
    private static final String[] SLAB_SUFFIX = {"", "_top"};

    public static void init()
    {
        for (Block block : ModBlocks.BLOCKS)
        {
            if (block instanceof IJsonGenerator)
            {
                if (block instanceof BlockBase)
                {
                    addBasicBlockFiles((BlockBase) block);
                }
                else if (block instanceof BlockStairBase)
                {
                    addStairFiles((BlockStairBase) block);
                }
                else if (block instanceof BlockSlabBase)
                {
                    addSlabFiles((BlockSlabBase) block);
                }
            }
        }

        for (Item item : ModItems.ITEMS)
        {
            basicItemModel(item);
        }
    }

    //Basic Block
    private static void addBasicBlockFiles(Block block)
    {
        basicBlockState(block);
        basicBlockModel(block);
        basicItemBlockModel(Utils.getNameFromRegistry(block));
    }

    private static void basicBlockState(Block block)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> model = new HashMap();
        model.put("", getFormattedName(block));
        json.put("variants", model);
        writeFile(json, BLOCKSTATE_DIR, Utils.getNameFromRegistry(block));
    }

    private static void basicBlockModel(Block block)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> textures = new HashMap();
        json.put("parent", "block/cube_all");
        textures.put("all", getFormattedName(block));
        json.put("textures", textures);
        writeFile(json, BLOCK_MODEL_DIR, Utils.getNameFromRegistry(block));
    }

    private static void basicItemBlockModel(String name)
    {
        Map<String, Object> json = new HashMap();
        json.put("parent", MinecraftBoom.MOD_ID + ":block/" + name);
        writeFile(json, ITEM_MODEL_DIR, name);
    }

    //Basic Item
    private static void basicItemModel(Item item)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> textures = new HashMap();
        json.put("parent", "item/generated");
        textures.put("layer0", MinecraftBoom.MOD_ID + ":item/" + Utils.getNameFromRegistry(item));
        json.put("textures", textures);
        writeFile(json, ITEM_MODEL_DIR, Utils.getNameFromRegistry(item));
    }

    //Stairs
    private static void addStairFiles(BlockStairBase block)
    {
        stairBlockState(block);
        stairBlockModel(block);
        basicItemBlockModel(block.getStairName());
        addShapedRecipe(new ItemStack(block, 4), "x  ", "xx ", "xxx", 'x', block.getParent().getBlock());
    }

    private static void stairBlockState(BlockStairBase block)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> facing = new LinkedHashMap();

        for (int i = 0; i < 40; i++)
        {
            boolean flag = i < 20;
            int j = i - ((i / 4) * 4);
            int k = (i / 4) - (flag ? 0 : 5);
            Map<String, Object> model = new LinkedHashMap();
            model.put("model", MinecraftBoom.MOD_ID + ":block/" + block.getStairName() + MODEL_SHAPE[k]);

            if (ROTATIONS[i] > 0)
            {
                model.put("y", ROTATIONS[i]);
                model.put("uvlock", true);
            }

            if (!flag)
            {
                model.put("x", 180);

                if (ROTATIONS[i] == 0)
                {
                    model.put("uvlock", true);
                }
            }

            facing.put("facing=" + DIRECTIONS[j] + ",half=" + SIDE[flag ? 0 : 1] + ",shape=" + SHAPE[k], model);
        }

        json.put("variants", facing);
        writeFile(json, BLOCKSTATE_DIR, block.getStairName());
    }

    private static void stairBlockModel(BlockStairBase block)
    {
        for (int i = 0; i < 3; i++)
        {
            Map<String, Object> json = new HashMap();
            Map<String, Object> textures = new LinkedHashMap();
            int j = i > 1 ? i + 1 : i;

            json.put("parent", "block/" + MODEL_SHAPE[j].replace("_", "") + (MODEL_SHAPE[j].isEmpty() ? "" : "_") + "stairs");

            for (int k = 0; k < SIDE.length; k++)
            {
                textures.put(SIDE[k], getFormattedName(block.getParent().getBlock()));
            }

            json.put("textures", textures);
            writeFile(json, BLOCK_MODEL_DIR, block.getStairName() + MODEL_SHAPE[j]);
        }
    }

    //Slabs
    private static void addSlabFiles(BlockSlabBase block)
    {
        slabBlockState(block);
        slabBlockModel(block);
        basicItemBlockModel(block.getSlabName());
        addShapedRecipe(new ItemStack(block, 6), "xxx", 'x', block.getParent().getBlock());
    }

    private static void slabBlockState(BlockSlabBase block)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> type = new LinkedHashMap();

        for (int i = 0; i < TYPE.length; i++)
        {
            Map<String, Object> model = new HashMap();
            String name = i == 2 ? Utils.getNameFromRegistry(block.getParent().getBlock()) : block.getSlabName() + SLAB_SUFFIX[i];
            model.put("model", MinecraftBoom.MOD_ID + ":block/" + name);
            type.put("type=" + TYPE[i], model);
        }

        json.put("variants", type);
        writeFile(json, BLOCKSTATE_DIR, block.getSlabName());
    }

    private static void slabBlockModel(BlockSlabBase block)
    {
        for (int i = 0; i < SLAB_SUFFIX.length; i++)
        {
            Map<String, Object> json = new HashMap();
            Map<String, Object> textures = new LinkedHashMap();

            json.put("parent", "block/slab" + SLAB_SUFFIX[i]);

            for (int j = 0; j < SIDE.length; j++)
            {
                textures.put(SIDE[j], getFormattedName(block.getParent().getBlock()));
            }

            json.put("textures", textures);
            writeFile(json, BLOCK_MODEL_DIR, block.getSlabName() + SLAB_SUFFIX[i]);
        }
    }

    //Recipes
    private static void addShapedRecipe(ItemStack result, Object... components)
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
        writeFile(json, RECIPES_DIR, Utils.getNameFromRegistry(result.getItem()));
    }

    private static Map<String, Object> serializeItem(Object obj)
    {
        if (obj instanceof Item)
        {
            return serializeItem(new ItemStack((Item) obj));
        }

        if (obj instanceof Block)
        {
            return serializeItem(new ItemStack((Block) obj));
        }

        if (obj instanceof ItemStack)
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

    //Utils
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

    private static String getFormattedName(Block block)
    {
        return block.getRegistryName().toString().replace(":", ":block/");
    }
}
