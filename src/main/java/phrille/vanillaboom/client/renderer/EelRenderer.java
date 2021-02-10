package phrille.vanillaboom.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import phrille.vanillaboom.client.model.EelModel;

public class EelRenderer extends BaseFishRenderer
{
    public EelRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new EelModel(), "eel");
    }

    @Override
    protected void translation(MatrixStack matrix)
    {
        matrix.translate(0.0D, 0.0D, (double) -0.55F);
    }

    @Override
    protected void landTranslation(MatrixStack matrix)
    {
        matrix.translate((double) 0.1F, (double) 0.1F, 0.0D);
    }
}
