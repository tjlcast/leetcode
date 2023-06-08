package com.jialtang.leetcode;

public class _058LengthofLastWord {
  public static void main(String[] args) {
    String s;
    int i;

    s = "   fly me   to   the moon  ";
    i = new Solution().lengthOfLastWord(s);
    System.out.println(i);

    s = "Hello World";
    i = new Solution().lengthOfLastWord(s);
    System.out.println(i);

    s = "HelloqwWorld";
    i = new Solution().lengthOfLastWord(s);
    System.out.println(i);
  }

  static class Solution {
    public int lengthOfLastWord(String s) {
      int l = 0;
      int r = 0;
      int lastLen = 0;

      while (r < s.length()) {
        if (s.charAt(r) == ' ') {
          lastLen = (r - l != 0) ? (r - l) : (lastLen);
          l = r + 1;
        }
        r++;
      }
      lastLen = (r - l != 0) ? (r - l) : (lastLen);
      return lastLen;
    }
  }
}
