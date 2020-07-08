package phrille.vanillaboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModWallBlock extends WallBlock
{
    protected final Block modelBlock;

    public ModWallBlock(Block block)
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
    
    public Block getModelBlock() 
    {
        return modelBlock;
    }
}
