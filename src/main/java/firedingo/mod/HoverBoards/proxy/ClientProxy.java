package firedingo.mod.HoverBoards.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import firedingo.mod.HoverBoards.entity.EntityHandler;
import firedingo.mod.HoverBoards.renderer.RenderHoverBoard;
import firedingo.mod.HoverBoards.entity.EntityHoverBoard;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Firedingo on 30/05/2015.
 */
public class ClientProxy extends CommonProxy {

    public static void InitRendering() {
       // RenderingRegistry.registerEntityRenderingHandler(EntityHoverBoard.class, new RenderHoverBoard(HBModel, 0.5F));
        EntityHandler.registerRenderers();
    }
    public static void InitEntities() {
        EntityHandler.registerEntities();

    }
}
