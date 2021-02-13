package phrille.vanillaboom.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DaylightDetectorBlock;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import phrille.vanillaboom.block.RainDetectorBlock;

public class RainDetectorTileEntity extends TileEntity implements ITickableTileEntity
{
    public RainDetectorTileEntity()
    {
        super(ModTileEntities.RAIN_DETECTOR.get());
    }
    
    public void tick()
    {
        if (world != null && !world.isRemote && world.getGameTime() % 20L == 0L)
        {
            BlockState blockstate = getBlockState();
            Block block = blockstate.getBlock();

            if (block instanceof RainDetectorBlock)
            {
                RainDetectorBlock.updatePower(blockstate, world, pos);
            }
        }

    }
}
