package firedingo.mod.HoverBoards.entity;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import firedingo.mod.HoverBoards.renderer.model.Hoverboard;
import firedingo.mod.HoverBoards.renderer.RenderHoverBoard;

/**
 * Created by Firedingo on 14/10/2015.
 */
public class EntityHandler {
    public static void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityHoverBoard.class, new RenderHoverBoard(new Hoverboard(), 1.0F));
    }
    public static void registerEntities() {
        EntityRegistry.registerGlobalEntityID(EntityHoverBoard.class, "EntityHoverBoard", EntityRegistry.findGlobalUniqueEntityId());
    }
}
