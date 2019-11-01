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
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.init.ModBlocks;
import phrille.minecraftboom.lib.Names;

/**
 * @author: All blockstate and model code written by @phrille. Recipes uses a
 *          modified version of @williewillus code.
 */
public class JsonGenerator
{
    //File Paths
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
    private static final String[] STAIR_DIRECTIONS = {"east", "west", "south", "north"};
    private static final int[] STAIR_ROTATIONS = {0, 180, 90, 270, 0, 180, 90, 270, 270, 90, 0, 180, 0, 180, 90, 270, 270, 90, 0, 180, 0, 180, 90, 270, 90, 270, 180, 0, 0, 180, 90, 270, 90, 270, 180, 0, 0, 180, 90, 270};
    private static final String[] STAIR_SIDE = {"bottom", "top", "side"};
    private static final String[] STAIR_SHAPE = {"straight", "outer_right", "outer_left", "inner_right", "inner_left"};
    private static final String[] STAIR_MODEL = {"", "_outer", "_outer", "_inner", "_inner"};

    //Slabs
    private static final String[] SLAB_TYPE = {"bottom", "top", "double"};
    private static final String[] SLAB_SUFFIX = {"", "_top"};

    //Panes
    private static final String[] PANE_DIRECTIONS = {"north", "east", "south", "west", "north", "east", "south", "west"};
    private static final int[] PANE_ROTATIONS = {0, 0, 90, 0, 90, 0, 0, 90, 270};
    private static final String[] PANE_MODEL = {"post", "side", "side", "side_alt", "side_alt", "noside", "noside_alt", "noside_alt", "noside"};
    private static final String[] PANE_SUFFIX = {"_post", "_side", "_side_alt", "_noside", "_noside_alt"};

    public static void init() 
    {
    }
    
    //Basic Block
    public static void addBasicBlockFiles(String name)
    {
        basicBlockState(name);
        basicBlockModel(name);
        basicItemBlockModel(name);
    }

