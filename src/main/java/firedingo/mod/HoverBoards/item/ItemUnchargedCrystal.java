package firedingo.mod.HoverBoards.item;

import firedingo.mod.HoverBoards.reference.Reference;
import firedingo.mod.HoverBoards.reference.Textures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Firedingo on 30/05/2015.
 */
public class ItemUnchargedCrystal extends ItemPC {
    public ItemUnchargedCrystal() {
        super();
        this.setTextureName(Textures.PowerCrystalT1Texture);
        this.setUnlocalizedName(Reference.MOD_ID + ":" + "ItemUnchargedCrystal");

        this.setMaxDamage(10);


    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        if (!player.isSneaking()) {
            if (stack.getItemDamage() > 1 && stack.getItemDamage() != 1) {
                stack.damageItem(1, player);
            }
        }
        else {
            //Might do something here but Not Sure
        }
        return super.onItemRightClick(stack, world, player);
    }
}
