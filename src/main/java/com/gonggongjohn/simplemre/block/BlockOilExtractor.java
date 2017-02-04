package com.gonggongjohn.simplemre.block;

import com.gonggongjohn.simplemre.SimpleMRE;
import com.gonggongjohn.simplemre.creativetab.CreativeTabsLoader;
import com.gonggongjohn.simplemre.inventory.GuiElementLoader;
import com.gonggongjohn.simplemre.tileentity.TileEntityOilExtractor;
import com.gonggongjohn.simplemre.tileentity.TileEntityOilMaker;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockOilExtractor extends BlockContainer
{
    public BlockOilExtractor()
    {
        super(Material.iron);
        this.setUnlocalizedName("oilExtractor");
        this.setHardness(7.0F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(CreativeTabsLoader.tabSimpleMRE);
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityOilExtractor();
    }
    
    @Override
    public int getRenderType()
    {
        return 3;
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
            EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            int id = GuiElementLoader.GUI_OIL_EXTRACTOR;
            playerIn.openGui(SimpleMRE.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }
}
