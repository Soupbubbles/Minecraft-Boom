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
import net.minecraft.item.ItemStack;
import phrille.minecraftboom.MinecraftBoom;

public class JsonAssetsGenerator
{
    //File Paths
    private static final String RESOURCE_DIR = "F:\\Programming\\Minecraft\\1.14.4\\Minecraft-Boom\\src\\main\\resources\\";
    public static final String ASSETS_DIR = RESOURCE_DIR + "assets\\minecraftboom\\";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    //Stairs and Slabs
    private static final String[] STAIR_SIDE = {"bottom", "top", "side"};
    private static final String[] STAIR_MODEL = {"", "_outer", "_outer", "_inner", "_inner"};
    private static final String[] SLAB_SUFFIX = {"", "_top"};

    public static void init()
    {
    }

    //Basic Block
    public static void addBasicBlockFiles(Block block)
    {
        BlockStateGenerator.basicBlockState(block.getRegistryName().getPath());
        BlockModelGenerator.basicBlockModel(block.getRegistryName().getPath());
        ItemModelGenerator.basicItemBlockModel(block.getRegistryName().getPath());
        JsonDataGenerator.LootTableGenerator.basicBlockLootTable(block.getRegistryName().getPath());
    }

    //Stairs
    public static void addStairFiles(Block block, Block parent)
    {
        BlockStateGenerator.stairBlockState(block.getRegistryName().getPath());
        BlockModelGenerator.stairBlockModel(block.getRegistryName().getPath(), parent.getRegistryName().getPath());
        ItemModelGenerator.basicItemBlockModel(block.getRegistryName().getPath());
        JsonDataGenerator.RecipeGenerator.addShapedRecipe(new ItemStack(block, 4), "x  ", "xx ", "xxx", 'x', parent);
        JsonDataGenerator.RecipeGenerator.addStoneCuttingRecipe(new ItemStack(block), parent);
        JsonDataGenerator.LootTableGenerator.basicBlockLootTable(block.getRegistryName().getPath());
    }

    //Slabs
    public static void addSlabFiles(Block block, Block parent)
    {
        BlockStateGenerator.slabBlockState(block.getRegistryName().getPath(), parent.getRegistryName().getPath());
        BlockModelGenerator.slabBlockModel(block.getRegistryName().getPath(), parent.getRegistryName().getPath());
        ItemModelGenerator.basicItemBlockModel(block.getRegistryName().getPath());
        JsonDataGenerator.RecipeGenerator.addShapedRecipe(new ItemStack(block, 6), "xxx", 'x', parent);
        JsonDataGenerator.RecipeGenerator.addStoneCuttingRecipe(new ItemStack(block, 2), parent);
        JsonDataGenerator.LootTableGenerator.basicBlockLootTable(block.getRegistryName().getPath());
    }

    //Panes
    public static void addPaneFiles(Block block, Block parent)
    {
        BlockStateGenerator.paneBlockState(block.getRegistryName().getPath());
        BlockModelGenerator.paneBlockModel(block.getRegistryName().getPath());
        ItemModelGenerator.basicItemModel(block.getRegistryName().getPath(), "block/" + block.getRegistryName().getPath().replace("_pane", ""));
        JsonDataGenerator.RecipeGenerator.addShapedRecipe(new ItemStack(block, 16), "xxx", "xxx", 'x', parent);
    }

    //Walls
    public static void addWallFiles(Block block, Block parent)
    {
        BlockStateGenerator.wallBlockState(block.getRegistryName().getPath());
        BlockModelGenerator.wallBlockModel(block.getRegistryName().getPath(), parent.getRegistryName().getPath());
        ItemModelGenerator.basicItemBlockModel(block.getRegistryName().getPath() + "_inventory", block.getRegistryName().getPath());
        JsonDataGenerator.RecipeGenerator.addShapedRecipe(new ItemStack(block, 6), "xxx", "xxx", 'x', parent);
        JsonDataGenerator.RecipeGenerator.addStoneCuttingRecipe(new ItemStack(block), parent);
        JsonDataGenerator.LootTableGenerator.basicBlockLootTable(block.getRegistryName().getPath());
    }
    
    public static class BlockStateGenerator
    {
        private static final File BLOCKSTATE_DIR = new File(ASSETS_DIR + "blockstates");

        public static void basicBlockState(String name)
        {
            Map<String, Object> json = new HashMap();
            Map<String, Object> normal = new HashMap();
            Map<String, Object> model = new HashMap();
            model.put("model", MinecraftBoom.MOD_ID + ":block/" + name);
            normal.put("", model);
            json.put("variants", normal);
            writeFile(json, BLOCKSTATE_DIR, name);
        }

        private static final String[] STAIR_DIRECTIONS = {"east", "west", "south", "north"};
        private static final int[] STAIR_ROTATIONS = {0, 180, 90, 270, 0, 180, 90, 270, 270, 90, 0, 180, 0, 180, 90, 270, 270, 90, 0, 180, 0, 180, 90, 270, 90, 270, 180, 0, 0, 180, 90, 270, 90, 270, 180, 0, 0, 180, 90, 270};
        private static final String[] STAIR_SHAPE = {"straight", "outer_right", "outer_left", "inner_right", "inner_left"};

