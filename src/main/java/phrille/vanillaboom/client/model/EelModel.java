package phrille.vanillaboom.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import phrille.vanillaboom.entity.fish.BaseFishEntity;

public class EelModel<T extends Entity> extends SegmentedModel<T>
{
    protected ModelRenderer finRight;
    protected ModelRenderer finLeft;
    protected ModelRenderer bodyFront;
    protected ModelRenderer bodyMiddle;
    protected ModelRenderer head;
    protected ModelRenderer finFront;
    protected ModelRenderer finMiddle;
    protected ModelRenderer bodyBack;
    protected ModelRenderer finTail;
    protected ModelRenderer finBack;

    public EelModel()
    {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this, 12, 0);
        head.setRotationPoint(0.0F, 22.0F, -1.0F);
        head.addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);

        finFront = new ModelRenderer(this, 0, 4);
        finFront.setRotationPoint(0.0F, -2.0F, 0.0F);
        finFront.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        bodyFront = new ModelRenderer(this, 0, 0);
        bodyFront.setRotationPoint(0.0F, 0.0F, -1.0F);
        bodyFront.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        bodyMiddle = new ModelRenderer(this, 12, 11);
        bodyMiddle.setRotationPoint(0.0F, 0.0F, 8.0F);
        bodyMiddle.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        finMiddle = new ModelRenderer(this, 0, 5);
        finMiddle.setRotationPoint(0.0F, -2.0F, 0.0F);
        finMiddle.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        bodyBack = new ModelRenderer(this, 0, 21);
        bodyBack.setRotationPoint(0.0F, 0.0F, 8.0F);
        bodyBack.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        finBack = new ModelRenderer(this, 0, 6);
        finBack.setRotationPoint(0.0F, -2.0F, 0.0F);
        finBack.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        finTail = new ModelRenderer(this, 2, 12);
        finTail.setRotationPoint(0.0F, 0.0F, 8.0F);
        finTail.addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);

        finRight = new ModelRenderer(this, -4, 0);
        finRight.setRotationPoint(-1.0F, 0.5F, 2.0F);
        finRight.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        finRight.rotateAngleZ = (-(float) Math.PI / 4F);

        finLeft = new ModelRenderer(this, 0, 0);
        finLeft.setRotationPoint(1.0F, 0.5F, 2.0F);
        finLeft.addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        finLeft.rotateAngleZ = ((float) Math.PI / 4F);

        head.addChild(bodyFront);
        bodyFront.addChild(bodyMiddle);
        bodyFront.addChild(finLeft);
        bodyFront.addChild(finRight);
        bodyFront.addChild(finFront);
        bodyMiddle.addChild(bodyBack);
        bodyMiddle.addChild(finMiddle);
        bodyBack.addChild(finBack);
        bodyBack.addChild(finTail);
    }

    @Override
    public Iterable<ModelRenderer> getParts()
    {
        return ImmutableList.of(head);
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        float f = 1.0F;
        float f1 = 1.0F;

        if (!entity.isInWater())
        {
            f = 1.3F;
            f1 = 1.7F;
        }
        else if (!((BaseFishEntity) entity).isMoving())
        {
            f = 0.2F;
        }

        bodyFront.rotateAngleY = -f * 0.25F * MathHelper.sin(f1 * 0.5F * ageInTicks);
        bodyMiddle.rotateAngleY = bodyFront.rotateAngleY * -2.0F;
        bodyBack.rotateAngleY = bodyFront.rotateAngleY * 2.0F;
        finTail.rotateAngleY = bodyMiddle.rotateAngleY * -0.8F;
    }
}
