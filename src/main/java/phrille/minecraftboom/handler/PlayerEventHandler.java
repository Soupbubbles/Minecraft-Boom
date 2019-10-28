package phrille.minecraftboom.handler;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.PistonType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.minecraftboom.util.Utils;

@Mod.EventBusSubscriber
public class PlayerEventHandler
{
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event)
    {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        IBlockState state = world.getBlockState(pos);
        ItemStack stack = event.getItemStack();

        if (event.isCanceled())
        {
            return;
        }

        if (stack != null)
        {
            if (stack.getItem() == Items.BLAZE_POWDER && state.getBlock() == Blocks.NETHER_WART)
            {
                int i = state.get(BlockNetherWart.AGE).intValue();

                if (i < 3)
                {
                    state = state.with(BlockNetherWart.AGE, Integer.valueOf(i + 1));
                    world.setBlockState(pos, state, 2);
                    spawnGrowParticles(world, pos, 10);

                    if (!event.getEntityPlayer().abilities.isCreativeMode)
                    {
                        stack.shrink(1);
                    }
                }
            }
            else if (stack.getItem() instanceof ItemSpade && event.getEntityPlayer().isSneaking())
            {
                if (state.getBlock() == Blocks.STICKY_PISTON)
                {
                    Utils.spawnEntityItem(world, pos.add(updatePiston(world, pos, state, stack, event.getEntityPlayer()).getDirectionVec()), Items.SLIME_BALL);
                }
                else if (state.getBlock() == Blocks.PISTON_HEAD)
                {
                    EnumFacing facing = (EnumFacing) state.get(BlockDirectional.FACING);
                    PistonType type = (PistonType) state.get(BlockPistonExtension.TYPE);
                    pos = pos.add(facing.getOpposite().getDirectionVec());

                    if (type == PistonType.STICKY)
                    {
                        Utils.spawnEntityItem(world, pos.add(updatePiston(world, pos, world.getBlockState(pos), stack, event.getEntityPlayer()).getDirectionVec()), Items.SLIME_BALL);
                    }
                }
            }
        }
    }

    private static EnumFacing updatePiston(World world, BlockPos pos, IBlockState state, ItemStack stack, EntityPlayer player)
    {
        if (state.getBlock() == Blocks.STICKY_PISTON)
        {
            EnumFacing facing = (EnumFacing) state.get(BlockDirectional.FACING);
            Boolean extended = (Boolean) state.get(BlockPistonBase.EXTENDED);

            world.setBlockState(pos, Blocks.PISTON.getDefaultState().with(BlockDirectional.FACING, facing).with(BlockPistonBase.EXTENDED, extended));

            if (extended)
            {
                world.setBlockState(pos.add(facing.getDirectionVec()), Blocks.PISTON_HEAD.getDefaultState().with(BlockDirectional.FACING, (EnumFacing) state.get(BlockDirectional.FACING)).with(BlockPistonExtension.SHORT, (Boolean) false).with(BlockPistonExtension.TYPE, PistonType.DEFAULT));
            }

            if (!player.abilities.isCreativeMode)
            {
                stack.damageItem(1, player);
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

        IBlockState state = world.getBlockState(pos);
        double height = state.isAir(world, pos) ? 1.0f : state.getShape(world, pos).getEnd(EnumFacing.Axis.Y);

        if (!state.isAir())
        {
            for (int i = 0; i < amount; ++i)
            {
                double d0 = world.rand.nextGaussian() * 0.02D;
                double d1 = world.rand.nextGaussian() * 0.02D;
                double d2 = world.rand.nextGaussian() * 0.02D;
                world.spawnParticle(Particles.FLAME, (double) ((float) pos.getX() + world.rand.nextFloat()), (double) pos.getY() + (double) world.rand.nextFloat() * height, (double) ((float) pos.getZ() + world.rand.nextFloat()), d0, d1, d2);
            }
        }
    }
}