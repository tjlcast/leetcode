package com.jialtang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _040CombinationSumII {

  public static void main(String[] args) {
    int[] candidates = new int[] {10, 1, 2, 7, 6, 1, 5};
    int target = 8;

    List<List<Integer>> lists = new Solution().combinationSum2(candidates, target);
    System.out.println(lists);
  }

  static class Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
      dfs(candidates, 0, new LinkedList<Integer>(), target);
      return ans;
    }

    private void dfs(int[] candidates, int b, LinkedList<Integer> can, int target) {
      if (target < 0) {
        return;
      }

      if (target == 0) {
        ans.add(new ArrayList<>(can));
        return;
      }

      int j = b;
      while (j < candidates.length) {
        can.addLast(candidates[j]);
        dfs(candidates, j + 1, can, target - candidates[j]);
        can.removeLast();

        j++;
        while (j < candidates.length && candidates[j - 1] == candidates[j]) j++;
      }
    }
  }
}
