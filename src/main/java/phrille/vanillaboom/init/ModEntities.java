package phrille.vanillaboom.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.CustomPaintingEntity;
import phrille.vanillaboom.entity.PrismarineArrowEntity;
import phrille.vanillaboom.entity.fish.BaseFishEntity;
import phrille.vanillaboom.entity.fish.EelEntity;
import phrille.vanillaboom.entity.fish.PerchEntity;
import phrille.vanillaboom.entity.fish.PikeEntity;
import phrille.vanillaboom.entity.fish.SwampDwellerEntity;
import phrille.vanillaboom.entity.fish.TunaEntity;
import phrille.vanillaboom.util.Names;
import phrille.vanillaboom.util.Utils;

@ObjectHolder(VanillaBoom.MOD_ID)
public class ModEntities
{
    public static final EntityType<PrismarineArrowEntity> PRISMARINE_ARROW = Utils._null();
    public static final EntityType<CustomPaintingEntity> CUSTOM_PAINTING = Utils._null();

    public static final EntityType<EelEntity> TUNA = Utils._null();
    public static final EntityType<PerchEntity> PERCH = Utils._null();
    public static final EntityType<PerchEntity> PIKE = Utils._null();
    public static final EntityType<EelEntity> EEL = Utils._null();
    public static final EntityType<EelEntity> SWAMP_DWELLER = Utils._null();

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Bus.MOD)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
        {
            event.getRegistry().register(build(Names.PRISMARINE_ARROW, EntityType.Builder.<PrismarineArrowEntity>create(PrismarineArrowEntity::new, EntityClassification.MISC).setCustomClientFactory((spawnEntity, world) -> new PrismarineArrowEntity(PRISMARINE_ARROW, world)).size(0.5F, 0.5F)));
            event.getRegistry().register(build(Names.CUSTOM_PAINTING, EntityType.Builder.<CustomPaintingEntity>create(CustomPaintingEntity::new, EntityClassification.MISC).setCustomClientFactory((spawnEntity, world) -> new CustomPaintingEntity(CUSTOM_PAINTING, world)).size(0.5F, 0.5F)));

            event.getRegistry().register(build("tuna", EntityType.Builder.<TunaEntity>create(TunaEntity::new, EntityClassification.WATER_AMBIENT).setCustomClientFactory((spawnEntity, world) -> new TunaEntity(TUNA, world)).size(0.6F, 0.6F).trackingRange(4)));
            event.getRegistry().register(build("perch", EntityType.Builder.<PerchEntity>create(PerchEntity::new, EntityClassification.WATER_AMBIENT).setCustomClientFactory((spawnEntity, world) -> new PerchEntity(PERCH, world)).size(0.5F, 0.3F).trackingRange(4)));
            event.getRegistry().register(build("pike", EntityType.Builder.<PikeEntity>create(PikeEntity::new, EntityClassification.WATER_AMBIENT).setCustomClientFactory((spawnEntity, world) -> new PikeEntity(PIKE, world)).size(0.7F, 0.4F).trackingRange(4)));
            event.getRegistry().register(build("eel", EntityType.Builder.<EelEntity>create(EelEntity::new, EntityClassification.WATER_AMBIENT).setCustomClientFactory((spawnEntity, world) -> new EelEntity(EEL, world)).size(0.8F, 0.2F).trackingRange(4)));
            event.getRegistry().register(build("swamp_dweller", EntityType.Builder.<SwampDwellerEntity>create(SwampDwellerEntity::new, EntityClassification.WATER_AMBIENT).setCustomClientFactory((spawnEntity, world) -> new SwampDwellerEntity(SWAMP_DWELLER, world)).size(0.5F, 0.3F).trackingRange(4)));
        }

        private static <T extends Entity> EntityType<T> build(String name, EntityType.Builder<T> builder)
        {
            ResourceLocation registryName = new ResourceLocation(VanillaBoom.MOD_ID, name);
            EntityType<T> entityType = builder.build(registryName.toString());
            entityType.setRegistryName(registryName);

            return entityType;
        }
    }

    public static void registerAttributes()
    {
        GlobalEntityTypeAttributes.put(ModEntities.TUNA, BaseFishEntity.getAttributes().create());
        GlobalEntityTypeAttributes.put(ModEntities.PERCH, BaseFishEntity.getAttributes().create());
        GlobalEntityTypeAttributes.put(ModEntities.PIKE, BaseFishEntity.getAttributes().create());
        GlobalEntityTypeAttributes.put(ModEntities.EEL, BaseFishEntity.getAttributes().create());
        GlobalEntityTypeAttributes.put(ModEntities.SWAMP_DWELLER, BaseFishEntity.getAttributes().create());

        //EntitySpawnPlacementRegistry.register(PERCH, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PerchEntity::func_223363_b);
    }
}
