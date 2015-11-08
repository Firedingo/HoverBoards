package firedingo.mod.HoverBoards.item;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Firedingo on 30/05/2015.
 */
public class ModItems {
    public static final ItemHB ItemUnchargedCrystal = new ItemUnchargedCrystal();
    public static final ItemHB ItemPolishedCrystal = new ItemPolishedCrystal();
    public static final ItemHB ItemHoverBoard = new ItemTierOneHB();

    public static void Init() {
        GameRegistry.registerItem(ItemUnchargedCrystal, "ItemUnchargedCrystal");
        GameRegistry.registerItem(ItemPolishedCrystal, "ItemPolishedCrystal");
        GameRegistry.registerItem(ItemHoverBoard, "ItemHoverBoard");

    }
}
