package com.jialtang.leetcode;

import java.util.Arrays;

public class _033SearchinRotatedSortedArray {

  public static void main(String[] args) {
    int[] nums = new int[] {1,3,5};
    int target = 5;
    int search = new Solution().search(nums, target);
    System.out.println(search);

    nums = new int[] {4, 5, 6, 7, 0, 1, 2};
    target = 0;
    search = new Solution().search(nums, target);
    System.out.println(search);

    nums = new int[] {4, 5, 6, 7, 0, 1, 2};
    target = 3;
    search = new Solution().search(nums, target);
    System.out.println(search);

    nums = new int[] {1};
    target = 0;
    search = new Solution().search(nums, target);
    System.out.println(search);
  }

  static class Solution {
    int pos = -1;

    public int search(int[] nums, int target) {
      bSearch(nums, target, 0, nums.length - 1);
      return (pos < 0) ? (-1) : (pos);
    }

    private void bSearch(int[] nums, int target, int left, int right) {
      if (left > right) return;
      if (left == right && nums[left] == target) {
        pos = left;
        return;
      }

      int mid = (left + right) >> 1;
      int midVal = nums[mid];

      if (midVal == target) {
        pos = mid;
      }

      if (midVal > nums[right]) {
        if (target < midVal && target >= nums[left]) {
          pos = Arrays.binarySearch(nums, left, mid, target);
        } else {
          bSearch(nums, target, mid + 1, right);
        }
      } else {
        if (target > midVal && target <= nums[right]) {
          pos = Arrays.binarySearch(nums, mid + 1, right+1, target);
        } else {
          bSearch(nums, target, left, mid - 1);
        }
      }
    }
  }
}
