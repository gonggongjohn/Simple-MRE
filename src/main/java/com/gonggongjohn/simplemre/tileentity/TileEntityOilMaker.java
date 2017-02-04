package com.gonggongjohn.simplemre.tileentity;

import com.gonggongjohn.simplemre.block.BlockOilMaker;
import com.gonggongjohn.simplemre.item.ItemChineseMreA;
import com.gonggongjohn.simplemre.item.ItemLoader;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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

public class TileEntityOilMaker extends TileEntity implements ITickable
{
    protected int workTime = 0;

    protected ItemStackHandler leftInventory = new ItemStackHandler(4);
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
            if (!this.worldObj.isRemote)
            {
                ItemStack itemStackA = leftInventory.extractItem(0, 8, true);
                ItemStack itemStackB = leftInventory.extractItem(1, 1, true);
                ItemStack itemStackC = leftInventory.extractItem(2, 1, true);
                ItemStack itemStackD = leftInventory.extractItem(3, 5, true);
				ItemStack itemStackE = new ItemStack( ItemLoader.chineseMreA, 1);
				ItemStack itemStackF = new ItemStack( Items.bucket, 1);
                IBlockState state = this.worldObj.getBlockState(pos);

                if (itemStackA != null && itemStackB != null && itemStackC != null && itemStackD != null && rightInventory.insertItem(0, itemStackE, true) == null)
                {
                    int workTotalTime = 1000;

                    if (++this.workTime >= workTotalTime)
                    {
                        this.workTime = 0;
                        itemStackA = leftInventory.extractItem(0, 8, false);
                        itemStackB = leftInventory.extractItem(1, 1, false);
                        itemStackC = leftInventory.extractItem(2, 1, false);
                        itemStackD = leftInventory.extractItem(3, 5, false);
                        rightInventory.insertItem(0, itemStackE, false);
                        leftInventory.insertItem(1, itemStackF, false);
                        leftInventory.insertItem(2, itemStackF, false);
                        this.markDirty();
                    }
                }
                else
                {
                	//TODO
                }
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
