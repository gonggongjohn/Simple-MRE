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

}