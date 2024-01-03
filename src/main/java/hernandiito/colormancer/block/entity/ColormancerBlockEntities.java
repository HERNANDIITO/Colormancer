package hernandiito.colormancer.block.entity;


import hernandiito.colormancer.Colormancer;
import hernandiito.colormancer.block.ColormancerBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ColormancerBlockEntities {
    public static final BlockEntityType<ColormancerLecternEntity> COLORMANCER_LECTERN =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Colormancer.MOD_ID, "colormancer_lectern"),
                    FabricBlockEntityTypeBuilder.create(ColormancerLecternEntity::new,
                            ColormancerBlocks.COLORMANCER_LECTERN).build());

    public static void registerBlockEntities() {
        Colormancer.LOGGER.info("Registering Block Entities for " + Colormancer.MOD_ID);
    }

}
