package hernandiito.colormancer.item;

import hernandiito.colormancer.Colormancer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ColormancerItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item EMPTY_VIAL = registerItem("empty_vial", new Item(new FabricItemSettings()));
    public static final Item COLOR_VIAL = registerItem("color_vial", (Item) new ColorVial(new FabricItemSettings().food(ColormancerFoodComponents.COLOR_VIAL)));

    private static void addItemsToIngredientTabItemsGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
        entries.add(EMPTY_VIAL);
        entries.add(COLOR_VIAL);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Colormancer.MOD_ID, name), item);
    };
    public static void registerModItems() {
        Colormancer.LOGGER.info("Registering mod items for: " + Colormancer.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ColormancerItems::addItemsToIngredientTabItemsGroup);

    }
}
