package phrille.minecraftboom.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import phrille.minecraftboom.init.ModBlocks;
import phrille.minecraftboom.lib.BlockValues;
import phrille.minecraftboom.util.IFuelBlock;
import phrille.minecraftboom.util.IJsonGenerator;
import phrille.minecraftboom.util.IStairSlab;

public class BlockBase extends Block implements IFuelBlock, IStairSlab, IJsonGenerator
{
    private int burnTime;
    protected Properties properties;

    private boolean hasStairSlab;
    private BlockStairBase stair;
    private BlockSlabBase slab;

    public BlockBase(String name)
    {
        this(name, MaterialColor.STONE);
    }

    public BlockBase(String name, MaterialColor color)
    {
        this(name, color, BlockValues.STONE_HARDNESS, BlockValues.STONE_RESISTANCE);
    }

    public BlockBase(String name, MaterialColor color, float hardness, float resistance)
    {
        this(name, Material.ROCK, color, hardness, resistance, SoundType.STONE);
    }

    public BlockBase(String name, Material material, MaterialColor mapColor, float hardness, float resistance, SoundType sound)
    {
        this(name, Properties.create(material, mapColor).hardnessAndResistance(hardness, resistance).sound(sound));
    }

    public BlockBase(String name, Properties builder)
    {
        super(builder);
        setRegistryName(name);
        burnTime = -1;
        properties = builder;
    }

    @Override
    public Block setBurnTime(int burn)
    {
        burnTime = burn;
        return this;
    }

    @Override
    public int getBurnTime()
    {
        return burnTime;
    }

    public Block getBlock()
    {
        return this;
    }

    @Override
    public Block addStairSlab()
    {
        ModBlocks.STAIR_SLAB_LIST.add(this);
        hasStairSlab = true;
        return getBlock();
    }

    @Override
    public boolean hasStairSlab()
    {
        return hasStairSlab;
    }

    @Override
    public BlockStairBase setStair(BlockStairBase stair)
    {
        return this.stair = stair;
    }

    @Override
    public BlockStairBase getStair()
    {
        return stair;
    }

    @Override
    public Properties getProperties()
    {
        return properties;
    }

    @Override
    public BlockSlabBase setSlab(BlockSlabBase slab)
    {
        return this.slab = slab;
    }

    @Override
    public BlockSlabBase getSlab()
    {
        return slab;
    }
}
