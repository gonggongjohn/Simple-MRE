package com.gonggongjohn.simplemre.client.gui;

import com.gonggongjohn.simplemre.SimpleMRE;
import com.gonggongjohn.simplemre.inventory.ContainerChineseMreA;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiContainerChineseMreA extends GuiContainer
{
    private static final String TEXTURE_PATH = SimpleMRE.MODID + ":" + "textures/gui/container/gui_chinese_mre_a.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);
    
    public GuiContainerChineseMreA(ContainerChineseMreA inventorySlotsIn)
    {
        super(inventorySlotsIn);
        this.xSize = 175;
        this.ySize = 165;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        // TODO
    }
}