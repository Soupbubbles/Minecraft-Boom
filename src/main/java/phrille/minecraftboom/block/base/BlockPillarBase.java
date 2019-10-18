package phrille.minecraftboom.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import phrille.minecraftboom.util.IFuelBlock;

public class BlockPillarBase extends BlockRotatedPillar implements IFuelBlock
{
    private int burnTime;

    public BlockPillarBase(String name, Material material, MaterialColor color, float hardness, float resistance, SoundType sound)
    {
        super(Properties.create(material, color).hardnessAndResistance(hardness, resistance).sound(sound));
        setRegistryName(name);
    }

    @Override
    public Block setBurnTime(int burn)
    {
        burnTime = burn;
        return this;
    }

    @Override
    public int getBurnTime()
    {
        return burnTime;
    }
}
