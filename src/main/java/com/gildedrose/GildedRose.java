package com.gildedrose;

import com.gildedrose.wrappers.ItemWrapper;

class GildedRose {
    protected final ItemWrapper[] items;

    public GildedRose(ItemWrapper[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (ItemWrapper wrapper : items) {
            wrapper.update(wrapper.getItem());
        }
    }
}