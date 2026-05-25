package org.example.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ThreeSumTest {

    private static ThreeSum threeSum = new ThreeSum();

    @Test
    public void testThreeSum_1() {
        List<List<Integer>> results = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(results.size(), 2, "actual: " + results);
        assertTrue(results.contains(Arrays.asList(-1, -1, 2)), "actual: " + results);
        assertTrue(results.contains(Arrays.asList(-1, 0, 1)), "actual: " + results);
    }

    @Test
    public void testThreeSum_2() {
        List<List<Integer>> results = threeSum.threeSum(new int[]{0, 1, 1});
        assertEquals(results.size(), 0, "actual: " + results);
    }

    @Test
    public void testThreeSum_3() {
        List<List<Integer>> results = threeSum.threeSum(new int[]{0, 0, 0});
        assertEquals(results.size(), 1, "actual: " + results);
        assertEquals(results.get(0), Arrays.asList(0, 0, 0), "actual: " + results);
    }

    @Test
    public void testThreeSum_Zeros() {
        List<List<Integer>> results = threeSum.threeSum(new int[]{0, 0, 0, 0});
        assertEquals(results.size(), 1, "actual: " + results);
        assertEquals(results.get(0), Arrays.asList(0, 0, 0), "actual: " + results);
    }
}
