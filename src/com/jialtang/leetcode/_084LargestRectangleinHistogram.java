package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class _084LargestRectangleinHistogram {
  public static void main(String[] args) {
    int[] heights;
    int i;
    heights = new int[] {2, 1, 5, 6, 2, 3};
    i = new Solution().largestRectangleArea(heights);
    System.out.println(i);
  }

  static class Solution {
    public int largestRectangleArea(int[] heights) {
      int[] leftLHeight = new int[heights.length];
      int[] rightRHeight = new int[heights.length];
      LinkedList<Integer> stack = new LinkedList<>();

      for (int i = heights.length - 1; i >= 0; i--) {
        if (stack.isEmpty()) {
          stack.addLast(i);
          leftLHeight[i] = -1;
        } else {
          while (!stack.isEmpty() && heights[stack.getLast()] > heights[i]) {
            int x = stack.removeLast();
            leftLHeight[x] = i;
          }
          stack.addLast(i);
          leftLHeight[i] = -1;
        }
      }
      System.out.println(Arrays.toString(leftLHeight));

      stack.clear();
      for (int i = 0; i < heights.length; i++) {
        if (stack.isEmpty()) {
          stack.addLast(i);
          rightRHeight[i] = heights.length;
        } else {
          while (!stack.isEmpty() && heights[stack.getLast()] > heights[i]) {
            int x = stack.removeLast();
            rightRHeight[x] = i;
          }
          stack.addLast(i);
          rightRHeight[i] = heights.length;
        }
      }
      System.out.println(Arrays.toString(rightRHeight));

      int ans = 0;
      for (int i = 0; i < heights.length; i++) {
        int l = leftLHeight[i], r = rightRHeight[i];
        int area = (r - l - 1) * heights[i];
        System.out.println(area);
        ans = Math.max(ans, area);
      }
      return ans;
    }
  }
}
