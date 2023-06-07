package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class _056MergeIntervals {
  public static void main(String[] args) {
    int[][] intervals;
    int[][] merge;

    System.out.println("====");
    intervals = new int[][] {{1, 3}, {0, 3}};
    merge = new Solution().merge(intervals);
    Arrays.stream(merge).forEach(e -> System.out.println(Arrays.toString(e)));

    //    System.out.println("====");
    //    intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    //    merge = new Solution().merge(intervals);
    //    Arrays.stream(merge).forEach(e -> System.out.println(Arrays.toString(e)));
    //
    //    System.out.println("====");
    //    intervals = new int[][] {{1, 4}, {4, 8}, {8, 10}, {10, 18}};
    //    merge = new Solution().merge(intervals);
    //    Arrays.stream(merge).forEach(e -> System.out.println(Arrays.toString(e)));
  }

  static class Solution {
    public int[][] merge(int[][] intervals) {
      List<int[]> recoders = new LinkedList<>();
      Arrays.sort(
          intervals,
          0,
          intervals.length,
          new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
              if (o1[0] > o2[0]) return 1;
              else if (o1[0] < o2[0]) return -1;
              return 0;
            }
          });

      int lastS = intervals[0][0];
      int lastE = intervals[0][1];
      int p = 0;
      while (p < intervals.length) {
        if (lastE >= intervals[p][0]) {
          lastE = Math.max(intervals[p][1], lastE);
        } else {
          // recorder lastS and lastE
          recoders.add(new int[] {lastS, lastE});
          lastS = intervals[p][0];
          lastE = intervals[p][1];
        }
        p++;
      }

      // recorder lastS and lastE
      recoders.add(new int[] {lastS, lastE});
      int[][] ints = recoders.stream().toArray(int[][]::new);
      return ints;
    }
  }
}
