package phrille.minecraftboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;

public class StairBlock extends StairsBlock
{
    public StairBlock(Block block)
    {
        super(block.getDefaultState(), Properties.from(block));
    }
}
