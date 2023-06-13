package com.jialtang.leetcode;

import java.util.Arrays;

public class _091DecodeWays {
  public static void main(String[] args) {
    String s = "226";
    int i = new Solution().numDecodings(s);
    System.out.println(i);
  }

  static class Solution {
    String s;
    int sLen;
    private int[] dp;

    public int numDecodings(String s) {
      this.s = s;
      this.sLen = s.length();
      this.dp = new int[sLen];
      Arrays.fill(dp, -1);

      int ans = decode(0);
      return ans;
    }

    private int decode(int i) {
      if (i >= this.sLen) return 1;
      if (s.charAt(i) == '0') return 0;

      if (dp[i] != -1) return dp[i];

      int ans = 0;
      int nums = s.charAt(i) - '0';
      if (i < sLen - 1) {
        nums = nums * 10 + s.charAt(i + 1) - '0';
        if (nums <= 26) ans += decode(i + 2);
      }
      ans += decode(i + 1);
      dp[i] = ans;
      return ans;
    }
  }
}
