package com.jialtang.leetcode;

public class _013RomantoInteger {

  public static void main(String[] args) {
    String s = "III";
    int i = new Solution().romanToInt(s);
    System.out.println(i);

    String s1 = "LVIII";
    int i1 = new Solution().romanToInt(s1);
    System.out.println(i1);

    String s2 = "MCMXCIV";
    int i2 = new Solution().romanToInt(s2);
    System.out.println(i2);
  }

  static class Solution {
    public int romanToInt(String s) {
      String[] roNum1 = {"IV", "IX", "XL", "XC", "CD", "CM", "I", "V", "X", "L", "C", "D", "M"};
      int[] inNum1 = {4, 9, 40, 90, 400, 900, 1, 5, 10, 50, 100, 500, 1000};
      int res = 0;

      int i = 0;
      while (i < s.length()) {
        for (int j = 0; j < roNum1.length; j++) {
          if (s.substring(i).startsWith(roNum1[j])) {
            res += inNum1[j];
            i += roNum1[j].length();
            break;
          }
        }
      }
      return res;
    }
  }
}
