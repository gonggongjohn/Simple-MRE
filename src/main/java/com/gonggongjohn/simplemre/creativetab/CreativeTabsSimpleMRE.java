package com.gonggongjohn.simplemre.creativetab;

import com.gonggongjohn.simplemre.block.BlockLoader;
import com.gonggongjohn.simplemre.item.ItemLoader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsSimpleMRE extends CreativeTabs
{
    public CreativeTabsSimpleMRE()
    {
        super("simplemre");
    }

    @Override
    public Item getTabIconItem()
    {
        return ItemLoader.chineseMreA;
    }
}