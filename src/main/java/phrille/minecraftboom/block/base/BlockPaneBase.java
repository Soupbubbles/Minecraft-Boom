package phrille.minecraftboom.block.base;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import phrille.minecraftboom.init.ModBlocks;
import phrille.minecraftboom.lib.BlockValues;
import phrille.minecraftboom.util.IJsonGenerator;

public class BlockPaneBase extends BlockPane implements IJsonGenerator
{
    private Block parent;
    
    public BlockPaneBase(String name, Block parentBlock)
    {
        this(name, Properties.create(Material.GLASS).hardnessAndResistance(BlockValues.GLASS_HARDNESS, BlockValues.GLASS_RESISTANCE).sound(SoundType.GLASS), parentBlock);
    }

    public BlockPaneBase(String name, Properties builder, Block parentBlock)
    {
        super(builder);
        setRegistryName(name);
        parent = parentBlock;
    }
    
    @Nullable
    public Block getParentBlock()
    {
        return parent;
    }

    public IItemProvider getItemDropped(IBlockState state, World world, BlockPos pos, int fortune)
    {
        return state.getMaterial() == Material.GLASS ? Items.AIR : super.getItemDropped(state, world, pos, fortune);
    }

    public BlockRenderLayer getRenderLayer()
    {
        return this == ModBlocks.BLOCK_ANDESITE_PILLAR ? super.getRenderLayer() : BlockRenderLayer.TRANSLUCENT;
    }
}
