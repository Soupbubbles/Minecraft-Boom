package phrille.vanillaboom.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.util.Utils;

public class HydroRockBlock extends Block
{
    public HydroRockBlock()
    {
        super(Properties.from(Blocks.PRISMARINE));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit)
    {
        ItemStack stack = player.getHeldItem(hand);
        BlockPos upPos = pos.offset(Direction.UP);

        if (VanillaBoomConfig.fillWaterBottleHydroRock && stack.getItem() == Items.GLASS_BOTTLE)
        {
            if (!world.getDimensionType().isUltrawarm())
            {
                if (!world.isRemote)
                {
                    if (!player.abilities.isCreativeMode)
                    {
                        ItemStack bottleStack = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER);
                        //player.addStat(Stats.);
                        stack.shrink(1);

                        if (stack.isEmpty())
                        {
                            player.setHeldItem(hand, bottleStack);
                        }
                        else if (!player.inventory.addItemStackToInventory(bottleStack))
                        {
                            player.dropItem(bottleStack, false);
                        }
                        else if (player instanceof ServerPlayerEntity)
                        {
                            ((ServerPlayerEntity) player).sendContainerToPlayer(player.container);
                        }
                    }

                    world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                Utils.spawnParticles(ParticleTypes.SPLASH, world, upPos, 8, world.getBlockState(upPos).isOpaqueCube(world, upPos), 0.05F);
                
                return ActionResultType.func_233537_a_(world.isRemote);
            }
            else
            {
                if (!world.isRemote)
                {
                    world.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                Utils.spawnParticles(ParticleTypes.SMOKE, world, upPos, 8, world.getBlockState(upPos).isOpaqueCube(world, upPos), 0.4F);
            }
        }

        return ActionResultType.PASS;
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
