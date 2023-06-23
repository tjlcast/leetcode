package com.jialtang.offer;

import java.util.HashMap;
import java.util.Map;

public class _050Offer {
  public static void main(String[] args) {
    String s = "";

    char c = new Solution().firstUniqChar(s);

    System.out.println(c);
  }

  static class Solution {
    public char firstUniqChar(String s) {
      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char c = chars[i];
        mark(c);
      }

      for (int i = 0; i < chars.length; i++) {
        char c = chars[i];
        if (isOne(c)) return c;
      }

      char c = 0;
      return c;
    }

    Map<Character, Integer> charNums = new HashMap<Character, Integer>();

    private void mark(char c) {
      int n = charNums.getOrDefault(c, 0);
      charNums.put(c, n + 1);
    }

    private boolean isOne(char c) {
      if (charNums.containsKey(c) && charNums.get(c) == 1) return true;
      return false;
    }
  }
}
