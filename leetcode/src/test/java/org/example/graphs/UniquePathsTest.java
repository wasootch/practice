package org.example.graphs;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UniquePathsTest {

    private final UniquePaths solution = new UniquePaths();

    @Test
    public void testUniquePaths_example1() {
        assertEquals(solution.uniquePaths(3, 7), 28);
    }

    @Test
    public void testUniquePaths_example2() {
        assertEquals(solution.uniquePaths(3, 2), 3);
    }

    @Test
    public void testUniquePaths_singleCell() {
        // already at destination
        assertEquals(solution.uniquePaths(1, 1), 1);
    }

    @Test
    public void testUniquePaths_singleRow() {
        // can only move right — exactly one path
        assertEquals(solution.uniquePaths(1, 7), 1);
        assertEquals(solution.uniquePaths(1, 100), 1);
    }

    @Test
    public void testUniquePaths_singleColumn() {
        // can only move down — exactly one path
        assertEquals(solution.uniquePaths(7, 1), 1);
        assertEquals(solution.uniquePaths(100, 1), 1);
    }

    @Test
    public void testUniquePaths_twoRows() {
        // 2×n grid: must make exactly 1 down move among (n-1) right moves = n choices
        assertEquals(solution.uniquePaths(2, 2), 2);
        assertEquals(solution.uniquePaths(2, 5), 5);
        assertEquals(solution.uniquePaths(2, 10), 10);
    }

    @Test
    public void testUniquePaths_twoColumns() {
        // symmetric to two-row case
        assertEquals(solution.uniquePaths(2, 2), 2);
        assertEquals(solution.uniquePaths(5, 2), 5);
        assertEquals(solution.uniquePaths(10, 2), 10);
    }

    @Test
    public void testUniquePaths_squareGrid() {
        assertEquals(solution.uniquePaths(3, 3), 6);
        assertEquals(solution.uniquePaths(4, 4), 20);
        assertEquals(solution.uniquePaths(10, 10), 48620);
    }

    @Test
    public void testUniquePaths_symmetry() {
        // uniquePaths(m, n) == uniquePaths(n, m)
        assertEquals(solution.uniquePaths(3, 7), solution.uniquePaths(7, 3));
        assertEquals(solution.uniquePaths(4, 9), solution.uniquePaths(9, 4));
        assertEquals(solution.uniquePaths(5, 10), solution.uniquePaths(10, 5));
    }

    @Test
    public void testUniquePaths_recurrence() {
        // uniquePaths(m, n) == uniquePaths(m-1, n) + uniquePaths(m, n-1)
        for (int m = 2; m <= 6; m++) {
            for (int n = 2; n <= 6; n++) {
                assertEquals(solution.uniquePaths(m, n),
                        solution.uniquePaths(m - 1, n) + solution.uniquePaths(m, n - 1),
                        "Recurrence failed for m=" + m + ", n=" + n);
            }
        }
    }
}
