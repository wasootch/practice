package org.example.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class SpiralMatrixTest {

    private final SpiralMatrix solution = new SpiralMatrix();

    private List<Integer> list(Integer... vals) {
        return Arrays.asList(vals);
    }

    @Test
    public void testSpiralOrder_example1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expected = list(1, 2, 3, 6, 9, 8, 7, 4, 5);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_example2() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> expected = list(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_singleElement() {
        List<Integer> expected = list(42);
        List<Integer> actual = solution.spiralOrder(new int[][]{{42}});
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_singleRow() {
        List<Integer> expected = list(1, 2, 3, 4);
        List<Integer> actual = solution.spiralOrder(new int[][]{{1, 2, 3, 4}});
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_singleColumn() {
        List<Integer> expected = list(1, 2, 3, 4);
        List<Integer> actual = solution.spiralOrder(new int[][]{{1}, {2}, {3}, {4}});
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_2x2() {
        int[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> expected = list(1, 2, 4, 3);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_4x4() {
        int[][] matrix = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16}
        };
        List<Integer> expected = list(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_tallMatrix() {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        List<Integer> expected = list(1, 2, 4, 6, 8, 7, 5, 3);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_wideMatrix() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        List<Integer> expected = list(1, 2, 3, 4, 8, 7, 6, 5);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_oneRowTwoCols() {
        List<Integer> expected = list(1, 2);
        List<Integer> actual = solution.spiralOrder(new int[][]{{1, 2}});
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_twoRowsOneCol() {
        List<Integer> expected = list(1, 2);
        List<Integer> actual = solution.spiralOrder(new int[][]{{1}, {2}});
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_negativeValues() {
        int[][] matrix = {{-1, -2}, {-3, -4}};
        List<Integer> expected = list(-1, -2, -4, -3);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_allSameValues() {
        int[][] matrix = {{7, 7, 7}, {7, 7, 7}, {7, 7, 7}};
        List<Integer> expected = list(7, 7, 7, 7, 7, 7, 7, 7, 7);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(actual, expected, "expected: " + expected + "\nactual: " + actual);
    }

    @Test
    public void testSpiralOrder_outputLengthEqualsElementCount() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(solution.spiralOrder(matrix).size(), 9);
    }
}
