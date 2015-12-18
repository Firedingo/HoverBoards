package firedingo.mod.HoverBoards.proxy;

import firedingo.mod.HoverBoards.entity.EntityHandler;
import firedingo.mod.HoverBoards.entity.EntityHoverBoard;

/**
 * Created by Firedingo on 30/05/2015.
 */
public abstract class CommonProxy implements IProxy {

    public void InitRendering() {} //See Client Proxy

    public static void InitEntities() {
        EntityHandler.registerEntities();

    }
}
