package com.jialtang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _076MinimumWindowSubstring {
  public static void main(String[] args) {
    String s, t, ans;

    s = "a";
    t = "aa";
    ans = new Solution().minWindow(s, t);
    System.out.println("ans: " + ans);

    s = "ADOBECODEBANC";
    t = "ABC";
    ans = new Solution().minWindow(s, t);
    System.out.println("ans: " + ans);
  }

  static class Solution {
    int l = 0;
    int r = 0;
    HashMap<Character, Integer> m = new HashMap<>();
    int minL, minR, minLen = Integer.MAX_VALUE;

    public String minWindow(String s, String t) {
      for (int i = 0; i < t.length(); i++) {
        Character c = t.charAt(i);
        Integer orDefault = this.m.getOrDefault(c, 0);
        m.put(c, orDefault + 1);
      }

      while (r < s.length()) {
        if (canBenT()) {
          if (r - l < minLen) {
            minLen = r - l + 1;
            minL = l;
            minR = r;
          }
          char c = s.charAt(l++);
          if (m.containsKey(c)) {
            m.put(c, m.get(c) + 1);
          }
        } else {
          char c = s.charAt(r++);
          if (m.containsKey(c)) {
            m.put(c, m.get(c) - 1);
          }
        }
      }

      while (canBenT()) {
        if (r - l < minLen) {
          minLen = r - l + 1;
          minL = l;
          minR = r;
        }
        char c = s.charAt(l++);
        if (m.containsKey(c)) {
          m.put(c, m.get(c) + 1);
        }
      }

      return s.substring(minL, minR);
    }

    private boolean canBenT() {
      for (Map.Entry<Character, Integer> entry : m.entrySet()) {
        if (entry.getValue() > 0) {
          return false;
        }
      }
      return true;
    }
  }
}
