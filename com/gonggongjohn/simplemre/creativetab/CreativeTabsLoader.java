package com.gonggongjohn.simplemre.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader
{
    public static CreativeTabs tabSimpleMRE;

    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
        tabSimpleMRE = new CreativeTabsSimpleMRE();
    }
}