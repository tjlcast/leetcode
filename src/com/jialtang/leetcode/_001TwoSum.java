package com.jialtang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _001TwoSum {
    public static void main(String[] args) {
        int[] sums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = new Solution().twoSum(sums, target);

        System.out.printf("%d - %d", res[0], res[1]);
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];
                int b = target - nums[i];
                if (map.containsKey(b)) {
                    return new int[]{map.get(b), i};
                }

                map.put(a, i);
            }

            return null;
        }
    }
}
