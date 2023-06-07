package com.jialtang.leetcode;

import java.util.*;

public class _057InsertInterval {

  public static void main(String[] args) {
    int[][] intervals;
    int[] newInterval;
    int[][] insert;

    System.out.println("----");
    intervals = new int[][] {{1, 3}, {6, 9}};
    newInterval = new int[] {10, 17};
    insert = new Solution().insert(intervals, newInterval);
    Arrays.stream(insert).forEach(e -> System.out.println(Arrays.toString(e)));

    System.out.println("----");
    intervals = new int[][] {{1, 3}, {9, 10}};
    newInterval = new int[] {5, 7};
    insert = new Solution().insert(intervals, newInterval);
    Arrays.stream(insert).forEach(e -> System.out.println(Arrays.toString(e)));

    System.out.println("----");
    intervals = new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    newInterval = new int[] {4, 8};
    insert = new Solution().insert(intervals, newInterval);
    Arrays.stream(insert).forEach(e -> System.out.println(Arrays.toString(e)));
  }

  static class Solution {
    List<int[]> ans = new LinkedList<>();

    public int[][] insert(int[][] intervals, int[] newInterval) {
      int p = 0;
      int lastS = newInterval[0];
      int lastE = newInterval[1];
      boolean isInserted = false;
      while (p < intervals.length) {
        if (isOverlap(intervals[p][0], intervals[p][1], newInterval[0], newInterval[1])) {
          while (p < intervals.length
              && isOverlap(intervals[p][0], intervals[p][1], newInterval[0], newInterval[1])) {
            lastS = Math.min(Math.min(intervals[p][0], newInterval[0]), lastS);
            lastE = Math.max(Math.max(intervals[p][1], newInterval[1]), lastE);
            p++;
          }
          ans.add(new int[] {lastS, lastE});
          isInserted = true;
          if (p >= intervals.length) continue;
        }

        ans.add(intervals[p]);
        p++;
      }

      if (!isInserted) ans.add(newInterval);
      Collections.sort(
          ans,
          new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
              if (o1[0] > o2[0]) return 1;
              else if (o1[0] < o2[0]) return -1;
              else return 0;
            }
          });

      return ans.stream().toArray(int[][]::new);
    }

    private boolean isOverlap(int s1, int e1, int s2, int e2) {
      return Math.max(s1, s2) <= Math.min(e1, e2);
    }
  }
}
