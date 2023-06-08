package com.jialtang.leetcode;

import java.util.Arrays;

public class _060PermutationSequence {
  public static void main(String[] args) {
    int n, k;
    String permutation;

    n = 3;
    k = 1;
    permutation = new Solution().getPermutation(n, k);
    System.out.println(permutation);

    n = 3;
    k = 2;
    permutation = new Solution().getPermutation(n, k);
    System.out.println(permutation);

    n = 3;
    k = 3;
    permutation = new Solution().getPermutation(n, k);
    System.out.println(permutation);
  }

  static class Solution {
    public String getPermutation(int n, int k) {
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = i + 1;
      }

      for (int i = 1; i < k; i++) {
        permutation(nums);
      }

      StringBuilder stringBuilder = new StringBuilder();
      Arrays.stream(nums).forEach(stringBuilder::append);
      return stringBuilder.toString();
    }

    private void permutation(int[] nums) {
      int i = nums.length - 2;
      while (i >= 0 && nums[i] >= nums[i + 1]) i--;
      if (i < 0) {
        return;
      }

      int j = nums.length - 1;
      while (j >= 0 && nums[j] <= nums[i]) j--;

      swap(nums, i, j);

      reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int i1) {
      while (i < i1) {
        swap(nums, i++, i1--);
      }
    }

    private void swap(int[] nums, int i, int j) {
      int n = nums[i];
      nums[i] = nums[j];
      nums[j] = n;
    }
  }
}
