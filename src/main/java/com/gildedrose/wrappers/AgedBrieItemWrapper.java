package com.gildedrose.wrappers;

import com.gildedrose.Item;

public class AgedBrieItemWrapper extends ItemWrapper implements UpdateItemTrait {

    public AgedBrieItemWrapper(Item item) {
        super(item);
    }

    @Override
    public void update(Item item) {
        item.sellIn -= 1;
        if (item.quality < 50) {
            item.quality += 1;
        }
    }
}
