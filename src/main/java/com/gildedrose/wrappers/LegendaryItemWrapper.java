package com.gildedrose.wrappers;

import com.gildedrose.Item;
import com.gildedrose.UpdateItemTrait;

public class LegendaryItemWrapper extends ItemWrapper implements UpdateItemTrait {

    public LegendaryItemWrapper(Item item) {
        super(item);
    }

    @Override
    public void update(Item item) {
        // Being a Legendary item we do not sell the item
        // We also don't decrease or increase the quality
        // How can something so legendary be sold or become less qualitative...
    }
}
