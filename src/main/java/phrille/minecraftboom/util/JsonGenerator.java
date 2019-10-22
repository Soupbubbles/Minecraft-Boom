package phrille.minecraftboom.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.block.Block;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.block.base.BlockBase;
import phrille.minecraftboom.block.base.BlockStairBase;
import phrille.minecraftboom.init.ModBlocks;

public class JsonGenerator
{
    private static final String RESOURCE_DIR = "F:\\Programming\\Minecraft\\1.13.2\\Minecraft-Boom\\src\\main\\resources\\assets\\minecraftboom\\";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    //Directories
    private static final File BLOCKSTATE_DIR = new File(RESOURCE_DIR + "blockstates");
    private static final File BLOCK_MODEL_DIR = new File(RESOURCE_DIR + "models/block");
    private static final File ITEM_MODEL_DIR = new File(RESOURCE_DIR + "models/item");

    //Stairs
    private static final String[] DIRECTIONS = {"east", "west", "south", "north"};
    private static final int[] ROTATIONS = {0, 180, 90, 270, 0, 180, 90, 270, 270, 90, 0, 180, 0, 180, 90, 270, 270, 90, 0, 180, 0, 180, 90, 270, 90, 270, 180, 0, 0, 180, 90, 270, 90, 270, 180, 0, 0, 180, 90, 270};
    private static final String[] SIDE = {"bottom", "top", "side"};
    private static final String[] SHAPE = {"straight", "outer_right", "outer_left", "inner_right", "inner_left"};
    private static final String[] MODEL_SHAPE = {"", "_outer", "_outer", "_inner", "_inner"};

    public static void init()
    {
        for (Block block : ModBlocks.BLOCKS) 
        {
            if (block instanceof IJsonGenerator) 
            {
                if (block instanceof BlockBase)
                {
                }
                else if (block instanceof BlockStairBase)
                {
                    addStairFiles((IStairSlab) ((BlockStairBase) block).getParent());
                }
            }
        }
    }

    private static void addStairFiles(IStairSlab block)
    {
        stairBlockState(block);
        stairBlockModel(block);
        basicItemBlockModel(block.getStair().getStairName());
    }

    private static void stairBlockState(IStairSlab block)
    {
        Map<String, Object> json = new HashMap();
        Map<String, Object> facing = new LinkedHashMap();

        for (int i = 0; i < 40; i++)
        {
            boolean flag = i < 20;
            int j = i - ((i / 4) * 4);
            int k = (i / 4) - (flag ? 0 : 5);
            Map<String, Object> model = new LinkedHashMap();
            model.put("model", MinecraftBoom.MOD_ID + ":block/" + block.getStair().getStairName() + MODEL_SHAPE[k]);

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
        writeFile(json, BLOCKSTATE_DIR, block.getStair().getStairName());
    }

    private static void stairBlockModel(IStairSlab block)
    {
        for (int i = 0; i < 3; i++)
        {
            Map<String, Object> json = new HashMap();
            Map<String, Object> textures = new LinkedHashMap();
            int j = i > 1 ? i + 1 : i;

            json.put("parent", "block/" + MODEL_SHAPE[j].replace("_", "") + (MODEL_SHAPE[j].isEmpty() ? "" : "_") + "stairs");

            for (int k = 0; k < SIDE.length; k++)
            {
                textures.put(SIDE[k], MinecraftBoom.MOD_ID + ":block/" + block.getName());
            }

            json.put("textures", textures);
            writeFile(json, BLOCK_MODEL_DIR, block.getStair().getStairName() + MODEL_SHAPE[j]);
        }
    }

    private static void basicItemBlockModel(String name)
    {
        Map<String, Object> json = new HashMap();
        json.put("parent", MinecraftBoom.MOD_ID + ":block/" + name);
        writeFile(json, ITEM_MODEL_DIR, name);
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
