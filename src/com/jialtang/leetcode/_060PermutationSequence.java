package com.jialtang.leetcode;

public class _060PermutationSequence {
  public static void main(String[] args) {
    int n, k;
    String permutation;

    n = 3;
    k = 3;
    permutation = new Solution().getPermutation(n, k);
    System.out.println(permutation);
  }

  static class Solution {
    public String getPermutation(int n, int k) {
      StringBuilder sb = new StringBuilder();
      for (int i=0; i<n; i++) {
        sb.append(i+1);
      }
      String s = sb.toString();
    }


  }
}
