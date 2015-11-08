package firedingo.mod.HoverBoards.item;

import firedingo.mod.HoverBoards.reference.Reference;
import firedingo.mod.HoverBoards.reference.Textures;

/**
 * Created by Firedingo on 3/10/2015.
 */
public class ItemPolishedCrystal extends ItemHB {

    //Constructor
    public ItemPolishedCrystal() {
        super();
        this.setTextureName(Textures.PowerCrystalT2Texture);
        this.setUnlocalizedName(Reference.MOD_ID + ":" + "ItemPolishedCrystal");
    }
}
