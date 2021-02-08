package phrille.vanillaboom.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.CustomPaintingEntity;
import phrille.vanillaboom.entity.PerchEntity;
import phrille.vanillaboom.entity.PrismarineArrowEntity;
import phrille.vanillaboom.util.Names;
import phrille.vanillaboom.util.Utils;

@ObjectHolder(VanillaBoom.MOD_ID)
public class ModEntities
{
    public static final EntityType<PrismarineArrowEntity> PRISMARINE_ARROW = Utils._null();
    public static final EntityType<CustomPaintingEntity> CUSTOM_PAINTING = Utils._null();

    public static final EntityType<PerchEntity> PERCH = Utils._null();

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Bus.MOD)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
        {
            event.getRegistry().register(build(Names.PRISMARINE_ARROW, EntityType.Builder.<PrismarineArrowEntity>create(PrismarineArrowEntity::new, EntityClassification.MISC).setCustomClientFactory((spawnEntity, world) -> new PrismarineArrowEntity(PRISMARINE_ARROW, world)).size(0.5f, 0.5f)));
            event.getRegistry().register(build(Names.CUSTOM_PAINTING, EntityType.Builder.<CustomPaintingEntity>create(CustomPaintingEntity::new, EntityClassification.MISC).setCustomClientFactory((spawnEntity, world) -> new CustomPaintingEntity(CUSTOM_PAINTING, world)).size(0.5f, 0.5f)));

            event.getRegistry().register(build("perch", EntityType.Builder.<PerchEntity>create(PerchEntity::new, EntityClassification.WATER_AMBIENT).setCustomClientFactory((spawnEntity, world) -> new PerchEntity(PERCH, world)).size(0.5F, 0.3F).trackingRange(4)));
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
        GlobalEntityTypeAttributes.put(ModEntities.PERCH, PerchEntity.getAttributes().create());
        //EntitySpawnPlacementRegistry.register(PERCH, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PerchEntity::func_223363_b);
    }
}
