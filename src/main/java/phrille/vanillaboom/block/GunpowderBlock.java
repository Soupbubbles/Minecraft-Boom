package phrille.vanillaboom.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class GunpowderBlock extends FallingBlock
{
    public GunpowderBlock()
    {
        super(Properties.from(Blocks.GRAVEL).sound(SoundType.SAND).harvestTool(ToolType.SHOVEL).tickRandomly());
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit)
    {
        ItemStack stack = player.getHeldItem(hand);

        if (!stack.isEmpty() && stack.getItem() instanceof FlintAndSteelItem)
        {
            explode(world, pos, player);
            stack.damageItem(1, player, (entity) ->
            {
                entity.sendBreakAnimation(hand);
            });

            return ActionResultType.SUCCESS;
        }

        return super.onBlockActivated(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return true;
    }
    
    @Override
    public void catchFire(BlockState state, World world, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter)
    {
        explode(world, pos, igniter);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand)
    {
        super.randomTick(state, world, pos, rand);
        boolean flag = false;

        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                if (world.getBlockState(pos.add(i, 0, j)).getBlock() instanceof FireBlock)
                {
                    flag = true;
                }
            }
        }

        if (world.getBlockState(pos.add(0, 1, 0)).getBlock() instanceof FireBlock)
        {
            flag = true;
        }

        if (flag && rand.nextFloat() > 0.8)
        {
            explode(world, pos, null);
        }
    }

    @Override
    public void onExplosionDestroy(World world, BlockPos pos, Explosion explosion)
    {
        explode(world, pos, explosion.getExplosivePlacedBy());
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity)
    {
        if (entity instanceof ArrowEntity && entity.isBurning())
        {
            explode(world, pos, world.getPlayerByUuid(((ArrowEntity) entity).getUniqueID()));

            if (!world.isRemote)
            {
                entity.remove();
            }
        }
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosion)
    {
        return false;
    }

    private void explode(World world, BlockPos pos, Entity entity)
    {
        if (!world.isRemote)
        {
            world.createExplosion(entity, pos.getX(), pos.getY(), pos.getZ(), 1.0F, true, Mode.DESTROY);
        }
    }
}
