package phrille.vanillaboom.event;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.PistonHeadBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.properties.PistonType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.util.Utils;

@Mod.EventBusSubscriber
public class PlayerEventHandler
{
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event)
    {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);
        ItemStack stack = event.getItemStack();

        if (event.isCanceled())
        {
            return;
        }

        if (!stack.isEmpty())
        {
            if (stack.getItem() == Items.BLAZE_POWDER && state.getBlock() == Blocks.NETHER_WART)
            {
                int i = state.get(NetherWartBlock.AGE).intValue();

                if (i < 3)
                {
                    state = state.with(NetherWartBlock.AGE, Integer.valueOf(i + 1));
                    world.setBlockState(pos, state, 2);
                    spawnGrowParticles(world, pos, 10);

                    if (!event.getPlayer().abilities.isCreativeMode)
                    {
                        stack.shrink(1);
                    }
                }
            }
            else if (stack.getItem() instanceof ShovelItem && event.getPlayer().isCrouching())
            {
                if (state.getBlock() == Blocks.STICKY_PISTON)
                {
                    Utils.spawnEntityItem(world, pos.add(updatePiston(world, pos, state, stack, event.getPlayer(), event.getHand()).getDirectionVec()), Items.SLIME_BALL);
                }
                else if (state.getBlock() == Blocks.PISTON_HEAD)
                {
                    Direction facing = (Direction) state.get(DirectionalBlock.FACING);
                    PistonType type = (PistonType) state.get(PistonHeadBlock.TYPE);
                    pos = pos.add(facing.getOpposite().getDirectionVec());

                    if (type == PistonType.STICKY)
                    {
                        Utils.spawnEntityItem(world, pos.add(updatePiston(world, pos, world.getBlockState(pos), stack, event.getPlayer(), event.getHand()).getDirectionVec()), Items.SLIME_BALL);
                    }
                }
            }
        }
    }

    private static Direction updatePiston(World world, BlockPos pos, BlockState state, ItemStack stack, PlayerEntity player, Hand hand)
    {
        if (state.getBlock() == Blocks.STICKY_PISTON)
        {
            Direction facing = (Direction) state.get(DirectionalBlock.FACING);
            Boolean extended = (Boolean) state.get(PistonBlock.EXTENDED);

            world.setBlockState(pos, Blocks.PISTON.getDefaultState().with(DirectionalBlock.FACING, facing).with(PistonBlock.EXTENDED, extended));

            if (extended)
            {
                world.setBlockState(pos.add(facing.getDirectionVec()), Blocks.PISTON_HEAD.getDefaultState().with(DirectionalBlock.FACING, (Direction) state.get(DirectionalBlock.FACING)).with(PistonHeadBlock.SHORT, (Boolean) false).with(PistonHeadBlock.TYPE, PistonType.DEFAULT));
            }

            if (!player.abilities.isCreativeMode)
            {
                stack.damageItem(1, player, (entity) ->
                {
                    entity.sendBreakAnimation(hand);
                });
            }

            return facing;
        }

        return null;
    }

    @OnlyIn(Dist.CLIENT)
    public static void spawnGrowParticles(World world, BlockPos pos, int amount)
    {
        if (amount == 0)
        {
            amount = 15;
        }

        BlockState state = world.getBlockState(pos);
        double height = state.isAir(world, pos) ? 1.0f : state.getShape(world, pos).getEnd(Direction.Axis.Y);

        if (!state.isAir())
        {
            for (int i = 0; i < amount; ++i)
            {
                double d0 = world.rand.nextGaussian() * 0.02D;
                double d1 = world.rand.nextGaussian() * 0.02D;
                double d2 = world.rand.nextGaussian() * 0.02D;
                world.addParticle(ParticleTypes.FLAME, (double) ((float) pos.getX() + world.rand.nextFloat()), (double) pos.getY() + (double) world.rand.nextFloat() * height, (double) ((float) pos.getZ() + world.rand.nextFloat()), d0, d1, d2);
            }
        }
    }
}