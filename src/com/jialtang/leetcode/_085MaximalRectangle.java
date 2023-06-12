package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class _085MaximalRectangle {
  public static void main(String[] args) {
    char[][] matrix;
    int ans;

    matrix =
        new char[][] {
          {'1', '0', '1', '0', '0'},
          {'1', '0', '1', '1', '1'},
          {'1', '1', '1', '1', '1'},
          {'1', '0', '0', '1', '0'}
        };

    ans = new Solution().maximalRectangle(matrix);
    System.out.println(ans);
  }

  static class Solution {
    int rows, cols;
    int ans = 0;
    int[] heights;

    public int maximalRectangle(char[][] matrix) {
      this.rows = matrix.length;
      this.cols = matrix[0].length;
      this.heights = new int[this.cols];

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          heights[j] += 1;
          if (matrix[i][j] == '0') heights[j] = 0;
        }

        System.out.println(Arrays.toString(heights));

        int are = getRectMax(heights);
        ans = Math.max(ans, are);
      }
      return ans;
    }

    int getRectMax(int[] heights) {
      int ans = 0;
      LinkedList<Integer> stack = new LinkedList<>();
      int[] rs = new int[cols];
      int[] ls = new int[cols];
      stack.clear();
      for (int i = cols - 1; i >= 0; i--) {
        while (!stack.isEmpty() && heights[i] < heights[stack.getLast()]) {
          int x = stack.removeLast();
          ls[x] = i;
        }
        stack.addLast(i);
        ls[i] = -1;
      }
      stack.clear();
      for (int i = 0; i < cols; i++) {
        while (!stack.isEmpty() && heights[i] < heights[stack.getLast()]) {
          int x = stack.removeLast();
          rs[x] = i;
        }
        stack.addLast(i);
        rs[i] = cols;
      }
      for (int i = 0; i < cols; i++) {
        int area = (rs[i] - ls[i] - 1) * heights[i];
        ans = Math.max(ans, area);
      }
      return ans;
    }
  }
}
