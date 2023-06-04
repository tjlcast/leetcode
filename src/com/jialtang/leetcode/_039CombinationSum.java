package com.jialtang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _039CombinationSum {
  public static void main(String[] args) {
    int[] candidates = new int[] {2, 3, 6, 7};
    int target = 7;

    List<List<Integer>> lists = new Solution().combinationSum(candidates, target);
    System.out.println(lists);
  }

  static class Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      dfs(candidates, new LinkedList<Integer>(), target);
      return ans;
    }

    private void dfs(int[] candidates, LinkedList<Integer> integers, int target) {
      if (target < 0) {
        return;
      }

      if (target == 0) {
        ans.add(new ArrayList<>(integers));
        return;
      }

      for (int i = 0; i < candidates.length; i++) {
        if (!integers.isEmpty() && integers.peekFirst() > candidates[i]) {
          continue;
        }

        integers.push(candidates[i]);
        dfs(candidates, integers, target - candidates[i]);
        integers.pop();
      }
    }
  }
}
