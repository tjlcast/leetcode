package com.jialtang.leetcode;

public class _032LongestValidParentheses {

  public static void main(String[] args) {
    String s = "()(())";
    int i = new Solution().longestValidParentheses(s);
    System.out.println(i);

    s = ")()())";
    i = new Solution().longestValidParentheses(s);
    System.out.println(i);

    s = "(()";
    i = new Solution().longestValidParentheses(s);
    System.out.println(i);

    s = "";
    i = new Solution().longestValidParentheses(s);
    System.out.println(i);

    s = "())";
    i = new Solution().longestValidParentheses(s);
    System.out.println(i);
  }

  static class Solution {
    int[] dp;

    public int longestValidParentheses(String s) {
      dp = new int[s.length()];
      dp(s);
      int max = 0;
      for (int i = 0; i < s.length(); i++) {
        max = Math.max(max, dp[i]);
      }
      return max;
    }

    private void dp(String s) {
      if (s == null || s.length() == 0) return;
      for (int i = 0; i < s.length(); i++) {
        // (
        if (s.charAt(i) == '(') dp[i] = 0;
        // )
        else {
          int max = getMax(s, i);
          if (i - max - 1 >= 0 && s.charAt(i - max - 1) == '(') {
            dp[i] = max + 2;
          }
          int max1 = getMax(s, i + 1);
          dp[i] = max1;
        }
      }
    }

    private int getMax(String s, int idx) {
      if (idx <= 1) return 0;
      int len = 0;

      int beforeIdx = idx - 1;
      while (beforeIdx >= 0 && dp[beforeIdx] != 0) {
        len += dp[beforeIdx];
        beforeIdx = beforeIdx - dp[beforeIdx];
      }

      return len;
    }
  }
}
