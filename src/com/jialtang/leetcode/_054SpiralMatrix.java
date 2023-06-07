package com.jialtang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class _054SpiralMatrix {
  public static void main(String[] args) {
    int[][] matrix;
    List<Integer> ans;

    matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    ans = new Solution().spiralOrder(matrix);
    ans.stream().forEach(e -> System.out.print(e + " "));
    System.out.println();

    matrix = new int[][] {{1, 2, 3}};
    ans = new Solution().spiralOrder(matrix);
    ans.stream().forEach(e -> System.out.print(e + " "));
    System.out.println();
  }

  static class Solution {
    private int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean[][] dp;
    private List<Integer> ans = new LinkedList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
      dp = new boolean[matrix.length][matrix[0].length];
      int x = 0, y = 0, d = 0;

      ans.add(matrix[x][y]);
      dp[x][y] = true;

      while (true) {
        int xx, yy;

        int k = 0;
        for (; k < 4; k++) {
          xx = x + directions[d][0];
          yy = y + directions[d][1];
          if (0 <= xx
              && xx < matrix.length
              && 0 <= yy
              && yy < matrix[0].length
              && dp[xx][yy] == false) {
            ans.add(matrix[xx][yy]);
            dp[xx][yy] = true;
            x = xx;
            y = yy;
            break;
          } else {
            d = (d + 1) % 4;
          }
        }

        if (k >= 4) {
          break;
        }
      }

      return ans;
    }
  }
}
