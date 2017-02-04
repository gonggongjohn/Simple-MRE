package com.gonggongjohn.simplemre.inventory;

import com.gonggongjohn.simplemre.SimpleMRE;
import com.gonggongjohn.simplemre.client.gui.GuiContainerChineseMreA;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiElementLoader implements IGuiHandler
{
    public static final int GUI_ChineseMreA = 1;

    public GuiElementLoader()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(SimpleMRE.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
        case GUI_ChineseMreA:
            return new ContainerChineseMreA(player);
        default:
            return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
        case GUI_ChineseMreA:
            return new GuiContainerChineseMreA(new ContainerChineseMreA(player));
        default:
            return null;
        }
    }
}