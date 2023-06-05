package com.jialtang.leetcode.common.practice.zhaoyingwangluo;

import java.util.ArrayList;

public class _2Pro {
  public static void main(String[] args) {
    String s;
    ArrayList<Integer> ans;

    s = "c12m23b3n4t56";
    ans = new Solution().extraNum(s);
    System.out.println(ans);
  }

  static class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return int整型ArrayList
     */
    public ArrayList<Integer> extraNum(String s) {
      // write code here
      ArrayList<Integer> ans = new ArrayList<>();
      char[] chars = s.toCharArray();

      int i = 0;
      while (i < chars.length) {
        if (!isNum(chars, i)) {
          i++;
          continue;
        }
        int num = 0;
        while (i < chars.length && isNum(chars, i)) {
          num = num * 10 + chars[i] - '0';
          i++;
        }
        ans.add(num);
      }

      return ans;
    }

    private boolean isNum(char[] str, int pos) {
      if ('0' <= str[pos] && str[pos] <= '9') {
        return true;
      }
      return false;
    }
  }
}
