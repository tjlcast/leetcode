package com.jialtang.leetcode;

public class _067AddBinary {
  public static void main(String[] args) {
    String a, b, c;

    a = "11";
    b = "1";
    c = new Solution().addBinary(a, b);
    System.out.println("c: " + c);

    a = "1010";
    b = "1011";
    c = new Solution().addBinary(a, b);
    System.out.println("c: " + c);
  }

  static class Solution {
    public String addBinary(String a, String b) {
      StringBuilder sb = new StringBuilder();
      int ai = a.length() - 1;
      int bi = b.length() - 1;

      int carr = 0;
      while (ai >= 0 || bi >= 0) {
        int av = (ai >= 0) ? (a.charAt(ai) - '0') : (0);
        int bv = (bi >= 0) ? (b.charAt(bi) - '0') : (0);
        int val = (av + bv + carr);
        carr = val / 2;
        sb.append(val % 2);
        ai--;
        bi--;
      }

      if (carr != 0) {
        sb.append(carr);
      }
      return sb.reverse().toString();
    }
  }
}
