package firedingo.mod.HoverBoards.item;

import firedingo.mod.HoverBoards.reference.Reference;
import firedingo.mod.HoverBoards.reference.Textures;
import net.minecraft.item.ItemStack;

/**
 * Created by Firedingo on 30/05/2015.
 */
public class ItemUnchargedCrystal extends ItemHB {
    public ItemUnchargedCrystal() {
        super();
        this.setTextureName(Textures.PowerCrystalT1Texture);
        this.setUnlocalizedName(Reference.MOD_ID + ":" + "ItemUnchargedCrystal");

        //trying to set durability/charge value
      //  ItemStack stack = new ItemStack(ItemUnchargedCrystal);
        this.setHasSubtypes(true);
        this.setMaxDamage(100);

    }
}
