package com.jialtang.leetcode;

/** https://zhuanlan.zhihu.com/p/390804211 */
public class _010RegularExpressionMatching {

  public static void main(String[] args) {
    String s, p;
    boolean match;

    s = "aab";
    p = ".*";
    match = new Solution().isMatch(s, p);
    System.out.println(match);

    s = "aab";
    p = "c*a*b";
    match = new Solution().isMatch(s, p);
    System.out.println(match);

    s = "a";
    p = "a*";
    match = new Solution().isMatch(s, p);
    System.out.println(match);

    s = "aa";
    p = "a*";
    match = new Solution().isMatch(s, p);
    System.out.println(match);

    s = "aaa";
    p = "a*";
    match = new Solution().isMatch(s, p);
    System.out.println(match);
  }

  static class Solution {
    private char[] ss;
    private char[] pp;

    public boolean isMatch(String s, String p) {
      ss = s.toCharArray();
      pp = p.toCharArray();
      return dp(0, 0);
    }

    private boolean dp(int i, int j) {
      boolean ans = false;
      if (j == pp.length) {
        ans = i == ss.length;
      } else {
        boolean first_math = i < ss.length && (pp[j] == ss[i] || pp[j] == '.');
        if (j + 1 < pp.length && pp[j + 1] == '*') {
          ans = dp(i, j + 2) || first_math && dp(i + 1, j);
        } else {
          ans = first_math && dp(i + 1, j + 1);
        }
      }
      return ans;
    }
  }
}
