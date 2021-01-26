package com.gildedrose;

import com.gildedrose.wrappers.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    // Standard Item Tests
    @Test
    void standardItemDecreaseOneDay() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ItemWrapper(new Item(ItemNames.Names.STANDARD_ITEM, 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.STANDARD_ITEM, app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(4, app.items[0].getItem().quality);
    }

    @Test
    void standardItemDecreaseTwoDays() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ItemWrapper(new Item(ItemNames.Names.STANDARD_ITEM, 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.STANDARD_ITEM, app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(4, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.Names.STANDARD_ITEM, app.items[0].getItem().name);
        assertEquals(8, app.items[0].getItem().sellIn);
        assertEquals(3, app.items[0].getItem().quality);
    }

    @Test
    void standardItemDecreaseQualityByTwoIfSellIsZeroOrLess() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ItemWrapper(new Item(ItemNames.Names.STANDARD_ITEM, 0, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.STANDARD_ITEM, app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(3, app.items[0].getItem().quality);
    }

    @Test
    void standardItemNoNegativeQuality() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ItemWrapper(new Item(ItemNames.Names.STANDARD_ITEM, 0, 0)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.STANDARD_ITEM, app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(0, app.items[0].getItem().quality);
    }

    // AgeBrie Tests
    @Test
    void agedBrieIncreaseOneDay() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new AgedBrieItemWrapper(new Item(ItemNames.Names.AGED_BRIE, 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.AGED_BRIE, app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(6, app.items[0].getItem().quality);
    }

    @Test
    void agedBrieIncreaseTwoDays() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new AgedBrieItemWrapper(new Item(ItemNames.Names.AGED_BRIE, 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.AGED_BRIE, app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(6, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.Names.AGED_BRIE, app.items[0].getItem().name);
        assertEquals(8, app.items[0].getItem().sellIn);
        assertEquals(7, app.items[0].getItem().quality);
    }

    @Test
    void agedBrieNotToHighQuality() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new AgedBrieItemWrapper(new Item(ItemNames.Names.AGED_BRIE, 0, 50)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.AGED_BRIE, app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(50, app.items[0].getItem().quality);
    }

    // BackstagePass Tests
    @Test
    void backstagePassIncreaseByOneAboveTen() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.Names.BACKSTAGE_PASS, 11, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.BACKSTAGE_PASS, app.items[0].getItem().name);
        assertEquals(10, app.items[0].getItem().sellIn);
        assertEquals(6, app.items[0].getItem().quality);
    }

    @Test
    void backstagePassIncreaseByTwoAboveFiveBelowTen() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.Names.BACKSTAGE_PASS, 6, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.BACKSTAGE_PASS, app.items[0].getItem().name);
        assertEquals(5, app.items[0].getItem().sellIn);
        assertEquals(7, app.items[0].getItem().quality);
    }

    @Test
    void backstagePassIncreaseByThreeAboveZeroBelowFive() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.Names.BACKSTAGE_PASS, 3, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.BACKSTAGE_PASS, app.items[0].getItem().name);
        assertEquals(2, app.items[0].getItem().sellIn);
        assertEquals(8, app.items[0].getItem().quality);
    }

    @Test
    void backstagePassIncreaseByOneAndTwo() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.Names.BACKSTAGE_PASS, 11, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.BACKSTAGE_PASS, app.items[0].getItem().name);
        assertEquals(10, app.items[0].getItem().sellIn);
        assertEquals(6, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.Names.BACKSTAGE_PASS, app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(8, app.items[0].getItem().quality);
    }

    @Test
    void backstagePassIncreaseByTwoAndThree() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.Names.BACKSTAGE_PASS, 6, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.BACKSTAGE_PASS, app.items[0].getItem().name);
        assertEquals(5, app.items[0].getItem().sellIn);
        assertEquals(7, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.Names.BACKSTAGE_PASS, app.items[0].getItem().name);
        assertEquals(4, app.items[0].getItem().sellIn);
        assertEquals(10, app.items[0].getItem().quality);
    }

    @Test
    void backstagePassIncreaseByThreeToZero() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.Names.BACKSTAGE_PASS, 1, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.BACKSTAGE_PASS, app.items[0].getItem().name);
        assertEquals(0, app.items[0].getItem().sellIn);
        assertEquals(8, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.Names.BACKSTAGE_PASS, app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(0, app.items[0].getItem().quality);
    }

    @Test
    void backStagePassNotToHighQuality() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.Names.BACKSTAGE_PASS, 0, 50)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.BACKSTAGE_PASS, app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(0, app.items[0].getItem().quality);
    }

    // Conjured Item Tests
    @Test
    void conjuredItemDecreaseOneDay() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ConjuredItemWrapper(new Item(ItemNames.Names.CONJURED_ITEM, 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.CONJURED_ITEM, app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(3, app.items[0].getItem().quality);
    }

    @Test
    void conjuredItemDecreaseTwoDays() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ConjuredItemWrapper(new Item(ItemNames.Names.CONJURED_ITEM, 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.CONJURED_ITEM, app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(3, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.Names.CONJURED_ITEM, app.items[0].getItem().name);
        assertEquals(8, app.items[0].getItem().sellIn);
        assertEquals(1, app.items[0].getItem().quality);
    }

    @Test
    void conjuredItemDecreaseQualityByTwoIfSellIsZeroOrLess() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ConjuredItemWrapper(new Item(ItemNames.Names.CONJURED_ITEM, 0, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.CONJURED_ITEM, app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(1, app.items[0].getItem().quality);
    }

    @Test
    void conjuredItemNoNegativeQuality() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ConjuredItemWrapper(new Item(ItemNames.Names.CONJURED_ITEM, 0, 0)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.Names.CONJURED_ITEM, app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(0, app.items[0].getItem().quality);
    }
}
