package com.jialtang.leetcode;

import java.util.Arrays;

public class _016_3SumClosest {

  public static void main(String[] args) {
    int[] nums1 = {-1, 2, 1, -4};
    int i1 = new Solution().threeSumClosest(nums1, 1);
    System.out.println(i1);

    int[] nums2 = {0, 0, 0};
    int i2 = new Solution().threeSumClosest(nums2, 1);
    System.out.println(i2);
  }

  static class Solution {
    public int threeSumClosest(int[] nums, int target) {
      int gap = Integer.MAX_VALUE;
      int sum = 0;
      Arrays.sort(nums);
      for (int r = nums.length - 1; r >= 2; r--) {
        int l = 0;
        int m = r - 1;

        while (l < m) {
          if (Math.abs(nums[l] + nums[m] + nums[r] - target) <= gap) {
            gap = Math.abs(nums[l] + nums[m] + nums[r] - target);
            sum = nums[l] + nums[m] + nums[r];
          }

          if (nums[l] + nums[m] + nums[r] > target) {
            m--;
          } else {
            l++;
          }
        }
      }
      return sum;
    }
  }
}
