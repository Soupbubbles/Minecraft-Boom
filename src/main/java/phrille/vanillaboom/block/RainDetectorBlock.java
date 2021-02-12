package phrille.vanillaboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import phrille.vanillaboom.tileentity.RainDetectorTileEntity;

public class RainDetectorBlock extends ContainerBlock
{
    public static final IntegerProperty POWER = BlockStateProperties.POWER_0_15;
    public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);

    public RainDetectorBlock(Properties builder)
    {
        super(builder);
        setDefaultState(getDefaultState().with(INVERTED, false).with(POWER, 0));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        if (player.isAllowEdit())
        {
            if (worldIn.isRemote)
            {
                return ActionResultType.SUCCESS;
            }
            else
            {
                BlockState blockstate = state.func_235896_a_(INVERTED);
                worldIn.setBlockState(pos, blockstate, 4);
                updatePower(blockstate, worldIn, pos);
                return ActionResultType.CONSUME;
            }
        }
        else
        {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

    public static void updatePower(BlockState state, World world, BlockPos pos)
    {
        if (world.getDimensionType().hasSkyLight())
        {
            boolean flag = state.get(INVERTED);
            boolean raining = world.isRaining();
            boolean thunderStorm = world.isThundering();
            int power = 0;

            if (raining)
            {
                power = 10;

                if (thunderStorm)
                {
                    power = 15;
                }
            }

            if (flag)
            {
                power = 15 - power;
            }

            if (state.get(POWER) != power)
            {
                world.setBlockState(pos, state.with(POWER, Integer.valueOf(MathHelper.clamp(power, 0, 15))), 3);
            }
        }
    }

    @Override
    public boolean canProvidePower(BlockState state)
    {
        return true;
    }

    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side)
    {
        return blockState.get(POWER);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean isTransparent(BlockState state)
    {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context)
    {
        return SHAPE;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn)
    {
        return new RainDetectorTileEntity();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(POWER, INVERTED);
    }
}
