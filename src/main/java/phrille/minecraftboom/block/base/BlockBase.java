package phrille.minecraftboom.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import phrille.minecraftboom.lib.BlockValues;

public class BlockBase extends Block
{
    private int harvestLevel;

    public BlockBase(String name)
    {
        this(name, MaterialColor.STONE);
    }

    public BlockBase(String name, MaterialColor color)
    {
        this(name, color, BlockValues.STONE_HARDNESS);
    }
    
    public BlockBase(String name, MaterialColor color, float hardness)
    {
        this(name, Material.ROCK, color, hardness, BlockValues.STONE_RESISTANCE);
    }

    public BlockBase(String name, Material material, MaterialColor mapColor, float hardness, float resistance)
    {
        this(name, material, mapColor, hardness, resistance, 0);
    }

    public BlockBase(String name, Material material, MaterialColor mapColor, float hardness, float resistance, int lightValue)
    {
        super(Properties.create(material, mapColor).hardnessAndResistance(hardness, resistance).lightValue(lightValue));
        setRegistryName(name);
    }
}
