package com.jialtang.leetcode;

import java.util.Arrays;

public class _043MultiplyStrings {
  public static void main(String[] args) {
    String num1, num2, multiply;

    num1 = "0";
    num2 = "0";
    multiply = new Solution().multiply(num1, num2);
    System.out.println(multiply);

    num1 = "12";
    num2 = "12";
    multiply = new Solution().multiply(num1, num2);
    System.out.println(multiply);

    num1 = "123";
    num2 = "456";
    multiply = new Solution().multiply(num1, num2);
    System.out.println(multiply);
  }

  static class Solution {
    public String multiply(String num1, String num2) {
      char[] chars1 = num1.toCharArray();
      char[] chars2 = num2.toCharArray();
      int[] ans = new int[chars1.length + chars2.length + 1];
      reverse(chars1);
      reverse(chars2);

      for (int i = 0; i < chars2.length; i++) {
        int val2 = chars2[i] - '0';
        for (int j = 0; j < chars1.length; j++) {
          int val1 = chars1[j] - '0';
          ans[j + i] = ans[j + i] + val1 * val2;
        }
      }

      int carr = 0;
      int i = 0;
      for (; i < ans.length; i++) {
        int val = ans[i] + carr;
        ans[i] = val % 10;
        carr = val / 10;
      }
      if (carr != 0) {
        ans[i] = carr;
      }

      reverse(ans);
      StringBuilder sb = new StringBuilder();
      Arrays.stream(ans)
          .forEach(
              e -> {
                if (sb.length() == 0 && e == 0) {
                } else {
                  sb.append(e);
                }
              });
      return (sb.length() == 0) ? ("0") : (sb.toString());
    }

    private void reverse(char[] chars) {
      int left = 0;
      int right = chars.length - 1;
      while (left < right) {
        char c = chars[left];
        chars[left] = chars[right];
        chars[right] = c;
        left++;
        right--;
      }
    }

    private void reverse(int[] chars) {
      int left = 0;
      int right = chars.length - 1;
      while (left < right) {
        int c = chars[left];
        chars[left] = chars[right];
        chars[right] = c;
        left++;
        right--;
      }
    }
  }
}
