package com.gildedrose.wrappers;

import com.gildedrose.Item;

public class AgedBrieItemWrapper extends ItemWrapper implements UpdateItemTrait {

    public AgedBrieItemWrapper(Item item) {
        super(item);
    }

    /**
     * The UpdateItemTrait is overridden to up the quality by one
     * instead of lowering the quality
     * Also this method checks if quality is below 50
     * @param item The Item that is going to be sold
     */
    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        item.sellIn -= 1;
    }
}
