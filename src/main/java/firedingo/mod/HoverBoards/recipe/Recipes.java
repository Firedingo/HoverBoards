package firedingo.mod.HoverBoards.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import firedingo.mod.HoverBoards.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Firedingo on 30/05/2015.
 */
public class Recipes {
    public static void Init() {
       // GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemUnchargedCrystal),"d","r  ","   ",'d', Items.diamond, 'r', Items.redstone);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemUnchargedCrystal),new Object[] {Items.diamond, Items.redstone});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemPolishedCrystal),new Object[] {ModItems.ItemUnchargedCrystal, Items.redstone});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.ItemHoverBoard), "   ", "www", "ccc", 'w', Blocks.planks, 'c', ModItems.ItemUnchargedCrystal);

    }
}
