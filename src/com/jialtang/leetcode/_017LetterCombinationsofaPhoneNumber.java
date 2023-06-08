package com.jialtang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _017LetterCombinationsofaPhoneNumber {

  public static void main(String[] args) {
    String digits = "23";
    List<String> strings = new Solution().letterCombinations(digits);
    System.out.println(strings);
  }

  static class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
      if (digits == null || digits.length() == 0) {
        return res;
      }

      dps(digits, "");
      return res;
    }

    public void dps(String digits, String done) {
      if (digits == null || digits.length() == 0) {
        res.add(done);
        return;
      }

      char c = digits.charAt(0);
      String button = dn[c - '1' - 1];
      for (int i = 0; i < button.length(); i++) {
        char c1 = button.charAt(i);
        dps(digits.substring(1), done + c1);
      }
    }

    String[] dn = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  }
}
