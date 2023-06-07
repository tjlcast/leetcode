package com.jialtang.leetcode;

public class _053MaximumSubarray {
  public static void main(String[] args) {
    int[] nums;
    int ans;
    nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    ans = new Solution().maxSubArray(nums);
    System.out.println(ans);
  }

  static class Solution {
    public int maxSubArray(int[] nums) {
      int sum = 0;
      int ans = Integer.MIN_VALUE;

      for (int i = 0; i < nums.length; i++) {
        sum = Math.max(nums[i], sum + nums[i]);
        ans = Math.max(ans, sum);
      }
      return ans;
    }
  }
}
