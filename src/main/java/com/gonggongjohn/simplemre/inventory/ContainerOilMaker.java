package com.gonggongjohn.simplemre.inventory;

import com.gonggongjohn.simplemre.tileentity.TileEntityOilMaker;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerOilMaker extends Container
{
    private IItemHandler leftAItems;
    private IItemHandler leftBItems;
    private IItemHandler leftCItems;
    private IItemHandler leftDItems;
    private IItemHandler rightItems;

    protected TileEntityOilMaker tileEntity;

    protected int workTime = 0;

    public ContainerOilMaker(EntityPlayer player, TileEntity tileEntity)
    {
        super();

        this.leftAItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        this.leftBItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        this.leftCItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        this.leftDItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        this.rightItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);

        this.addSlotToContainer(new SlotItemHandler(this.leftAItems, 0, 11, 29)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return stack != null && stack.getItem() == Items.wheat && super.isItemValid(stack);
            }
        });
        this.addSlotToContainer(new SlotItemHandler(this.leftBItems, 1, 29, 29)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return stack != null && stack.getItem() == Items.water_bucket && super.isItemValid(stack);
            }
        });
        this.addSlotToContainer(new SlotItemHandler(this.leftCItems, 2, 11, 47)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return stack != null && stack.getItem() == Items.lava_bucket && super.isItemValid(stack);
            }
        });
        this.addSlotToContainer(new SlotItemHandler(this.leftDItems, 3, 29, 47)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return stack != null && stack.getItem() == Items.baked_potato && super.isItemValid(stack);
            }
        });
        this.addSlotToContainer(new SlotItemHandler(this.rightItems, 0, 121, 33)
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
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
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
    
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        this.workTime = tileEntity.getWorkTime();

        for (ICrafting i : this.crafters)
        {
            i.sendProgressBarUpdate(this, 0, this.workTime);
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int data)
    {
        super.updateProgressBar(id, data);

        switch (id)
        {
        case 0:
            this.workTime = data;
            break;
        default:
            break;
        }
    }
    
    public int getWorkTime()
    {
        return this.workTime;
    }

    public int getTotalWorkTime()
    {
        return this.tileEntity.getTotalWorkTime();
    }
}