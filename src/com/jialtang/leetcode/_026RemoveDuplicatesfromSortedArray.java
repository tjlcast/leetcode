package com.jialtang.leetcode;

import java.util.Arrays;

public class _026RemoveDuplicatesfromSortedArray {
  public static void main(String[] args) {
    int[] nums = {1, 1, 2};
    int i = new Solution().removeDuplicates(nums);
    System.out.println(i);
    System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, i)));

    nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    i = new Solution().removeDuplicates(nums);
    System.out.println(i);
    System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, i)));
  }

  static class Solution {
    public int removeDuplicates(int[] nums) {
      int left = 0, right = 0;
      while (right < nums.length) {
        nums[left] = nums[right];

        while (right < nums.length && nums[left] == nums[right]) right++;
        left++;
      }
      return left;
    }
  }
}
