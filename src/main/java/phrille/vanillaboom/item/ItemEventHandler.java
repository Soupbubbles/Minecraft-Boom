package phrille.vanillaboom.item;

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
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.state.properties.PistonType;
import net.minecraft.stats.Stats;
import net.minecraft.util.Direction;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.init.ModBlocks;
import phrille.vanillaboom.init.ModItems;
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
                Utils.spawnEntityItem(world, pos.offset(updatePiston(world, pos, state, stack, player, event.getHand())), Items.SLIME_BALL);
            }
            else if (state.getBlock() == Blocks.PISTON_HEAD)
            {
                Direction facing = (Direction) state.get(DirectionalBlock.FACING);
                PistonType type = (PistonType) state.get(PistonHeadBlock.TYPE);
                pos = pos.add(facing.getOpposite().getDirectionVec());

                if (type == PistonType.STICKY)
                {
                    Direction direction = updatePiston(world, pos, world.getBlockState(pos), stack, player, event.getHand());
                    Utils.spawnEntityItem(world, pos.offset(direction).offset(direction), Items.SLIME_BALL);
                }
            }
        }
        else if (VanillaBoomConfig.fillWaterBottleHydroRock && stack.getItem() == Items.GLASS_BOTTLE && state.getBlock() == ModBlocks.HYDRO_ROCK)
        {
            world.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            player.addStat(Stats.ITEM_USED.get(stack.getItem()));

            if (!world.isRemote)
            {
                DrinkHelper.fill(stack, player, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER));
            }

            BlockPos upPos = pos.offset(Direction.UP);
            spawnGrowParticles(ParticleTypes.BUBBLE_POP, world, upPos, 8, world.getBlockState(upPos).isOpaqueCube(world, upPos), 0.2F);
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

        spawnGrowParticles(particle, world, pos, 10, state.getBlock().isAir(state, world, pos), 1.0F);

        if (!player.abilities.isCreativeMode)
        {
            stack.shrink(1);
        }
    }

    private static void spawnGrowParticles(BasicParticleType particle, World world, BlockPos pos, int amount, boolean condition, float height)
    {
        if (amount == 0)
        {
            amount = 15;
        }

        if (!condition)
        {
            for (int i = 0; i < amount; ++i)
            {
                double d0 = world.rand.nextGaussian() * 0.02D;
                double d1 = world.rand.nextGaussian() * 0.02D;
                double d2 = world.rand.nextGaussian() * 0.02D;

                world.addParticle(particle, (double) ((float) pos.getX() + world.rand.nextFloat()), (double) pos.getY() + (double) world.rand.nextFloat() * height, (double) ((float) pos.getZ() + world.rand.nextFloat()), d0, d1, d2);
            }
        }
    }
}