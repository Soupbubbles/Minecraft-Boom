package phrille.minecraftboom.block;

import net.minecraft.block.BlockSlime;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import phrille.minecraftboom.lib.BlockValues;
import phrille.minecraftboom.lib.Names;

public class BlockMagmaCream extends BlockSlime
{
    public BlockMagmaCream()
    {
        super(Properties.create(Material.CLAY, MaterialColor.GRASS).hardnessAndResistance(BlockValues.SLIME_HARDNESS, BlockValues.SLIME_RESISTANCE).slipperiness(0.8F).sound(SoundType.SLIME));
        setRegistryName(Names.BLOCK_MAGMA_CREAM);
    }
}
