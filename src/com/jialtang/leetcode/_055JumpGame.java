package com.jialtang.leetcode;

import java.util.Arrays;

public class _055JumpGame {
  public static void main(String[] args) {
    int[] nums;
    boolean b;

    nums = new int[] {2, 3, 1, 1, 4};
    b = new Solution().canJump(nums);
    System.out.println(b);

    nums = new int[] {0, 0, 1, 1, 4};
    b = new Solution().canJump(nums);
    System.out.println(b);
  }

  static class Solution {
    int[] dp;

    public boolean canJump(int[] nums) {
      dp = new int[nums.length];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[nums.length - 1] = 0;

      for (int i = nums.length - 2; i >= 0; i--) {
        int maxPos = nums[i] + i;
        int min = Integer.MAX_VALUE;
        for (int j = i; j <= Math.min(maxPos, nums.length - 1); j++) {
          min = Math.min(min, (dp[j] != Integer.MAX_VALUE) ? (dp[j] + 1) : (Integer.MAX_VALUE));
        }
        dp[i] = min;
      }

      return dp[0] < Integer.MAX_VALUE;
    }
  }
}
