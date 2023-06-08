package com.jialtang.leetcode;

import java.util.Arrays;

public class _063UniquePathsII {
  public static void main(String[] args) {
    int[][] obstacleGrid;
    int i;

    obstacleGrid = new int[][] {{0, 1}, {0, 0}};
    i = new Solution().uniquePathsWithObstacles(obstacleGrid);
    System.out.println(i);

    obstacleGrid = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    i = new Solution().uniquePathsWithObstacles(obstacleGrid);
    System.out.println(i);
  }

  static class Solution {
    private int[][] obstacleGrid;
    private int[][] can;
    private int rows;
    private int cols;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      this.obstacleGrid = obstacleGrid;
      this.rows = obstacleGrid.length;
      this.cols = obstacleGrid[0].length;
      this.can = new int[rows][cols];
      Arrays.stream(can).forEach(e -> Arrays.fill(e, -1));
      return dfs(0, 0);
    }

    private int dfs(int i, int j) {
      if (i >= rows || j >= cols) return 0;
      if (obstacleGrid[i][j] == 1) return 0;
      if (i == rows - 1 && j == cols - 1) return 1;

      if (can[i][j]!=-1) return can[i][j];

      int val = dfs(i + 1, j) + dfs(i, j + 1);
      can[i][j] = val;
      return val;
    }
  }
}
