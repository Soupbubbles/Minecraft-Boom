package phrille.vanillaboom.util;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.item.ModItems;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class FuelEventHandler
{
    //Vanilla
    public static final int BLAZE_POWDER = 1200;

    //Vanilla Boom
    public static final int CHARCOAL_BLOCK = 16000;
    public static final int BLAZE_POWDER_BLOCK = 10800;
    public static final int WITHER_BONE_BLOCK = 9000;
    public static final int WITHER_BONE = 1000;
    public static final int WITHER_BONE_MEAL = 333;
    public static final int PINECONE = 300;

    @SubscribeEvent
    public void onFuelBurnTime(FurnaceFuelBurnTimeEvent event)
    {
        if (event.getItemStack().isEmpty()) 
        {
            return;
        }
        
        Item item = event.getItemStack().getItem();

        if (item == Items.BLAZE_POWDER)
        {
            event.setBurnTime(BLAZE_POWDER);
        }
        else if (item == ModBlocks.CHARCOAL_BLOCK.asItem())
        {
            event.setBurnTime(CHARCOAL_BLOCK);
        }
        else if (item == ModBlocks.BLAZE_POWDER_BLOCK.asItem())
        {
            event.setBurnTime(BLAZE_POWDER_BLOCK);
        }
        else if (item == ModBlocks.WITHER_BONE_BLOCK.asItem())
        {
            event.setBurnTime(WITHER_BONE_BLOCK);
        }
        else if (item == ModItems.WITHER_BONE)
        {
            event.setBurnTime(WITHER_BONE);
        }
        else if (item == ModItems.WITHER_BONE_MEAL)
        {
            event.setBurnTime(WITHER_BONE_MEAL);
        }
        else if (item == ModItems.PINECONE)
        {
            event.setBurnTime(PINECONE);
        }
    }
}
