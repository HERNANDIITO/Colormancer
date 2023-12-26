package hernandiito.colormancer.block;

import hernandiito.colormancer.Colormancer;
import hernandiito.colormancer.block.custom.ColormancerLecternBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ColormancerBlocks {
    public static final Block COLORMANCER_LECTERN = registerBlock("colormancer_lectern",
            new ColormancerLecternBlock(FabricBlockSettings.copyOf(Blocks.LECTERN).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Colormancer.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Colormancer.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Colormancer.LOGGER.info("Registering ModBlocks for " + Colormancer.MOD_ID);
    }

}
