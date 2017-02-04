package com.gonggongjohn.simplemre.inventory;

import com.gonggongjohn.simplemre.item.ItemLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerChineseMreA extends Container
{
	private ItemStackHandler items = new ItemStackHandler(9);
	
    public ContainerChineseMreA(EntityPlayer player)
    {
        super();
        
        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new SlotItemHandler(items, i, 8 + i * 18, 41));
        }

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
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return new ItemStack(ItemLoader.chineseMreA).isItemEqual(playerIn.getCurrentEquippedItem());
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        return null;
    }
}