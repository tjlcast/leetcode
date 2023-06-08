package com.jialtang.leetcode;

import java.util.Arrays;

public class _073SetMatrixZeroes {
  public static void main(String[] args) {
    int[][] matrix;

    matrix = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    new Solution().setZeroes(matrix);
    Arrays.stream(matrix).forEach(e -> System.out.println(Arrays.toString(e)));
    System.out.println("----");

    matrix = new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    new Solution().setZeroes(matrix);
    Arrays.stream(matrix).forEach(e -> System.out.println(Arrays.toString(e)));
    System.out.println("----");
  }

  static class Solution {
    int rows, cols;
    int[] zRows;
    int[] zCols;

    public void setZeroes(int[][] matrix) {
      this.rows = matrix.length;
      this.cols = matrix[0].length;
      this.zRows = new int[this.rows];
      this.zCols = new int[this.cols];

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (matrix[i][j] == 0) {
            zRows[i] = 1;
            zCols[j] = 1;
          }
        }
      }

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (zRows[i] == 1 || zCols[j] == 1) {
            matrix[i][j] = 0;
          }
        }
      }
    }
  }
}
