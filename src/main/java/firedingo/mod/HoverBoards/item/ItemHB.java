package firedingo.mod.HoverBoards.item;

import firedingo.mod.HoverBoards.entity.EntityHoverBoard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Firedingo on 20/11/2015.
 */
public class ItemHB extends HBCommon {
    public ItemHB () {

    }

    public static void spawnEntity(ItemStack stack, EntityPlayer player, World world) {

        EntityHoverBoard HB = new EntityHoverBoard(world);
       // HB.setPosition();
        HB.setPosition(player.posX + 1, player.posY + 1, player.posZ + 1);
        world.spawnEntityInWorld(HB);
        if (!player.capabilities.isCreativeMode) {
            stack.stackSize--;
        }

    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            spawnEntity(stack, player, world);
            System.out.print(" onItemRightClick Called");
        }
        System.out.print(" onItemRightClick 2nd Output Called");
        return super.onItemRightClick(stack, world, player);
    }
}
