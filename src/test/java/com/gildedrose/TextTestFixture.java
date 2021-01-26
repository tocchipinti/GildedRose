package com.gildedrose;

import com.gildedrose.wrappers.*;

public class TextTestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemWrapper[] items = new ItemWrapper[] {
                new ItemWrapper(new Item("+5 Dexterity Vest", 10, 20)),
                new AgedBrieItemWrapper(new Item(ItemNames.Names.AGED_BRIE, 2, 0)),
                new ItemWrapper(new Item("Elixir of the Mongoose", 5, 7)),
                new LegendaryItemWrapper(new Item("Sulfuras, Hand of Ragnaros", 0, 80)),
                new LegendaryItemWrapper(new Item("Sulfuras, Hand of Ragnaros", -1, 80)),
                new BackstagePassWrapper(new Item(ItemNames.Names.BACKSTAGE_PASS, 15, 20)),
                new BackstagePassWrapper(new Item(ItemNames.Names.BACKSTAGE_PASS, 10, 49)),
                new BackstagePassWrapper(new Item(ItemNames.Names.BACKSTAGE_PASS, 5, 49)),
                new ConjuredItemWrapper(new Item("Conjured Mana Cake", 3, 6))
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
