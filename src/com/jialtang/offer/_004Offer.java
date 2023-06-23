package com.jialtang.offer;

public class _004Offer {
  public static void main(String[] args) {
    int[][] matrix;
    int target;

    matrix = new int[][] {{-5}};
    target = -5;

    boolean numberIn2DArray = new Solution().findNumberIn2DArray(matrix, target);
    System.out.println(numberIn2DArray);
  }

  static class Solution {
    private int rows;
    private int cols;
    private int[][] matrix;

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
        return false;
      }
      this.matrix = matrix;
      this.rows = matrix.length;
      this.cols = matrix[0].length;

      int i = rows - 1, j = 0;
      while (i >= 0 && j <= cols - 1) {
        if (matrix[i][j] > target) {
          i -= 1;
        } else if (matrix[i][j] < target) {
          j += 1;
        } else {
          return true;
        }
      }
      return false;
    }
  }
}
