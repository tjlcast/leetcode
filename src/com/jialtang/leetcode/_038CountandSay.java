package com.jialtang.leetcode;

public class _038CountandSay {
  public static void main(String[] args) {
    int n = 4;
    String s = new Solution().countAndSay(n);
    System.out.println(s);

    String say = new Solution().say("3322251");
    System.out.println(say);
  }

  static class Solution {
    public String countAndSay(int n) {
      String str = "1";
      for (int i = 2; i <= n; i++) {
        str = say(str);
      }
      return str;
    }

    public String say(String str) {
      char[] chars = str.toCharArray();

      StringBuilder sb = new StringBuilder();
      int i = 0;
      while (i < chars.length) {
        int num = 0;
        char val = chars[i];
        while (i < chars.length && val == chars[i]) {
          num++;
          i++;
        }
        sb.append(num);
        sb.append(val);
      }
      return sb.toString();
    }
  }
}
