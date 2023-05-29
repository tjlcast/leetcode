package com.jialtang.leetcode;

public class _011ContainerWithMostWater {

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        int i = solution.maxArea(heights);
        System.out.println(i);
    }

    static class Solution {
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int maxArea = 0;

            while (i < j) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);

                if (height[i] > height[j]) {
                    j--;
                } else {
                    i++;
                }
            }

            return maxArea;
        }
    }
}
