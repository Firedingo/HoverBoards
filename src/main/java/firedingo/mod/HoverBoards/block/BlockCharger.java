package firedingo.mod.HoverBoards.block;

import firedingo.mod.HoverBoards.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by Firedingo on 12/06/2015.
 */
public class BlockCharger extends BlockHB {
    private IIcon[] icons = new IIcon[6];
    public String name = "BlockCharger";
    public BlockCharger() {
        super();
        this.setBlockName(Reference.MOD_ID + ":" + name);

    }

    @Override //0 = top/bottom, 1 = top/bottom, 2 = front, 3 = side, 4 = side, 5 = side
    public void registerBlockIcons(IIconRegister iconRegister) {
        super.registerBlockIcons(iconRegister);
    }

    /* for(int i=0; i < 6; i++) {
            if (i == 0) {
                side = "_top";
            }
            else if (i == 1) {
                side = "_top";
            }
            else if (i == 2) {

                side = "_front_off";
            }
            else if (i == 3) {
                side = "_side";
            }
            else if (i == 4) {
               // side = "_front_on";
                side = "_side";
            }
            else if (i == 5) {
                side = "_side";
            }
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + name + side);
        }
    }
    @Override
    public IIcon getIcon(int side, int meta) {
        return icons[side];
    } */
}
