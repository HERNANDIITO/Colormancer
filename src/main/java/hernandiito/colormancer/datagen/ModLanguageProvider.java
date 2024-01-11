package hernandiito.colormancer.datagen;

import hernandiito.colormancer.Colormancer;
import hernandiito.colormancer.block.ModBlocks;
import hernandiito.colormancer.effect.ModStatusEffects;
import hernandiito.colormancer.item.ModItemGroups;
import hernandiito.colormancer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLanguageProvider extends FabricLanguageProvider {
    protected ModLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.EMPTY_VIAL, "Empty vial");
        translationBuilder.add(ModItems.WATER_VIAL, "Water vial");
        translationBuilder.add(ModItems.COLOR_VIAL, "Concentrated color");
        translationBuilder.add(ModItems.DYE_MIXTURE, "Dye mixture");
        translationBuilder.add(ModItems.PIGMENTS, "Pigments");
        translationBuilder.add(ModItems.COLORMANCER_BOOK, "Vademecum Cromaticus");

        translationBuilder.add("itemGroup.colormancer", "Colormancer items");

        translationBuilder.add(ModStatusEffects.CYAN, "Cyan Senses");
        translationBuilder.add(ModStatusEffects.MAGENTA, "Magenta Freedom");
        translationBuilder.add(ModStatusEffects.YELLOW, "Yellow Soul");
        translationBuilder.add(ModStatusEffects.BLACK, "Black Strength");
        translationBuilder.add(ModStatusEffects.WHITE, "White Sickness");

        translationBuilder.add(ModBlocks.COLORMANCER_LECTERN, "Colormancer Lectern");

        translationBuilder.add("advancements." + Colormancer.MOD_ID + ".root.title", "Colormancer");
        translationBuilder.add("advancements." + Colormancer.MOD_ID + ".root.description", "Become a Colormancer");

        translationBuilder.add("gui." + Colormancer.MOD_ID + ".colormancer_lectern", "Colormancer lectern");
    }
}
