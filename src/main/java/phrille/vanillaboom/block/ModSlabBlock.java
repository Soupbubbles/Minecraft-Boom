package phrille.vanillaboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModSlabBlock extends SlabBlock
{
    protected final Block modelBlock;
    
    public ModSlabBlock(Block block)
    {
        super(Properties.from(block));
        modelBlock = block;
    }
    
    /*@OnlyIn(Dist.CLIENT)
    @Override
    public boolean func_225543_m_(BlockState state) 
    {
       return modelBlock.func_225543_m_(state);
    }*/

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity)
    {
        modelBlock.onEntityWalk(world, pos, entity);
    }
}
