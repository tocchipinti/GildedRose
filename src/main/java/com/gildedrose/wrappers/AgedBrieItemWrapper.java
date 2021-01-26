package com.gildedrose.wrappers;

import com.gildedrose.Item;

public class AgedBrieItemWrapper extends ItemWrapper implements UpdateItemTrait {

    public AgedBrieItemWrapper(Item item) {
        super(item);
    }

    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        item.sellIn -= 1;
    }
}
