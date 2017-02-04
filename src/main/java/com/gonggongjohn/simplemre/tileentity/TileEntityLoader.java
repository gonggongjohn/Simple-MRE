package com.gonggongjohn.simplemre.tileentity;

import com.gonggongjohn.simplemre.SimpleMRE;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityLoader
{
    public TileEntityLoader(FMLPreInitializationEvent event)
    {
        registerTileEntity(TileEntityOilMaker.class, "OilMaker");
    }

    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id)
    {
        GameRegistry.registerTileEntity(tileEntityClass, SimpleMRE.MODID + ":" + id);
    }
}