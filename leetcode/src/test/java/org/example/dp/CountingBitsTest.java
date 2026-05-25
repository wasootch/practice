package org.example.dp;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class CountingBitsTest {

    private final CountingBits solution = new CountingBits();

    @Test
    public void testCountBits_example1() {
        int[] expected = {0, 1, 1};
        int[] actual = solution.countBits(2);
        assertEquals(actual, expected, "expected: " + Arrays.toString(expected) + "\nactual: " + Arrays.toString(actual));
    }

    @Test
    public void testCountBits_example2() {
        int[] expected = {0, 1, 1, 2, 1, 2};
        int[] actual = solution.countBits(5);
        assertEquals(actual, expected, "expected: " + Arrays.toString(expected) + "\nactual: " + Arrays.toString(actual));
    }

    @Test
    public void testCountBits_zero() {
        int[] expected = {0};
        int[] actual = solution.countBits(0);
        assertEquals(actual, expected, "expected: " + Arrays.toString(expected) + "\nactual: " + Arrays.toString(actual));
    }

    @Test
    public void testCountBits_one() {
        int[] expected = {0, 1};
        int[] actual = solution.countBits(1);
        assertEquals(actual, expected, "expected: " + Arrays.toString(expected) + "\nactual: " + Arrays.toString(actual));
    }

    @Test
    public void testCountBits_outputLength() {
        for (int n : new int[]{0, 1, 5, 10, 100}) {
            assertEquals(solution.countBits(n).length, n + 1);
        }
    }

    @Test
    public void testCountBits_firstElementAlwaysZero() {
        for (int n : new int[]{0, 1, 10, 100}) {
            assertEquals(solution.countBits(n)[0], 0);
        }
    }

    @Test
    public void testCountBits_powersOfTwoHaveOneBit() {
        int[] result = solution.countBits(16);
        assertEquals(result[1], 1);
        assertEquals(result[2], 1);
        assertEquals(result[4], 1);
        assertEquals(result[8], 1);
        assertEquals(result[16], 1);
    }

    @Test
    public void testCountBits_fullThreeBitRange() {
        int[] expected = {0, 1, 1, 2, 1, 2, 2, 3};
        int[] actual = solution.countBits(7);
        assertEquals(actual, expected, "expected: " + Arrays.toString(expected) + "\nactual: " + Arrays.toString(actual));
    }

    @Test
    public void testCountBits_matchesBitCount() {
        int[] result = solution.countBits(100);
        for (int i = 0; i <= 100; i++) {
            assertEquals(result[i], Integer.bitCount(i), "Mismatch at i=" + i);
        }
    }

    @Test
    public void testCountBits_maxInput() {
        int n = 100000;
        int[] result = solution.countBits(n);
        assertEquals(result.length, n + 1);
        assertEquals(result[n], Integer.bitCount(n));
    }
}
