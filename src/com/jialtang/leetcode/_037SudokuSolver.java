package com.jialtang.leetcode;

import java.util.Arrays;

public class _037SudokuSolver {
  public static void main(String[] args) {
    char[][] board =
        new char[][] {
          {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
    new Solution().solveSudoku(board);
    for (int i = 0; i < board.length; i++) {
      System.out.println(Arrays.toString(board[i]));
    }
  }

  static class Solution {
    private final int n = 9;
    private boolean[][] rows = new boolean[n][n];
    private boolean[][] cols = new boolean[n][n];
    private boolean[][] blks = new boolean[n][n];

    public void solveSudoku(char[][] board) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (board[i][j] == '.') continue;
          int num = board[i][j] - '1';
          rows[i][num] = true;
          cols[j][num] = true;
          blks[i / 3 * 3 + j / 3][num] = true;
        }
      }
      backtrace(board, 0, 0);
    }

    private boolean backtrace(char[][] board, int i, int j) {
      if (i == board.length) return true;

      // 本行结束，定位到下一行开始位置
      if (j == board.length) return backtrace(board, i + 1, 0);
      // skip.
      if (board[i][j] != '.') return backtrace(board, i, j + 1);

      int m = i / 3 * 3 + j / 3;
      for (int k = 0; k < 9; k++) {
        if (!rows[i][k] && !cols[j][k] && !blks[m][k]) {
          rows[i][k] = true;
          cols[j][k] = true;
          blks[m][k] = true;
          board[i][j] = (char) (k + '1');

          if (backtrace(board, i, j + 1)) {
            return true;
          }

          board[i][j] = '.';
          rows[i][k] = false;
          cols[j][k] = false;
          blks[m][k] = false;
        }
      }
      return false;
    }
  }
}
