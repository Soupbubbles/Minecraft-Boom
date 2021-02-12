package phrille.vanillaboom.init;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.tileentity.RainDetectorTileEntity;

public class ModTileEntities
{
    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, VanillaBoom.MOD_ID);

    public static final RegistryObject<TileEntityType<RainDetectorTileEntity>> RAIN_DETECTOR = TILE_ENTITY_TYPES.register("rain_detector", () -> TileEntityType.Builder.create(RainDetectorTileEntity::new, ModBlocks.RAIN_DETECTOR).build(null));

    public static void init(IEventBus modEventBus)
    {
        TILE_ENTITY_TYPES.register(modEventBus);
    }
}
