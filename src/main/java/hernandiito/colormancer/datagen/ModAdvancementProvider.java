package hernandiito.colormancer.datagen;

import hernandiito.colormancer.Colormancer;
import hernandiito.colormancer.effect.ModStatusEffects;
import hernandiito.colormancer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry root = Advancement.Builder.create()
                .display(
                        ModItems.PIGMENTS, // The display icon
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.title"), // The title
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.description"), // The description
                        new Identifier("textures/block/gray_glazed_terracotta.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("become_a_colormancer", TickCriterion.Conditions.createTick())
                .build(consumer, Colormancer.MOD_ID + ":root");

        AdvancementEntry dyeEater = Advancement.Builder.create().parent(root)
                .display(
                        ModItems.DYE_MIXTURE,
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.title"),
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.description"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("ate_apple", ConsumeItemCriterion.Conditions.any())
                .build(consumer, Colormancer.MOD_ID + ":dye_eater");

        AdvancementEntry black = Advancement.Builder.create().parent(dyeEater)
                .display(
                        Items.BLACK_DYE, // The display icon
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.title"), // The title
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.description"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("use_black", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ModStatusEffects.BLACK)) )
                .build(consumer, Colormancer.MOD_ID + ":black");

        AdvancementEntry cyan = Advancement.Builder.create().parent(dyeEater)
                .display(
                        Items.CYAN_DYE, // The display icon
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.title"), // The title
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.description"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("use_cyan", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ModStatusEffects.CYAN)))
                .build(consumer, Colormancer.MOD_ID + ":cyan");

        AdvancementEntry magenta = Advancement.Builder.create().parent(dyeEater)
                .display(
                        Items.MAGENTA_DYE, // The display icon
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.title"), // The title
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.description"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("use_magenta", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ModStatusEffects.MAGENTA)))
                .build(consumer, Colormancer.MOD_ID + ":magenta");

        AdvancementEntry yellow = Advancement.Builder.create().parent(dyeEater)
                .display(
                        Items.YELLOW_DYE, // The display icon
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.title"), // The title
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.description"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("use_yellow", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ModStatusEffects.YELLOW)))
                .build(consumer, Colormancer.MOD_ID + ":yellow");

        AdvancementEntry white = Advancement.Builder.create().parent(dyeEater)
                .display(
                        Items.WHITE_DYE, // The display icon
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.title"), // The title
                        Text.translatable("advancements." + Colormancer.MOD_ID + ".root.description"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("use_white", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ModStatusEffects.WHITE)))
                .build(consumer, Colormancer.MOD_ID + ":white");

    }
}
