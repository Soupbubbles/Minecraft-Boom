package phrille.minecraftboom.block;

import java.util.Random;

import net.minecraft.block.BlockFire;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import phrille.minecraftboom.block.base.BlockFallingBase;
import phrille.minecraftboom.lib.BlockValues;
import phrille.minecraftboom.lib.Names;

public class BlockGunpowder extends BlockFallingBase
{
    public BlockGunpowder()
    {
        super(Names.BLOCK_GUNPOWDER, Properties.create(Material.SAND, MaterialColor.GRAY).hardnessAndResistance(BlockValues.SAND_HARDNESS, BlockValues.SAND_RESISTANCE).sound(SoundType.SAND).needsRandomTick());
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack stack = player.getHeldItem(hand);

        if (stack != null && stack.getItem() instanceof ItemFlintAndSteel)
        {
            explode(world, pos, player);
            stack.damageItem(1, player);

            return true;
        }

        return super.onBlockActivated(state, world, pos, player, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void tick(IBlockState state, World world, BlockPos pos, Random rand)
    {
        super.tick(state, world, pos, rand);
        boolean flag = false;
        
        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                if (world.getBlockState(pos.add(i, 0, j)).getBlock() instanceof BlockFire)
                {
                    flag = true;
                }
            }
        }

        if (world.getBlockState(pos.add(0, 1, 0)).getBlock() instanceof BlockFire)
        {
            flag = true;
        }

        if (flag && rand.nextFloat() > 0.5)
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
    public void onEntityCollision(IBlockState state, World world, BlockPos pos, Entity entity)
    {
        if (entity instanceof EntityArrow && entity.isBurning())
        {
            explode(world, pos, world.getPlayerEntityByUUID(((EntityArrow) entity).shootingEntity));

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
            world.createExplosion(entity, pos.getX(), pos.getY(), pos.getZ(), 1.0F, true);
        }
    }
}
