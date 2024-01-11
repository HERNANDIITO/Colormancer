package hernandiito.colormancer.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent COLOR_VIAL = new FoodComponent.Builder()
            .hunger(0)
            .saturationModifier(0.1f)
            .alwaysEdible()
            .snack()
            .build();
    public static final FoodComponent WATER_VIAL = new FoodComponent.Builder()
            .hunger(0)
            .saturationModifier(0.1f)
            .alwaysEdible()
            .snack()
            .build();
}
