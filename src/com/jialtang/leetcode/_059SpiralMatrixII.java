package com.jialtang.leetcode;

import java.util.Arrays;

public class _059SpiralMatrixII {
  public static void main(String[] args) {
    int n;
    int[][] ints;

    n = 3;
    ints = new Solution().generateMatrix(n);
    Arrays.stream(ints).forEach(e -> System.out.println(Arrays.toString(e)));

    n = 1;
    ints = new Solution().generateMatrix(n);
    Arrays.stream(ints).forEach(e -> System.out.println(Arrays.toString(e)));
  }

  static class Solution {
    private int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] matrix;

    public int[][] generateMatrix(int num) {
      int n = num * num;
      matrix = new int[num][num];
      int d = 0;

      int x = 0;
      int y = 0;
      matrix[x][y] = 1;
      for (int i = 2; i <= n; i++) {
        int k = 0;
        for (; k < 4; k++) {
          int xx = x + directions[d][0];
          int yy = y + directions[d][1];
          if (can(xx, yy)) {
            matrix[xx][yy] = i;
            x = xx;
            y = yy;
            break;
          } else {
            d = (d + 1) % 4;
          }
        }
        if (k >= 4) break;
      }

      return matrix;
    }

    private boolean can(int xx, int yy) {
      if (xx < 0 || xx >= matrix.length) return false;
      if (yy < 0 || yy >= matrix[0].length) return false;
      if (matrix[xx][yy] != 0) return false;
      return true;
    }
  }
}
