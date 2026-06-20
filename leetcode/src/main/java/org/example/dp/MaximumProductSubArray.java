package org.example.dp;

///
/// 152. Maximum Product Subarray
/// Medium
///
/// Given an integer array nums, find a subarray that has the largest product, and return the product.
/// The test cases are generated so that the answer will fit in a 32-bit integer.
/// Note that the product of an array with a single element is the value of that element.
///
/// Example 1:
/// Input: nums = [2,3,-2,4]
/// Output: 6
/// Explanation: [2,3] has the largest product 6.
///
/// Example 2:
/// Input: nums = [-2,0,-1]
/// Output: 0
/// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
///
/// Constraints:
/// 1 <= nums.length <= 2 * 104
/// -10 <= nums[i] <= 10
/// The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
///
public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int negCount = 0, zeroCount = 0;
        for (int n : nums) {
            if (n < 0) negCount++;
            else if (n == 0) zeroCount++;
        }

        if (zeroCount == 0 && negCount % 2 == 0) {
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                product *= nums[i];
            }
            return product;
        }

        int maxProduct = Integer.MIN_VALUE;
        int i = 0;
        int right = 1;
        int left = 1;
        while (i < nums.length) {
            left *= nums[i];
            right *= nums[nums.length - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(left, right));
            i++;

            left = left != 0 ? left : 1;
            right = right != 0 ? right : 1;
        }
        return maxProduct;
    }
}
