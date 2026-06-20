package org.example.dp;

import java.util.ArrayList;
import java.util.List;

///
/// 300. Longest Increasing Subsequence
/// Medium
///
/// Given an integer array nums, return the length of the longest strictly increasing subsequence.
///
/// Example 1:
/// Input: nums = [10,9,2,5,3,7,101,18]
/// Output: 4
/// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
///
/// Example 2:
/// Input: nums = [0,1,0,3,2,3]
/// Output: 4
///
/// Example 3:
/// Input: nums = [7,7,7,7,7,7,7]
/// Output: 1
///
/// Constraints:
/// 1 <= nums.length <= 2500
/// -104 <= nums[i] <= 104
///
/// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
///
public class LongestIncreasingSequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            if (res.isEmpty() || res.get(res.size() - 1) < n) {
                res.add(n);
            } else {
                int idx = binarySearch(res, n);
                res.set(idx, n);
            }
        }

        return res.size();
    }

    private int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
