package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _090SubsetsII {
  public static void main(String[] args) {
    int[] nums;

    nums = new int[] {1, 2, 2};
    List<List<Integer>> lists = new Solution().subsetsWithDup(nums);
    lists.stream().forEach(e -> System.out.println(Arrays.toString(e.toArray())));
  }

  static class Solution {
    private List<List<Integer>> ans = new LinkedList<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
      this.nums = nums;
      Arrays.sort(nums);
      LinkedList<Integer> stack = new LinkedList<>();
      dfs(0, stack);
      return ans;
    }

    private void dfs(int idx, LinkedList<Integer> stack) {
      // if (idx > nums.length) return;
      ans.add(new LinkedList<>(stack));

      for (int i = idx; i < nums.length; i++) {
        if (i > idx && nums[i] == nums[i - 1]) continue;
        stack.addLast(nums[i]);
        dfs(i + 1, stack);
        // dfs(idx+1, stack);
        stack.removeLast();
      }

      return;
    }
  }
}
