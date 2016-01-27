package firedingo.mod.HoverBoards.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import firedingo.mod.HoverBoards.KeyHandler;
import firedingo.mod.HoverBoards.entity.EntityHandler;
import firedingo.mod.HoverBoards.entity.EntityHoverBoard;

/**
 * Created by Firedingo on 30/05/2015.
 */
public abstract class CommonProxy implements IProxy {

    public void InitRendering() {} //See Client Proxy

    public void InitKeyHandler() {
        FMLCommonHandler.instance().bus().register(new KeyHandler());
        KeyHandler.KeyHandlerInit();
    } //See Client Proxy

    public void InitEntities() {
        EntityHandler.registerEntities();

    }
}
