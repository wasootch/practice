package org.example.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

///
/// [57. Insert Interval](https://leetcode.com/problems/insert-interval/description/?envType=problem-list-v2&envId=oizxjoit)
/// Medium
/// Topics
/// premium lock icon
/// Companies
/// Hint
/// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti,endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start,end] that represents the start and end of another interval.
///
/// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
///
/// Return intervals after the insertion.
///
/// Note that you don't need to modify intervals in-place. You can make a new array and return it.
///
///
///
/// Example 1:
///
/// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
/// Output: [[1,5],[6,9]]
/// Example 2:
///
/// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
/// Output: [[1,2],[3,10],[12,16]]
/// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
///
///
/// Constraints:
///
/// 0 <= intervals.length <= 104
/// intervals[i].length == 2
/// 0 <= starti <= endi <= 105
/// intervals is sorted by starti in ascending order.
/// newInterval.length == 2
/// 0 <= start <= end <= 105
///
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] merged = new int[intervals.length + 1][0];
        for (int i = 0; i < intervals.length; i++) {
            merged[i] = intervals[i];
        }
        merged[intervals.length] = newInterval;

        Arrays.sort(merged, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> temp = new ArrayList<>();
        int[] tmp = new int[]{merged[0][0], merged[0][1]};
        temp.add(tmp);
        for (int i = 0; i < merged.length; i++) {
            if (merged[i][0] <= tmp[1]) {
                tmp[1] = Math.max(tmp[1], merged[i][1]);
            } else {
                tmp = new int[]{merged[i][0], merged[i][1]};
                temp.add(tmp);
            }
        }

        return temp.toArray(new int[0][0]);
    }
}
