package org.example.arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JumpGameTest {

    private final JumpGame solution = new JumpGame();

    @Test
    public void testCanJump_example1() {
        assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void testCanJump_example2() {
        assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void testCanJump_singleElement() {
        // already at the last index
        assertTrue(solution.canJump(new int[]{0}));
    }

    @Test
    public void testCanJump_twoElements_canReach() {
        assertTrue(solution.canJump(new int[]{1, 0}));
    }

    @Test
    public void testCanJump_twoElements_stuckAtStart() {
        // value 0 at start, can't move
        assertFalse(solution.canJump(new int[]{0, 1}));
    }

    @Test
    public void testCanJump_largeJumpFromStart() {
        // single jump clears all zeros
        assertTrue(solution.canJump(new int[]{5, 0, 0, 0, 0, 0}));
    }

    @Test
    public void testCanJump_jumpLandExactlyOnLastIndex() {
        assertTrue(solution.canJump(new int[]{2, 0, 0}));
    }

    @Test
    public void testCanJump_stepByStep() {
        assertTrue(solution.canJump(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void testCanJump_zeroBlocksPath() {
        // can reach index 1 but its value is 0, can't proceed
        assertFalse(solution.canJump(new int[]{1, 0, 1, 0}));
    }

    @Test
    public void testCanJump_stuckOneShortOfEnd() {
        // reaches index 4 (val 0) but last index is 5
        assertFalse(solution.canJump(new int[]{1, 1, 1, 1, 0, 0}));
    }

    @Test
    public void testCanJump_decreasingValues_blockedByZero() {
        assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 0}));
    }

    @Test
    public void testCanJump_jumpOverZero() {
        // index 0 jumps 2, skipping the 0 at index 1
        assertTrue(solution.canJump(new int[]{2, 0, 1}));
    }

    @Test
    public void testCanJump_allOnes() {
        assertTrue(solution.canJump(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void testCanJump_allZerosExceptFirst() {
        // can only move to index 1, which has value 0 — can't reach end
        assertFalse(solution.canJump(new int[]{1, 0, 0, 0, 0}));
    }
}
