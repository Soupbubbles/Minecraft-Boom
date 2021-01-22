package phrille.vanillaboom.world.biome;

import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.ParticleEffectAmbience;
import net.minecraft.world.biome.SoundAdditionsAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class BiomeBuilder
{
    public static Biome buildGraveyardBiome()
    {
        MobSpawnInfo mobspawninfo = (new MobSpawnInfo.Builder())
                .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 20, 5, 5))
                .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.GHAST, 50, 4, 4))
                .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 1, 4, 4))
                .withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRIDER, 60, 1, 2))
                .withSpawnCost(EntityType.SKELETON, 0.7D, 0.15D).withSpawnCost(EntityType.GHAST, 0.7D, 0.15D)
                .withSpawnCost(EntityType.ENDERMAN, 0.7D, 0.15D).withSpawnCost(EntityType.STRIDER, 0.7D, 0.15D).copy();

        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder())
                .withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244187_s)
                .withStructure(StructureFeatures.FORTRESS)
                .withStructure(StructureFeatures.NETHER_FOSSIL)
                .withStructure(StructureFeatures.RUINED_PORTAL_NETHER)
                .withStructure(StructureFeatures.BASTION_REMNANT)
                .withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.field_243772_f)
                .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA)
                .withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Features.BASALT_PILLAR)
                .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_OPEN)
                .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA)
                .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE)
                .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_CRIMSON_ROOTS)
                .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE)
                .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_SOUL_FIRE)
                .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA)
                .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED)
                .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_SOUL_SAND);
        
        DefaultBiomeFeatures.withCommonNetherBlocks(biomegenerationsettings$builder);
        
        return (new Biome.Builder())
                .precipitation(Biome.RainType.NONE)
                .category(Biome.Category.NETHER)
                .depth(0.1F)
                .scale(0.2F)
                .temperature(2.0F)
                .downfall(0.0F)
                .setEffects((new BiomeAmbience.Builder())
                .setWaterColor(4159204)
                .setWaterFogColor(329011)
                .setFogColor(1787717)
                .withSkyColor(getSkyColorWithTemperatureModifier(2.0F))
                .setParticle(new ParticleEffectAmbience(ParticleTypes.ASH, 0.00625F))
                .setAmbientSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP)
                .setMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                .setAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_NETHER_SOUL_SAND_VALLEY))
                .build()).withMobSpawnSettings(mobspawninfo).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }
    
    private static int getSkyColorWithTemperatureModifier(float temperature)
    {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
     }
}
