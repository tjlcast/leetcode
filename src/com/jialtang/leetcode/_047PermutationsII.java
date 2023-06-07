package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _047PermutationsII {

  public static void main(String[] args) {
    int[] nums;
    List<List<Integer>> ans;

    nums = new int[] {1, 1, 2};
    ans = new Solution().permuteUnique(nums);
    ans.forEach(e -> System.out.println(Arrays.toString(e.toArray())));
  }

  static class Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
      Arrays.sort(nums);
      ans.add(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
      while (nextPermute(nums)) {
        ans.add(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
      }
      return ans;
    }

    private boolean nextPermute(int[] nums) {
      int pos = nums.length - 2;
      while (pos >= 0 && nums[pos] >= nums[pos + 1]) pos--;

      if (pos < 0) return false;

      int bigger_pos = nums.length - 1;
      while (bigger_pos > pos && nums[bigger_pos] <= nums[pos]) bigger_pos--;
      swap(nums, pos, bigger_pos);

      reverse(nums, pos + 1, nums.length - 1);
      return true;
    }

    private void reverse(int[] nums, int i, int i1) {
      if (i < 0) return;
      if (i1 >= nums.length) return;
      if (i >= i1) return;

      while (i < i1) {
        swap(nums, i++, i1--);
      }
    }

    private void swap(int[] nums, int pos, int bigger_pos) {
      int n = nums[pos];
      nums[pos] = nums[bigger_pos];
      nums[bigger_pos] = n;
    }
  }
}