        public static void stairBlockState(String name)
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

        private static final String[] SLAB_TYPE = {"bottom", "top", "double"};

        public static void slabBlockState(String name, String parentName)
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

        private static final String[] PANE_DIRECTIONS = {"north", "east", "south", "west", "north", "east", "south", "west"};
        private static final int[] PANE_ROTATIONS = {0, 0, 90, 0, 90, 0, 0, 90, 270};
        private static final String[] PANE_MODEL = {"post", "side", "side", "side_alt", "side_alt", "noside", "noside_alt", "noside_alt", "noside"};

        public static void paneBlockState(String name)
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

        private static final String[] WALL_DIRECTIONS = {"up", "north", "east", "south", "west"};
        private static final int[] WALL_ROTATIONS = {0, 0, 90, 180, 270};

        public static void wallBlockState(String name)
        {
            Map<String, Object> json = new HashMap();
            List<Map> multipart = new ArrayList<>();

            for (int i = 0; i < WALL_DIRECTIONS.length; i++)
            {
                Map<String, Object> map = new LinkedHashMap();

                Map<String, Object> direction = new HashMap();
                direction.put(WALL_DIRECTIONS[i], true);
                map.put("when", direction);

                Map<String, Object> model = new LinkedHashMap();
                model.put("model", MinecraftBoom.MOD_ID + ":block/" + name + (i == 0 ? "_post" : "_side"));

                if (WALL_ROTATIONS[i] != 0)
                {
                    model.put("y", WALL_ROTATIONS[i]);
                }

                if (i != 0)
                {
                    model.put("uvlock", true);
                }

                map.put("apply", model);
                multipart.add(map);
            }

            json.put("multipart", multipart);
            writeFile(json, BLOCKSTATE_DIR, name);
        }
    }

    public static class BlockModelGenerator
    {
        private static final File BLOCK_MODEL_DIR = new File(ASSETS_DIR + "models/block");

        public static void basicBlockModel(String name)
        {
            Map<String, Object> json = new HashMap();
            Map<String, Object> textures = new HashMap();
            json.put("parent", "block/cube_all");
            textures.put("all", MinecraftBoom.MOD_ID + ":block/" + name);
            json.put("textures", textures);
            writeFile(json, BLOCK_MODEL_DIR, name);
        }

        public static void stairBlockModel(String name, String parentName)
        {
            for (int i = 0; i < 3; i++)
            {
                Map<String, Object> json = new HashMap();
                Map<String, Object> textures = new LinkedHashMap();
                int j = i > 1 ? i + 1 : i;

                json.put("parent", "block/" + STAIR_MODEL[j].replace("_", "") + (STAIR_MODEL[j].isEmpty() ? "" : "_") + "stairs");

                for (int k = 0; k < STAIR_SIDE.length; k++)
                {
                    textures.put(STAIR_SIDE[k], MinecraftBoom.MOD_ID + ":block/" + parentName);
                }

                json.put("textures", textures);
                writeFile(json, BLOCK_MODEL_DIR, name + STAIR_MODEL[j]);
            }
        }

        public static void slabBlockModel(String name, String parentName)
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

        private static final String[] PANE_SUFFIX = {"_post", "_side", "_side_alt", "_noside", "_noside_alt"};

        public static void paneBlockModel(String name)
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

        private static final String[] WALL_MODELS = {"post", "side", "inventory"};

        public static void wallBlockModel(String name, String parentName)
        {
            for (int i = 0; i < WALL_MODELS.length; i++)
            {
                Map<String, Object> json = new HashMap();
                Map<String, Object> textures = new HashMap();
                json.put("parent", "block/" + (i == 2 ? "" : "template_") + "wall_" + WALL_MODELS[i]);
                textures.put("wall", MinecraftBoom.MOD_ID + ":block/" + parentName);
                json.put("textures", textures);
                writeFile(json, BLOCK_MODEL_DIR, name + "_" + WALL_MODELS[i]);
            }
        }
    }

    public static class ItemModelGenerator
    {
        private static final File ITEM_MODEL_DIR = new File(ASSETS_DIR + "models/item");

        public static void basicItemBlockModel(String name, String fileName)
        {
            Map<String, Object> json = new HashMap();
            json.put("parent", MinecraftBoom.MOD_ID + ":block/" + name);
            writeFile(json, ITEM_MODEL_DIR, fileName);
        }

        public static void basicItemBlockModel(String name)
        {
            basicItemBlockModel(name, name);
        }

        public static void basicItemModel(String name, String textureName)
        {
            Map<String, Object> json = new HashMap();
            Map<String, Object> textures = new HashMap();
            json.put("parent", "item/generated");
            textures.put("layer0", MinecraftBoom.MOD_ID + ":" + textureName);
            json.put("textures", textures);
            writeFile(json, ITEM_MODEL_DIR, name);
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
