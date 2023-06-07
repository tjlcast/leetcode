package com.jialtang.leetcode;

import java.util.Arrays;

public class _059SpiralMatrixII {
  public static void main(String[] args) {
    int n;
    int[][] ints;
    n = 3;

    ints = new Solution().generateMatrix(n);
    Arrays.stream(ints).forEach(e -> System.out.println(Arrays.toString(e)));
  }

  static class Solution {
    private int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] matrix;

    public int[][] generateMatrix(int num) {
      int n = num * num;
      matrix = new int[num][num];

      int x = 0;
      int y = 0;
      matrix[x][y] = 1;
      for (int i = 2; i < n; i++) {

      }

      return matrix;
    }
  }
}
