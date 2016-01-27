package firedingo.mod.HoverBoards.item;

import firedingo.mod.HoverBoards.entity.EntityHoverBoard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Firedingo on 20/11/2015.
 */
public class ItemHB extends HBCommon {
    public ItemHB () {

    }

    public static void spawnEntity(ItemStack stack, EntityPlayer player, World world) {

        EntityHoverBoard HB = new EntityHoverBoard(world);

        double x = player.getLookVec().xCoord;
        double y = player.getLookVec().yCoord;
        double z = player.getLookVec().zCoord;
       // System.out.println("X: " + x + " Y: " + y + " Z: " + z); //For Testing
        HB.setPosition(player.posX + (x+ 1D),player.posY + (y + 1D),player.posZ + (z+ 1D)); //+1D is used to raise the spawn location out of the blocks below the player if any
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
