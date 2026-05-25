package org.example.arrays;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        int last = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            if (h > last) {
                int area = h * (right - left);
                maxArea = Math.max(maxArea, area);
            }
            last = Math.max(last, h);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
