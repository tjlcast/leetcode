package com.jialtang.leetcode;

public class _096UniqueBinarySearchTrees {
  public static void main(String[] args) {
    int n = 5;
    int i = new Solution().numTrees(n);
    System.out.println(i);
  }

  static class Solution {
    int[][] dp;

    public int numTrees(int n) {
      this.dp = new int[n + 1][n + 1];
      int ans = dfs(1, n);
      return ans;
    }

    private int dfs(int l, int r) {
      if (l > r) return 1;
      if (l == r) return 1;
      if (dp[l][r] != 0) return dp[l][r];

      int ans = 0;
      for (int i = l; i <= r; i++) {
        int left = dfs(l, i - 1);
        int right = dfs(i + 1, r);
        ans += left * right;
      }
      dp[l][r] = ans;

      return ans;
    }
  }
}
