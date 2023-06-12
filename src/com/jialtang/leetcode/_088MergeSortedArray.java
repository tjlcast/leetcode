package com.jialtang.leetcode;

import java.util.Arrays;

public class _088MergeSortedArray {
  public static void main(String[] args) {
    int[] nums1, nums2;
    int n, m;

    nums1 = new int[] {1, 2, 3, 0, 0, 0};
    m = 3;
    nums2 = new int[] {2, 5, 6};
    n = 3;

    new Solution().merge(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));
  }

  static class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int l = m - 1;
      int r = n - 1;
      int k = m + n - 1;

      while (k >= 0) {
        int val1 = Integer.MIN_VALUE;
        int val2 = Integer.MIN_VALUE;

        if (l >= 0) val1 = nums1[l];
        if (r >= 0) val2 = nums2[r];

        if (val1 > val2) {
          nums1[k--] = val1;
          l--;
        } else {
          nums1[k--] = val2;
          r--;
        }
      }
    }
  }
}
