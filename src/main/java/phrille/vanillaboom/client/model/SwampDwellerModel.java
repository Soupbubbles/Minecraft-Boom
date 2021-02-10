package phrille.vanillaboom.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SwampDwellerModel<T extends Entity> extends PerchModel<T>
{
    protected ModelRenderer finTopLeft;
    protected ModelRenderer finTopRight;

    public SwampDwellerModel()
    {
        super();

        finTop = new ModelRenderer(this, 14, 5);
        finTop.setRotationPoint(0.0F, 20.0F, -1.0F);
        finTop.addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);

        finTopLeft = new ModelRenderer(this, 14, 7);
        finTopLeft.setRotationPoint(1.0F, 21.0F, -1.0F);
        finTopLeft.addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);

        finTopRight = new ModelRenderer(this, 14, 9);
        finTopRight.setRotationPoint(-1.0F, 21.0F, -1.0F);
        finTopRight.addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public Iterable<ModelRenderer> getParts()
    {
        return Iterables.concat(ImmutableList.of(finTopRight, finTopLeft), super.getParts());
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        float f = 0.5F * MathHelper.sin(0.08F * ageInTicks);

        finTop.rotateAngleZ = f;
        finTopLeft.rotateAngleZ = f + 0.6F;
        finTopRight.rotateAngleZ = -f - 0.6F;
    }
}
