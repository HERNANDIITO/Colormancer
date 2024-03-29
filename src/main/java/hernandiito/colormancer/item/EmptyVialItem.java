package hernandiito.colormancer.item;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class EmptyVialItem extends Item {
    public EmptyVialItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = GlassBottleItem.raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);

        if (blockHitResult.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(itemStack);
        }

        BlockPos blockPos = blockHitResult.getBlockPos();
        if (!world.canPlayerModifyAt(user, blockPos)) {
            return TypedActionResult.pass(itemStack);
        }

        if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
            world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
            return TypedActionResult.success(this.fill(itemStack, user, ModItems.WATER_VIAL.getDefaultStack()), world.isClient());
        }

        if (world.getBlockState(blockPos).getBlock() == Blocks.WATER_CAULDRON) {
            world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
            return TypedActionResult.success(this.fill(itemStack, user, ModItems.WATER_VIAL.getDefaultStack()), world.isClient());
        }
        return TypedActionResult.pass(itemStack);
    }

    protected ItemStack fill(ItemStack stack, PlayerEntity player, ItemStack outputStack) {
        player.incrementStat(Stats.USED.getOrCreateStat(this));
        return ItemUsage.exchangeStack(stack, player, outputStack);
    }
}
