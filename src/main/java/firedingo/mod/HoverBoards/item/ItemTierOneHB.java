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
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        return super.onItemRightClick(stack, world, player);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        EntityHoverBoard HB = new EntityHoverBoard(world);
        HB.setPosition(player.posX +1, player.posY +1, player.posZ +1);
        world.spawnEntityInWorld(HB);
        stack.stackSize--;

        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }
}