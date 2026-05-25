package org.example.arrays;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];

        int base = 0;
        for (int num : nums) {
            if (base < 0) {
                base = 0;
            }
            base += num;
            result = Math.max(result, base);
        }

        return result;
    }
}
