package hernandiito.colormancer.effect;

import hernandiito.colormancer.Colormancer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final StatusEffect CYAN = registerStatusEffect("cyan", new CyanEffect(StatusEffectCategory.NEUTRAL, 0));
    public static final StatusEffect MAGENTA = registerStatusEffect("magenta", new MagentaEffect(StatusEffectCategory.NEUTRAL, 0));
    public static final StatusEffect YELLOW = registerStatusEffect("yellow", new YellowEffect(StatusEffectCategory.NEUTRAL, 0));
    public static final StatusEffect BLACK = registerStatusEffect("black", new BlackEffect(StatusEffectCategory.NEUTRAL, 0));
    public static final StatusEffect WHITE = registerStatusEffect("white", new WhiteEffect(StatusEffectCategory.HARMFUL, 0));

    private static StatusEffect registerStatusEffect(String id, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Colormancer.MOD_ID, id), effect);
    }

    public static void registerModStatusEffects() {
        Colormancer.LOGGER.info("Registering ModStatusEffects for " + Colormancer.MOD_ID);
    }
}
