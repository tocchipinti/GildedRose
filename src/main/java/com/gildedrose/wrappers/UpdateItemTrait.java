package com.gildedrose.wrappers;

import com.gildedrose.Item;

public interface UpdateItemTrait {
    default void update(Item item) {
        if (item.sellIn > 0) {
            item.quality -= 1;
        }
        if (item.sellIn <= 0) {
            item.quality -= 2;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
        item.sellIn -= 1;
    }
}
