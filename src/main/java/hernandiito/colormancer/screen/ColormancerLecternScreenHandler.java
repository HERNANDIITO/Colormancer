package hernandiito.colormancer.screen;

import hernandiito.colormancer.block.entity.ColormancerLecternEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LecternBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ColormancerLecternScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    public final ColormancerLecternEntity blockEntity;

    public ColormancerLecternScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
    }
    public ColormancerLecternScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(ColormancerScreenHandlers.COLORMANCER_LECTERN_SCREEN_HANDLER, syncId);
        checkSize( (Inventory) blockEntity, 5);
        this.inventory = (Inventory) blockEntity;
        inventory.onOpen(playerInventory.player);
        this.blockEntity = (ColormancerLecternEntity) blockEntity;

        this.addSlot(new Slot(inventory, 0, 32, 37));
        this.addSlot(new Slot(inventory, 1, 8,  27));
        this.addSlot(new Slot(inventory, 2, 56, 27));
        this.addSlot(new Slot(inventory, 3, 8,  47));
        this.addSlot(new Slot(inventory, 4, 56, 47));

        addPlayerHotbar(playerInventory);
        addPlayerInventory(playerInventory);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
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
        return this.inventory.canPlayerUse(player);
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
}
