package firedingo.mod.HoverBoards.item;

import firedingo.mod.HoverBoards.entity.EntityHoverBoard;
import firedingo.mod.HoverBoards.reference.Reference;
import firedingo.mod.HoverBoards.reference.Textures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Firedingo on 3/10/2015.
 */
public class ItemTierOneHB extends ItemHB {

    public ItemTierOneHB() {
        super();
        this.setTextureName(Textures.HBTexture);
        this.setUnlocalizedName(Reference.MOD_ID + ":" + "ItemTierOneHB");
        this.setMaxStackSize(1);
        //this.showDurabilityBar()

    }

}