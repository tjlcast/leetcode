package com.jialtang.leetcode;

import java.util.Arrays;

public class _066PlusOne {

  public static void main(String[] args) {
    int[] digits;
    int[] ans;

    digits = new int[] {1, 2, 3};
    ans = new Solution().plusOne(digits);
    System.out.println(Arrays.toString(ans));

    digits = new int[] {9, 9, 9};
    ans = new Solution().plusOne(digits);
    System.out.println(Arrays.toString(ans));
  }

  static class Solution {
    public int[] plusOne(int[] digits) {
      int carr = 1; // plus one.
      int p = digits.length - 1;
      while (p >= 0) {
        int val = (carr + digits[p]);
        digits[p] = val % 10;
        carr = val / 10;
        p--;
      }

      p = 0;
      int[] ans;
      if (carr > 0) {
        ans = new int[digits.length + 1];
        ans[p++] = carr;
      } else {
        ans = new int[digits.length];
      }
      for (int i = 0; i < digits.length; i++) {
        ans[p++] = digits[i];
      }
      return ans;
    }
  }
}
