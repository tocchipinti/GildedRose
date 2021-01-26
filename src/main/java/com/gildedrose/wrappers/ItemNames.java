package com.gildedrose.wrappers;

public enum ItemNames {
    STANDARD_ITEM("Standard item"),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert"),
    LEGENDARY_ITEM("Legendary item"),
    CONJURED_ITEM("Conjured item");

    public String toString() {
        return this.label;
    }

    private final String label;

    private ItemNames(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


