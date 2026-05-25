package org.example.binarysearch;

public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (right == 0) {
            return nums[0] == target ? 0 : -1;
        }

        while (left <= right) {
            int mid = (right + left) / 2;

            int m = nums[mid];
            if (m == target) {
                return mid;
            }

            if (m >= nums[left]) {
                if (target >= nums[left] && target < m) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > m) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
