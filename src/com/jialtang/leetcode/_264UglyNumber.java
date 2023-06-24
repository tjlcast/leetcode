package com.jialtang.leetcode;

import java.util.Arrays;

public class _264UglyNumber {

  public static void main(String[] args) {
    int n = 10;
    int i = new Solution().nthUglyNumber(n);
    System.out.println(i);
  }

  static class Solution {
    public int nthUglyNumber(int n) {
      int[] dp = new int[n];
      dp[0] = 1;

      int p2 = 0, p3 = 0, p5 = 0;
      for (int i = 1; i < n; i++) {
        int v = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
        if (dp[p2] * 2 == v) p2++;
        if (dp[p3] * 3 == v) p3++;
        if (dp[p5] * 5 == v) p5++;
        dp[i] = v;
      }

      System.out.println(Arrays.toString(dp));

      return dp[n - 1];
    }
  }
}
