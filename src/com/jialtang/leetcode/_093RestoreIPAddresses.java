package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _093RestoreIPAddresses {
  public static void main(String[] args) {
    String s = "101023";
    List<String> strings = new Solution().restoreIpAddresses(s);
    System.out.println(Arrays.toString(strings.toArray()));
  }

  static class Solution {
    List<String> ans = new LinkedList<>();
    String s;

    public List<String> restoreIpAddresses(String s) {
      this.s = s;
      dfs(0, new LinkedList<>());
      return ans;
    }

    private void dfs(int i, LinkedList<String> stack) {
      if (i >= s.length() && stack.size() == 4) {
        String ip = String.join(".", stack);
        ans.add(ip);
        return;
      }
      if (i >= s.length()) return;

      int num = 0;
      for (int r = i; r < i + 3 && r < s.length(); r++) {
        num = num * 10 + (s.charAt(r) - '0');
        if ((r - i == 1 && num < 10) || (r - i == 2 && num < 100)) continue;
        if (num <= 255) {
          stack.addLast(num + "");
          dfs(r + 1, stack);
          stack.removeLast();
        }
      }
    }
  }
}
