package com.jialtang.leetcode;

public class _006ZigzagConversion {

    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;

        Solution solution = new Solution();
        String convert = solution.convert(s, numRows);

        System.out.println(convert);
    }

    static class Solution {
        String[] zip = null;

        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }

            int len = s.length();
            zip = new String[numRows];
            for (int i = 0; i < zip.length; i++) {
                zip[i] = "";
            }

            int zipLen = numRows + numRows - 2;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                int i1 = i % zipLen;
                if (i1 < numRows) {
                    zip[i1] = zip[i1] + c;
                } else {
                    zip[numRows + numRows - i1 - 2] = zip[numRows + numRows - i1 - 2] + c;
                }
            }

            String res = "";
            for (int i = 0; i < zip.length; i++) {
                res = res + zip[i];
            }
            return res;
        }
    }
}
