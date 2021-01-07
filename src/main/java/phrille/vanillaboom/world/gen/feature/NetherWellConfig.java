package phrille.vanillaboom.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class NetherWellConfig implements IFeatureConfig
{
    public static final Codec<NetherWellConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(BlockState.CODEC.fieldOf("main_block").forGetter(NetherWellConfig::getMainBlock), BlockState.CODEC.fieldOf("chiseled_block").forGetter(NetherWellConfig::getChiseledBlock), BlockState.CODEC.fieldOf("stair_block").forGetter(NetherWellConfig::getStairBlock), BlockState.CODEC.fieldOf("slab_block").forGetter(NetherWellConfig::getSlabBlock), BlockState.CODEC.fieldOf("wall_block").forGetter(NetherWellConfig::getWallBlock), BlockState.CODEC.fieldOf("cracked_block").forGetter(NetherWellConfig::getCrackedBlock), BlockState.CODEC.fieldOf("cracked_stair_block").forGetter(NetherWellConfig::getCrackedStairBlock), BlockState.CODEC.fieldOf("craccked_slab_block").forGetter(NetherWellConfig::getCrackedSlabBlock)).apply(instance, NetherWellConfig::new));

    private BlockState mainBlock;
    private BlockState chiseledBlock;
    private BlockState stairBlock;
    private BlockState slabBlock;
    private BlockState wallBlock;
    private BlockState crackedBlock;
    private BlockState crackedStairBlock;
    private BlockState crackedSlabBlock;

    public NetherWellConfig(BlockState block, BlockState chiseled, BlockState stair, BlockState slab, BlockState wall, BlockState cracked, BlockState crackedStair, BlockState crackedSlab)
    {
        mainBlock = block;
        chiseledBlock = chiseled;
        stairBlock = stair;
        slabBlock = slab;
        wallBlock = wall;
        crackedBlock = cracked;
        crackedStairBlock = crackedStair;
        crackedSlabBlock = crackedSlab;
    }

    public BlockState getMainBlock()
    {
        return mainBlock;
    }

    public BlockState getChiseledBlock()
    {
        return chiseledBlock;
    }

    public BlockState getStairBlock()
    {
        return stairBlock;
    }

    public BlockState getSlabBlock()
    {
        return slabBlock;
    }

    public BlockState getWallBlock()
    {
        return wallBlock;
    }

    public BlockState getCrackedBlock()
    {
        return crackedBlock;
    }

    public BlockState getCrackedStairBlock()
    {
        return crackedStairBlock;
    }

    public BlockState getCrackedSlabBlock()
    {
        return crackedSlabBlock;
    }
}
