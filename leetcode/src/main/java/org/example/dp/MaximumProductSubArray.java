package org.example.dp;

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
