package org.example.dp;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaximumProductSubArrayTest {

    MaximumProductSubArray solution = new MaximumProductSubArray();

    @Test
    public void testMaxProduct_1() {
        assertEquals(solution.maxProduct(new int[]{2, 3, -2, 4}), 6);
    }

    @Test
    public void testMaxProduct_2() {
        assertEquals(solution.maxProduct(new int[]{-2, 0, -1}), 0);
    }

    @Test
    public void testMaxProduct_singleElement() {
        assertEquals(solution.maxProduct(new int[]{-3}), -3);
    }

    @Test
    public void testMaxProduct_allNegatives_odd() {
        assertEquals(solution.maxProduct(new int[]{-2, -3, -4}), 12);
    }

    @Test
    public void testMaxProduct_allNegatives_even() {
        assertEquals(solution.maxProduct(new int[]{-2, -3, -4, -5}), 120);
    }

    @Test
    public void testMaxProduct_zeroInMiddle() {
        assertEquals(solution.maxProduct(new int[]{3, -1, 4, 0, 2, 3}), 6);
    }

    @Test
    public void testMaxProduct_allPositive() {
        assertEquals(solution.maxProduct(new int[]{1, 2, 3, 4}), 24);
    }

    @Test
    public void testMaxProduct_ThreeNegativeZero() {
        assertEquals(solution.maxProduct(new int[]{-1, -2, -3, 0}), 6);
    }
}
