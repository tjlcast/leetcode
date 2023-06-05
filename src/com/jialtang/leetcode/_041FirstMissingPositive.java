package com.jialtang.leetcode;

public class _041FirstMissingPositive {
  public static void main(String[] args) {
    int[] nums;
    int i;

    nums = new int[] {10, 19};
    i = new Solution().firstMissingPositive(nums);
    System.out.println(i);

    nums = new int[] {1, 2, 0};
    i = new Solution().firstMissingPositive(nums);
    System.out.println(i);

    nums = new int[] {3, 4, -1, 1};
    i = new Solution().firstMissingPositive(nums);
    System.out.println(i);

    nums = new int[] {};
    i = new Solution().firstMissingPositive(nums);
    System.out.println(i);
  }

  static class Solution {
    public int firstMissingPositive(int[] nums) {
      int n = nums.length;

      // do init
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= 0) nums[i] = n + 1;
      }

      // do mark
      for (int i = 0; i < nums.length; i++) {
        int num = Math.abs(nums[i]);
        if (num >= n + 1) continue;
        mark(nums, num - 1);
      }

      // get max
      for (int i = 1; i <= n; i++) {
        if (!exits(nums, i - 1)) return i;
      }

      return n + 1;
    }

    private boolean exits(int[] nums, int i) {
      if (nums[i] < 0 && nums[i] < nums.length) return true;
      return false;
    }

    private void mark(int[] nums, int i) {
      if (nums[i] < 0) return;
      nums[i] = nums[i] * -1;
    }
  }
}
