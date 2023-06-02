package com.jialtang.leetcode;

import java.util.Arrays;

public class _034FindFirstandLastPositionofElementinSortedArray {

  public static void main(String[] args) {
    int[] nums = new int[] {5, 7, 7, 8, 8, 10};
    int target = 7;
    int[] ints = new Solution().searchRange(nums, target);
    System.out.println(Arrays.toString(ints));

    nums = new int[] {};
    target = 7;
    ints = new Solution().searchRange(nums, target);
    System.out.println(Arrays.toString(ints));
  }

  static class Solution {
    public int[] searchRange(int[] nums, int target) {
      int a = bLeftSearch(nums, target, 0, nums.length - 1);
      int b = bRightSearch(nums, target, 0, nums.length - 1);
      return new int[] {a, b};
    }

    private int bLeftSearch(int[] nums, int target, int left, int right) {
      if (left > right) {
        return -1;
      }
      while (left <= right) {
        int mid = (left + right) >> 1;
        if (nums[mid] > target) {
          right = mid - 1;
        } else if (nums[mid] < target) {
          left = mid + 1;
        } else {
          if (left == mid || (left + 1 <= mid && nums[mid - 1] < nums[mid])) {
            return mid;
          } else {
            right = mid - 1;
          }
        }
      }
      return -1;
    }

    private int bRightSearch(int[] nums, int target, int left, int right) {
      if (left > right) {
        return -1;
      }
      while (left <= right) {
        int mid = (left + right) >> 1;
        if (nums[mid] > target) {
          right = mid - 1;
        } else if (nums[mid] < target) {
          left = mid + 1;
        } else {
          if (right == mid || (nums[mid] < nums[mid + 1])) {
            return mid;
          } else {
            left = mid + 1;
          }
        }
      }
      return -1;
    }
  }
}
