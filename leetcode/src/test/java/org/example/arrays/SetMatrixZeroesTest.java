package org.example.arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SetMatrixZeroesTest {

    private final SetMatrixZeroes solution = new SetMatrixZeroes();

    @Test
    public void testSetZeroes_example1() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}});
    }

    @Test
    public void testSetZeroes_example2() {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}});
    }

    @Test
    public void testSetZeroes_noZeroes() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    @Test
    public void testSetZeroes_allZeroes() {
        int[][] matrix = {
                {0, 0},
                {0, 0}
        };
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{0, 0}, {0, 0}});
    }

    @Test
    public void testSetZeroes_singleCell_zero() {
        int[][] matrix = {{0}};
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{0}});
    }

    @Test
    public void testSetZeroes_singleCell_nonZero() {
        int[][] matrix = {{5}};
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{5}});
    }

    @Test
    public void testSetZeroes_zeroInCorner() {
        int[][] matrix = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 1, 1}});
    }

    @Test
    public void testSetZeroes_multipleZeroesDontPropagateEachOther() {
        // Two original zeroes — only their rows/cols should be zeroed, not cells
        // zeroed as a result of those operations
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 1},
                {1, 1, 0}
        };
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 0, 0}});
    }

    @Test
    public void testSetZeroes_singleRow() {
        int[][] matrix = {{1, 0, 3, 4}};
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{0, 0, 0, 0}});
    }

    @Test
    public void testSetZeroes_singleColumn() {
        int[][] matrix = {{1}, {0}, {3}};
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{0}, {0}, {0}});
    }

    @Test
    public void testSetZeroes_negativeValues() {
        int[][] matrix = {
                {-1, -2, 0},
                {3, 4, 5},
                {6, 7, 8}
        };
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{0, 0, 0}, {3, 4, 0}, {6, 7, 0}});
    }


    @Test
    public void testSetZeroes_LoneValue() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {0, 10, 11, 12},
                {13, 14, 15, 0}
        };
        solution.setZeroes(matrix);
        assertEquals(matrix, new int[][]{{0, 0, 3, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
    }
}
