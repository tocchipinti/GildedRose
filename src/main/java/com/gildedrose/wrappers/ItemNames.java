package com.gildedrose.wrappers;

public enum ItemNames {
    STANDARD_ITEM(Names.STANDARD_ITEM),
    AGED_BRIE(Names.AGED_BRIE),
    BACKSTAGE_PASS(Names.BACKSTAGE_PASS),
    LEGENDARY_ITEM(Names.LEGENDARY_ITEM),
    CONJURED_ITEM(Names.CONJURED_ITEM);

    public static class Names {
        public static final String STANDARD_ITEM = "Standard item";
        public static final String AGED_BRIE = "Aged Brie";
        public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
        public static final String LEGENDARY_ITEM = "Legendary item";
        public static final String CONJURED_ITEM = "Conjured item";
    }

    public String toString() {
        return this.label;
    }

    private final String label;

    private ItemNames(String label) {
        this.label = label;
    }
}


