package com.jialtang.leetcode;

import java.util.Arrays;

public class _070ClimbingStairs {
  public static void main(String[] args) {
    int n, i;

    n = 2;
    i = new Solution().climbStairs(n);
    System.out.println(i);

    n = 3;
    i = new Solution().climbStairs(n);
    System.out.println(i);

    n = 4;
    i = new Solution().climbStairs(n);
    System.out.println(i);
  }

  static class Solution {
    private int n;
    private int[] dp;

    public int climbStairs(int n) {
      this.n = n;
      this.dp = new int[n+1];
      Arrays.fill(this.dp, -1);
      return dfs(n);
    }

    public int dfs(int i) {
      if (i == 0) return 1;
      if (i < 0) return 0;

      if (dp[i] >= 0) {
        return dp[i];
      }

      int val = dfs(i - 1) + dfs(i - 2);
      dp[i] = val;
      return val;
    }
  }
}
