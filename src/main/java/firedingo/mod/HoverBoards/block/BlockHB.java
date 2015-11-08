package firedingo.mod.HoverBoards.block;

import firedingo.mod.HoverBoards.creativetab.CreativeTabHB;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Firedingo on 12/06/2015.
 */
public class BlockHB extends Block {
    public BlockHB() {
        super(Material.ground);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.setCreativeTab(CreativeTabHB.HB_TAB);
    }
}
