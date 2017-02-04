package com.gonggongjohn.simplemre.client;

import com.gonggongjohn.simplemre.block.BlockLoader;
import com.gonggongjohn.simplemre.item.ItemLoader;

public class ItemRenderLoader
{
    public ItemRenderLoader()
    {
        ItemLoader.registerRenders();
        BlockLoader.registerRenders();
    }
}
