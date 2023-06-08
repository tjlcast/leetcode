package com.jialtang.leetcode;

public class _074Searcha2DMatrix {
  public static void main(String[] args) {
    int target;
    boolean ans;
    int[][] matrix;

    matrix = new int[][] {{1, 1}};
    target = 2;
    ans = new Solution().searchMatrix(matrix, target);
    System.out.println(ans);

    matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    target = 3;
    ans = new Solution().searchMatrix(matrix, target);
    System.out.println(ans);

    matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    target = 13;
    ans = new Solution().searchMatrix(matrix, target);
    System.out.println(ans);
  }

  static class Solution {
    int[][] matrix;

    public boolean searchMatrix(int[][] matrix, int target) {
      this.matrix = matrix;
      int l = 0;
      int r = matrix.length * matrix[0].length - 1;

      while (l <= r) {
        int mid = (l + r) >> 1;
        int val = getVal(mid);
        if (val < target) {
          l = mid + 1;
        } else if (val > target) {
          r = mid - 1;
        } else {
          return true;
        }
      }
      return false;
    }

    private int getVal(int no) {
      int i = no / matrix[0].length;
      int j = no % matrix[0].length;
      return matrix[i][j];
    }
  }
}
