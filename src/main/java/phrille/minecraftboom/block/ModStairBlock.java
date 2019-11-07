package phrille.minecraftboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;

public class ModStairBlock extends StairsBlock
{
    public ModStairBlock(Block block)
    {
        super(block.getDefaultState(), Properties.from(block));
    }
}
