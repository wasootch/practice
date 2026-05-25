package org.example.binarysearch;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FindMinInRotatedSortedArrayTest {

    FindMinInRotatedSortedArray solution = new FindMinInRotatedSortedArray();

    @Test
    public void testFindMin_1() {
        assertEquals(solution.findMin(new int[]{3, 4, 5, 1, 2}), 1);
    }

    @Test
    public void testFindMin_2() {
        assertEquals(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}), 0);
    }

    @Test
    public void testFindMin_3() {
        assertEquals(solution.findMin(new int[]{11, 13, 15, 17}), 11);
    }

    @Test
    public void testFindMin_singleElement() {
        assertEquals(solution.findMin(new int[]{1}), 1);
    }

    @Test
    public void testFindMin_twoElements_rotated() {
        assertEquals(solution.findMin(new int[]{2, 1}), 1);
    }

    @Test
    public void testFindMin_minAtEnd() {
        assertEquals(solution.findMin(new int[]{2, 3, 4, 5, 1}), 1);
    }

    @Test
    public void testFindMin_minAtStart() {
        assertEquals(solution.findMin(new int[]{1, 2, 3, 4, 5}), 1);
    }

    @Test
    public void testFindMin_largeArray_rotatedAtQuarter() {
        int n = 1_000_000, k = n / 4;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = (k + i) % n;
        assertEquals(solution.findMin(nums), 0);
    }

    @Test
    public void testFindMin_largeArray_rotatedAtThreeQuarters() {
        int n = 1_000_000, k = (3 * n) / 4;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = (k + i) % n;
        assertEquals(solution.findMin(nums), 0);
    }

    @Test
    public void testFindMin_largeArray_rotatedAtMiddle() {
        int n = 1_000_000, k = n / 2;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = (k + i) % n;
        assertEquals(solution.findMin(nums), 0);
    }

    @Test(timeOut = 150)
    public void testFindMin_performance() {
        int n = 10_000_000, k = n / 3;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = (k + i) % n;
        assertEquals(solution.findMin(nums), 0);
    }
}
