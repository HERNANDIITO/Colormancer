package hernandiito.colormancer.screen;

import hernandiito.colormancer.Colormancer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlerTypes {
    public static final ScreenHandlerType<ColormancerLecternScreenHandler> COLORMANCER_LECTERN =
            registerScreenHandlerType("colormancer_studying", ColormancerLecternScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T> registerScreenHandlerType(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(Colormancer.MOD_ID, id), new ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
    }

    public static void registerModScreenHandlerTypes() {
        Colormancer.LOGGER.info("Registering ModScreenHandlerTypes for " + Colormancer.MOD_ID);
    }
}
