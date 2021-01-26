package phrille.vanillaboom.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HydroRockBlock extends Block
{

    public HydroRockBlock()
    {
        super(Properties.from(Blocks.PRISMARINE));
    }

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random rand)
    {
        for (Direction direction : Direction.values())
        {
            BlockPos blockpos = pos.offset(direction);

            if (!world.getBlockState(blockpos).isOpaqueCube(world, blockpos))
            {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double) direction.getXOffset() : (double) rand.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double) direction.getYOffset() : (double) rand.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double) direction.getZOffset() : (double) rand.nextFloat();

                if (rand.nextInt(15) == 0)
                {
                    world.addParticle(ParticleTypes.BUBBLE_POP, (double) pos.getX() + d1, (double) pos.getY() + d2, (double) pos.getZ() + d3, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }
}
