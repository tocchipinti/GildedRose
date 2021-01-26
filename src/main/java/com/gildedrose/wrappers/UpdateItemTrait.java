package com.gildedrose.wrappers;

import com.gildedrose.Item;

public interface UpdateItemTrait {

    /**
     * The UpdateItemTrait specifies a method to lower
     * the count and quality by one or by two if the
     * sellIn is below zero
     * Also this method makes sure the quality will not
     * go under zero
     * @param item The Item that is going to be sold
     */
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
