package com.jialtang.leetcode;

import java.util.Arrays;

public class _064MinimumPathSum {
  public static void main(String[] args) {
    int[][] grid;
    int i;

    grid = new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    i = new Solution().minPathSum(grid);
    System.out.println(i);
  }

  static class Solution {
    int rows, cols;
    int[][] can;
    int[][] grid;
    int ans;

    public int minPathSum(int[][] grid) {
      this.grid = grid;
      this.rows = grid.length;
      this.cols = grid[0].length;
      this.can = new int[rows][cols];
      Arrays.stream(this.can).forEach(e -> Arrays.fill(e, -1));

      ans = dfs(0, 0);
      return ans;
    }

    private int dfs(int i, int j) {
      if (i >= rows || j >= cols) return Integer.MAX_VALUE;
      if (i == rows - 1 && j == cols - 1) return grid[i][j];

      if (this.can[i][j] != -1) return this.can[i][j];
      int val = grid[i][j] + Math.min(dfs(i + 1, j), dfs(i, j + 1));
      this.can[i][j] = val;
      return val;
    }
  }
}
