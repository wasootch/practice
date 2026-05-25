package org.example.bits;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReverseBitsTest {

    private final ReverseBits solution = new ReverseBits();

    @Test
    public void testReverseBits_example1() {
        assertEquals(solution.reverseBits(43261596), 964176192);
    }

    @Test
    public void testReverseBits_example2() {
        assertEquals(solution.reverseBits(2147483644), 1073741822);
    }

    @Test
    public void testReverseBits_zero() {
        assertEquals(solution.reverseBits(0), 0);
    }

    @Test
    public void testReverseBits_minNonZero() {
        assertEquals(solution.reverseBits(2), 1073741824);
    }

    @Test
    public void testReverseBits_singleBitPosition2() {
        assertEquals(solution.reverseBits(4), 536870912);
    }

    @Test
    public void testReverseBits_applyTwiceIsIdentity() {
        int n = 43261596;
        assertEquals(solution.reverseBits(solution.reverseBits(n)), n);
    }

    @Test
    public void testReverseBits_symmetricPair() {
        assertEquals(solution.reverseBits(1073741824), 2);
    }

    @Test
    public void testReverseBits_palindromeBits() {
        assertEquals(solution.reverseBits(2147483646), 2147483646);
    }

    @Test
    public void testReverseBits_lowBitsSet() {
        assertEquals(solution.reverseBits(65534), 2147418112);
    }
}
