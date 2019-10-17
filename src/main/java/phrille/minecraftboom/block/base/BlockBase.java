package phrille.minecraftboom.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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
        this(name, color, BlockValues.STONE_HARDNESS, BlockValues.STONE_RESISTANCE);
    }
    
    public BlockBase(String name, MaterialColor color, float hardness, float resistance)
    {
        this(name, Material.ROCK, color, hardness, resistance, SoundType.STONE);
    }

    public BlockBase(String name, Material material, MaterialColor mapColor, float hardness, float resistance, SoundType sound)
    {
        this(name, Properties.create(material, mapColor).hardnessAndResistance(hardness, resistance).sound(sound));
    }

    public BlockBase(String name, Properties properties)
    {
        super(properties);
        setRegistryName(name);
    }
}
