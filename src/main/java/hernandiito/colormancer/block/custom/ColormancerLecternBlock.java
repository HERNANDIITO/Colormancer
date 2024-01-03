package hernandiito.colormancer.block.custom;

import hernandiito.colormancer.block.entity.ColormancerLecternEntity;
import hernandiito.colormancer.item.ColormancerItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsage;
import net.minecraft.registry.Registry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;


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

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ColormancerLecternEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (player.getStackInHand(hand).itemMatches(ColormancerItems.COLORMANCER_BOOK.getRegistryEntry())) {
                player.getStackInHand(hand).decrement(1);
            }
        }

        return ActionResult.SUCCESS;
    }
}
