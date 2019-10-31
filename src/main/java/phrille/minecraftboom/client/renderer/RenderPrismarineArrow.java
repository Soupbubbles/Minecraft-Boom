package phrille.minecraftboom.client.renderer;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderTippedArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.util.ResourceLocation;

public class RenderPrismarineArrow extends RenderTippedArrow
{
    private final ResourceLocation entityTexture;

    public RenderPrismarineArrow(RenderManager renderManager, ResourceLocation entityTexture)
    {
        super(renderManager);
        this.entityTexture = entityTexture;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTippedArrow entity)
    {
        return entityTexture;
    }
}