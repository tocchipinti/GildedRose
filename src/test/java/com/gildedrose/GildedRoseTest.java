package com.gildedrose;

import com.gildedrose.wrappers.ItemWrapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    // Standard Item Tests
    @Test
    void standardItemDecrease() {
        // Arrange
        ItemWrapper[] wrappers = new ItemWrapper[] { new ItemWrapper(new Item("Default Item", 10, 5)) };
        GildedRose app = new GildedRose(wrappers);

        // Act
        app.updateQuality();

        // Assert
        assertEquals("Default Item", app.items[0].getItem().name);
        assertEquals(9, app.items[0].getItem().sellIn);
        assertEquals(4, app.items[0].getItem().quality);
    }
}
