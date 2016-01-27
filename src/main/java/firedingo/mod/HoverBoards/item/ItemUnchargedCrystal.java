package firedingo.mod.HoverBoards.item;

import firedingo.mod.HoverBoards.reference.Reference;
import firedingo.mod.HoverBoards.reference.Textures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Firedingo on 30/05/2015.
 */
public class ItemUnchargedCrystal extends HBCommon {
    public ItemUnchargedCrystal() {
        super();
        this.setTextureName(Textures.PowerCrystalT1Texture);
        this.setUnlocalizedName(Reference.MOD_ID + ":" + "ItemUnchargedCrystal");
       // this.setMaxDamage(4000);
        this.setMaxDamage(10);



    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        System.out.println("Test Print!!! CAN YOU SEE ME?!?!?!?!?!?");
        //  if (player.getDisplayName() == "firedingo") {
       // if (!player.isSneaking()) {
           // if (stack.getItemDamage() > 1 && stack.getItemDamage() != 1) {

             //   stack.damageItem(1, player);
                //int damage =
                stack.getItem().setDamage(stack, 1);
               // stack.setItemDamage(damage - 1);
                this.showDurabilityBar(stack);
          //  }
      //  } else {
            //Might do something here but Not Sure
      //  }
        //   }
        return super.onItemRightClick(stack, world, player);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        int health = stack.getItemDamage();
        list.add(EnumChatFormatting.GOLD + "Flight Time = " + health);
        //super.addInformation(stack, player, list, par4);
    }
}
