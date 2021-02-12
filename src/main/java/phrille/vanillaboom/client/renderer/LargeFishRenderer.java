package phrille.vanillaboom.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import phrille.vanillaboom.entity.fish.BaseFishEntity;

public class LargeFishRenderer extends BaseFishRenderer
{
    public LargeFishRenderer(EntityRendererManager renderManager, SegmentedModel<BaseFishEntity> model, String name)
    {
        super(renderManager, model, name);
    }

    @Override
    protected void translation(MatrixStack matrix)
    {
        matrix.translate(0.0D, 0.0D, (double) -0.4F);
    }

    @Override
    protected void landTranslation(MatrixStack matrix)
    {
        matrix.translate((double) 0.2F, 0.1F, 0.0D);
    }
}
