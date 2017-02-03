package com.gonggongjohn.simplemre.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventLoader {
	public EventLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
	
	
}
