package com.gildedrose.wrappers;

import com.gildedrose.Item;

public class LegendaryItemWrapper extends ItemWrapper implements UpdateItemTrait {

    public LegendaryItemWrapper(Item item) {
        super(item);
    }

    /**
     * The UpdateItemTrait is overridden to not do anything
     * Being a Legendary item the values must stay the same
     * @param item The Item that is going to be sold
     */
    @Override
    public void update(Item item) {}
}
