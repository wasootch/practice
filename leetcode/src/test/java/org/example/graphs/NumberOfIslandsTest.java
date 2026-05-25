package org.example.graphs;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberOfIslandsTest {

    private final NumberOfIslands solution = new NumberOfIslands();

    @Test
    public void testNumIslands_example1() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        assertEquals(solution.numIslands(grid), 1);
    }

    @Test
    public void testNumIslands_example2() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        assertEquals(solution.numIslands(grid), 3);
    }

    @Test
    public void testNumIslands_allWater() {
        char[][] grid = {
            {'0','0','0'},
            {'0','0','0'},
            {'0','0','0'}
        };
        assertEquals(solution.numIslands(grid), 0);
    }

    @Test
    public void testNumIslands_allLand() {
        char[][] grid = {
            {'1','1','1'},
            {'1','1','1'},
            {'1','1','1'}
        };
        assertEquals(solution.numIslands(grid), 1);
    }

    @Test
    public void testNumIslands_singleCell_land() {
        assertEquals(solution.numIslands(new char[][]{{'1'}}), 1);
    }

    @Test
    public void testNumIslands_singleCell_water() {
        assertEquals(solution.numIslands(new char[][]{{'0'}}), 0);
    }

    @Test
    public void testNumIslands_diagonalIslandsNotConnected() {
        // Diagonal adjacency does not count — each '1' is its own island
        char[][] grid = {
            {'1','0','1'},
            {'0','1','0'},
            {'1','0','1'}
        };
        assertEquals(solution.numIslands(grid), 5);
    }

    @Test
    public void testNumIslands_horizontalStripe() {
        char[][] grid = {
            {'1','1','1','1','1'},
            {'0','0','0','0','0'},
            {'1','1','1','1','1'}
        };
        assertEquals(solution.numIslands(grid), 2);
    }

    @Test
    public void testNumIslands_verticalStripe() {
        char[][] grid = {
            {'1','0','1'},
            {'1','0','1'},
            {'1','0','1'}
        };
        assertEquals(solution.numIslands(grid), 2);
    }

    @Test
    public void testNumIslands_singleRow() {
        char[][] grid = {{'1','0','1','0','1'}};
        assertEquals(solution.numIslands(grid), 3);
    }

    @Test
    public void testNumIslands_singleColumn() {
        char[][] grid = {{'1'},{'0'},{'1'},{'1'},{'0'}};
        assertEquals(solution.numIslands(grid), 2);
    }
}
