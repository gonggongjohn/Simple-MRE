package com.gonggongjohn.simplemre.item;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
    public static Item chineseMreA = new ItemChineseMreA();
    public static Item oilDust = new ItemOilDust();
    public static Item PCB = new ItemPcb();
    public static Item pcbBase = new ItemPcbBase();

    public ItemLoader(FMLPreInitializationEvent event)
    {
        register(chineseMreA, "chinese_mre_a");
        register(oilDust, "oil_dust");
        register(PCB, "pcb");
        register(pcbBase, "pcb_base");
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(chineseMreA);
        registerRender(oilDust);
        registerRender(PCB);
        registerRender(pcbBase);
    }

    private static void register(Item item, String name)
    {
        GameRegistry.registerItem(item, name);
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        String name = GameData.getItemRegistry().getNameForObject(item).toString();
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
    }
}
