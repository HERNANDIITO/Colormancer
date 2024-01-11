package hernandiito.colormancer;

import hernandiito.colormancer.screen.ColormancerLecternScreen;
import hernandiito.colormancer.screen.ModScreenHandlerTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ColormancerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlerTypes.COLORMANCER_LECTERN, ColormancerLecternScreen::new);
    }
}
