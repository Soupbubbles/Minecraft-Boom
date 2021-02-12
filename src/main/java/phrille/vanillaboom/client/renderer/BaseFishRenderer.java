package phrille.vanillaboom.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.fish.BaseFishEntity;

public class BaseFishRenderer extends MobRenderer<BaseFishEntity, SegmentedModel<BaseFishEntity>>
{
    private final ResourceLocation texture;

    public BaseFishRenderer(EntityRendererManager renderManager, SegmentedModel<BaseFishEntity> model, String name)
    {
        super(renderManager, model, 0.3F);
        texture = new ResourceLocation(VanillaBoom.MOD_ID, "textures/entity/" + name + ".png");
    }

    @Override
    protected void applyRotations(BaseFishEntity fishEntity, MatrixStack matrix, float ageInTicks, float rotationYaw, float partialTicks)
    {
        super.applyRotations(fishEntity, matrix, ageInTicks, rotationYaw, partialTicks);
        float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);

        matrix.rotate(Vector3f.YP.rotationDegrees(f));
        translation(matrix);

        if (!fishEntity.isInWater())
        {
            landTranslation(matrix);
            matrix.rotate(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }

    @Override
    public ResourceLocation getEntityTexture(BaseFishEntity entity)
    {
        return texture;
    }

    protected void translation(MatrixStack matrix)
    {
    }

    protected void landTranslation(MatrixStack matrix)
    {
        matrix.translate((double) 0.1F, (double) 0.1F, (double) -0.1F);
    }
}
