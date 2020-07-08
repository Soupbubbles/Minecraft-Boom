package phrille.vanillaboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModStairBlock extends StairsBlock
{
    protected Block modelBlock;
    
    public ModStairBlock(Block block)
    {
        super(block.getDefaultState(), Properties.from(block));
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
