package com.jialtang.leetcode;

public class _035SearchInsertPosition {
  public static void main(String[] args) {
    int[] nums;
    int target;
    int i;

    nums = new int[] {1, 3, 5, 6};
    target = 2;
    i = new Solution().searchInsert(nums, target);
    System.out.println(i);

    nums = new int[] {1, 3, 5, 6};
    target = 8;
    i = new Solution().searchInsert(nums, target);
    System.out.println(i);

    nums = new int[] {1, 3};
    target = 2;
    i = new Solution().searchInsert(nums, target);
    System.out.println(i);
  }

  static class Solution {
    public int searchInsert(int[] nums, int target) {
      int left = 0, right = nums.length - 1;
      if (target < nums[left]) return left;
      if (target > nums[right]) return right + 1;
      while (left <= right) {
        int mid = (left + right) >> 1;

        if (target > nums[mid]) {
          left = mid + 1;
          if (left <= right && nums[left] > target) {
            return left;
          }
        } else if (target < nums[mid]) {
          right = mid - 1;
          if (left <= right && nums[right] < target) {
            return mid;
          }
        } else {
          return mid;
        }
      }
      return -1;
    }
  }
}
