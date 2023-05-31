package com.jialtang.leetcode;

import java.util.Arrays;

public class _027RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int i = new Solution().removeElement(nums, val);
        System.out.println(i);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, i)));

        nums = new int[]{3, 2, 2, 3};
        val = 2;
        i = new Solution().removeElement(nums, val);
        System.out.println(i);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, i)));
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int left = 0, right = 0;
            while (right < nums.length) {
                while (right < nums.length && nums[right] == val) {
                    right++;
                }
                if (left < nums.length && right < nums.length) {
                    nums[left++] = nums[right++];
                }
            }
            return left;
        }
    }
}
