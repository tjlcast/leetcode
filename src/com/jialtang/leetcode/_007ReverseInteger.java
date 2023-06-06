package com.jialtang.leetcode;

public class _007ReverseInteger {
  public static void main(String[] args) {
    int x;
    int reverse;

    x = 123;
    reverse = new Solution().reverse(x);
    System.out.println(reverse);

    x = -123;
    reverse = new Solution().reverse(x);
    System.out.println(reverse);

    x = 0;
    reverse = new Solution().reverse(x);
    System.out.println(reverse);
  }

  static class Solution {
    public int reverse(int x) {
      boolean isBigger = x >= 0;

      char[] chars = String.valueOf(x).toCharArray();
      int left = (isBigger) ? (0) : (1);
      int right = chars.length - 1;

      while (left < right) {
        char c = chars[left];
        chars[left] = chars[right];
        chars[right] = c;

        left++;
        right--;
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < chars.length; i++) {
        sb.append(chars[i]);
      }
      try {
        return Integer.parseInt(sb.toString());
      } catch (Exception e) {
        return 0;
      }
    }
  }
}
