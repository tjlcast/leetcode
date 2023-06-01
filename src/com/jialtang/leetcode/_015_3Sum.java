package com.jialtang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015_3Sum {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists1 = new Solution().threeSum(nums1);
        System.out.println(lists1);

        int[] nums2 = {0, 1, 1};
        List<List<Integer>> lists2 = new Solution().threeSum(nums2);
        System.out.println(lists2);

        int[] nums3 = {0, 0, 0};
        List<List<Integer>> lists3 = new Solution().threeSum(nums3);
        System.out.println(lists3);

        int[] nums4 = {0, 0, 0, 0, 0, 0, 0};
        List<List<Integer>> lists4 = new Solution().threeSum(nums4);
        System.out.println(lists4);
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            ArrayList<List<Integer>> objects = new ArrayList<>();
            Arrays.sort(nums);
            for (int r = nums.length - 1; r >= 2; ) {
                int rest = 0 - nums[r];
                int l = 0, m = r - 1;
                while (l < m) {
                    if (nums[l] + nums[m] > rest) {
                        m--;
                    } else if (nums[l] + nums[m] < rest) {
                        l++;
                    } else {
                        List<Integer> objects1 = new ArrayList<>();
                        objects1.add(nums[l]);
                        objects1.add(nums[m]);
                        objects1.add(nums[r]);
                        objects.add(objects1);
                        do {
                            m--;
                            l++;
                        } while (l < m && nums[l - 1] == nums[l] && nums[m] == nums[m + 1]);
                    }
                }

                r--;
                while (r >= 2 && nums[r] == nums[r + 1]) r--;
            }
            return objects;
        }
    }
}
