package phrille.vanillaboom.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.util.Utils;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, value = Dist.CLIENT)
public class ClientEventHandler
{
    private static final int BLIT_OFFSET = 1;

    @SubscribeEvent
    public static void onRenderTooltip(RenderTooltipEvent.PostText event)
    {
        ItemStack stack = event.getStack();

        if (VanillaBoomConfig.addFoodTooltips && !stack.isEmpty() && Utils.isFood(stack.getItem()))
        {
            Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));

            int uOffset = 16;
            int vOffset = 27;
            int uWidth = 9;
            int vHeight = 9;
            int x = event.getX() - 1;
            int y = event.getY() + 11 * (event.getLines().size() - 1);
            int healing = Utils.isCake(stack.getItem()) ? 14 : stack.getItem().getFood().getHealing();
            int k = healing - healing / 2;

            for (int i = 0; i < k; i++)
            {
                blit(event.getMatrixStack(), x + 8 * i, y, uOffset, vOffset, uWidth, vHeight);

                if (i == k - 1)
                {
                    int j = healing % 2 == 0 ? 0 : 9;

                    blit(event.getMatrixStack(), x + 8 * i, y, uOffset + 36 + j, vOffset, uWidth, vHeight);
                }
                else
                {
                    blit(event.getMatrixStack(), x + 8 * i, y, uOffset + 36, vOffset, uWidth, vHeight);
                }
            }
        }
    }

    public static void blit(MatrixStack matrixStack, int x, int y, int uOffset, int vOffset, int uWidth, int vHeight)
    {
        blit(matrixStack, x, y, uOffset, vOffset, uWidth, vHeight, 256, 256);
    }

    public static void blit(MatrixStack matrixStack, int x, int y, int uOffset, int vOffset, int uWidth, int vHeight, int textureWidth, int textureHeight)
    {
        innerBlit(matrixStack.getLast().getMatrix(), x, x + uWidth, y, y + vHeight, (uOffset + 0.0F) / (float) textureWidth, (uOffset + (float) uWidth) / (float) textureWidth, (vOffset + 0.0F) / (float) textureHeight, (vOffset + (float) vHeight) / (float) textureHeight);
    }

    private static void innerBlit(Matrix4f matrix, int x1, int x2, int y1, int y2, float minU, float maxU, float minV, float maxV)
    {
        BufferBuilder bufferbuilder = Tessellator.getInstance().getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos(matrix, (float) x1, (float) y2, (float) BLIT_OFFSET).tex(minU, maxV).endVertex();
        bufferbuilder.pos(matrix, (float) x2, (float) y2, (float) BLIT_OFFSET).tex(maxU, maxV).endVertex();
        bufferbuilder.pos(matrix, (float) x2, (float) y1, (float) BLIT_OFFSET).tex(maxU, minV).endVertex();
        bufferbuilder.pos(matrix, (float) x1, (float) y1, (float) BLIT_OFFSET).tex(minU, minV).endVertex();
        bufferbuilder.finishDrawing();
        RenderSystem.enableAlphaTest();
        WorldVertexBufferUploader.draw(bufferbuilder);
    }
}
