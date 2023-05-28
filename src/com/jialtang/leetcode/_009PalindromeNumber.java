package com.jialtang.leetcode;

public class _009PalindromeNumber {

    public static void main(String[] args) {
        int x = 1211;
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(x);
        System.out.println(palindrome);
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            int n = x;
            int r = 0;
            if (x < 0) {
                return false;
            }

            if (x == 0) {
                return true;
            }

            while (n > 0) {
                r = r * 10 + n % 10;
                n = n / 10;
            }

            return x == r;
        }
    }
}
