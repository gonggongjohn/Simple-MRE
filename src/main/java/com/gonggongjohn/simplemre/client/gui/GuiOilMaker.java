package com.gonggongjohn.simplemre.client.gui;

import com.gonggongjohn.simplemre.SimpleMRE;
import com.gonggongjohn.simplemre.inventory.ContainerOilMaker;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class GuiOilMaker extends GuiContainer
{
    private static final String TEXTURE_PATH = SimpleMRE.MODID + ":" + "textures/gui/container/gui_oil_maker.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);

    protected ContainerOilMaker inventory;
	private int totalWorkTime;

    public GuiOilMaker(ContainerOilMaker inventorySlotsIn)
    {
        super(inventorySlotsIn);
        this.xSize = 175;
        this.ySize = 165;
        this.inventory = inventorySlotsIn;
        this.totalWorkTime = inventorySlotsIn.getTotalWorkTime();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);

        int workTime = this.inventory.getWorkTime();
        int textureWidth = (int) Math.ceil(63.0 * workTime / this.totalWorkTime);
        this.drawTexturedModalRect(offsetX + 79, offsetY + 15, 177, 0, 16, textureWidth);
    }
}