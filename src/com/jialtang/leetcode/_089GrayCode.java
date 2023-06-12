package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _089GrayCode {

    public static void main(String[] args) {
        int n;
        List<Integer> ans;

        n = 3;
        ans = new Solution().grayCode(n);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    static class Solution {
        List<Integer> ans = new LinkedList<>();

        public List<Integer> grayCode(int n) {
            LinkedList<Integer> ans = new LinkedList<>();
            ans.add(0);

            for (int i=0; i<n; i++) {
                int lastSize = ans.size();
                for (int j=lastSize-1; j>=0; j--) {
                    int num = ans.get(j) | (1 << (i));
                    ans.add(num);
                }
            }
            return ans;
        }
    }
}
