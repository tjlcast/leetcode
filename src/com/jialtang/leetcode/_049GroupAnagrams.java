package com.jialtang.leetcode;

import java.util.*;

public class _049GroupAnagrams {

  public static void main(String[] args) {
    String[] strs;
    List<List<String>> ans;

    strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
    ans = new Solution().groupAnagrams(strs);
    ans.forEach(e -> System.out.println(Arrays.toString(e.toArray())));
  }

  static class Solution {
    List<List<String>> ans = new LinkedList<>();

    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> map = new HashMap<>();
      for (String str : strs) {
        String code = getHash(str);
        List<String> orDefault = map.getOrDefault(code, new LinkedList<>());
        orDefault.add(str);
        map.put(code, orDefault);
      }
      for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        ans.add(entry.getValue());
      }
      return ans;
    }

    private String getHash(String str) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        char a = (char) ('a' + i);
        int total = 0;
        for (int j = 0; j < str.length(); j++) {
          if (str.charAt(j) == a) {
            total++;
          }
        }
        sb.append(a + total);
      }
      return sb.toString();
    }
  }
}
