package phrille.vanillaboom.item;

import net.minecraft.block.Block;
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
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.properties.PistonType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.util.Utils;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class ItemEventHandler
{
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event)
    {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);
        ItemStack stack = event.getItemStack();
        PlayerEntity player = event.getPlayer();

        if (event.isCanceled() || stack.isEmpty())
        {
            return;
        }

        if ((stack.getItem() == Items.BLAZE_POWDER || stack.getItem() == ModItems.WITHER_BONE_MEAL))
        {
            if (VanillaBoomConfig.growNetherWarts && state.getBlock() == Blocks.NETHER_WART)
            {
                int i = state.get(NetherWartBlock.AGE).intValue();

                if (i < 3)
                {
                    state = state.with(NetherWartBlock.AGE, Integer.valueOf(i + 1));
                    world.setBlockState(pos, state, 2);
                    success(player, world, pos, stack, stack.getItem() == Items.BLAZE_POWDER ? ParticleTypes.FLAME : ParticleTypes.SMOKE);
                }
            }
            else if (VanillaBoomConfig.growWitherRoses && state.getBlock() == ModBlocks.ROSE && stack.getItem() != Items.BLAZE_POWDER)
            {
                if (world.rand.nextInt(4) == 0)
                {
                    world.setBlockState(pos, Blocks.WITHER_ROSE.getDefaultState(), 2);
                }

                success(player, world, pos, stack, ParticleTypes.SMOKE);
            }
        }
        else if (VanillaBoomConfig.removeSlimeBallPistons && stack.getItem() instanceof ShovelItem && player.isCrouching())
        {
            if (state.getBlock() == Blocks.STICKY_PISTON)
            {
                Block.spawnAsEntity(world, pos.offset(updatePiston(world, pos, state, stack, player, event.getHand())), new ItemStack(Items.SLIME_BALL));
            }
            else if (state.getBlock() == Blocks.PISTON_HEAD)
            {
                Direction facing = (Direction) state.get(DirectionalBlock.FACING);
                PistonType type = (PistonType) state.get(PistonHeadBlock.TYPE);
                pos = pos.add(facing.getOpposite().getDirectionVec());

                if (type == PistonType.STICKY)
                {
                    Direction direction = updatePiston(world, pos, world.getBlockState(pos), stack, player, event.getHand());
                    Block.spawnAsEntity(world, pos.offset(direction).offset(direction), new ItemStack(Items.SLIME_BALL));
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

            world.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_CHICKEN_EGG, SoundCategory.NEUTRAL, 1.0F, 1.0F);

            return facing;
        }

        return null;
    }

    private static void success(PlayerEntity player, World world, BlockPos pos, ItemStack stack, BasicParticleType particle)
    {
        BlockState state = world.getBlockState(pos);

        Utils.spawnParticles(particle, world, pos, 10, state.getBlock().isAir(state, world, pos), 1.0F);

        if (!player.abilities.isCreativeMode)
        {
            stack.shrink(1);
        }
    }

}