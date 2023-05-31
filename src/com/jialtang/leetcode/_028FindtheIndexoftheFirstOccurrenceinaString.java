package com.jialtang.leetcode;

public class _028FindtheIndexoftheFirstOccurrenceinaString {
    public static void main(String[] args) {
        String haystack = "leetcode", needle = "leeto";
        int i = new Solution().strStr(haystack, needle);
        System.out.println(i);
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }
}
