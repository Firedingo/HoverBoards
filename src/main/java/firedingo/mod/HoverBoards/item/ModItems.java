package firedingo.mod.HoverBoards.item;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Firedingo on 30/05/2015.
 */
public class ModItems {
    public static final HBCommon ItemUnchargedCrystal = new ItemUnchargedCrystal();
    public static final HBCommon ItemPolishedCrystal = new ItemPolishedCrystal();
    public static final HBCommon ItemHoverBoard = new ItemTierOneHB();

    public static void Init() {
        GameRegistry.registerItem(ItemUnchargedCrystal, "ItemUnchargedCrystal");
        GameRegistry.registerItem(ItemPolishedCrystal, "ItemPolishedCrystal");
        GameRegistry.registerItem(ItemHoverBoard, "ItemHoverBoard");

    }
}
