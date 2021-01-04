package phrille.vanillaboom.event;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.init.ModBlocks;
import phrille.vanillaboom.init.ModItems;

@Mod.EventBusSubscriber
public class FurnaceFuelEventHandler
{
    //Vanilla
    public static final int BLAZE_POWDER = 1200;

    //VanillaBoom
    public static final int CHARCOAL_BLOCK = 16000;
    public static final int BLAZE_POWDER_BLOCK = 10800;
    public static final int WITHER_BONE_BLOCK = 9000;
    public static final int WITHER_BONE = 1000;
    public static final int PINECONE = 300;

    @SubscribeEvent
    public void onFuelBurnTime(FurnaceFuelBurnTimeEvent event)
    {
        Item item = event.getItemStack().getItem();

        if (item == Items.BLAZE_POWDER)
        {
            event.setBurnTime(BLAZE_POWDER);
        }
        else if (item == Item.getItemFromBlock(ModBlocks.CHARCOAL_BLOCK))
        {
            event.setBurnTime(CHARCOAL_BLOCK);
        }
        else if (item == Item.getItemFromBlock(ModBlocks.BLAZE_POWDER_BLOCK))
        {
            event.setBurnTime(BLAZE_POWDER_BLOCK);
        }
        else if (item == Item.getItemFromBlock(ModBlocks.WITHER_BONE_BLOCK))
        {
            event.setBurnTime(WITHER_BONE_BLOCK);
        }
        else if (item == ModItems.WITHER_BONE)
        {
            event.setBurnTime(WITHER_BONE);
        }
        else if (item == ModItems.PINECONE)
        {
            event.setBurnTime(PINECONE);
        }
    }
}
