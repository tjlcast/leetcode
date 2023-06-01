package com.jialtang.leetcode;

import java.util.Arrays;

public class _031NextPermutation {
  public static void main(String[] args) {
    int[] nums = new int[] {5, 4, 7, 5, 3, 2};
    new Solution().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[] {1, 2, 3};
    new Solution().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[] {3, 2, 1};
    new Solution().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[] {1, 3, 2};
    new Solution().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }

  static class Solution {
    public void nextPermutation(int[] nums) {
      int pos = nums.length - 2;
      while (pos >= 0 && nums[pos] >= nums[pos + 1]) {
        pos--;
      }

      if (pos < 0) {
        reverse(nums, 0, nums.length);
        return;
      }

      int idx_bigger = nums.length - 1;
      while (idx_bigger > pos && nums[idx_bigger] <= nums[pos]) idx_bigger--;
      swap(nums, pos, idx_bigger);

      reverse(nums, pos + 1, nums.length - (pos + 1));
    }

    private void swap(int[] nums, int a, int b) {
      int num = nums[a];
      nums[a] = nums[b];
      nums[b] = num;
    }

    private void reverse(int[] nums, int pos, int len) {
      if (pos < 0 || pos + len - 1 >= nums.length) {
        return;
      }
      int left = pos;
      int right = pos + len - 1;

      while (left < right) {
        swap(nums, left++, right--);
      }
    }
  }
}
