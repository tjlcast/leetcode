package com.jialtang.offer;

public class _005Offer {
  public static void main(String[] args) {
    String s = "We are happy.";
    String s1 = new Solution().replaceSpace(s);
    System.out.println(s1);
  }

  static class Solution {
    public String replaceSpace(String s) {
      StringBuilder sb = new StringBuilder();
      char[] arr = s.toCharArray();
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == ' ') {
          sb.append("%20");
        } else {
          sb.append(arr[i]);
        }
      }
      return sb.toString();
    }
  }
}
