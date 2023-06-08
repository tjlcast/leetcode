package com.jialtang.leetcode;

public class _062UniquePaths {
  public static void main(String[] args) {
    int m, n, i;

    m = 3;
    n = 7;
    i = new Solution().uniquePaths(m, n);
    System.out.println(i);

    m = 3;
    n = 2;
    i = new Solution().uniquePaths(m, n);
    System.out.println(i);

    m = 19;
    n = 13;
    i = new Solution().uniquePaths(m, n);
    System.out.println(i);
  }

  static class Solution {
    private int[][] dp;
    private boolean[][] can;
    private int m;
    private int n;

    public int uniquePaths(int m, int n) {
      this.m = m;
      this.n = n;
      dp = new int[m][n];
      can = new boolean[m][n];
      return dfs(0, 0);
    }

    private int dfs(int i, int j) {
      if (i == m - 1 && j == n - 1) {
        can[i][j] = true;
        dp[i][j] = 1;
        return dp[i][j];
      }
      if (i >= m) return 0;
      if (j >= n) return 0;

      if (can[i][j]) return dp[i][j];
      int val = dfs(i, j + 1) + dfs(i + 1, j);
      dp[i][j] = val;
      can[i][j] = true;
      return dp[i][j];
    }
  }
}
