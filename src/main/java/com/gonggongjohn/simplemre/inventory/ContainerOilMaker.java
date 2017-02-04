package com.gonggongjohn.simplemre.inventory;

import com.gonggongjohn.simplemre.tileentity.TileEntityOilMaker;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerOilMaker extends Container
{
    private IItemHandler inItems;
    private IItemHandler outItems;

    protected TileEntityOilMaker tileEntity;

    protected int workTime = 0;

    public ContainerOilMaker(EntityPlayer player, TileEntity tileEntity)
    {
        super();

        this.inItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        this.outItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);

        this.addSlotToContainer(new SlotItemHandler(this.inItems, 0, 56, 30));
        this.addSlotToContainer(new SlotItemHandler(this.outItems, 0, 110, 30)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return false;
            }
        });

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 74 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 132));
        }

        this.tileEntity = (TileEntityOilMaker) tileEntity;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        Slot slot = inventorySlots.get(index);

        if (slot == null || !slot.getHasStack())
        {
            return null;
        }

        ItemStack newStack = slot.getStack(), oldStack = newStack.copy();

        boolean isMerged = false;

        if (index == 0 || index == 1)
        {
            isMerged = mergeItemStack(newStack, 2, 38, true);
        }
        else if (index >= 2 && index < 29)
        {
            isMerged = mergeItemStack(newStack, 0, 1, false) || mergeItemStack(newStack, 29, 38, false);
        }
        else if (index >= 29 && index < 38)
        {
            isMerged = mergeItemStack(newStack, 0, 1, false) || mergeItemStack(newStack, 2, 29, false);
        }

        if (!isMerged)
        {
            return null;
        }

        if (newStack.stackSize == 0)
        {
            slot.putStack(null);
        }
        else
        {
            slot.onSlotChanged();
        }

        slot.onPickupFromSlot(playerIn, newStack);

        return oldStack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return playerIn.getDistanceSq(this.tileEntity.getPos()) <= 64;
    }
}