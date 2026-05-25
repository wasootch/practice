package org.example.dp;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CoinChangeTest {

    private final CoinChange solution = new CoinChange();

    @Test
    public void testCoinChange_example1() {
        assertEquals(solution.coinChange(new int[]{1, 2, 5}, 11), 3);
    }

    @Test
    public void testCoinChange_example2() {
        assertEquals(solution.coinChange(new int[]{2}, 3), -1);
    }

    @Test
    public void testCoinChange_example3() {
        assertEquals(solution.coinChange(new int[]{1}, 0), 0);
    }

    @Test
    public void testCoinChange_exactCoin() {
        assertEquals(solution.coinChange(new int[]{5}, 5), 1);
    }

    @Test
    public void testCoinChange_singleCoinMultiple() {
        assertEquals(solution.coinChange(new int[]{5}, 15), 3);
    }

    @Test
    public void testCoinChange_greedyFailsButDpSucceeds() {
        // Greedy would pick 4, leaving 3 (impossible), but 3+3 works
        assertEquals(solution.coinChange(new int[]{1, 3, 4}, 6), 2);
    }

    @Test
    public void testCoinChange_impossible() {
        assertEquals(solution.coinChange(new int[]{3, 5}, 7), -1);
    }

    @Test
    public void testCoinChange_largeAmount() {
        assertEquals(solution.coinChange(new int[]{1, 2, 5}, 100), 20);
    }

    @Test
    public void testCoinChange_amountEqualsOneCoin() {
        assertEquals(solution.coinChange(new int[]{2, 5, 10, 1}, 10), 1);
    }

    @Test
    public void testCoinChange_singleCoinOne() {
        assertEquals(solution.coinChange(new int[]{1}, 10000), 10000);
    }

    @Test
    public void testCoinChange_largeCoins() {
        assertEquals(solution.coinChange(new int[]{474, 83, 404, 3}, 264), 8);
    }
}