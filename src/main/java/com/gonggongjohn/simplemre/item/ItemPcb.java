package com.gonggongjohn.simplemre.item;

import com.gonggongjohn.simplemre.creativetab.CreativeTabsLoader;

import net.minecraft.item.Item;

public class ItemPcb extends Item
{
	public ItemPcb()
	{
        super();
        this.setUnlocalizedName("PCB");
        this.setCreativeTab(CreativeTabsLoader.tabSimpleMRE);
	}
}
