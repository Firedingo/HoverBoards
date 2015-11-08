package firedingo.mod.HoverBoards.renderer;

import firedingo.mod.HoverBoards.reference.Textures;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


/**
 * Created by Firedingo on 13/10/2015.
 */
public class RenderHoverBoard extends RenderLiving {

    //Yo Fire Just because you're bound to do this again, THIS vvvv is where the texture of the Hoverboard Model is being applied ;)
    private static ResourceLocation HBTexture = new ResourceLocation(Textures.HBModelTexture);

    public RenderHoverBoard(ModelBase model, float shadow) {
        super(model, shadow);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return HBTexture;
    }
}
