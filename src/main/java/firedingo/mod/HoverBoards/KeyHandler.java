package firedingo.mod.HoverBoards;


import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import firedingo.mod.HoverBoards.entity.EntityHoverBoard;
import firedingo.mod.HoverBoards.renderer.model.Hoverboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import org.lwjgl.input.Keyboard;

/**
 * Created by Firedingo on 19/01/2016.
 */
public class KeyHandler {
    public static KeyBinding ascend;
    public static KeyBinding descend;

    public static void KeyHandlerInit() {
        ascend = new KeyBinding("Key.Ascend", Keyboard.KEY_SPACE, "key.categories.HB");
        descend = new KeyBinding("Key.Descend", Keyboard.KEY_LSHIFT, "key.categories.HB");

        ClientRegistry.registerKeyBinding(ascend);
        ClientRegistry.registerKeyBinding(descend);
    }

    @SubscribeEvent
    public void onKeyInput (InputEvent.KeyInputEvent event) {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;

        if (ascend.isPressed()) {
            if (player.ridingEntity instanceof EntityHoverBoard) {
                while (((EntityHoverBoard) player.ridingEntity).getHealth() > 0) {
                    player.ridingEntity.motionY ++;
                }

            }
        }
        else if (descend.isPressed()) {
            if (player.ridingEntity instanceof EntityHoverBoard) {
                while (((EntityHoverBoard) player.ridingEntity).getHealth() > 0) {
                    player.ridingEntity.motionY --;
                }

            }
        }
    }
}
