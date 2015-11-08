package firedingo.mod.HoverBoards.block;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Firedingo on 12/06/2015.
 */
public class ModBlocks {
    public static final BlockHB BlockCharger = new BlockCharger();

    public static void Init() {
        GameRegistry.registerBlock(BlockCharger, "BlockCharger");
    }
}
