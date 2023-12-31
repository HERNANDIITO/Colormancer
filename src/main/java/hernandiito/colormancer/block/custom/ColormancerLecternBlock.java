package hernandiito.colormancer.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;


public class ColormancerLecternBlock extends BlockWithEntity implements BlockEntityProvider {

    private static final VoxelShape SHAPE = ColormancerLecternBlock.createCuboidShape(0, 0,0, 16, 22, 16);

    public ColormancerLecternBlock( Settings settings ) {
        super ( settings );
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity( BlockPos pos, BlockState state ) {
        return null;
    }




}
