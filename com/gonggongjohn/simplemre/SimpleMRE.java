package com.gonggongjohn.simplemre;

import com.gonggongjohn.simplemre.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SimpleMRE.MODID, name = SimpleMRE.NAME, version = SimpleMRE.VERSION, acceptedMinecraftVersions = "1.8.9")

public class SimpleMRE {
    public static final String MODID = "simplemre";
    public static final String NAME = "Simple MRE";
    public static final String VERSION = "1.0.0";

    @Instance(SimpleMRE.MODID)
    public static SimpleMRE instance;

    @SidedProxy(clientSide = "com.gonggongjohn.simplemre.client.ClientProxy", serverSide = "com.gonggongjohn.simplemre.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

}
