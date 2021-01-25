package com.gildedrose;

import com.gildedrose.wrappers.ItemWrapper;

public class TextTestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemWrapper[] items = new ItemWrapper[] {
                new ItemWrapper(new Item("+5 Dexterity Vest", 10, 20)),
                new ItemWrapper(new Item("Aged Brie", 2, 0)),
                new ItemWrapper(new Item("Elixir of the Mongoose", 5, 7)),
                new ItemWrapper(new Item("Sulfuras, Hand of Ragnaros", 0, 80)),
                new ItemWrapper(new Item("Sulfuras, Hand of Ragnaros", -1, 80)),
                new ItemWrapper(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)),
                new ItemWrapper(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)),
                new ItemWrapper(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)),
                // this conjured item does not work properly yet
                new ItemWrapper(new Item("Conjured Mana Cake", 3, 6))
        };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (ItemWrapper wrapper : items) {
                System.out.println(wrapper.getItem());
            }
            System.out.println();
            app.updateQuality();
        }
    }
}
