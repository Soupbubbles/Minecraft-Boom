package phrille.vanillaboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import phrille.vanillaboom.item.ModItems;

public class RicePlantBlock extends CropsBlock
{
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 8);

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public RicePlantBlock(Properties builder)
    {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return SHAPE_BY_AGE[state.get(getAgeProperty())];
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit)
    {
        int i = state.get(AGE);
        boolean flag = i == getMaxAge();

        if (!flag && player.getHeldItem(hand).getItem() == Items.BONE_MEAL)
        {
            return ActionResultType.PASS;
        }
        else if (flag && player.getHeldItem(hand).getItem() == Items.BOWL)
        {
            if (!world.isRemote)
            {
                ItemStack stack = player.getHeldItem(hand);
                ItemStack riceStack = new ItemStack(ModItems.RICE_BOWL);

                if (!player.abilities.isCreativeMode)
                {
                    stack.shrink(1);
                }

                if (stack.isEmpty())
                {
                    player.setHeldItem(hand, riceStack);
                }
                else if (!player.inventory.addItemStackToInventory(riceStack))
                {
                    player.dropItem(riceStack, false);
                }
                else if (player instanceof ServerPlayerEntity)
                {
                    ((ServerPlayerEntity) player).sendContainerToPlayer(player.container);
                }

                world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.rand.nextFloat() * 0.4F);
            }

            world.setBlockState(pos, state.with(AGE, Integer.valueOf(5)), 2);
            return ActionResultType.func_233537_a_(world.isRemote);
        }
        else
        {
            return super.onBlockActivated(state, world, pos, player, hand, hit);
        }
    }

    @Override
    protected IItemProvider getSeedsItem()
    {
        return ModItems.RICE_SEEDS;
    }

    @Override
    public int getMaxAge()
    {
        return 8;
    }

    @Override
    protected int getBonemealAgeIncrease(World world)
    {
        return 1;
    }

    @Override
    public IntegerProperty getAgeProperty()
    {
        return AGE;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(AGE);
    }
}
