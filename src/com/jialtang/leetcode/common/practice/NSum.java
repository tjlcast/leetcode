package com.jialtang.leetcode.common.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NSum {
  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4, 5, 6};
    int target = 6;

    List<List<Integer>> sum = new Solution().sum(nums, target);
    System.out.println(sum);
  }

  static class Solution {
    List<List<Integer>> ans;

    List<List<Integer>> sum(int[] nums, int target) {
      ans = new LinkedList<>();
      dfs(nums, nums.length - 1, target, new ArrayList<>());
      return ans;
    }

    void dfs(int[] nums, int pos, int target, List<Integer> list) {
      if (pos < 0) return;
      if (target < 0) return;

      if (target == 0) {
        ans.add(new ArrayList<>(list));
      } else {
        dfs(nums, pos - 1, target, new ArrayList<>(list));
        ArrayList<Integer> integers = new ArrayList<>(list);
        integers.add(nums[pos]);
        dfs(nums, pos - 1, target - nums[pos], integers);
      }
    }
  }
}
