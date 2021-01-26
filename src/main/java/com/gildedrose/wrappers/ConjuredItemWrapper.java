package com.gildedrose.wrappers;

import com.gildedrose.Item;

public class ConjuredItemWrapper extends ItemWrapper implements UpdateItemTrait{

    public ConjuredItemWrapper(Item item) {
        super(item);
    }

    /**
     * The UpdateItemTrait is overridden to lower the quality
     * twice as hard as usual
     * Also this method makes sure the quality will not
     * go above fifty
     * @param item The Item that is going to be sold
     */
    @Override
    public void update(Item item) {
        if (item.sellIn > 0 && item.quality > 0) {
            item.quality -= 2;
        } else if (item.sellIn <= 0 && item.quality > 0) {
            item.quality -= 4;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
        item.sellIn -= 1;
    }
}
