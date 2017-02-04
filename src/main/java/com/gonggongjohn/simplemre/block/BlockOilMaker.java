package com.gonggongjohn.simplemre.block;

import com.gonggongjohn.simplemre.creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class BlockOilMaker extends Block
{
    public BlockOilMaker()
    {
        super(Material.iron);
        this.setUnlocalizedName("oilMaker");
        this.setHardness(7.0F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(CreativeTabsLoader.tabSimpleMRE);
    }
}
