package com.jialtang.leetcode;

public class _042TrappingRainWater {

  public static void main(String[] args) {
    int[] height;

    height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int trap = new Solution().trap(height);
    System.out.println(trap);
  }

  static class Solution {
    private int[] heights;
    private int[] maxLeftPos;
    private int[] maxRightPos;

    public int trap(int[] height) {
      int total = 0;
      heights = new int[height.length + 2];
      maxLeftPos = new int[height.length + 2];
      maxRightPos = new int[height.length + 2];
      for (int i = 1; i <= height.length; i++) {
        heights[i] = height[i - 1];
      }

      int maxP = 0;
      for (int i = 1; i < maxLeftPos.length; i++) {
        maxLeftPos[i] = maxP;
        if (heights[maxP] < heights[i]) {
          maxP = i;
        }
      }

      maxP = heights.length - 1;
      for (int i = heights.length - 2; i >= 0; i--) {
        maxRightPos[i] = maxP;
        if (heights[maxP] < heights[i]) {
          maxP = i;
        }
      }

      int p = 1;
      while (p < heights.length - 1) {
        int h = Math.min(heights[maxLeftPos[p]], heights[maxRightPos[p]]);
        int area = h - heights[p];
        if (area > 0) {
          total += area;
        }
        p++;
      }
      return total;
    }
  }
}
