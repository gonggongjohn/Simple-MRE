package com.gonggongjohn.simplemre.inventory;

import com.gonggongjohn.simplemre.SimpleMRE;
import com.gonggongjohn.simplemre.client.gui.GuiOilExtractor;
import com.gonggongjohn.simplemre.client.gui.GuiOilMaker;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiElementLoader implements IGuiHandler
{
    public static final int GUI_OIL_MAKER = 1;
    public static final int GUI_OIL_EXTRACTOR = 2;

    public GuiElementLoader()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(SimpleMRE.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
        case GUI_OIL_MAKER:
            return new ContainerOilMaker(player, world.getTileEntity(new BlockPos(x, y, z)));
        case GUI_OIL_EXTRACTOR:
        	return new ContainerOilExtractor(player, world.getTileEntity(new BlockPos(x, y, z)));
        default:
            return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
        case GUI_OIL_MAKER:
            return new GuiOilMaker(new ContainerOilMaker(player, world.getTileEntity(new BlockPos(x, y, z))));
        case GUI_OIL_EXTRACTOR:
        	return new GuiOilExtractor(new ContainerOilExtractor(player, world.getTileEntity(new BlockPos(x, y, z))));
        default:
            return null;
        }
    }
}