package firedingo.mod.HoverBoards.tileentity;

import firedingo.mod.HoverBoards.item.ModItems;
import firedingo.mod.HoverBoards.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Firedingo on 2/01/2016.
 */
public class TECharger extends TileEntity implements ISidedInventory {

    private ItemStack[] inventory;

    public TECharger() {

    }

    @Override
    public boolean hasCustomInventoryName() { //Read Up On This
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int sideInt) { //read up on this
        return new int[0];
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public int getSizeInventory() {
        return 2;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return Reference.MOD_ID + "." + "TECharger";
    }

    @Override
    public void openInventory() {
        //NOOP
    }

    @Override
    public void closeInventory() {
        //NOOP
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize <= amt) {
                setInventorySlotContents(slot, null);
            }
            else {
                stack = stack.splitStack(amt);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side) {
        return isItemValidForSlot(slot, stack);
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int side) {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        switch(slot) {
            case 0: //Fuel
                return false;
            case 1: //Input
                if (stack == new ItemStack(ModItems.ItemHoverBoard) || stack == new ItemStack(ModItems.ItemUnchargedCrystal)) {
                    return true;
                }
                else {
                    return false;
                }
            case 2: //Output
                return false;
        }
        return true;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void writeToNBT(NBTTagCompound par1)
    {
        super.writeToNBT(par1);
    //    par1.setInteger("customField", customField);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1)
    {
        super.readFromNBT(par1);
       // this.customField = par1.getInteger("customField");
    }

    public void chargeItems(ItemStack stack, World world) {

        world.getTileEntity(this.xCoord, this.yCoord, this.zCoord);
        int damage = stack.getItemDamage();
       // int time =
        if (damage >= 0) {
            if (world.canBlockSeeTheSky(this.xCoord, this.yCoord, this.zCoord)) {

            }
        }
    }
}