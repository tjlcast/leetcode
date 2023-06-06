package com.jialtang.leetcode;

import java.util.Arrays;

/**
 * https://zhuanlan.zhihu.com/p/401283711
 */
public class _044WildcardMatching {

  public static void main(String[] args) {
    String s, p;
    boolean match;

    s = "aa";
    p = "a";
    match = new Solution().isMatch(s, p);
    System.out.println(match);

    s = "cb";
    p = "?a";
    match = new Solution().isMatch(s, p);
    System.out.println(match);
  }

  static class Solution {
    private char[] ss;
    private char[] pp;
    private int[][] memo;

    public boolean isMatch(String s, String p) {
      ss = s.toCharArray();
      pp = p.toCharArray();
      memo = new int[ss.length + 1][pp.length + 1];
      for (int[] ints : memo) {
        Arrays.fill(ints, -1);
      }
      return dp(0, 0);
    }

    private boolean dp(int i, int j) {
      boolean ans;
      if (memo[i][j] >= 0) return memo[i][j] > 0;

      if (j == pp.length) {
        ans = i == ss.length;
      } else {
        if (pp[j] == '*') {
          ans = dp(i, j + 1) || (i + 1 <= ss.length && dp(i + 1, j));
        } else {
          boolean first_match = i < ss.length && (pp[j] == ss[i] || pp[j] == '?');
          ans = first_match && dp(i + 1, j + 1);
        }
        memo[i][j] = (ans) ? (1) : (0);
      }

      return ans;
    }
  }
}
