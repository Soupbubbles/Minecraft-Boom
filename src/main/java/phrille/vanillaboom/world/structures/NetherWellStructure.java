package phrille.vanillaboom.world.structures;

import org.apache.logging.log4j.Level;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;
import phrille.vanillaboom.VanillaBoom;

public class NetherWellStructure extends Structure<NoFeatureConfig>
{
    public NetherWellStructure(Codec<NoFeatureConfig> codec)
    {
        super(codec);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory()
    {
        return NetherWellStructure.Start::new;
    }

    @Override
    public GenerationStage.Decoration getDecorationStage()
    {
        return GenerationStage.Decoration.UNDERGROUND_DECORATION;
    }

    public static class Start extends StructureStart<NoFeatureConfig>
    {
        private static final int MAX_HEIGHT = 100;
        
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn)
        {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }

        @Override
        public void func_230364_a_(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config)
        {
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;
            int k = chunkGenerator.getSeaLevel();
            int y = k + rand.nextInt(chunkGenerator.getMaxBuildHeight() - 70 - k);

            IBlockReader iblockreader = chunkGenerator.func_230348_a_(x, z);
            BlockPos.Mutable mutable;

            for (mutable = new BlockPos.Mutable(x, y, z); y > k; --y)
            {
                if (iblockreader.getBlockState(mutable).isAir() && isValidBlock(iblockreader.getBlockState(mutable.move(Direction.DOWN))))
                {
                    break;
                }
            }

            if (y > k && y < MAX_HEIGHT)
            {
                JigsawManager.func_242837_a(dynamicRegistryManager, new VillageConfig(() -> dynamicRegistryManager.getRegistry(Registry.JIGSAW_POOL_KEY).getOrDefault(new ResourceLocation(VanillaBoom.MOD_ID, "nether_well/nether_well_pool")), 1), AbstractVillagePiece::new, chunkGenerator, templateManagerIn, new BlockPos(x, y, z), components, rand, false, false);
                components.forEach(piece -> piece.getBoundingBox().minY += 1);
                recalculateStructureSize();
            }
        }

        public boolean isValidBlock(BlockState state)
        {
            return state.isIn(Blocks.NETHERRACK) || state.isIn(Blocks.WARPED_NYLIUM) || state.isIn(Blocks.CRIMSON_NYLIUM) || state.isIn(Blocks.SOUL_SOIL) || state.isIn(Blocks.SOUL_SAND);
        }
    }
}