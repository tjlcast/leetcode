package com.jialtang.offer2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _059Offer {
  public static void main(String[] args) {
    int[] nums;
    int k;

    nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
    k = 3;
    int[] ints = new Solution().maxSlidingWindow(nums, k);
    System.out.println(Arrays.toString(ints));
  }

  static class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n = nums.length;
      // 双端队列, 递增队列
      Deque<Integer> queue = new ArrayDeque<>();
      int[] res = new int[n - k + 1];

      for (int i = 0, j = 0; i < n; i++) {
        // 判断对头是否在滑动窗口范围
        while (!queue.isEmpty() && i - k + 1 > queue.getFirst()) queue.pollFirst();
        // 维护单调递减队列
        while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) queue.pollLast();
        // 将当前元素插入队列
        queue.addLast(i);
        // 滑动窗口的元素到达k个，才可以将其加入答案数组中
        if (i - k + 1 >= 0) res[j++] = nums[queue.getFirst()];
      }
      return res;
    }
  }
}
