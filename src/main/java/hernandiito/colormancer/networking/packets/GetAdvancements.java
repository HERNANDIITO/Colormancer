package hernandiito.colormancer.networking.packets;

import hernandiito.colormancer.Colormancer;
import hernandiito.colormancer.datagen.ModAdvancementProvider;
import hernandiito.colormancer.screen.ColormancerLecternScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class GetAdvancements {

    public static void recieve(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        int[] packet = buf.readIntArray();
        Colormancer.LOGGER.info(String.valueOf(packet.length));

        client.execute(() -> {
            if ( packet[0] != 1 ) {
                ColormancerLecternScreenHandler.drawButton(ModAdvancementProvider.advancementIDs.get(packet[1]));
            }
        });
    }
}
