package com.jialtang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class _022GenerateParentheses {

  public static void main(String[] args) {
    int n = 3;
    List<String> strings = new Solution().generateParenthesis(n);
    System.out.println(strings);

    n = 1;
    strings = new Solution().generateParenthesis(n);
    System.out.println(strings);
  }

  static class Solution {
    List<String> ans = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
      dp("", n, n, n);
      return ans;
    }

    private void dp(String str, int left, int right, int n) {
      if (left == 0 && right == 0) {
        ans.add(str);
      }
      if (right > 0 && (n - left > n - right)) {
        dp(str + ")", left, right - 1, n);
      }
      if (left > 0) {
        dp(str + "(", left - 1, right, n);
      }
    }
  }
}
