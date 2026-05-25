package org.example.intervals;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class InsertIntervalTest {

    private final InsertInterval solution = new InsertInterval();

    private void assertIntervals(int[][] actual, int[][] expected) {
        assertTrue(Arrays.deepEquals(actual, expected),
                "expected: " + Arrays.deepToString(expected) + "\nactual:   " + Arrays.deepToString(actual));
    }

    @Test
    public void testInsert_example1() {
        assertIntervals(
                solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}),
                new int[][]{{1, 5}, {6, 9}}
        );
    }

    @Test
    public void testInsert_example2_mergesMultiple() {
        assertIntervals(
                solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}),
                new int[][]{{1, 2}, {3, 10}, {12, 16}}
        );
    }

    @Test
    public void testInsert_emptyIntervals() {
        assertIntervals(
                solution.insert(new int[][]{}, new int[]{5, 7}),
                new int[][]{{5, 7}}
        );
    }

    @Test
    public void testInsert_noOverlap_insertBefore() {
        assertIntervals(
                solution.insert(new int[][]{{3, 5}, {6, 9}}, new int[]{1, 2}),
                new int[][]{{1, 2}, {3, 5}, {6, 9}}
        );
    }

    @Test
    public void testInsert_noOverlap_insertAfter() {
        assertIntervals(
                solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{10, 12}),
                new int[][]{{1, 3}, {6, 9}, {10, 12}}
        );
    }

    @Test
    public void testInsert_noOverlap_insertInMiddle() {
        assertIntervals(
                solution.insert(new int[][]{{1, 2}, {8, 10}}, new int[]{4, 6}),
                new int[][]{{1, 2}, {4, 6}, {8, 10}}
        );
    }

    @Test
    public void testInsert_newIntervalContainsAll() {
        // new interval swallows every existing interval
        assertIntervals(
                solution.insert(new int[][]{{2, 3}, {5, 6}}, new int[]{1, 7}),
                new int[][]{{1, 7}}
        );
    }

    @Test
    public void testInsert_existingContainsNewInterval() {
        // new interval is fully inside an existing one — no change
        assertIntervals(
                solution.insert(new int[][]{{1, 10}}, new int[]{2, 5}),
                new int[][]{{1, 10}}
        );
    }

    @Test
    public void testInsert_touchingEndpoint_merges() {
        // [1,5] and [5,7] share endpoint 5 — treated as overlapping
        assertIntervals(
                solution.insert(new int[][]{{1, 5}}, new int[]{5, 7}),
                new int[][]{{1, 7}}
        );
    }

    @Test
    public void testInsert_touchingBothNeighbours() {
        // [5,6] touches [1,5] and [6,9] — bridges them into one
        assertIntervals(
                solution.insert(new int[][]{{1, 5}, {6, 9}}, new int[]{5, 6}),
                new int[][]{{1, 9}}
        );
    }

    @Test
    public void testInsert_singleExistingInterval_noOverlap_before() {
        assertIntervals(
                solution.insert(new int[][]{{5, 7}}, new int[]{1, 3}),
                new int[][]{{1, 3}, {5, 7}}
        );
    }

    @Test
    public void testInsert_singleExistingInterval_noOverlap_after() {
        assertIntervals(
                solution.insert(new int[][]{{1, 3}}, new int[]{5, 7}),
                new int[][]{{1, 3}, {5, 7}}
        );
    }

    @Test
    public void testInsert_pointInterval_overlapping() {
        // [3,3] is a point inside [1,5]
        assertIntervals(
                solution.insert(new int[][]{{1, 5}}, new int[]{3, 3}),
                new int[][]{{1, 5}}
        );
    }

    @Test
    public void testInsert_pointInterval_nonOverlapping() {
        // [3,3] sits in the gap between [1,2] and [4,5]
        assertIntervals(
                solution.insert(new int[][]{{1, 2}, {4, 5}}, new int[]{3, 3}),
                new int[][]{{1, 2}, {3, 3}, {4, 5}}
        );
    }
}
