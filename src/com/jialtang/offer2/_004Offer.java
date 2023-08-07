package com.jialtang.offer2;

import java.util.HashMap;
import java.util.Map;

public class _004Offer {
  public static void main(String[] args) {}

  static class Solution {
    public int singleNumber(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>();

      for (Integer num : nums) {
        int a = map.getOrDefault(num, 0);
        map.put(num, a + 1);
      }

      int ans = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1) return entry.getKey();
      }

      return -1;
    }
  }
}
