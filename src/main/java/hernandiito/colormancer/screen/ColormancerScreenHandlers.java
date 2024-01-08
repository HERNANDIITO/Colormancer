package hernandiito.colormancer.screen;

import hernandiito.colormancer.Colormancer;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ColormancerScreenHandlers {
    public static final ScreenHandlerType<ColormancerLecternScreenHandler> COLORMANCER_LECTERN_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Colormancer.MOD_ID, "colormancer_studying"),
                    new ExtendedScreenHandlerType<>(ColormancerLecternScreenHandler::new));

    public static void registerScreenHandlers() {
        Colormancer.LOGGER.info("Registering Screen Handlers for " + Colormancer.MOD_ID);
    }
}
