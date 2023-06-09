package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _077Combinations {

  public static void main(String[] args) {
    int n, k;
    List<List<Integer>> ans;

    n = 4;
    k = 2;
    ans = new Solution().combine(n, k);
    ans.stream().forEach(e -> System.out.println(Arrays.toString(e.toArray())));
  }

  static class Solution {
    int n, k;
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
      this.n = n;
      this.k = k;

      dfs(1, new LinkedList<>());
      return ans;
    }

    private void dfs(int idx, LinkedList<Integer> queue) {
      if (queue.size() == this.k) {
        ans.add(new LinkedList(queue));
        return;
      }
      if (idx > this.n) return;

      queue.addLast(idx);
      dfs(idx+1, queue);
      queue.removeLast();

      dfs(idx+1, queue);
    }
  }
}
