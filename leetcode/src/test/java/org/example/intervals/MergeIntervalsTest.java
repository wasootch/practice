package org.example.intervals;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class MergeIntervalsTest {

    private final MergeIntervals solution = new MergeIntervals();

    private void assertIntervals(int[][] actual, int[][] expected) {
        assertTrue(Arrays.deepEquals(actual, expected),
                "expected: " + Arrays.deepToString(expected) + "\nactual:   " + Arrays.deepToString(actual));
    }

    @Test
    public void testMerge_example1() {
        assertIntervals(
                solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}),
                new int[][]{{1, 6}, {8, 10}, {15, 18}}
        );
    }

    @Test
    public void testMerge_example2_touchingEndpoints() {
        // [1,4] and [4,5] share endpoint 4 — merge into [1,5]
        assertIntervals(
                solution.merge(new int[][]{{1, 4}, {4, 5}}),
                new int[][]{{1, 5}}
        );
    }

    @Test
    public void testMerge_example3_unsortedInput() {
        // input is out of order; must still merge [1,4] and [4,7]
        assertIntervals(
                solution.merge(new int[][]{{4, 7}, {1, 4}}),
                new int[][]{{1, 7}}
        );
    }

    @Test
    public void testMerge_singleInterval() {
        assertIntervals(
                solution.merge(new int[][]{{2, 6}}),
                new int[][]{{2, 6}}
        );
    }

    @Test
    public void testMerge_allDisjoint() {
        assertIntervals(
                solution.merge(new int[][]{{1, 2}, {3, 4}, {5, 6}}),
                new int[][]{{1, 2}, {3, 4}, {5, 6}}
        );
    }

    @Test
    public void testMerge_allMergeIntoOne() {
        assertIntervals(
                solution.merge(new int[][]{{1, 4}, {2, 5}, {3, 6}}),
                new int[][]{{1, 6}}
        );
    }

    @Test
    public void testMerge_oneContainsAnother() {
        // [1,10] fully swallows [2,5]
        assertIntervals(
                solution.merge(new int[][]{{1, 10}, {2, 5}}),
                new int[][]{{1, 10}}
        );
    }

    @Test
    public void testMerge_containedIntervalLastInInput() {
        assertIntervals(
                solution.merge(new int[][]{{2, 5}, {1, 10}}),
                new int[][]{{1, 10}}
        );
    }

    @Test
    public void testMerge_gapBetweenIntervals() {
        // gap of 1 between [1,2] and [4,5] — no merge
        assertIntervals(
                solution.merge(new int[][]{{1, 2}, {4, 5}}),
                new int[][]{{1, 2}, {4, 5}}
        );
    }

    @Test
    public void testMerge_chainMerge() {
        // [1,3] + [2,4] + [3,5] chain into [1,5]
        assertIntervals(
                solution.merge(new int[][]{{1, 3}, {2, 4}, {3, 5}}),
                new int[][]{{1, 5}}
        );
    }

    @Test
    public void testMerge_zeroValueIntervals() {
        assertIntervals(
                solution.merge(new int[][]{{0, 0}, {0, 1}}),
                new int[][]{{0, 1}}
        );
    }

    @Test
    public void testMerge_pointIntervals() {
        // single-point intervals [2,2] and [3,3] are disjoint; [2,2] and [2,2] merge
        assertIntervals(
                solution.merge(new int[][]{{2, 2}, {2, 2}, {3, 3}}),
                new int[][]{{2, 2}, {3, 3}}
        );
    }
}
