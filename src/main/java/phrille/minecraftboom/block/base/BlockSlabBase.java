package phrille.minecraftboom.block.base;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.extensions.IForgeBlock;
import phrille.minecraftboom.util.IJsonGenerator;
import phrille.minecraftboom.util.IStairSlab;
import phrille.minecraftboom.util.Utils;

public class BlockSlabBase extends BlockSlab implements IJsonGenerator
{
    private String slabName;
    private Block parent;
    private boolean isVanilla;

    public BlockSlabBase(IStairSlab block)
    {
        this(block.getBlock(), false);
    }

    public BlockSlabBase(Block block, boolean vanilla)
    {
        super(Properties.from(block.getBlock()));
        slabName = Utils.getNameFromRegistry(((IForgeBlock) block).getBlock()).replace("bricks", "brick") + "_slab";
        setRegistryName(slabName);
        parent = block;
        isVanilla = vanilla;
    }
    
    @Override
    public int quantityDropped(IBlockState state, Random random)
    {
        return parent.quantityDropped(state, random);
    }

    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return parent.getRenderLayer();
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return state.getMaterial() == Material.GLASS ? false : super.isFullCube(state);
    }

    @Override
    protected boolean canSilkHarvest()
    {
        return getDefaultState().getMaterial() == Material.GLASS ? true : super.canSilkHarvest();
    }
    
    @Override
    public boolean propagatesSkylightDown(IBlockState state, IBlockReader reader, BlockPos pos)
    {
        return parent.propagatesSkylightDown(state, reader, pos);
    }

    public String getSlabName()
    {
        return slabName;
    }

    public Block getParent()
    {
        return parent;
    }

    public boolean isVanilla()
    {
        return isVanilla;
    }
}
