package phrille.minecraftboom.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.TippedArrowRenderer;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.ResourceLocation;

public class PrismarineArrowRenderer extends TippedArrowRenderer
{
    private final ResourceLocation entityTexture;

    public PrismarineArrowRenderer(EntityRendererManager renderManager, ResourceLocation entityTexture)
    {
        super(renderManager);
        this.entityTexture = entityTexture;
    }

    @Override
    protected ResourceLocation getEntityTexture(ArrowEntity entity)
    {
        return entityTexture;
    }
}