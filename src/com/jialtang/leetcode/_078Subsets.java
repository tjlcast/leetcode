package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _078Subsets {

    public static void main(String[] args) {
        int[] nums;
        List<List<Integer>> ans;

        nums = new int[] {1, 2, 3};
        ans = new Solution().subsets(nums);
        ans.stream().forEach(e -> System.out.println(Arrays.toString(e.toArray())));
    }

    static class Solution {
        int[] nums;
        List<List<Integer>> ans = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            this.nums = nums;
            ans.add(new LinkedList());

            for (int i=0; i<nums.length; i++) {
                int n = nums[i];
                int setSize = ans.size();
                for (int j=0; j<setSize; j++) {
                    LinkedList<Integer> item = new LinkedList(ans.get(j));
                    ans.add(item);
                    item.add(n);
                }
            }

            return ans;
        }
    }
}
