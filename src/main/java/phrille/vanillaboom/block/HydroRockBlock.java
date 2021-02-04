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
        Direction direction = Direction.getRandomDirection(rand);
        BlockPos blockpos = pos.offset(direction);
        BlockState blockstate = world.getBlockState(blockpos);

        if (blockstate.getFluidState().isEmpty() && (!blockstate.isSolid() || !blockstate.isSolidSide(world, blockpos, direction.getOpposite())))
        {
            Direction.Axis direction$axis = direction.getAxis();
            double d1 = direction.getXOffset() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getXOffset() * 0.6D;
            double d2 = direction.getYOffset() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getYOffset() * 0.6D;
            double d3 = direction.getZOffset() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getZOffset() * 0.6D;

            if (rand.nextInt(2) == 0)
            {
                if (world.getDimensionType().isUltrawarm() && direction != Direction.DOWN)
                {
                    world.addParticle(ParticleTypes.SMOKE, (double) pos.getX() + d1, (double) pos.getY() + d2, (double) pos.getZ() + d3, 0.0D, 0.0D, 0.0D);
                }
                else if (direction != Direction.UP)
                {
                    world.addParticle(ParticleTypes.DRIPPING_WATER, (double) pos.getX() + d1, (double) pos.getY() + d2, (double) pos.getZ() + d3, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }
}
