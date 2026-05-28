package org.example.graphs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CourseScheduleTest {

    private CourseSchedule solution;

    @BeforeMethod
    public void setUp() {
        solution = new CourseSchedule();
    }

    @Test
    public void testExample1_noCycle_returnsTrue() {
        assertTrue(solution.canFinish(2, new int[][]{{1, 0}}));
    }

    @Test
    public void testExample2_directCycle_returnsFalse() {
        assertFalse(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    public void testNoPrerequisites_returnsTrue() {
        assertTrue(solution.canFinish(5, new int[][]{}));
    }

    @Test
    public void testSingleCourse_returnsTrue() {
        assertTrue(solution.canFinish(1, new int[][]{}));
    }

    @Test
    public void testLongerCycle_returnsFalse() {
        // 0 -> 1 -> 2 -> 0
        assertFalse(solution.canFinish(3, new int[][]{{1, 0}, {2, 1}, {0, 2}}));
    }

    @Test
    public void testDiamondDependency_returnsTrue() {
        // 4 is prereq for 1 and 2; 1 and 2 are prereqs for 3 — no cycle
        assertTrue(solution.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
    }

}