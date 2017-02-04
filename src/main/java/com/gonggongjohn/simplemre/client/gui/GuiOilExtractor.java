package com.gonggongjohn.simplemre.client.gui;

import com.gonggongjohn.simplemre.SimpleMRE;
import com.gonggongjohn.simplemre.inventory.ContainerOilExtractor;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiOilExtractor extends GuiContainer
{
    private static final String TEXTURE_PATH = SimpleMRE.MODID + ":" + "textures/gui/container/gui_oil_extractor.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);

    protected ContainerOilExtractor inventory;
	private int totalWorkTime;

    public GuiOilExtractor(ContainerOilExtractor inventorySlotsIn)
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
        int textureWidth = (int) Math.ceil(21.0 * workTime / this.totalWorkTime);
        this.drawTexturedModalRect(offsetX + 80, offsetY + 35, 0, 167, textureWidth, 14);
    }
}