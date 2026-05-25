package org.example.arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RotateImageTest {

    private final RotateImage solution = new RotateImage();

    @Test
    public void testRotate_example1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        assertEquals(matrix, new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});
    }

    @Test
    public void testRotate_example2() {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution.rotate(matrix);
        assertEquals(matrix, new int[][]{{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}});
    }

    @Test
    public void testRotate_singleElement() {
        int[][] matrix = {{42}};
        solution.rotate(matrix);
        assertEquals(matrix, new int[][]{{42}});
    }

    @Test
    public void testRotate_2x2() {
        int[][] matrix = {{1, 2}, {3, 4}};
        solution.rotate(matrix);
        assertEquals(matrix, new int[][]{{3, 1}, {4, 2}});
    }

    @Test
    public void testRotate_fourRotationsIsIdentity() {
        int[][] original = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix   = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < 4; i++) solution.rotate(matrix);
        assertEquals(matrix, original);
    }

    @Test
    public void testRotate_negativeValues() {
        int[][] matrix = {{-1, -2}, {-3, -4}};
        solution.rotate(matrix);
        assertEquals(matrix, new int[][]{{-3, -1}, {-4, -2}});
    }

    @Test
    public void testRotate_allSameValues() {
        int[][] matrix = {{7, 7, 7}, {7, 7, 7}, {7, 7, 7}};
        solution.rotate(matrix);
        assertEquals(matrix, new int[][]{{7, 7, 7}, {7, 7, 7}, {7, 7, 7}});
    }
}
