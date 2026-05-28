package org.example.graphs;

import java.util.ArrayList;
import java.util.List;

/// [207. Course Schedule](https://leetcode.com/problems/course-schedule/description/?envType=problem-list-v2&envId=oizxjoit)
/// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,bi] indicates that you must take course bi first if you want to take course ai.
///
/// For example, the pair [0,1], indicates that to take course 0 you have to first take course 1.
/// Return true if you can finish all courses. Otherwise, return false.
///
/// Example 1:
/// Input: numCourses = 2, prerequisites = [[1,0]]
/// Output: true
/// Explanation: There are a total of 2 courses to take.
/// To take course 1 you should have finished course 0. So it is possible.
///
/// Example 2:
/// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
/// Output: false
/// Explanation: There are a total of 2 courses to take.
/// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
///
/// Constraints:
/// 1 <= numCourses <= 2000
/// 0 <= prerequisites.length <= 5000
/// prerequisites[i].length == 2
/// 0 <= ai, bi < numCourses
/// All the pairs prerequisites[i] are unique.
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[numCourses];
        boolean[] visPath = new boolean[numCourses];

        for (int i = 1; i <= numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] ints : prerequisites) {
            int a = ints[0], b = ints[1];
            adj.get(b).add(a);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (!dfs(i, vis, visPath, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int i, boolean[] vis, boolean[] visPath, List<List<Integer>> adj) {
        vis[i] = true;
        visPath[i] = true;

        for (int ele : adj.get(i)) {
            if (visPath[ele]) {
                return false;
            }
            if (!vis[ele]) {
                if (!dfs(ele, vis, visPath, adj)) {
                    return false;
                }
            }
        }
        visPath[i] = false;
        return true;
    }
}
