package com.jialtang.leetcode;

public class _081SearchinRotatedSortedArrayII {
  public static void main(String[] args) {
    int[] nums;
    int target;
    boolean ans;

    nums = new int[] {1, 0, 1, 1, 1};
    target = 0;
    ans = new Solution().search(nums, target);
    System.out.println("ans: " + ans);

    //    nums = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
    //    target = 2;
    //    ans = new Solution().search(nums, target);
    //    System.out.println("ans: " + ans);
    //
    //    nums = new int[] {1, 0, 1, 1, 1};
    //    target = 0;
    //    ans = new Solution().search(nums, target);
    //    System.out.println("ans: " + ans);
    //
    //    nums = new int[] {2, 5, 6, 0, 0, 1, 2};
    //    target = 3;
    //    ans = new Solution().search(nums, target);
    //    System.out.println("ans: " + ans);
  }

  static class Solution {
    public boolean search(int[] nums, int target) {
      return dfs1(nums, 0, nums.length - 1, target);
    }

    private boolean dfs1(int[] nums, int left, int right, int target) {
      if (left > right) return false;

      int mid = (left + right) >> 1;
      if (nums[mid] == target) return true;

      if (nums[mid] < nums[right]) {
        if (nums[mid]<=target && target<=nums[right]) return dfs1(nums , mid+1, right, target);
        else return dfs1(nums, left, mid-1, target);
      } else if (nums[mid] > nums[right]) {
        if (nums[left]<=target && target<=nums[mid]) return dfs1(nums, left, mid-1, target);
        else return dfs1(nums, mid+1, right, target);
      } else {
        return dfs1(nums, left, right-1, target);
      }
    }

    private boolean dfs(int[] nums, int left, int right, int target) {
      if (left > right) return false;

      while (left < right) {
        int mid = (left + right) >> 1;
        if (nums[mid] == target) {
          return true;
        }

        if (nums[mid] > nums[right]) {
          if (nums[mid] > target && nums[left] <= target) right = mid - 1;
          else left = mid + 1;
        } else if (nums[mid] < nums[right]) {
          if (nums[mid] < target && nums[right] >= target) left = mid + 1;
          else right = mid - 1;
        } else {
          right -= 1;
        }
      }
      return nums[left] == target ? true : false;
    }
  }
}
