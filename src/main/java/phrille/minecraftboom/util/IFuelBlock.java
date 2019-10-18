package phrille.minecraftboom.util;

import net.minecraft.block.Block;

public interface IFuelBlock
{
    public Block setBurnTime(int burn);

    public int getBurnTime();
}
