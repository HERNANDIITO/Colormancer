package hernandiito.colormancer.datagen;

import hernandiito.colormancer.Colormancer;
import hernandiito.colormancer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry colormancer = Advancement.Builder.create()
                .display(new AdvancementDisplay(
                        new ItemStack(ModItems.DYE_MIXTURE), // icon
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.title"), // title
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.description"), // description
                        new Identifier("minecraft", "textures/block/gray_glazed_terracotta.png"), // background
                        AdvancementFrame.TASK, // frame
                        true, // showToast,
                        false, // announceToChat,
                        true // hidden
                ))
                .criterion("start", TickCriterion.Conditions.createTick())
                .build(consumer, Colormancer.MOD_ID + ":colormancer");

        Advancement.Builder.create()
                .display(new AdvancementDisplay(
                        new ItemStack(ModItems.COLOR_VIAL), // icon
                        Text.literal("Dye eater"), // title
                        Text.literal("Try eating any dye"), // description
                        null, // background
                        AdvancementFrame.TASK, // frame
                        true, // showToast,
                        false, // announceToChat,
                        true // hidden
                ))
                .criterion("dyeeating", ConsumeItemCriterion.Conditions.any())
                .parent(colormancer)
                .build(consumer, Colormancer.MOD_ID + ":dye_eater");
    }
}
