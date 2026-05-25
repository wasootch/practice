package org.example.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class TwoSumTest {

    private final TwoSum solution = new TwoSum();

    private void assertResult(int[] actual, int[] expected) {
        Arrays.sort(actual);
        Arrays.sort(expected);
        assertEquals(actual, expected,
                "expected: " + Arrays.toString(expected) + "\nactual: " + Arrays.toString(actual));
    }

    @Test
    public void testTwoSum_example1() {
        assertResult(solution.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
    }

    @Test
    public void testTwoSum_example2() {
        assertResult(solution.twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
    }

    @Test
    public void testTwoSum_example3() {
        assertResult(solution.twoSum(new int[]{3, 3}, 6), new int[]{0, 1});
    }

    @Test
    public void testTwoSum_twoElements() {
        assertResult(solution.twoSum(new int[]{1, 2}, 3), new int[]{0, 1});
    }

    @Test
    public void testTwoSum_answerAtEnd() {
        assertResult(solution.twoSum(new int[]{1, 2, 3, 4}, 7), new int[]{2, 3});
    }

    @Test
    public void testTwoSum_firstAndLastElements() {
        assertResult(solution.twoSum(new int[]{4, 1, 2, 3}, 7), new int[]{0, 3});
    }

    @Test
    public void testTwoSum_negativeNumbers() {
        assertResult(solution.twoSum(new int[]{-3, 4, 3, 90}, 0), new int[]{0, 2});
    }

    @Test
    public void testTwoSum_negativeTarget() {
        assertResult(solution.twoSum(new int[]{-2, -7, 11, 15}, -9), new int[]{0, 1});
    }

    @Test
    public void testTwoSum_zeroTarget() {
        assertResult(solution.twoSum(new int[]{0, 4, 3, 0}, 0), new int[]{0, 3});
    }

    @Test
    public void testTwoSum_largeValues() {
        assertResult(solution.twoSum(new int[]{-1000000000, 999999999, 1000000000}, 0), new int[]{0, 2});
    }

    @Test
    public void testTwoSum_skipNonMatchingPairs() {
        assertResult(solution.twoSum(new int[]{5, 3, 1, 2, 4}, 6), new int[]{0, 2});
    }

    @Test
    public void testTwoSum_negativeAndPositive() {
        assertResult(solution.twoSum(new int[]{-1, 5, 3, 2}, 4), new int[]{0, 1});
    }
}
