package hernandiito.colormancer.potion;

import hernandiito.colormancer.Colormancer;
import hernandiito.colormancer.effect.ColormancerEffects;
import hernandiito.colormancer.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.potion.Potion;
import net.minecraft.entity.effect.StatusEffectInstance;

public class ModPotions {
    public static Potion WHITE_POTION_TIER_1;
    public static Potion WHITE_POTION_TIER_2;
    public static Potion WHITE_POTION_TIER_3;

    public static Potion registerPotion(String name, int duration) {
        return Registry.register(Registries.POTION, new Identifier(Colormancer.MOD_ID, name),
                new Potion(new StatusEffectInstance(ColormancerEffects.WHITE, duration, 0)));
    }

    public static void registerPotions() {
        WHITE_POTION_TIER_1 = registerPotion("white_potion_1", 100);
        WHITE_POTION_TIER_2 = registerPotion("white_potion_2", 200);
        WHITE_POTION_TIER_3 = registerPotion("white_potion_3", 300);

        registerPotionRecipes();
    }

    public static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.WHITE_DYE, ModPotions.WHITE_POTION_TIER_1);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.WHITE_POTION_TIER_1, Items.WHITE_DYE, ModPotions.WHITE_POTION_TIER_2);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.WHITE_POTION_TIER_2, Items.WHITE_DYE, ModPotions.WHITE_POTION_TIER_3);
    }
}
