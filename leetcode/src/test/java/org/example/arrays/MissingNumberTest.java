package org.example.arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MissingNumberTest {
    MissingNumber missingNumber = new MissingNumber();

    @Test
    public void testMissingNumber_First() {
        assertEquals(missingNumber.missingNumber(new int[]{3, 0, 1}), 2);
    }

    @Test
    public void testMissingNumber_Second() {
        assertEquals(missingNumber.missingNumber(new int[]{0, 1}), 2);
    }

    @Test
    public void testMissingNumber_Third() {
        assertEquals(missingNumber.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}), 8);
    }
}
