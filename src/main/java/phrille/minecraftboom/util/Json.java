package phrille.minecraftboom.util;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import phrille.minecraftboom.MinecraftBoom;

public class Json
{
    public static class LootTableGenerator
    {
        private static final File LOOT_TABLES_DIR = new File(JsonGenerator.DATA_DIR + "loot_tables/blocks");

        public static void generateBasicBlockLootTable(String name)
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

            JsonGenerator.writeFile(json, LOOT_TABLES_DIR, name);
        }
    }
}
