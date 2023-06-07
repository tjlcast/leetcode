package com.jialtang.leetcode;

import java.util.Arrays;

public class _048RotateImage {
  public static void main(String[] args) {
    int[][] matrix;

    matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    new Solution().rotate(matrix);
    Arrays.stream(matrix).forEach(e -> System.out.println(Arrays.toString(e)));
  }

  static class Solution {
    public void rotate(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols && j < cols - 1- i; j++) {
          int ii = cols - 1 - j;
          int jj = rows - 1 - i;
          swap(matrix, i, j, ii, jj);
        }
      }

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (i>=rows/2) continue;
          int ii = rows - 1 - i;
          int jj = j;
          swap(matrix, i, j, ii, jj);
        }
      }
    }

    private void swap(int[][] matrix, int i, int j, int ii, int jj) {
      int n = matrix[i][j];
      matrix[i][j] = matrix[ii][jj];
      matrix[ii][jj] = n;
    }
  }
}
