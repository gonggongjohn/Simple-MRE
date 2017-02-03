package com.gonggongjohn.simplemre.common;

import com.gonggongjohn.simplemre.item.ItemLoader;
import com.gonggongjohn.simplemre.creativetab.CreativeTabsLoader;
import com.gonggongjohn.simplemre.crafting.CraftingLoader;
import com.gonggongjohn.simplemre.inventory.GuiElementLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
    	new CreativeTabsLoader(event);
    	new ItemLoader(event);
    }

    public void init(FMLInitializationEvent event)
    {
        new CraftingLoader();
        new EventLoader();
        new GuiElementLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
