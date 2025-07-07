package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    FuzzyListGenerator generator = new FuzzyListGenerator();

    @Test
    void testLinearSearchOnSortedList() {
        ArrayList<Fuzzy> sorted = generator.sortedRainbowFuzzies();
        int index = App.linearSearch(sorted);
        assertTrue(index >= 0);
        assertEquals("gold", sorted.get(index).color);
    }

    @Test
    void testBinarySearchOnSortedList() {
        ArrayList<Fuzzy> sorted = generator.sortedRainbowFuzzies();
        int index = App.binarySearch(sorted);
        assertTrue(index >= 0);
        assertEquals("gold", sorted.get(index).color);
    }

    @Test
    void testLinearSearchOnRandomList() {
        ArrayList<Fuzzy> random = generator.randomizedRainbowFuzzies();
        int index = App.linearSearch(random);
        assertTrue(index >= 0);
        assertEquals("gold", random.get(index).color);
    }

    @Test
    void testBinarySearchOnRandomList() {
        ArrayList<Fuzzy> random = generator.randomizedRainbowFuzzies();
        int correctIndex = App.linearSearch(random);
        int badIndex = App.binarySearch(random);

        // We expect binary search to fail or return a wrong index
        assertTrue(badIndex == -1 || badIndex != correctIndex);
    }
}
