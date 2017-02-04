package com.gonggongjohn.simplemre.item;

import com.gonggongjohn.simplemre.creativetab.CreativeTabsLoader;

import net.minecraft.item.Item;

public class ItemPcbBase extends Item
{
	public ItemPcbBase()
	{
        super();
        this.setUnlocalizedName("pcbBase");
        this.setCreativeTab(CreativeTabsLoader.tabSimpleMRE);
	}
}
