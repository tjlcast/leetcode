package com.jialtang.leetcode;

public class _012IntegertoRoman {

    public static void main(String[] args) {
        String conver = new Solution().intToRoman(666);
        System.out.println(conver);

        String conver1 = new Solution().intToRoman(3);
        System.out.println(conver1);

        String conver2 = new Solution().intToRoman(58);
        System.out.println(conver2);

        String conver3 = new Solution().intToRoman(1994);
        System.out.println(conver3);
    }

    static class Solution {
        public String intToRoman(int num) {
            StringBuilder result = new StringBuilder();
            String[] roNum = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
            int[] inNum = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
            for (int i = inNum.length - 1; i >= 0; i--) {
                while (num >= inNum[i]) {
                    result.append(roNum[i]);
                    num -= inNum[i];
                }
            }
            return result.toString();
        }
    }
}
