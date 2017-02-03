package com.gonggongjohn.simplemre.item;

import com.gonggongjohn.simplemre.SimpleMRE;
import com.gonggongjohn.simplemre.creativetab.CreativeTabsLoader;
import com.gonggongjohn.simplemre.inventory.GuiElementLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ItemChineseMreA extends Item 
{
    public ItemChineseMreA()
    {
        super();
        this.setUnlocalizedName("chineseMreA");
        this.setCreativeTab(CreativeTabsLoader.tabSimpleMRE);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
            --itemStackIn.stackSize;
        }
        if (!worldIn.isRemote)
        {
            BlockPos pos = playerIn.getPosition();
            int id = GuiElementLoader.GUI_ChineseMreA;
            playerIn.openGui(SimpleMRE.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return itemStackIn;
    }
}