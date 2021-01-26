package com.gildedrose;

public interface UpdateItemTrait {
    default void update(Item item) {
        item.sellIn -= 1;
        if (item.sellIn > 0 && item.quality > 0) {
            item.quality -= 1;
        } else if (item.sellIn <= 0 && item.quality > 0) {
            item.quality -= 2;
        }
    }
}
