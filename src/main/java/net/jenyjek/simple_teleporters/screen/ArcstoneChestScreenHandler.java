package net.jenyjek.simple_teleporters.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jenyjek.simple_teleporters.SimpleTeleporters;
import net.jenyjek.simple_teleporters.block.entity.ArcstoneChestBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.logging.Logger;


public class ArcstoneChestScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final ArcstoneChestBlockEntity blockEntity;

    public ArcstoneChestScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, (ArcstoneChestBlockEntity) inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
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

    public ArcstoneChestScreenHandler( int syncId, PlayerInventory playerInventory, ArcstoneChestBlockEntity blockEntity) {
        super(ModScreenHandlers.arcstoneChestScreen, syncId);

        this.inventory = (Inventory) blockEntity;
        this.blockEntity = blockEntity;

        checkSize(inventory, 81);

        inventory.onOpen(playerInventory.player);

        for (int i = 0; i < 9; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(inventory, l + i * 9, 8 + l * 18, 16 + i * 18));
            }
        }

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        //return this.inventory.canPlayerUse(player);
        return true;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        if (!player.getWorld().isClient && blockEntity != null) {
            blockEntity.closeChest(player); // play animation, sound, etc.
        }
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 192 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 250));
        }
    }
}
