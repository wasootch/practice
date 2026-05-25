package org.example.dp;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestIncreasingSequenceTest {

    private final LongestIncreasingSequence solution = new LongestIncreasingSequence();

    @Test
    public void testLengthOfLIS_example1() {
        assertEquals(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}), 4);
    }

    @Test
    public void testLengthOfLIS_example2() {
        assertEquals(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}), 4);
    }

    @Test
    public void testLengthOfLIS_allSame() {
        assertEquals(solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}), 1);
    }

    @Test
    public void testLengthOfLIS_singleElement() {
        assertEquals(solution.lengthOfLIS(new int[]{5}), 1);
    }

    @Test
    public void testLengthOfLIS_strictlyIncreasing() {
        assertEquals(solution.lengthOfLIS(new int[]{1, 2, 3, 4, 5}), 5);
    }

    @Test
    public void testLengthOfLIS_strictlyDecreasing() {
        assertEquals(solution.lengthOfLIS(new int[]{5, 4, 3, 2, 1}), 1);
    }

    @Test
    public void testLengthOfLIS_twoElements_increasing() {
        assertEquals(solution.lengthOfLIS(new int[]{1, 2}), 2);
    }

    @Test
    public void testLengthOfLIS_twoElements_equal() {
        assertEquals(solution.lengthOfLIS(new int[]{3, 3}), 1);
    }

    @Test
    public void testLengthOfLIS_twoElements_decreasing() {
        assertEquals(solution.lengthOfLIS(new int[]{2, 1}), 1);
    }

    @Test
    public void testLengthOfLIS_negativeNumbers() {
        assertEquals(solution.lengthOfLIS(new int[]{-3, -2, -1, 0, 1}), 5);
    }

    @Test
    public void testLengthOfLIS_mixedNegativeAndPositive() {
        assertEquals(solution.lengthOfLIS(new int[]{-1, 3, -2, 4}), 3);
    }
}
