package phrille.minecraftboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockStairBase extends BlockStairs
{
    public BlockStairBase(Block block)
    {
        super(block.getDefaultState(), Properties.from(block));
    }
}
