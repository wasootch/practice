package org.example.dp;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HouseRobberTest {

    private final HouseRobber solution = new HouseRobber();

    @Test
    public void testRob_example1() {
        assertEquals(solution.rob(new int[]{1, 2, 3, 1}), 4);
    }

    @Test
    public void testRob_example2() {
        assertEquals(solution.rob(new int[]{2, 7, 9, 3, 1}), 12);
    }

    @Test
    public void testRob_singleHouse() {
        assertEquals(solution.rob(new int[]{5}), 5);
    }

    @Test
    public void testRob_twoHouses_takeLarger() {
        assertEquals(solution.rob(new int[]{3, 10}), 10);
    }

    @Test
    public void testRob_twoHouses_equal() {
        assertEquals(solution.rob(new int[]{5, 5}), 5);
    }

    @Test
    public void testRob_allZeros() {
        assertEquals(solution.rob(new int[]{0, 0, 0, 0}), 0);
    }

    @Test
    public void testRob_increasingValues() {
        // Best: skip 1, take 2, skip 3, take 4 → 2+4=6; or take 1+3+5=9; or take 1+4=5
        // [1,2,3,4,5] → best is 1+3+5=9
        assertEquals(solution.rob(new int[]{1, 2, 3, 4, 5}), 9);
    }

    @Test
    public void testRob_skipMiddleIsBetter() {
        // [2, 1, 1, 2] → rob house 0 and 3: 2+2=4
        assertEquals(solution.rob(new int[]{2, 1, 1, 2}), 4);
    }

    @Test
    public void testRob_maxConstraints() {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) nums[i] = 400;
        // Every other house: 50 houses * 400 = 20000
        assertEquals(solution.rob(nums), 20000);
    }
}