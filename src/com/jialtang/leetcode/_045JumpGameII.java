package com.jialtang.leetcode;

import java.util.Arrays;

public class _045JumpGameII {
  public static void main(String[] args) {
    int[] nums;
    int jump;

    nums = new int[] {2, 0, 2, 4, 6, 0, 0, 3};
    jump = new Solution().jump(nums);
    System.out.println(jump);

    nums = new int[] {2, 3, 1, 1, 4};
    jump = new Solution().jump(nums);
    System.out.println(jump);

    nums = new int[] {2, 3, 0, 1, 4};
    jump = new Solution().jump(nums);
    System.out.println(jump);
  }

  static class Solution {
    int[] steps;

    public int jump(int[] nums) {
      steps = new int[nums.length];
      Arrays.fill(steps, Integer.MAX_VALUE);
      steps[steps.length - 1] = 0;

      int i = nums.length - 2;
      while (i >= 0) {
        for (int j = i + 1; j <= Math.min(nums.length - 1, i + nums[i]); j++) {
          steps[i] = Math.min((steps[j]>=Integer.MAX_VALUE)?(Integer.MAX_VALUE):(steps[j]+1), steps[i]);
        }
        i--;
      }

      System.out.println(Arrays.toString(steps));
      return steps[0];
    }
  }
}
