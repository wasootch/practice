package org.example.bits;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberOfOneBitsTest {

    private final NumberOfOneBits solution = new NumberOfOneBits();

    @Test
    public void testHammingWeight_example1() {
        assertEquals(solution.hammingWeight(11), 3);
    }

    @Test
    public void testHammingWeight_example2() {
        assertEquals(solution.hammingWeight(128), 1);
    }

    @Test
    public void testHammingWeight_example3() {
        assertEquals(solution.hammingWeight(2147483645), 30);
    }

    @Test
    public void testHammingWeight_one() {
        assertEquals(solution.hammingWeight(1), 1);
    }

    @Test
    public void testHammingWeight_maxValue() {
        assertEquals(solution.hammingWeight(2147483647), 31);
    }

    @Test
    public void testHammingWeight_powersOfTwo() {
        assertEquals(solution.hammingWeight(2), 1);
        assertEquals(solution.hammingWeight(1024), 1);
        assertEquals(solution.hammingWeight(1073741824), 1);
    }

    @Test
    public void testHammingWeight_alternatingBits() {
        assertEquals(solution.hammingWeight(0x55555555), 16);
    }

    @Test
    public void testHammingWeight_lower16BitsSet() {
        assertEquals(solution.hammingWeight(0x0000FFFF), 16);
    }

    @Test
    public void testHammingWeight_twoBitsSet() {
        assertEquals(solution.hammingWeight(6), 2);
        assertEquals(solution.hammingWeight(12), 2);
    }
}
