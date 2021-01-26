package phrille.vanillaboom.world.structures;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
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
import phrille.vanillaboom.init.ModBlocks;

public class GraveStructure extends Structure<NoFeatureConfig>
{
    public GraveStructure(Codec<NoFeatureConfig> codec)
    {
        super(codec);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory()
    {
        return GraveStructure.Start::new;
    }

    @Override
    public GenerationStage.Decoration getDecorationStage()
    {
        return GenerationStage.Decoration.VEGETAL_DECORATION;
    }

    public static class Start extends StructureStart<NoFeatureConfig>
    {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn)
        {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }

        @Override
        public void func_230364_a_(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config)
        {
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;
            int seaLevel = chunkGenerator.getSeaLevel();
            int y = seaLevel + rand.nextInt(chunkGenerator.getMaxBuildHeight() - 10 - seaLevel);

            IBlockReader iblockreader = chunkGenerator.func_230348_a_(x, z);
            BlockPos pos = null;
            
            for (; y > seaLevel; y--) 
            {
                pos = new BlockPos(x, y, z);
                BlockState state = iblockreader.getBlockState(pos);
                BlockState stateDown = iblockreader.getBlockState(pos.down());

                if (state.getBlock().isAir(state, iblockreader, pos) && (isValidBlock(stateDown)|| stateDown.isSolidSide(iblockreader, pos.down(), Direction.UP)))
                {
                    break;
                }
            }

            if (y > seaLevel && pos != null)
            {
                JigsawManager.func_242837_a(dynamicRegistryManager, new VillageConfig(() -> dynamicRegistryManager.getRegistry(Registry.JIGSAW_POOL_KEY).getOrDefault(new ResourceLocation(VanillaBoom.MOD_ID, "grave/grave_pool")), 1), AbstractVillagePiece::new, chunkGenerator, templateManagerIn, pos, components, rand, false, false);
                recalculateStructureSize();
            }
        }

        public boolean isValidBlock(BlockState state)
        {
            return state.getBlock() == Blocks.SOUL_SAND || state.getBlock() == Blocks.SOUL_SOIL;
        }
    }
}