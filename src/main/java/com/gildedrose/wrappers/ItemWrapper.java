package com.gildedrose.wrappers;

import com.gildedrose.Item;
import com.gildedrose.UpdateItemTrait;

public class ItemWrapper implements UpdateItemTrait {
    private final Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
