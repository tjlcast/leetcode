package com.jialtang.leetcode;

public class _014LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String s = new Solution().longestCommonPrefix(strs);
        System.out.println(s);

        String[] strs1 = new String[]{"dog", "racecar", "car"};
        String s1 = new Solution().longestCommonPrefix(strs1);
        System.out.println(s1);
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int maxLen = 300;
            for (String str : strs) {
                maxLen = Math.min(maxLen, str.length());
            }

            for (int i = 0; i < maxLen; i++) {
                Character c = strs[0].charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }

            return strs[0].substring(0, maxLen);
        }
    }
}
