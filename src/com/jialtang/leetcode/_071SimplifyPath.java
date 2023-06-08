package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class _071SimplifyPath {

  public static void main(String[] args) {
    String path, ans;

    path = "/a/./b/../../c/";
    ans = new Solution().simplifyPath(path);
    System.out.println(ans);

    path = "/home/";
    ans = new Solution().simplifyPath(path);
    System.out.println(ans);

    path = "/home//foo/";
    ans = new Solution().simplifyPath(path);
    System.out.println(ans);

    path = "/../";
    ans = new Solution().simplifyPath(path);
    System.out.println(ans);
  }

  static class Solution {
    StringBuilder sb = new StringBuilder();

    public String simplifyPath(String path) {
      LinkedList<String> adjustPaths = new LinkedList<>();
      String[] split = path.split("/");
      split = Arrays.stream(split).filter(e -> !e.isEmpty()).toArray(String[]::new);
      for (String tPath : split) {
        if (tPath.equals("..")) {
          if (adjustPaths.size() != 0) adjustPaths.removeLast();
        } else if (tPath.equals(".")) {

        } else {
          adjustPaths.addLast(tPath);
        }
      }

      for (String tPath : adjustPaths) {
        sb.append("/");
        sb.append(tPath);
      }
      if (sb.length() == 0) {
        sb.append("/");
      }

      return sb.toString();
    }
  }
}
