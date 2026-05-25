package org.example.backtracking;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class CombinationSumTest {

    private static CombinationSum combinationSum = new CombinationSum();

    @Test
    public void testCombinationSum_1() {
        List<List<Integer>> results = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        assertEquals(results.size(), 2, "actual: " + results);
        assertTrue(results.contains(Arrays.asList(2, 2, 3)), "actual: " + results);
        assertTrue(results.contains(Arrays.asList(7)), "actual: " + results);
    }

    @Test
    public void testCombinationSum_2() {
        List<List<Integer>> results = combinationSum.combinationSum(new int[]{2, 3, 5}, 8);
        assertEquals(results.size(), 3, "actual: " + results);
        assertTrue(results.contains(Arrays.asList(2, 2, 2, 2)), "actual: " + results);
        assertTrue(results.contains(Arrays.asList(2, 3, 3)), "actual: " + results);
        assertTrue(results.contains(Arrays.asList(3, 5)), "actual: " + results);
    }

    @Test
    public void testCombinationSum_3_noSolution() {
        List<List<Integer>> results = combinationSum.combinationSum(new int[]{2}, 1);
        assertEquals(results.size(), 0, "actual: " + results);
    }

    @Test
    public void testCombinationSum_singleCandidate() {
        List<List<Integer>> results = combinationSum.combinationSum(new int[]{3}, 9);
        assertEquals(results.size(), 1, "actual: " + results);
        assertTrue(results.contains(Arrays.asList(3, 3, 3)), "actual: " + results);
    }

    @Test
    public void testCombinationSum_targetIsCandidate() {
        List<List<Integer>> results = combinationSum.combinationSum(new int[]{5, 10}, 10);
        assertEquals(results.size(), 2, "actual: " + results);
        assertTrue(results.contains(Arrays.asList(5, 5)), "actual: " + results);
        assertTrue(results.contains(Arrays.asList(10)), "actual: " + results);
    }

    @Test
    public void testCombinationSum_ReverseOrder() {
        List<List<Integer>> results = combinationSum.combinationSum(new int[]{8, 7, 4, 3}, 11);
        assertEquals(results.size(), 3, "actual: " + results);
        assertTrue(results.contains(Arrays.asList(3, 4, 4)), "actual: " + results);
        assertTrue(results.contains(Arrays.asList(3, 8)), "actual: " + results);
        assertTrue(results.contains(Arrays.asList(4, 7)), "actual: " + results);
    }
}
