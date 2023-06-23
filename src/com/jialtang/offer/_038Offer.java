package com.jialtang.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class _038Offer {
  public static void main(String[] args) {
    String s = "aab";

    String[] permutation = new Solution().permutation(s);
    System.out.println(Arrays.toString(permutation));
  }

  static class Solution {
    LinkedList<String> ans = new LinkedList<>();
    boolean[] can;

    public String[] permutation(String s) {
      char[] chars = s.toCharArray();
      can = new boolean[chars.length];
      Arrays.sort(chars);

      dfs(chars, new LinkedList<>(), 0);

      return ans.stream().toArray(String[]::new);
    }

    private void dfs(char[] s, LinkedList<Character> chars, int i) {
      if (chars.size() == s.length) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < chars.size(); j++) sb.append(chars.get(j));
        ans.add(sb.toString());
        return;
      }

      Set<Character> set = new HashSet<>();
      for (int j = 0; j < s.length; j++) {
        if (can[j]) continue;
        if (j-1>=0 && s[j-1]==s[j] && !can[j-1]) continue;

        chars.addLast(s[j]);
        can[j] = true;
        dfs(s, chars, j + 1);
        chars.removeLast();
        can[j] = false;
      }

      return;
    }
  }
}
