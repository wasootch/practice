package org.example.intervals;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NonOverlappingIntervalsTest {

    private final NonOverlappingIntervals solution = new NonOverlappingIntervals();

    @Test
    public void testEraseOverlapIntervals_example1() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}), 1);
    }

    @Test
    public void testEraseOverlapIntervals_example2() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}), 2);
    }

    @Test
    public void testEraseOverlapIntervals_example3() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}), 0);
    }

    @Test
    public void testEraseOverlapIntervals_singleInterval() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 5}}), 0);
    }

    @Test
    public void testEraseOverlapIntervals_noOverlap() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {3, 4}, {5, 6}}), 0);
    }

    @Test
    public void testEraseOverlapIntervals_allIdentical() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{2, 5}, {2, 5}, {2, 5}, {2, 5}}), 3);
    }

    @Test
    public void testEraseOverlapIntervals_allOverlapping() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 10}, {2, 8}, {3, 6}, {4, 5}}), 3);
    }

    @Test
    public void testEraseOverlapIntervals_oneContainsAnother() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 10}, {2, 3}}), 1);
    }

    @Test
    public void testEraseOverlapIntervals_preferEarlierEnd() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}), 2);
    }

    @Test
    public void testEraseOverlapIntervals_reverseOrder() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{3, 4}, {2, 3}, {1, 2}}), 0);
    }

    @Test
    public void testEraseOverlapIntervals_chainTouchingAtPoints() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}), 0);
    }

    @Test
    public void testEraseOverlapIntervals_negativeCoordinates() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{-50000, -1}, {-1, 0}, {0, 50000}}), 0);
    }

    @Test
    public void testEraseOverlapIntervals_negativeCoordinatesWithOverlap() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{-5, 0}, {-3, 2}, {0, 3}}), 1);
    }

    @Test
    public void testEraseOverlapIntervals_twoOverlapping() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 3}, {2, 4}}), 1);
    }

    @Test
    public void testEraseOverlapIntervals_twoNonOverlapping() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {3, 4}}), 0);
    }

    @Test
    public void testEraseOverlapIntervals_oneLongSpanningInterval() {
        assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 10}, {1, 3}, {4, 6}, {7, 9}}), 1);
    }
}
