package com.jialtang.leetcode;

public class _080RemoveDuplicatesfromSortedArrayII {
  public static void main(String[] args) {
    int[] nums;
    int ans;

    nums = new int[] {1, 1, 1, 2, 2, 3};
    ans = new Solution().removeDuplicates(nums);
    System.out.println(ans);
  }

  static class Solution {
    public int removeDuplicates(int[] nums) {
      int l = 0;
      int r = 0;

      while (r < nums.length) {
        int n = nums[r];
        int count = 1;
        while (r < nums.length && (r - 1 >= 0 && nums[r] == nums[r - 1])) {
          if (count > 0) {
            nums[l++] = nums[r];
            count -= 1;
          }
          r++;
        }
        if (r < nums.length) nums[l++] = nums[r];
        r++;
      }
      return l;
    }
  }
}
