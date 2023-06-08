package com.jialtang.leetcode;

import java.util.Arrays;

public class _075SortColors {
  public static void main(String[] args) {
    int[] nums;

    nums = new int[] {1, 2, 0};
    new Solution().sortColors(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[] {1, 0, 1};
    new Solution().sortColors(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[] {2, 0, 2, 1, 1, 0};
    new Solution().sortColors(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[] {2, 0, 2, 0, 0, 1, 0};
    new Solution().sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }

  static class Solution {
    public void sortColors(int[] nums) {
      int l = 0;
      int r = nums.length - 1;
      sort(nums, l, r);
    }

    private void sort(int[] nums, int l, int r) {
      if (l > r) return;
      int p = partition(nums, l, r);
      sort(nums, l, p - 1);
      sort(nums, p + 1, r);
    }

    private int partition(int[] nums, int left, int right) {
      int val = nums[left];
      int l = left;
      int r = right;

      while (l < r) {
        while (l < r && nums[r] > val) r--;
        while (l < r && nums[l] <= val) l++;
        swap(nums, l, r);
      }
      swap(nums, left, r);
      return r;
    }

    private void swap(int[] nums, int i, int j) {
      int n = nums[i];
      nums[i] = nums[j];
      nums[j] = n;
    }
  }
}
