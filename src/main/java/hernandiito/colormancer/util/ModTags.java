package hernandiito.colormancer.util;

import hernandiito.colormancer.Colormancer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
//        public static final TagKey<Block> METAL_DETECTOR_DETECTABLE_BLOCKS =
//                createTag("metal_detector_detectable_blocks");
//
        private static TagKey<Block> createTag(String id) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Colormancer.MOD_ID, id));
        }
    }

    public static class Items {
        public static final TagKey<Item> PURE_DYES = createTag("pure_dyes");
        public static final TagKey<Item> MIXED_DYES = createTag("mixed_dyes");
        public static final TagKey<Item> LIGHT_DYES = createTag("light_dyes");

        private static TagKey<Item> createTag(String id) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Colormancer.MOD_ID, id));
        }
    }
}
