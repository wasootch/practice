package org.example.arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaximumSubArrayTest {

    private final MaximumSubArray solution = new MaximumSubArray();

    @Test
    public void testMaxSubArray_example1() {
        assertEquals(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6);
    }

    @Test
    public void testMaxSubArray_example2() {
        assertEquals(solution.maxSubArray(new int[]{1}), 1);
    }

    @Test
    public void testMaxSubArray_example3() {
        assertEquals(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}), 23);
    }

    @Test
    public void testMaxSubArray_singleNegative() {
        assertEquals(solution.maxSubArray(new int[]{-7}), -7);
    }

    @Test
    public void testMaxSubArray_allNegative() {
        assertEquals(solution.maxSubArray(new int[]{-3, -1, -4, -2}), -1);
    }

    @Test
    public void testMaxSubArray_allPositive() {
        assertEquals(solution.maxSubArray(new int[]{1, 2, 3, 4, 5}), 15);
    }

    @Test
    public void testMaxSubArray_allZeros() {
        assertEquals(solution.maxSubArray(new int[]{0, 0, 0}), 0);
    }

    @Test
    public void testMaxSubArray_bestAtStart() {
        assertEquals(solution.maxSubArray(new int[]{5, 4, -20, 1}), 9);
    }

    @Test
    public void testMaxSubArray_bestAtEnd() {
        assertEquals(solution.maxSubArray(new int[]{1, -20, 4, 5}), 9);
    }

    @Test
    public void testMaxSubArray_bestIsSingleMiddleElement() {
        assertEquals(solution.maxSubArray(new int[]{-5, 10, -5}), 10);
    }

    @Test
    public void testMaxSubArray_largeDipThenRun() {
        assertEquals(solution.maxSubArray(new int[]{-100, 3, 4, 5}), 12);
    }

    @Test
    public void testMaxSubArray_alternating() {
        assertEquals(solution.maxSubArray(new int[]{2, -1, 2, -1, 2}), 4);
    }

    @Test
    public void testMaxSubArray_twoIslands() {
        assertEquals(solution.maxSubArray(new int[]{1, 2, -100, 3, 4}), 7);
    }

    @Test
    public void testMaxSubArray_maxPositiveElement() {
        assertEquals(solution.maxSubArray(new int[]{10000}), 10000);
    }

    @Test
    public void testMaxSubArray_minNegativeElement() {
        assertEquals(solution.maxSubArray(new int[]{-10000}), -10000);
    }

    @Test
    public void testMaxSubArray_twoElementsNegThenPos() {
        assertEquals(solution.maxSubArray(new int[]{-3, 5}), 5);
    }

    @Test
    public void testMaxSubArray_twoElementsPosThenNeg() {
        assertEquals(solution.maxSubArray(new int[]{5, -3}), 5);
    }

    @Test
    public void testMaxSubArray_zeroInMiddle() {
        assertEquals(solution.maxSubArray(new int[]{3, 0, 4}), 7);
    }
}
