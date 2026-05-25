package org.example.graphs;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.*;

public class PacificAtlanticWaterFlowTest {

    PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();

    @Test
    public void testPacificAtlantic_1() {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> expected = List.of(
                Arrays.asList(0, 4),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4),
                Arrays.asList(2, 2),
                Arrays.asList(3, 0),
                Arrays.asList(3, 1),
                Arrays.asList(4, 0)
        );
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        assertEquals(new HashSet<>(result), new HashSet<>(expected), "expected: " + expected + "\nactual: " + result);
    }

    @Test
    public void testPacificAtlantic_singleCell() {
        List<List<Integer>> expected = List.of(Arrays.asList(0, 0));
        List<List<Integer>> result = solution.pacificAtlantic(new int[][]{{1}});
        assertEquals(result, expected, "expected: " + expected + "\nactual: " + result);
    }

    @Test
    public void testPacificAtlantic_2x2() {
        int[][] heights = {{1, 2}, {3, 4}};
        List<List<Integer>> expected = List.of(
                Arrays.asList(0, 1),
                Arrays.asList(1, 0),
                Arrays.asList(1, 1)
        );
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        assertEquals(new HashSet<>(result), new HashSet<>(expected), "actual: " + result);
    }

    @Test
    public void testPacificAtlantic_allEqual() {
        int[][] heights = {{5, 5}, {5, 5}};
        List<List<Integer>> expected = List.of(
                Arrays.asList(0, 0),
                Arrays.asList(0, 1),
                Arrays.asList(1, 0),
                Arrays.asList(1, 1)
        );
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        assertEquals(new HashSet<>(result), new HashSet<>(expected), "actual: " + result);
    }

    @Test
    public void testPacificAtlantic_increasing3x3() {
        int[][] heights = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<List<Integer>> expected = List.of(
                Arrays.asList(0, 2),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(2, 1),
                Arrays.asList(2, 2)
        );
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        assertEquals(new HashSet<>(result), new HashSet<>(expected), "actual: " + result);
    }

    @Test
    public void testPacificAtlantic_isolatedCenter() {
        int[][] heights = {{10, 10, 10}, {10, 1, 10}, {10, 10, 10}};
        List<List<Integer>> expected = List.of(
                Arrays.asList(0, 0), Arrays.asList(0, 1), Arrays.asList(0, 2),
                Arrays.asList(1, 0), Arrays.asList(1, 2),
                Arrays.asList(2, 0), Arrays.asList(2, 1), Arrays.asList(2, 2)
        );
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        assertEquals(new HashSet<>(result), new HashSet<>(expected), "actual: " + result);
    }
}
