package phrille.vanillaboom.init;

import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.world.structures.GraveStructure;
import phrille.vanillaboom.world.structures.NetherWellStructure;

public class ModStructures
{

    public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, VanillaBoom.MOD_ID);

    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_WELL = registerStructure("nether_well", () -> (new NetherWellStructure(NoFeatureConfig.field_236558_a_)));
    public static final RegistryObject<Structure<NoFeatureConfig>> GRAVE = registerStructure("grave", () -> (new GraveStructure(NoFeatureConfig.field_236558_a_)));

    public static void init(IEventBus modEventBus)
    {
        STRUCTURES.register(modEventBus);
    }

    private static <T extends Structure<?>> RegistryObject<T> registerStructure(String name, Supplier<T> structure)
    {
        return STRUCTURES.register(name, structure);
    }

    public static void setupStructures()
    {
        setupMapSpacingAndLand(NETHER_WELL.get(), new StructureSeparationSettings(6, 2, 847633048), true);
        setupMapSpacingAndLand(GRAVE.get(), new StructureSeparationSettings(5, 3, 847633049), true);
    }

    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand)
    {
        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);

        if (transformSurroundingLand)
        {
            Structure.field_236384_t_ = ImmutableList.<Structure<?>>builder().addAll(Structure.field_236384_t_).add(structure).build();
        }

        DimensionStructuresSettings.field_236191_b_ = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder().putAll(DimensionStructuresSettings.field_236191_b_).put(structure, structureSeparationSettings).build();
    }
}
