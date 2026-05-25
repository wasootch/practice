package org.example.arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContainsDuplicateTest {

    private final ContainsDuplicate solution = new ContainsDuplicate();

    @Test
    public void testContainsDuplicate_example1() {
        assertTrue(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void testContainsDuplicate_example2() {
        assertFalse(solution.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testContainsDuplicate_example3() {
        assertTrue(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    public void testContainsDuplicate_singleElement() {
        assertFalse(solution.containsDuplicate(new int[]{42}));
    }

    @Test
    public void testContainsDuplicate_twoSameElements() {
        assertTrue(solution.containsDuplicate(new int[]{5, 5}));
    }

    @Test
    public void testContainsDuplicate_twoDistinctElements() {
        assertFalse(solution.containsDuplicate(new int[]{1, 2}));
    }

    @Test
    public void testContainsDuplicate_duplicateAtEnd() {
        assertTrue(solution.containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1}));
    }

    @Test
    public void testContainsDuplicate_allSame() {
        assertTrue(solution.containsDuplicate(new int[]{3, 3, 3, 3}));
    }

    @Test
    public void testContainsDuplicate_negativeValues() {
        assertFalse(solution.containsDuplicate(new int[]{-1000000000, -999999999, 999999999, 1000000000}));
        assertTrue(solution.containsDuplicate(new int[]{-1000000000, 0, -1000000000}));
    }

    @Test
    public void testContainsDuplicate_mixedSignsDistinct() {
        assertFalse(solution.containsDuplicate(new int[]{-3, -2, -1, 0, 1,2, 3}));
    }

    @Test
    public void testContainsDuplicate_mixedSignsDuplicate() {
        assertTrue(solution.containsDuplicate(new int[]{-3, -2, -1, 0, 1, 2, -3}));
    }
}
