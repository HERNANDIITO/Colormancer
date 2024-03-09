package hernandiito.colormancer.effect;

import hernandiito.colormancer.Colormancer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ColormancerEffects {
    public static StatusEffect CYAN, MAGENTA, YELLOW, BLACK, WHITE;

    public static void registerEffects() {

        CYAN = Registry.register(Registries.STATUS_EFFECT,
                new Identifier(Colormancer.MOD_ID, "cyan"),
                new CyanEffect(StatusEffectCategory.NEUTRAL, 0));

        MAGENTA = Registry.register(Registries.STATUS_EFFECT,
                new Identifier(Colormancer.MOD_ID, "magenta"),
                new MagentaEffect(StatusEffectCategory.NEUTRAL, 0));

        YELLOW = Registry.register(Registries.STATUS_EFFECT,
                new Identifier(Colormancer.MOD_ID, "yellow"),
                new YellowEffect(StatusEffectCategory.NEUTRAL, 0));

        BLACK = Registry.register(Registries.STATUS_EFFECT,
                new Identifier(Colormancer.MOD_ID, "black"),
                new BlackEffect(StatusEffectCategory.NEUTRAL, 0));

        WHITE = Registry.register(Registries.STATUS_EFFECT,
                new Identifier(Colormancer.MOD_ID, "white"),
                new BlackEffect(StatusEffectCategory.HARMFUL, 14348010));
    }
}
