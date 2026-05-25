package org.example.arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BestTimeBuySellStockTest {

    private final BestTimeBuySellStock solution = new BestTimeBuySellStock();

    @Test
    public void testMaxProfit_example1() {
        assertEquals(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5, "prices=[7,1,5,3,6,4]");
    }

    @Test
    public void testMaxProfit_example2() {
        assertEquals(solution.maxProfit(new int[]{7, 6, 4, 3, 1}), 0, "prices=[7,6,4,3,1]");
    }

    @Test
    public void testMaxProfit_singleElement() {
        assertEquals(solution.maxProfit(new int[]{5}), 0, "prices=[5]");
    }

    @Test
    public void testMaxProfit_twoElementsProfit() {
        assertEquals(solution.maxProfit(new int[]{1, 10}), 9, "prices=[1,10]");
    }

    @Test
    public void testMaxProfit_twoElementsNoProfit() {
        assertEquals(solution.maxProfit(new int[]{10, 1}), 0, "prices=[10,1]");
    }

    @Test
    public void testMaxProfit_allSamePrice() {
        assertEquals(solution.maxProfit(new int[]{5, 5, 5, 5}), 0, "prices=[5,5,5,5]");
    }

    @Test
    public void testMaxProfit_bestBuyNotFirst() {
        assertEquals(solution.maxProfit(new int[]{10, 2, 8}), 6, "prices=[10,2,8]");
    }

    @Test
    public void testMaxProfit_bestSellAtEnd() {
        assertEquals(solution.maxProfit(new int[]{3, 1, 4, 1, 9}), 8, "prices=[3,1,4,1,9]");
    }

    @Test
    public void testMaxProfit_peakBeforeValley() {
        assertEquals(solution.maxProfit(new int[]{9, 1, 9}), 8, "prices=[9,1,9]");
    }

    @Test
    public void testMaxProfit_dipThenRise() {
        assertEquals(solution.maxProfit(new int[]{5, 10, 1, 20}), 19, "prices=[5,10,1,20]");
    }

    @Test
    public void testMaxProfit_profitOfOne() {
        assertEquals(solution.maxProfit(new int[]{4, 5}), 1, "prices=[4,5]");
    }

    @Test
    public void testMaxProfit_priceOfZero() {
        assertEquals(solution.maxProfit(new int[]{0, 10000}), 10000, "prices=[0,10000]");
    }

    @Test
    public void testMaxProfit_maxConstraintValues() {
        assertEquals(solution.maxProfit(new int[]{0, 10000}), 10000, "prices=[0,10000]");
    }

    @Test
    public void testMaxProfit_peakInMiddle() {
        assertEquals(solution.maxProfit(new int[]{1, 4, 2}), 3, "prices=[1,4,2]");
    }

    @Test
    public void testMaxProfit_earlySpikeThenDipThenRise() {
        assertEquals(solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}), 4, "prices=[3,3,5,0,0,3,1,4]");
    }

    @Test
    public void testMaxProfit_spikeSkipsDip() {
        assertEquals(solution.maxProfit(new int[]{3, 5, 0, 4}), 4, "prices=[3,5,0,4]");
    }

    @Test
    public void testMaxProfit_spikeWithLowerStart() {
        assertEquals(solution.maxProfit(new int[]{2, 5, 0, 4}), 4, "prices=[2,5,0,4]");
    }

    @Test
    public void testMaxProfit_middleSpikeHigherStart() {
        assertEquals(solution.maxProfit(new int[]{2, 4, 1}), 2, "prices=[2,4,1]");
    }
}
