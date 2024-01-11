package hernandiito.colormancer.datagen;

import hernandiito.colormancer.block.ModBlocks;
import hernandiito.colormancer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.COLORMANCER_LECTERN, ModelIds.getBlockModelId(ModBlocks.COLORMANCER_LECTERN));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COLORMANCER_LECTERN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COLOR_VIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.COLORMANCER_BOOK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DYE_MIXTURE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_VIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PIGMENTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.WATER_VIAL, Models.GENERATED);
    }
}
