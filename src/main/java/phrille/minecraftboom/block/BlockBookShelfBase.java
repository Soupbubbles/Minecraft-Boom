package phrille.minecraftboom.block;

import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class BlockBookShelfBase extends BlockBookshelf
{
    public BlockBookShelfBase(Properties builder)
    {
        super(builder);
    }

    @Override
    public float getEnchantPowerBonus(IBlockState state, IWorldReader world, BlockPos pos)
    {
        return 1;
    }
}
