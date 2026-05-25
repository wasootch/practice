package org.example.arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContainerWithMostWaterTest {

    private final ContainerWithMostWater solution = new ContainerWithMostWater();

    @Test
    public void testMaxArea_example1() {
        // [1,8,6,2,5,4,8,3,7] → 49 (between index 1 and 8: min(8,7)*7)
        assertEquals(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
    }

    @Test
    public void testMaxArea_example2() {
        assertEquals(solution.maxArea(new int[]{1, 1}), 1);
    }

    @Test
    public void testMaxArea_twoElements_asymmetric() {
        assertEquals(solution.maxArea(new int[]{4, 1}), 1);
    }

    @Test
    public void testMaxArea_equalHeights() {
        // outermost pair: min(5,5)*3 = 15
        assertEquals(solution.maxArea(new int[]{5, 5, 5, 5}), 15);
    }

    @Test
    public void testMaxArea_increasing() {
        // [1,2,3,4,5] → best is min(2,5)*3 or min(3,5)*2 = 6
        assertEquals(solution.maxArea(new int[]{1, 2, 3, 4, 5}), 6);
    }

    @Test
    public void testMaxArea_decreasing() {
        assertEquals(solution.maxArea(new int[]{5, 4, 3, 2, 1}), 6);
    }

    @Test
    public void testMaxArea_tallInMiddle() {
        // tall middle wall doesn't help; outermost pair is min(1,1)*2 = 2
        assertEquals(solution.maxArea(new int[]{1, 100, 1}), 2);
    }

    @Test
    public void testMaxArea_allSameHeight() {
        assertEquals(solution.maxArea(new int[]{3, 3, 3, 3, 3}), 12);
    }

    @Test
    public void testMaxArea_oneZeroHeight() {
        assertEquals(solution.maxArea(new int[]{0, 5}), 0);
    }

    @Test
    public void testMaxArea_maxValues() {
        assertEquals(solution.maxArea(new int[]{10000, 10000}), 10000);
    }

    @Test
    public void testMaxArea_bestNotAtOuterEdge() {
        // [2,3,4,5,18,17,6]: best is between heights 18 and 17 → min(18,17)*1 = 17
        assertEquals(solution.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}), 17);
    }
}
