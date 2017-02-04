package com.gonggongjohn.simplemre.tileentity;

import com.gonggongjohn.simplemre.item.ItemLoader;
import com.gonggongjohn.simplemre.block.BlockOilExtractor;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityOilExtractor extends TileEntity implements ITickable
{
    protected int workTime = 0;

    protected ItemStackHandler leftInventory = new ItemStackHandler(2);
    protected ItemStackHandler rightInventory = new ItemStackHandler();

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
            T result = (T) (facing == EnumFacing.DOWN ? rightInventory : leftInventory);
            return result;
        }
        return super.getCapability(capability, facing);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.leftInventory.deserializeNBT(compound.getCompoundTag("LeftInventory"));
        this.rightInventory.deserializeNBT(compound.getCompoundTag("RightInventory"));
        this.workTime = compound.getInteger("WorkTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setTag("LeftInventory", this.leftInventory.serializeNBT());
        compound.setTag("RightInventory", this.rightInventory.serializeNBT());
        compound.setInteger("WorkTime", this.workTime);
    }
    
    @Override
    public void update()
    {
        if (!this.worldObj.isRemote)
        {
                ItemStack itemStackA = leftInventory.extractItem(0, 1, true);
                ItemStack itemStackB = leftInventory.extractItem(1, 1, true);
                ItemStack itemStackC = new ItemStack(ItemLoader.chineseMreA, 1);
                IBlockState state = this.worldObj.getBlockState(pos);

                if (itemStackA != null && itemStackB != null && rightInventory.insertItem(0, itemStackC, true) == null)
                {
                    int workTotalTime = 1000;

                    if (++this.workTime >= workTotalTime)
                    {
                        this.workTime = 0;
                        itemStackA = leftInventory.extractItem(0, 1, false);
                        itemStackB = leftInventory.extractItem(1, 1, false);
                        rightInventory.insertItem(0, itemStackC, false);
                        this.markDirty();
                    }
                }
                else
                {
                	//TODO
                }

        }
    }
    
    public int getWorkTime()
    {
        return this.workTime;
    }

    public int getTotalWorkTime()
    {
        IBlockState state = this.worldObj.getBlockState(this.pos);
        return 1000;
    }
    
    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
    {
        return oldState.getBlock() != newState.getBlock();
    }
}
