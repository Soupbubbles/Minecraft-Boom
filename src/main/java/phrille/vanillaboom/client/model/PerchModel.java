package phrille.vanillaboom.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PerchModel<T extends Entity> extends SegmentedModel<T>
{
    protected final ModelRenderer body;
    protected final ModelRenderer finTop;
    protected final ModelRenderer head;
    protected final ModelRenderer headFront;
    protected final ModelRenderer finRight;
    protected final ModelRenderer finLeft;
    protected final ModelRenderer tail;

    public PerchModel()
    {
        textureWidth = 32;
        textureHeight = 32;

        body = new ModelRenderer(this, 0, 0);
        body.addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 7.0F);
        body.setRotationPoint(0.0F, 22.0F, 0.0F);
        head = new ModelRenderer(this, 11, 0);
        head.addBox(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F);
        head.setRotationPoint(0.0F, 22.0F, 0.0F);
        headFront = new ModelRenderer(this, 0, 0);
        headFront.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 1.0F);
        headFront.setRotationPoint(0.0F, 22.0F, -3.0F);
        finRight = new ModelRenderer(this, 22, 2);
        finRight.addBox(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F);
        finRight.setRotationPoint(-1.0F, 23.0F, 0.0F);
        finRight.rotateAngleZ = (-(float) Math.PI / 4F);
        finLeft = new ModelRenderer(this, 22, 4);
        finLeft.addBox(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F);
        finLeft.setRotationPoint(1.0F, 23.0F, 0.0F);
        finLeft.rotateAngleZ = ((float) Math.PI / 4F);
        tail = new ModelRenderer(this, 22, 3);
        tail.addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F);
        tail.setRotationPoint(0.0F, 22.0F, 7.0F);
        finTop = new ModelRenderer(this, 20, -6);
        finTop.addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 6.0F);
        finTop.setRotationPoint(0.0F, 20.0F, 0.0F);
    }

    @Override
    public Iterable<ModelRenderer> getParts()
    {
        return ImmutableList.of(body, head, headFront, finRight, finLeft, tail, finTop);
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        float f = 1.0F;

        if (!entity.isInWater())
        {
            f = 1.5F;
        }

        tail.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
    }
}