    private static void basicBlockState(String name)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> normal = new HashMap();
        Map<String, Object> model = new HashMap();
        model.put("model", MinecraftBoom.MOD_ID + ":block/" + name);
        normal.put("", model);
        json.put("variants", normal);
        writeFile(json, BLOCKSTATE_DIR, name);
    }

    private static void basicBlockModel(String name)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> textures = new HashMap();
        json.put("parent", "block/cube_all");
        textures.put("all", MinecraftBoom.MOD_ID + ":block/" + name);
        json.put("textures", textures);
        writeFile(json, BLOCK_MODEL_DIR, name);
    }

    private static void basicItemBlockModel(String name)
    {
        Map<String, Object> json = new HashMap();
        json.put("parent", MinecraftBoom.MOD_ID + ":block/" + name);
        writeFile(json, ITEM_MODEL_DIR, name);
    }

    //Basic Item
    public static void basicItemModel(String name, String textureName)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> textures = new HashMap();
        json.put("parent", "item/generated");
        textures.put("layer0", MinecraftBoom.MOD_ID + ":" + textureName);
        json.put("textures", textures);
        writeFile(json, ITEM_MODEL_DIR, name);
    }

    //Stairs
    public static void addStairFiles(BlockStairs block, Block parent, String name, String parentName)
    {
        stairBlockState(name);
        stairBlockModel(name, parentName);
        basicItemBlockModel(name);
//        addShapedRecipe(name, new ItemStack(block, 4), "x  ", "xx ", "xxx", 'x', parent);
    }

    private static void stairBlockState(String name)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> facing = new LinkedHashMap();

        for (int i = 0; i < 40; i++)
        {
            boolean flag = i < 20;
            int j = i - ((i / 4) * 4);
            int k = (i / 4) - (flag ? 0 : 5);
            Map<String, Object> model = new LinkedHashMap();
            model.put("model", MinecraftBoom.MOD_ID + ":block/" + name + STAIR_MODEL[k]);

            if (STAIR_ROTATIONS[i] > 0)
            {
                model.put("y", STAIR_ROTATIONS[i]);
                model.put("uvlock", true);
            }

            if (!flag)
            {
                model.put("x", 180);

                if (STAIR_ROTATIONS[i] == 0)
                {
                    model.put("uvlock", true);
                }
            }

            facing.put("facing=" + STAIR_DIRECTIONS[j] + ",half=" + STAIR_SIDE[flag ? 0 : 1] + ",shape=" + STAIR_SHAPE[k], model);
        }

        json.put("variants", facing);
        writeFile(json, BLOCKSTATE_DIR, name);
    }

    private static void stairBlockModel(String name, String parentName)
    {
        for (int i = 0; i < 3; i++)
        {
            Map<String, Object> json = new HashMap();
            Map<String, Object> textures = new LinkedHashMap();
            int j = i > 1 ? i + 1 : i;

            json.put("parent", "block/" + STAIR_MODEL[j].replace("_", "") + (STAIR_MODEL[j].isEmpty() ? "" : "_") + "stairs");

            for (int k = 0; k < STAIR_SIDE.length; k++)
            {
                textures.put(STAIR_SIDE[k], parentName);
            }

            json.put("textures", textures);
            writeFile(json, BLOCK_MODEL_DIR, name + STAIR_MODEL[j]);
        }
    }

    //Slabs
    public static void addSlabFiles(BlockSlab block, Block parent, String name, String parentName)
    {
        slabBlockState(name, parentName);
        slabBlockModel(name, parentName);
        basicItemBlockModel(name);
        addShapedRecipe(name, new ItemStack(block, 6), "xxx", 'x', parent);
    }

    private static void slabBlockState(String name, String parentName)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> type = new LinkedHashMap();

        for (int i = 0; i < SLAB_TYPE.length; i++)
        {
            Map<String, Object> model = new HashMap();
            String name2 = i == 2 ? parentName : name + SLAB_SUFFIX[i];
            model.put("model", MinecraftBoom.MOD_ID + ":block/" + name2);
            type.put("type=" + SLAB_TYPE[i], model);
        }

        json.put("variants", type);
        writeFile(json, BLOCKSTATE_DIR, name);
    }

    private static void slabBlockModel(String name, String parentName)
    {
        for (int i = 0; i < SLAB_SUFFIX.length; i++)
        {
            Map<String, Object> json = new HashMap();
            Map<String, Object> textures = new LinkedHashMap();
            json.put("parent", "block/slab" + SLAB_SUFFIX[i]);

            for (int j = 0; j < STAIR_SIDE.length; j++)
            {
                textures.put(STAIR_SIDE[j], parentName);
            }

            json.put("textures", textures);
            writeFile(json, BLOCK_MODEL_DIR, name + SLAB_SUFFIX[i]);
        }
    }

    //Panes
    private static void addPaneFiles(Block block, Block parent, String name, String parentName)
    {
        paneBlockState(name);
        paneBlockModel(name);
        basicItemModel(name, "block/" + name.replace("_pane", ""));
        addShapedRecipe(name, new ItemStack(block, 16), "xxx", "xxx", 'x', parent);
    }

    private static void paneBlockState(String name)
    {
        Map<String, Object> json = new HashMap();
        List<Map> multipart = new ArrayList<>();

        for (int i = 0; i < PANE_MODEL.length; i++)
        {
            Map<String, Object> map = new HashMap();
            Map<String, Object> model = new HashMap();
            model.put("model", MinecraftBoom.MOD_ID + ":block/" + name + "_" + PANE_MODEL[i]);

            if (PANE_ROTATIONS[i] != 0)
            {
                model.put("y", PANE_ROTATIONS[i]);
            }

            if (i != 0)
            {
                Map<String, Object> direction = new HashMap();
                direction.put(PANE_DIRECTIONS[i - 1], i < 5);
                map.put("when", direction);
            }

            map.put("apply", model);
            multipart.add(map);
        }

        json.put("multipart", multipart);
        writeFile(json, BLOCKSTATE_DIR, name);
    }

    private static void paneBlockModel(String name)
    {
        for (int i = 0; i < PANE_SUFFIX.length; i++)
        {
            Map<String, Object> json = new HashMap();
            Map<String, Object> textures = new LinkedHashMap();
            json.put("parent", "block/template_glass_pane" + PANE_SUFFIX[i]);

            if (i < 3)
            {
                textures.put("edge", MinecraftBoom.MOD_ID + ":block/" + name + "_top");
            }

            textures.put("pane", name.replace("_pane", ""));
            json.put("textures", textures);
            writeFile(json, BLOCK_MODEL_DIR, name + PANE_SUFFIX[i]);
        }
    }

    //Recipes
    private static void addShapedRecipe(String fileName, ItemStack result, Object... components)
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
        writeFile(json, RECIPES_DIR, fileName);
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

        if (obj instanceof String)
        {
            String tag = (String) obj;
            Map<String, Object> result = new HashMap<>();
            result.put("tag", tag);

            return result;
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
}
