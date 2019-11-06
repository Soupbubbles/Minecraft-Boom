package phrille.minecraftboom.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.entity.PrismarineArrowEntity;
import phrille.minecraftboom.lib.Names;
import phrille.minecraftboom.util.Utils;

@ObjectHolder(MinecraftBoom.MOD_ID)
public class ModEntities
{
    public static final EntityType<PrismarineArrowEntity> PRISMARINE_ARROW = Utils._null();

    @Mod.EventBusSubscriber(modid = MinecraftBoom.MOD_ID, bus = Bus.MOD)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
        {
            event.getRegistry().register(build(Names.PRISMARINE_ARROW, EntityType.Builder.<PrismarineArrowEntity>create(PrismarineArrowEntity::new, EntityClassification.MISC).setCustomClientFactory((spawnEntity, world) -> new PrismarineArrowEntity(PRISMARINE_ARROW, world)).size(0.5f, 0.5f)));
        }

        private static <T extends Entity> EntityType<T> build(String name, EntityType.Builder<T> builder)
        {
            ResourceLocation registryName = new ResourceLocation(MinecraftBoom.MOD_ID, name);
            EntityType<T> entityType = builder.build(registryName.toString());
            entityType.setRegistryName(registryName);

            return entityType;
        }
    }
}
