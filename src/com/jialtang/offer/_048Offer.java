package com.jialtang.offer;

import java.util.HashMap;

public class _048Offer {
  public static void main(String[] args) {
    String s = "pwwkew";
    int i = new Solution().lengthOfLongestSubstring(s);
    System.out.println(i);
  }

  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s.length() <= 1) return s.length();

      int ans = 0;
      int l = 0, r = 0;
      HashMap<Character, Integer> map = new HashMap<>();

      while (r < s.length()) {
        char c = s.charAt(r);
        if (map.containsKey(c)) {
          if (map.get(c) >= l) l += 1;
        }
        System.out.println("l: " + l + " r: " + r);
        ans = Math.max(ans, r - l + 1);
        map.put(c, r);

        r++;
      }

      System.out.println("l: " + l + " r: " + r);
      ans = Math.max(ans, r - l);

      return ans;
    }
  }
}
