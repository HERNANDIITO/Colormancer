package hernandiito.colormancer.datagen;

import hernandiito.colormancer.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.PURE_DYES)
            .add(Items.CYAN_DYE)
            .add(Items.MAGENTA_DYE)
            .add(Items.YELLOW_DYE)
            .add(Items.BLACK_DYE);

        getOrCreateTagBuilder(ModTags.Items.MIXED_DYES)
            .add(Items.WHITE_DYE)
            .add(Items.LIGHT_GRAY_DYE)
            .add(Items.GRAY_DYE)
            .add(Items.BROWN_DYE)
            .add(Items.ORANGE_DYE)
            .add(Items.LIME_DYE)
            .add(Items.LIGHT_BLUE_DYE)
            .add(Items.PURPLE_DYE)
            .add(Items.PINK_DYE);

        getOrCreateTagBuilder(ModTags.Items.LIGHT_DYES)
            .add(Items.RED_DYE)
            .add(Items.GREEN_DYE)
            .add(Items.BLUE_DYE);
    }
}
