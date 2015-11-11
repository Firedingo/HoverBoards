package firedingo.mod.HoverBoards.item;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import firedingo.mod.HoverBoards.entity.EntityHoverBoard;
import firedingo.mod.HoverBoards.proxy.ServerProxy;
import firedingo.mod.HoverBoards.reference.Reference;
import firedingo.mod.HoverBoards.reference.Textures;
import net.minecraft.client.Minecraft;
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
    }

    public static void spawnEntity(ItemStack stack, EntityPlayer player, World world) {

        EntityHoverBoard HB = new EntityHoverBoard(world);
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
        return stack;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int posX, int posY, int posZ, int par7, float par8, float par9, float par10) {
        if (!world.isRemote) {
            spawnEntity(stack, player, world);
            System.out.print(" onItemUse Called");
        }
        return true;
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            spawnEntity(stack, player, world);
            System.out.print(" onItemUseFirst Called");

        }

        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }
}