package phrille.vanillaboom.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.client.model.PerchModel;
import phrille.vanillaboom.entity.PerchEntity;

@OnlyIn(Dist.CLIENT)
public class PerchRenderer extends MobRenderer<PerchEntity, PerchModel<PerchEntity>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(VanillaBoom.MOD_ID, "textures/entity/perch.png");

    public PerchRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new PerchModel<>(), 0.3F);
    }

    public ResourceLocation getEntityTexture(PerchEntity entity)
    {
        return TEXTURE;
    }

    protected void applyRotations(PerchEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
        if (!entityLiving.isInWater())
        {
            matrixStackIn.translate((double) 0.1F, (double) 0.1F, (double) -0.1F);
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }
}
