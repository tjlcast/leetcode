package com.jialtang.leetcode.common.practice.zhaoyingwangluo;

public class _1Pro {
  public static void main(String[] args) {
    int L, R, x, i;

    L = 2;
    R = 22;
    x = 2;
    i = new Solution().countNum(L, R, x);
    System.out.println(i);

    L = 1;
    R = 11;
    x = 1;
    i = new Solution().countNum(L, R, x);
    System.out.println(i);
  }

  static class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param L int整型
     * @param R int整型
     * @param x int整型
     * @return int整型
     */
    public int countNum(int L, int R, int x) {
      int count = 0;
      // write code here
      for (int i = L; i <= R; i++) {
        int val = i;
        while (val != 0) {
          if (val % 10 == x) {
            count++;
          }
          val = val / 10;
        }
      }
      return count;
    }
  }
}
