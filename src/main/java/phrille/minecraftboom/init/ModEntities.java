package phrille.minecraftboom.init;

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import phrille.minecraftboom.MinecraftBoom;
import phrille.minecraftboom.entity.EntityPrismarineArrow;
import phrille.minecraftboom.lib.Names;
import phrille.minecraftboom.util.Utils;

@ObjectHolder(MinecraftBoom.MOD_ID)
public class ModEntities
{
    public static final EntityType<EntityPrismarineArrow> PRISMARINE_ARROW = Utils._null();

    @Mod.EventBusSubscriber(modid = MinecraftBoom.MOD_ID, bus = Bus.MOD)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
        {
            event.getRegistry().register(build(Names.PRISMARINE_ARROW, EntityType.Builder.create(EntityPrismarineArrow.class, EntityPrismarineArrow::new).tracker(64, 20, false)));
        }

        private static EntityType<?> build(String name, EntityType.Builder<?> builder)
        {
            ResourceLocation registryName = new ResourceLocation(MinecraftBoom.MOD_ID, name);
            return builder.build(registryName.toString()).setRegistryName(registryName);
        }
    }
}
