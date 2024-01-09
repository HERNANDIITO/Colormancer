package hernandiito.colormancer.datagen;

import hernandiito.colormancer.item.ColormancerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ColormancerModelProvider extends FabricModelProvider {

    public ColormancerModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ColormancerItems.DYE_MIXTURE, Models.GENERATED);
        itemModelGenerator.register(ColormancerItems.PIGMENTS, Models.GENERATED);

        itemModelGenerator.register(ColormancerItems.COLORMANCER_BOOK, Models.GENERATED);

        itemModelGenerator.register(ColormancerItems.EMPTY_VIAL, Models.GENERATED);
        itemModelGenerator.register(ColormancerItems.WATER_VIAL, Models.GENERATED);
        itemModelGenerator.register(ColormancerItems.COLOR_VIAL, Models.GENERATED);

    }
}
