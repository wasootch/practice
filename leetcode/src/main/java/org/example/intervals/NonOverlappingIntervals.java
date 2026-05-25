package org.example.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });

        int prev = intervals[0][1];
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (prev > intervals[i][0]) {
                result++;
            } else {
                prev = intervals[i][1];
            }
        }
        return result;
    }
}
