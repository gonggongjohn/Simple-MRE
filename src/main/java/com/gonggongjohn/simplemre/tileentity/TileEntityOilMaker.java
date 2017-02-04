package com.gonggongjohn.simplemre.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityOilMaker extends TileEntity implements ITickable
{
    protected int workTime = 0;

    protected ItemStackHandler inInventory = new ItemStackHandler();
    protected ItemStackHandler outInventory = new ItemStackHandler();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
        {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
        {
            @SuppressWarnings("unchecked")
            T result = (T) (facing == EnumFacing.DOWN ? outInventory : inInventory);
            return result;
        }
        return super.getCapability(capability, facing);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.inInventory.deserializeNBT(compound.getCompoundTag("InInventory"));
        this.outInventory.deserializeNBT(compound.getCompoundTag("OutInventory"));
        this.workTime = compound.getInteger("WorkTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setTag("InInventory", this.inInventory.serializeNBT());
        compound.setTag("OutInventory", this.outInventory.serializeNBT());
        compound.setInteger("WorkTime", this.workTime);
    }
    
    @Override
    public void update()
    {
        if (!this.worldObj.isRemote)
        {
            // TODO
        }
    }
}
