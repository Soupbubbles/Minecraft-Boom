package phrille.vanillaboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

public class TomatoPlantBlock extends CropsBlock
{
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D), Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 6.0D, 9.0D), Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 9.0D, 11.0D), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 14.0D, 16.0D, 14.0D)};

    public TomatoPlantBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return state.get(getAgeProperty()) > 3 ? SHAPE_BY_AGE[4] : SHAPE_BY_AGE[state.get(getAgeProperty())];
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        int i = state.get(AGE);
        boolean flag = i == 7;

        if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL)
        {
            return ActionResultType.PASS;
        }
        else if (flag)
        {
            spawnAsEntity(world, pos, new ItemStack(ModItems.TOMATO));
            world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.rand.nextFloat() * 0.4F);
            world.setBlockState(pos, state.with(AGE, Integer.valueOf(4)), 2);
            return ActionResultType.func_233537_a_(world.isRemote);
        }
        else
        {
            return super.onBlockActivated(state, world, pos, player, handIn, hit);
        }
    }

    @Override
    protected IItemProvider getSeedsItem()
    {
        return ModItems.TOMATO_SEEDS;
    }

    @Override
    protected int getBonemealAgeIncrease(World world)
    {
        return world.rand.nextInt(2) + 1;
    }
}
