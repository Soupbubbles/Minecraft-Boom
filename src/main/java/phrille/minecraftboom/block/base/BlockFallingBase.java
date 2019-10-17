package phrille.minecraftboom.block.base;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import phrille.minecraftboom.lib.BlockValues;

public class BlockFallingBase extends BlockFalling
{
    public BlockFallingBase(String name)
    {
        this(name, MaterialColor.SAND, SoundType.SAND);
    }
    
    public BlockFallingBase(String name, MaterialColor color, SoundType sound)
    {
        this(name, Properties.create(Material.SAND, color).hardnessAndResistance(BlockValues.SAND_HARDNESS, BlockValues.SAND_RESISTANCE).sound(sound));
    }
    
    public BlockFallingBase(String name, Properties properties)
    {
        super(properties);
        setRegistryName(name);
    }
}