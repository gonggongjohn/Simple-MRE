package com.gonggongjohn.simplemre.crafting;

import com.gonggongjohn.simplemre.block.BlockLoader;
import com.gonggongjohn.simplemre.item.ItemLoader;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader {
    public CraftingLoader()
    {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    private static void registerRecipe()
    {
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.pcbBase), new Object[]
        {
                "*#*", "#$#", "*#*", '#', Items.gold_ingot, '*', Items.iron_ingot, '$', Items.redstone
        });
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.PCB), new Object[]
        {
                " # ", "#*#", " #　", '#', ItemLoader.pcbBase, '*', Items.diamond
        });
        GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.oilMaker), new Object[]
        {
                "$&$", "*#*", "$&$", '#', ItemLoader.PCB, '*', Items.diamond, '$', Items.iron_ingot, '&', Items.redstone
        });
    }

    private static void registerSmelting()
    {

    }

    private static void registerFuel()
    {

    }
}
