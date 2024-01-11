package hernandiito.colormancer.item;

import hernandiito.colormancer.Colormancer;
import hernandiito.colormancer.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup COLORMANCER = Registry.register(Registries.ITEM_GROUP,
        new Identifier(Colormancer.MOD_ID, "colormancer"),
        FabricItemGroup.builder().displayName(Text.translatable("itemGroup.colormancer"))
            .icon(() -> new ItemStack(ModItems.COLOR_VIAL)).entries((displayContext, entries) -> {
                entries.add(ModItems.EMPTY_VIAL);
                entries.add(ModItems.WATER_VIAL);
                entries.add(ModItems.COLOR_VIAL);
                entries.add(ModItems.DYE_MIXTURE);
                entries.add(ModItems.PIGMENTS);
                entries.add(ModItems.COLORMANCER_BOOK);
                entries.add(ModBlocks.COLORMANCER_LECTERN);
            }).build());
    public static void registerModItemGroups() {
        Colormancer.LOGGER.info("Registering ModItemGroups for " + Colormancer.MOD_ID);
    }
}
