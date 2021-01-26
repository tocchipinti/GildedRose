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
                new ItemWrapper(new Item(ItemNames.STANDARD_ITEM.getLabel(), 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.STANDARD_ITEM.getLabel(), app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(4, app.items[0].getItem().quality);
    }

    @Test
    void standardItemDecreaseTwoDays() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ItemWrapper(new Item(ItemNames.STANDARD_ITEM.getLabel(), 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.STANDARD_ITEM.getLabel(), app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(4, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.STANDARD_ITEM.getLabel(), app.items[0].getItem().name);
        assertEquals(8, app.items[0].getItem().sellIn);
        assertEquals(3, app.items[0].getItem().quality);
    }

    @Test
    void standardItemDecreaseQualityByTwoIfSellIsZeroOrLess() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ItemWrapper(new Item(ItemNames.STANDARD_ITEM.getLabel(), 0, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.STANDARD_ITEM.getLabel(), app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(3, app.items[0].getItem().quality);
    }

    @Test
    void standardItemNoNegativeQuality() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ItemWrapper(new Item(ItemNames.STANDARD_ITEM.getLabel(), 0, 0)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.STANDARD_ITEM.getLabel(), app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(0, app.items[0].getItem().quality);
    }

    // AgeBrie Tests
    @Test
    void agedBrieIncreaseOneDay() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new AgedBrieItemWrapper(new Item(ItemNames.AGED_BRIE.getLabel(), 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.AGED_BRIE.getLabel(), app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(6, app.items[0].getItem().quality);
    }

    @Test
    void agedBrieIncreaseTwoDays() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new AgedBrieItemWrapper(new Item(ItemNames.AGED_BRIE.getLabel(), 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.AGED_BRIE.getLabel(), app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(6, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.AGED_BRIE.getLabel(), app.items[0].getItem().name);
        assertEquals(8, app.items[0].getItem().sellIn);
        assertEquals(7, app.items[0].getItem().quality);
    }

    @Test
    void agedBrieNotToHighQuality() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new AgedBrieItemWrapper(new Item(ItemNames.AGED_BRIE.getLabel(), 0, 50)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.AGED_BRIE.getLabel(), app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(50, app.items[0].getItem().quality);
    }

    // BackstagePass Tests
    @Test
    void backstagePassIncreaseByOneAboveTen() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.BACKSTAGE_PASS.getLabel(), 11, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.BACKSTAGE_PASS.getLabel(), app.items[0].getItem().name);
        assertEquals(10, app.items[0].getItem().sellIn);
        assertEquals(6, app.items[0].getItem().quality);
    }

    @Test
    void backstagePassIncreaseByTwoAboveFiveBelowTen() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.BACKSTAGE_PASS.getLabel(), 6, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.BACKSTAGE_PASS.getLabel(), app.items[0].getItem().name);
        assertEquals(5, app.items[0].getItem().sellIn);
        assertEquals(7, app.items[0].getItem().quality);
    }

    @Test
    void backstagePassIncreaseByThreeAboveZeroBelowFive() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.BACKSTAGE_PASS.getLabel(), 3, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.BACKSTAGE_PASS.getLabel(), app.items[0].getItem().name);
        assertEquals(2, app.items[0].getItem().sellIn);
        assertEquals(8, app.items[0].getItem().quality);
    }

    @Test
    void backstagePassIncreaseByOneAndTwo() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.BACKSTAGE_PASS.getLabel(), 11, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.BACKSTAGE_PASS.getLabel(), app.items[0].getItem().name);
        assertEquals(10, app.items[0].getItem().sellIn);
        assertEquals(6, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.BACKSTAGE_PASS.getLabel(), app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(8, app.items[0].getItem().quality);
    }

    @Test
    void backstagePassIncreaseByTwoAndThree() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.BACKSTAGE_PASS.getLabel(), 6, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.BACKSTAGE_PASS.getLabel(), app.items[0].getItem().name);
        assertEquals(5, app.items[0].getItem().sellIn);
        assertEquals(7, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.BACKSTAGE_PASS.getLabel(), app.items[0].getItem().name);
        assertEquals(4, app.items[0].getItem().sellIn);
        assertEquals(10, app.items[0].getItem().quality);
    }

    @Test
    void backstagePassIncreaseByThreeToZero() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.BACKSTAGE_PASS.getLabel(), 1, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.BACKSTAGE_PASS.getLabel(), app.items[0].getItem().name);
        assertEquals(0, app.items[0].getItem().sellIn);
        assertEquals(8, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.BACKSTAGE_PASS.getLabel(), app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(0, app.items[0].getItem().quality);
    }

    @Test
    void backStagePassNotToHighQuality() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new BackstagePassWrapper(new Item(ItemNames.BACKSTAGE_PASS.getLabel(), 0, 50)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.BACKSTAGE_PASS.getLabel(), app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(0, app.items[0].getItem().quality);
    }

    // Conjured Item Tests
    @Test
    void conjuredItemDecreaseOneDay() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ConjuredItemWrapper(new Item(ItemNames.CONJURED_ITEM.getLabel(), 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.CONJURED_ITEM.getLabel(), app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(3, app.items[0].getItem().quality);
    }

    @Test
    void conjuredItemDecreaseTwoDays() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ConjuredItemWrapper(new Item(ItemNames.CONJURED_ITEM.getLabel(), 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.CONJURED_ITEM.getLabel(), app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(3, app.items[0].getItem().quality);

        // Act Again
        app.updateQuality();

        // Assert Again
        assertEquals(ItemNames.CONJURED_ITEM.getLabel(), app.items[0].getItem().name);
        assertEquals(8, app.items[0].getItem().sellIn);
        assertEquals(1, app.items[0].getItem().quality);
    }

    @Test
    void conjuredItemDecreaseQualityByTwoIfSellIsZeroOrLess() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ConjuredItemWrapper(new Item(ItemNames.CONJURED_ITEM.getLabel(), 0, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.CONJURED_ITEM.getLabel(), app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(1, app.items[0].getItem().quality);
    }

    @Test
    void conjuredItemNoNegativeQuality() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] {
                new ConjuredItemWrapper(new Item(ItemNames.CONJURED_ITEM.getLabel(), 0, 0)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(ItemNames.CONJURED_ITEM.getLabel(), app.items[0].getItem().name);
        assertEquals(-1, app.items[0].getItem().sellIn);
        assertEquals(0, app.items[0].getItem().quality);
    }
}
