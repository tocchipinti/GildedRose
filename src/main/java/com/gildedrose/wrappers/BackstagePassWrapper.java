package com.gildedrose.wrappers;

import com.gildedrose.Item;

public class BackstagePassWrapper extends ItemWrapper implements UpdateItemTrait {

    public BackstagePassWrapper(Item item) {
        super(item);
    }

    /**
     * The UpdateItemTrait is overridden to lower the quality by one
     * two or three depending on the number of sellIn left
     * Also this method makes sure the quality will not
     * go above fifty
     * @param item The Item that is going to be sold
     */
    @Override
    public void update(Item item) {
        if (item.sellIn > 10) {
            item.quality += 1;
        } else if (item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn > 0) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }

        if (item.quality > 50) {
            item.quality = 50;
        }
        item.sellIn -= 1;
    }
}
