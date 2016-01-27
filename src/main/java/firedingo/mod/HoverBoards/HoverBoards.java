package firedingo.mod.HoverBoards;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import firedingo.mod.HoverBoards.block.ModBlocks;
import firedingo.mod.HoverBoards.item.ModItems;
import firedingo.mod.HoverBoards.proxy.ClientProxy;
import firedingo.mod.HoverBoards.proxy.CommonProxy;
import firedingo.mod.HoverBoards.proxy.IProxy;
import firedingo.mod.HoverBoards.recipe.Recipes;
import firedingo.mod.HoverBoards.reference.Reference;

/**
 * Created by Firedingo on 30/05/2015.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class HoverBoards {
    @Mod.Instance(Reference.MOD_ID)
    public static HoverBoards instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {
        ModItems.Init();
        ModBlocks.Init();
        proxy.InitKeyHandler();


    }
    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event) {
        Recipes.Init();
        proxy.InitRendering();
        proxy.InitEntities();
    }
    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent event) {

    }
}
