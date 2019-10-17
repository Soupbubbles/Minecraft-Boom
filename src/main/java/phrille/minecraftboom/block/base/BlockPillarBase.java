package phrille.minecraftboom.block.base;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockPillarBase extends BlockRotatedPillar
{
    public BlockPillarBase(String name, Material material, MaterialColor color, float hardness, float resistance, SoundType sound)
    {
        super(Properties.create(material, color).hardnessAndResistance(hardness, resistance).sound(sound));
        setRegistryName(name);
    }
}
