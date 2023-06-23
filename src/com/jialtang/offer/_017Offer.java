package com.jialtang.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _017Offer {
  public static void main(String[] args) {
    int[] ints = new Solution().printNumbers(3);
    System.out.println(Arrays.toString(ints));
  }

  static class Solution {
    public int[] printNumbers(int n) {
      LinkedList<Integer> ans = new LinkedList<>();

      if (n == 0) {
        return convList2Array(ans);
      }

      for (int i = 1; i <= 9; i++) {
        ans.add(i);
      }

      if (n == 1) {
        return convList2Array(ans);
      }

      for (int i = 1; i < n; i++) {
        int len = ans.size();
        for (int j = 0; j < len; j++) {
          for (int d = 0; d < 10; d++) {
            ans.addLast(ans.get(j) * 10 + d);
          }
        }
      }

      return convList2Array(ans);
    }

    private int[] convList2Array(List<Integer> list) {
      int[] arr = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        arr[i] = list.get(i);
      }
      return arr;
    }
  }
}
