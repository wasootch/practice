package org.example.intervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/// [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/description/?envType=problem-list-v2&envId=oizxjoit)
/// Medium
///
/// Given an array of intervals where intervals[i] = [starti,endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
///
/// Example 1:
/// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
/// Output: [[1,6],[8,10],[15,18]]
/// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
///
/// Example 2:
/// Input: intervals = [[1,4],[4,5]]
/// Output: [[1,5]]
/// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
///
/// Example 3:
/// Input: intervals = [[4,7],[1,4]]
/// Output: [[1,7]]
/// Explanation: Intervals [1,4] and [4,7] are considered overlapping.
///
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> temp = new ArrayList<>();
        int[] tmp = new int[]{intervals[0][0], intervals[0][1]};
        temp.add(tmp);
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= tmp[1]) {
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            } else {
                tmp = new int[]{intervals[i][0], intervals[i][1]};
                temp.add(tmp);
            }
        }

        return temp.toArray(new int[0][0]);
    }
}
