package com.jialtang.leetcode;

public class _005LongestPalindromicSubstring {

    public static void main(String[] args) {
//        String s = "cbbd";
        String s = "babad";

        Solution solution = new Solution();
        String s1 = solution.longestPalindrome(s);

        System.out.println(s1);
    }

    static class Solution {
        int[] d = null;

        public String longestPalindrome(String s) {
            return s;
        }

        public int dpPalindrome(String s, int b, int e) {
            if (e == b) {
                return 0;
            }
            if (e - b == 1) {
                return 1;
            }
            if (e - b == 2 && s.charAt(b) == s.charAt(e - 1)) {
                return 2;
            }
            if (true)
                return dpPalindrome(s, b+1, e-1) + 2;
            return 0;
        }
    }
}
