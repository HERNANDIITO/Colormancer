package hernandiito.colormancer.datagen;

import hernandiito.colormancer.effect.ColormancerEffects;
import hernandiito.colormancer.item.ColormancerItems;
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

public class ColormancerAdvancementProvider extends FabricAdvancementProvider {
    public ColormancerAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry root = Advancement.Builder.create()
                .display(
                        ColormancerItems.PIGMENTS, // The display icon
                        Text.translatable("advancements.colormancer.root.title"), // The title
                        Text.translatable("advancements.colormancer.root.description"), // The description
                        new Identifier("textures/block/gray_glazed_terracotta.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("become_a_colormancer", TickCriterion.Conditions.createTick())
                .build(consumer, "colormancer" + "/root");

        AdvancementEntry dyeEater = Advancement.Builder.create().parent(root)
                .display(
                        ColormancerItems.DYE_MIXTURE,
                        Text.translatable("advancements.colormancer.root.title"),
                        Text.translatable("advancements.colormancer.root.description"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("ate_apple", ConsumeItemCriterion.Conditions.any())
                .build(consumer, "colormancer" + "/dye_eater");

        AdvancementEntry black = Advancement.Builder.create().parent(dyeEater)
                .display(
                        Items.BLACK_DYE, // The display icon
                        Text.translatable("advancements.colormancer.root.title"), // The title
                        Text.translatable("advancements.colormancer.root.description"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("use_black", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ColormancerEffects.BLACK)) )
                .build(consumer, "colormancer" + "/black");

        AdvancementEntry cyan = Advancement.Builder.create().parent(dyeEater)
                .display(
                        Items.CYAN_DYE, // The display icon
                        Text.translatable("advancements.colormancer.root.title"), // The title
                        Text.translatable("advancements.colormancer.root.description"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("use_cyan", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ColormancerEffects.CYAN)))
                .build(consumer, "colormancer" + "/cyan");

        AdvancementEntry magenta = Advancement.Builder.create().parent(dyeEater)
                .display(
                        Items.MAGENTA_DYE, // The display icon
                        Text.translatable("advancements.colormancer.root.title"), // The title
                        Text.translatable("advancements.colormancer.root.description"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("use_magenta", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ColormancerEffects.MAGENTA)))
                .build(consumer, "colormancer" + "/magenta");

        AdvancementEntry yellow = Advancement.Builder.create().parent(dyeEater)
                .display(
                        Items.YELLOW_DYE, // The display icon
                        Text.translatable("advancements.colormancer.root.title"), // The title
                        Text.translatable("advancements.colormancer.root.description"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("use_yellow", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ColormancerEffects.YELLOW)))
                .build(consumer, "colormancer" + "/yellow");

        AdvancementEntry white = Advancement.Builder.create().parent(dyeEater)
                .display(
                        Items.WHITE_DYE, // The display icon
                        Text.translatable("advancements.colormancer.root.title"), // The title
                        Text.translatable("advancements.colormancer.root.description"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        false, // Announce to chat
                        true // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("use_white", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ColormancerEffects.WHITE)))
                .build(consumer, "colormancer" + "/white");

    }
}
