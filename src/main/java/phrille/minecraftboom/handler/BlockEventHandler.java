package phrille.minecraftboom.handler;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.minecraftboom.init.ModItems;

@Mod.EventBusSubscriber
public class BlockEventHandler
{

    @SubscribeEvent
    public void onBlockDropItems(BlockEvent.HarvestDropsEvent event)
    {
        Random rand = event.getWorld().getRandom();

        if (event.isCanceled())
        {
            return;
        }

        if (event.getState().getBlock() == Blocks.SPRUCE_LEAVES)
        {
            event.setDropChance(1.0F);

            if (rand.nextFloat() < 0.02)
            {
                event.getDrops().add(new ItemStack(ModItems.ITEM_PINECONE));
            }
        }
        else if (event.getState().getBlock() == Blocks.PUMPKIN)
        {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(ModItems.ITEM_PUMPKIN_SLICE, Math.min(9, (3 + rand.nextInt(5)) + rand.nextInt(1 + event.getFortuneLevel()))));
        }
    }
}