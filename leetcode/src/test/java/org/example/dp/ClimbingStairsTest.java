package org.example.dp;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ClimbingStairsTest {

    private final ClimbingStairs solution = new ClimbingStairs();

    @Test
    public void testClimbStairs_n1() {
        assertEquals(solution.climbStairs(1), 1);
    }

    @Test
    public void testClimbStairs_example1() {
        assertEquals(solution.climbStairs(2), 2);
    }

    @Test
    public void testClimbStairs_example2() {
        assertEquals(solution.climbStairs(3), 3);
    }

    @Test
    public void testClimbStairs_n4() {
        assertEquals(solution.climbStairs(4), 5);
    }

    @Test
    public void testClimbStairs_n5() {
        assertEquals(solution.climbStairs(5), 8);
    }

    @Test
    public void testClimbStairs_recurrenceProperty() {
        for (int n = 3; n <= 10; n++) {
            assertEquals(solution.climbStairs(n),
                    solution.climbStairs(n - 1) + solution.climbStairs(n - 2));
        }
    }

    @Test
    public void testClimbStairs_n10() {
        assertEquals(solution.climbStairs(10), 89);
    }

    @Test
    public void testClimbStairs_maxValue() {
        assertEquals(solution.climbStairs(45), 1836311903);
    }
}
