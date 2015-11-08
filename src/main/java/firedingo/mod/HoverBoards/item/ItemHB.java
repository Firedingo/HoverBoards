package firedingo.mod.HoverBoards.item;

import firedingo.mod.HoverBoards.creativetab.CreativeTabHB;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Firedingo on 30/05/2015.
 */
public class ItemHB extends Item {
    public ItemHB() {
        super();
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.setCreativeTab(CreativeTabHB.HB_TAB);
        this.maxStackSize = 1;
    }
}
