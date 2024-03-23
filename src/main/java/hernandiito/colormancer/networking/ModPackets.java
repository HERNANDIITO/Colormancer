package hernandiito.colormancer.networking;

import hernandiito.colormancer.Colormancer;
import hernandiito.colormancer.networking.packets.GetAdvancements;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier GET_ADVANCEMENTS = new Identifier(Colormancer.MOD_ID, "highlight_block");

    public static void registerClientPackets() {
        ClientPlayNetworking.registerGlobalReceiver(GET_ADVANCEMENTS, GetAdvancements::recieve);
    }
}
