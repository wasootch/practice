package org.example.binarysearch;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchInRotatedArrayTest {

    SearchInRotatedArray solution = new SearchInRotatedArray();

    @Test
    public void testSearch_1() {
        assertEquals(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0), 4);
    }

    @Test
    public void testSearch_2() {
        assertEquals(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), -1);
    }

    @Test
    public void testSearch_3() {
        assertEquals(solution.search(new int[]{1}, 0), -1);
    }

    @Test
    public void testSearch_singleElement_found() {
        assertEquals(solution.search(new int[]{1}, 1), 0);
    }

    @Test
    public void testSearch_targetAtStart() {
        assertEquals(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4), 0);
    }

    @Test
    public void testSearch_targetAtEnd() {
        assertEquals(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2), 6);
    }

    @Test
    public void testSearch_noRotation() {
        assertEquals(solution.search(new int[]{1, 2, 3, 4, 5}, 3), 2);
    }

    @Test
    public void testSearch_noRotation_notFound() {
        assertEquals(solution.search(new int[]{1, 2, 3, 4, 5}, 6), -1);
    }

    @Test
    public void testSearch_targetAtPivot() {
        assertEquals(solution.search(new int[]{6, 7, 8, 1, 2, 3, 4, 5}, 1), 3);
    }

    @Test(timeOut = 150)
    public void testSearch_performance() {
        int n = 10_000_000, k = n / 3;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = (k + i) % n;
        assertEquals(solution.search(nums, 0), n - k);
    }
}
