package com.jialtang.leetcode;

import java.util.Arrays;

public class _005LongestPalindromicSubstring {

    public static void main(String[] args) {
//        String s = "cbbd";
//        String s = "aaaaaa";
//        String s = "abcdef";
        String s = "babad";

        Solution solution = new Solution();
        String s1 = solution.longestPalindrome(s);

        System.out.println(s1);
        System.out.println(solution);
    }

    static class Solution {
        int max = 0;
        int maxBegin = 0;
        int maxLength = 0;
        int[][] dp = null;

        public String longestPalindrome(String s) {
            int length = s.length();
            dp = new int[length][length + 1];
            initDp(dp, -2);
            for (int i = 0; i < length; i++) {
                for (int j = 1; j <= length; j++) {
                    dpPalindrome(s, i, j);
                }
            }

            return s.substring(maxBegin, maxBegin + maxLength);
        }

        public int dpPalindrome(String s, int begin, int length) {
            if (dp[begin][length] != -2) {
                return dp[begin][length];
            }

            if (begin + length - 1 >= s.length() || begin + length - 1 < 0) {
                return update(begin, length, -1);
            }

            if (length == 0) {
                return update(begin, length, 0);
            }
            if (length == 1) {
                return update(begin, length, 1);
            }

            if (s.charAt(begin) == s.charAt(begin + length - 1)) {
                int beforeDp = dpPalindrome(s, begin + 1, length - 2);
                if (beforeDp < 0) {
                    return -1;
                }
                return update(begin, length, beforeDp + 2);
            }

            return update(begin, length, -1);
        }

        private void initDp(int[][] dp, int val) {
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], val);
            }
        }

        private int update(int begin, int length, int val) {
            dp[begin][length] = val;
            if (dp[begin][length] >= max) {
                max = dp[begin][length];
                maxBegin = begin;
                maxLength = length;
            }
            return val;
        }

        @Override
        public String toString() {
            return "Solution{" +
                    "max=" + max +
                    ", maxBegin=" + maxBegin +
                    ", maxLength=" + maxLength +
                    ", dp=" + Arrays.toString(dp) +
                    '}';
        }
    }
}
