package firedingo.mod.HoverBoards.creativetab;

import firedingo.mod.HoverBoards.item.ModItems;
import firedingo.mod.HoverBoards.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Firedingo on 30/05/2015.
 */
public class CreativeTabHB {
    public static final CreativeTabs HB_TAB = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return (ModItems.ItemUnchargedCrystal);
        }
    };
}
