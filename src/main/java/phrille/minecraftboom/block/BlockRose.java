package phrille.minecraftboom.block;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import phrille.minecraftboom.lib.BlockValues;
import phrille.minecraftboom.lib.Names;

public class BlockRose extends BlockFlower
{
    public BlockRose()
    {
        super(Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(BlockValues.FLOWER_HARDNESS, BlockValues.FLOWER_RESISTANCE).doesNotBlockMovement().sound(SoundType.PLANT));
        setRegistryName(Names.BLOCK_ROSE);
    }
}