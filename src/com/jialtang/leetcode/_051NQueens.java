package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _051NQueens {

  public static void main(String[] args) {
    int n;
    List<List<String>> ans;

    n = 4;
    ans = new Solution().solveNQueens(n);
    ans.stream().forEach(e -> System.out.println(Arrays.toString(e.toArray())));
  }

  static class Solution {
    List<List<String>> ans = new LinkedList<>();
    private int n;

    public List<List<String>> solveNQueens(int n) {
      this.n = n;
      int[][] matrix = new int[n][n];
      Arrays.stream(matrix).forEach(e -> Arrays.fill(e, 0));

      dfs(matrix, 0);
      return ans;
    }

    private void dfs(int[][] matrix, int i) {
      if (i >= this.n) {
        ans.add(printM(matrix));
        return;
      }

      for (int j = 0; j < n; j++) {
        if (check(matrix, i, j)) {
          matrix[i][j] = 1;
          dfs(matrix, i+1);
          matrix[i][j] = 0;
        }
      }
    }

    private List<String> printM(int[][] matrix) {
      List<String> ans = new LinkedList<>();
      for (int i = 0; i < matrix.length; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < matrix[i].length; j++) {
          sb.append((matrix[i][j] == 0) ? ('.') : ('Q'));
        }
        ans.add(sb.toString());
      }
      return ans;
    }

    private boolean check(int[][] matrix, int i, int j) {
      if (matrix[i][j] == 1) {
        return false;
      }
      for (int ii = 0; ii < n; ii++) {
        for (int jj = 0; jj < n; jj++) {
          if (ii == i && jj == j) continue;

          if (ii == i && matrix[ii][jj] == 1) return false;
          if (jj == j && matrix[ii][jj] == 1) return false;
          if (((ii - i) == (jj - j) || (ii - i) + (jj - j) == 0) && matrix[ii][jj] == 1)
            return false;
        }
      }
      return true;
    }
  }
}
