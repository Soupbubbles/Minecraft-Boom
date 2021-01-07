package phrille.vanillaboom.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import phrille.vanillaboom.init.ModBlocks;

public class NetherWellFeature extends Feature<NetherWellConfig>
{
    private static final BlockStateMatcher IS_NETHERRACK = BlockStateMatcher.forBlock(Blocks.NETHERRACK);
    private static final BlockStateMatcher IS_CRIMSON_NYLIUM = BlockStateMatcher.forBlock(Blocks.CRIMSON_NYLIUM);
    private static final BlockStateMatcher IS_WARPED_NYLIUM = BlockStateMatcher.forBlock(Blocks.WARPED_NYLIUM);
    private static final BlockStateMatcher IS_BLACKSTONE = BlockStateMatcher.forBlock(Blocks.BLACKSTONE);
    private static final BlockStateMatcher IS_SOUL_SAND = BlockStateMatcher.forBlock(Blocks.SOUL_SAND);
    private static final BlockStateMatcher IS_SOUL_SOIL = BlockStateMatcher.forBlock(Blocks.SOUL_SOIL);

    private final BlockState lava = Blocks.LAVA.getDefaultState();
    private final BlockState chain = Blocks.CHAIN.getDefaultState();

    public NetherWellFeature(Codec<NetherWellConfig> codec)
    {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NetherWellConfig config)
    {
        for (pos = pos.up(); reader.isAirBlock(pos) && pos.getY() > 2; pos = pos.down())
        {
        }

        if (IS_NETHERRACK.test(reader.getBlockState(pos)) || IS_CRIMSON_NYLIUM.test(reader.getBlockState(pos)) || IS_WARPED_NYLIUM.test(reader.getBlockState(pos)) || IS_BLACKSTONE.test(reader.getBlockState(pos)) || IS_SOUL_SOIL.test(reader.getBlockState(pos)) || IS_SOUL_SAND.test(reader.getBlockState(pos)))
        {
            for (int x = -2; x <= 2; ++x)
            {
                for (int z = -2; z <= 2; ++z)
                {
                    if (reader.isAirBlock(pos.add(x, -1, z)) && reader.isAirBlock(pos.add(x, -2, z)))
                    {
                        return false;
                    }
                }
            }

            for (int y = 1; y <= 5; ++y)
            {
                for (int x = -2; x <= 2; ++x)
                {
                    for (int z = -2; z <= 2; ++z)
                    {
                        if (!reader.isAirBlock(pos.add(x, y, z)))
                        {
                            return false;
                        }
                    }
                }
            }

            System.out.println("Nether Well generated at: X: " + pos.getX() + ", Y: " + pos.getY() + ", Z: " + pos.getZ());

            for (int y = -1; y <= 0; ++y)
            {
                for (int x = -2; x <= 2; ++x)
                {
                    for (int z = -2; z <= 2; ++z)
                    {
                        reader.setBlockState(pos.add(x, y, z), getMainBlock(config, rand), 2);
                    }
                }
            }

            reader.setBlockState(pos, lava, 2);

            for (Direction direction : Direction.Plane.HORIZONTAL)
            {
                reader.setBlockState(pos.offset(direction), lava, 2);
            }

            for (int x = -2; x <= 2; ++x)
            {
                for (int z = -2; z <= 2; ++z)
                {
                    if (Math.abs(x) > 1 && Math.abs(z) > 1)
                    {
                        reader.setBlockState(pos.add(x, 1, z), getMainBlock(config, rand), 2);
                    }
                }
            }

            reader.setBlockState(pos.add(2, 1, 0), getSlabBlock(config, rand), 2);
            reader.setBlockState(pos.add(-2, 1, 0), getSlabBlock(config, rand), 2);
            reader.setBlockState(pos.add(0, 1, 2), getSlabBlock(config, rand), 2);
            reader.setBlockState(pos.add(0, 1, -2), getSlabBlock(config, rand), 2);

            reader.setBlockState(pos.add(2, 1, 1), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.SOUTH), 2);
            reader.setBlockState(pos.add(2, 1, -1), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.NORTH), 2);
            reader.setBlockState(pos.add(-2, 1, 1), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.SOUTH), 2);
            reader.setBlockState(pos.add(-2, 1, -1), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.NORTH), 2);
            reader.setBlockState(pos.add(1, 1, 2), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.EAST), 2);
            reader.setBlockState(pos.add(-1, 1, 2), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.WEST), 2);
            reader.setBlockState(pos.add(1, 1, -2), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.EAST), 2);
            reader.setBlockState(pos.add(-1, 1, -2), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.WEST), 2);

            for (int y = 1; y <= 3; ++y)
            {
                reader.setBlockState(pos.add(-1, y, -1), getMainBlock(config, rand), 2);
                reader.setBlockState(pos.add(-1, y, 1), getMainBlock(config, rand), 2);
                reader.setBlockState(pos.add(1, y, -1), getMainBlock(config, rand), 2);
                reader.setBlockState(pos.add(1, y, 1), getMainBlock(config, rand), 2);
            }

            reader.setBlockState(pos.add(-1, 4, -1), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.EAST), 2);
            reader.setBlockState(pos.add(-1, 4, 1), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.EAST), 2);
            reader.setBlockState(pos.add(-1, 4, 0), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.EAST), 2);

            reader.setBlockState(pos.add(1, 4, -1), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.WEST), 2);
            reader.setBlockState(pos.add(1, 4, 1), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.WEST), 2);
            reader.setBlockState(pos.add(1, 4, 0), getStairBlock(config, rand).with(StairsBlock.FACING, Direction.WEST), 2);

            reader.setBlockState(pos.add(0, 4, 1), config.getChiseledBlock(), 2);
            reader.setBlockState(pos.add(0, 4, -1), config.getChiseledBlock(), 2);

            reader.setBlockState(pos.add(0, 5, 1), getSlabBlock(config, rand), 2);
            reader.setBlockState(pos.add(0, 5, 0), getSlabBlock(config, rand), 2);
            reader.setBlockState(pos.add(0, 5, -1), getSlabBlock(config, rand), 2);

            for (Direction direction : Direction.Plane.HORIZONTAL)
            {
                BlockState wall = config.getWallBlock().updatePostPlacement(direction.rotateY(), config.getWallBlock(), reader, pos, pos.offset(direction.rotateY()));
                reader.setBlockState(pos.offset(direction).up(), wall.updatePostPlacement(direction.rotateYCCW(), wall, reader, pos, pos.offset(direction.rotateYCCW())), 2);
            }

            for (int y = 3; y <= 4; ++y)
            {
                reader.setBlockState(pos.add(0, y, 0), chain, 2);
            }

            if (!addLanternPost(reader, getRandomCorner(pos, rand), config)) 
            {
                for (int i = 0; i <= 4; ++i) 
                {
                    reader.setBlockState(getRandomCorner(pos, rand), Blocks.SOUL_LANTERN.getDefaultState(), 2);
                }
            }

            return true;
        }

        return false;
    }

    public boolean addLanternPost(ISeedReader reader, BlockPos pos, NetherWellConfig config)
    {
        if (config.getMainBlock().getBlock() == Blocks.NETHER_BRICKS)
        {
            reader.setBlockState(pos, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 2);
            reader.setBlockState(pos.up(), Blocks.SOUL_LANTERN.getDefaultState(), 2);
            
            return true;
        }
        else if (config.getMainBlock().getBlock() == Blocks.RED_NETHER_BRICKS)
        {
            reader.setBlockState(pos, ModBlocks.RED_NETHER_BRICK_FENCE.getDefaultState(), 2);
            reader.setBlockState(pos.up(), Blocks.SOUL_LANTERN.getDefaultState(), 2);
            
            return true;
        }
        
        return false;
    }

    public BlockPos getRandomCorner(BlockPos pos, Random rand)
    {
        switch (rand.nextInt(4))
        {
            case 0:
            {
                return pos.add(2, 2, 2);
            }
            case 1:
            {
                return pos.add(-2, 2, -2);
            }
            case 2:
            {
                return pos.add(-2, 2, 2);
            }
            default:
            {
                return pos.add(2, 2, -2);
            }
        }
    }

    public BlockState getMainBlock(NetherWellConfig config, Random rand)
    {
        return rand.nextInt(4) == 0 ? config.getCrackedBlock() : config.getMainBlock();
    }

    public BlockState getStairBlock(NetherWellConfig config, Random rand)
    {
        return rand.nextInt(3) == 0 ? config.getCrackedStairBlock() : config.getStairBlock();
    }

    public BlockState getSlabBlock(NetherWellConfig config, Random rand)
    {
        return rand.nextInt(2) == 0 ? config.getCrackedSlabBlock() : config.getSlabBlock();
    }
}
