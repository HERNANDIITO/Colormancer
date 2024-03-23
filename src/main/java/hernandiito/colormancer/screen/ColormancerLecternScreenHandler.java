package hernandiito.colormancer.screen;

import hernandiito.colormancer.Colormancer;
import hernandiito.colormancer.block.ModBlocks;
import hernandiito.colormancer.datagen.ModAdvancementProvider;
import hernandiito.colormancer.item.ModItems;
import hernandiito.colormancer.networking.ModPackets;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ColormancerLecternScreenHandler extends ScreenHandler {
    private static final int BOOK_SLOT = 0;
    private static final int CYAN_SLOT = 1;
    private static final int MAGENTA_SLOT = 2;
    private static final int YELLOW_SLOT = 3;
    private static final int BLACK_SLOT = 4;

    public final Inventory inventory = new SimpleInventory(5) {
        @Override
        public void markDirty() {
            super.markDirty();
        }
    };
    private final ScreenHandlerContext context;

    public ColormancerLecternScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public ColormancerLecternScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ModScreenHandlerTypes.COLORMANCER_LECTERN, syncId);
        this.context = context;

        this.addSlot(new SpecificItemSlot(inventory, BOOK_SLOT,    ModItems.COLORMANCER_BOOK, 32, 37));
        this.addSlot(new SpecificItemSlot(inventory, CYAN_SLOT,    Items.CYAN_DYE,             8, 27));
        this.addSlot(new SpecificItemSlot(inventory, MAGENTA_SLOT, Items.MAGENTA_DYE,         56, 27));
        this.addSlot(new SpecificItemSlot(inventory, YELLOW_SLOT,  Items.YELLOW_DYE,           8, 47));
        this.addSlot(new SpecificItemSlot(inventory, BLACK_SLOT,   Items.BLACK_DYE,           56, 47));

        addAdvancements(playerInventory.player);
        addPlayerHotbar(playerInventory);
        addPlayerInventory(playerInventory);
    }

    private void addAdvancements( PlayerEntity player ) {
        if ( player.getWorld().isClient() ) {
            return;
        }

        for (String advancement : ModAdvancementProvider.advancementIDs) {
            playerFinishedAdvancement( (ServerPlayerEntity) player, advancement);
        }
    }

    public static void drawButton(String advancement) {
        Colormancer.LOGGER.info(advancement);
        

    }

    private void playerFinishedAdvancement(ServerPlayerEntity serverPlayer, String advancement) {

        PacketByteBuf tracker = PacketByteBufs.create();
        Identifier advancementId = new Identifier(Colormancer.MOD_ID, advancement);
        AdvancementEntry advancementEntry = serverPlayer.getServer().getAdvancementLoader().get(advancementId);

        int advDone = serverPlayer.getAdvancementTracker().getProgress(advancementEntry).isDone() ? 0 : 1;
        int advId = 0;

        boolean advFound = false;

        for (int i = 0; i < ModAdvancementProvider.advancementIDs.size() && !advFound; i++) {
            if ( ModAdvancementProvider.advancementIDs.get(i).equals(advancement) ) {
                advId = i;
                advFound = true;
            }
        }

        int[] packet = {advDone, advId};
        tracker.writeIntArray( packet );
        ServerPlayNetworking.send(serverPlayer, ModPackets.GET_ADVANCEMENTS, tracker);

    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (slotIndex < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) { // into player inventory
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) { // into lectern inventory
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(context, player, ModBlocks.COLORMANCER_LECTERN);
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.context.run((world, pos) -> this.dropInventory(player, this.inventory));
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 87 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 145));
        }
    }

    public static class SpecificItemSlot extends Slot {
        public final Item filterItem;

        public SpecificItemSlot(Inventory inventory, int index, Item filterItem, int x, int y) {
            super(inventory, index, x, y);
            this.filterItem = filterItem;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return stack.isOf(this.filterItem);
        }
    }
}
