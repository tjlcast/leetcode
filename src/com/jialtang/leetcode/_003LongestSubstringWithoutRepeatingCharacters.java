package com.jialtang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _003LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    String s = "abc";
    int i = new Solution().lengthOfLongestSubstring(s);
    System.out.println(i);
  }

  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s.length() == 0) {
        return 0;
      }
      int maxLen = 1;
      int lastIdx = 0;
      Map<Character, Integer> characters = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (characters.containsKey(c)) {
          characters.clear();
          int len = i - lastIdx;
          maxLen = Math.max(maxLen, len);
          lastIdx = i;
        }
        characters.put(c, i);
      }
      maxLen = Math.max(maxLen, s.length() - lastIdx);
      return maxLen;
    }
  }
}
