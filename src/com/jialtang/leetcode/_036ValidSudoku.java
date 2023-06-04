package com.jialtang.leetcode;

public class _036ValidSudoku {
  public static void main(String[] args) {
    char[][] board;

    board =
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
    System.out.println(new Solution().isValidSudoku(board));
  }

  static class Solution {
    public boolean isValidSudoku(char[][] board) {
      boolean[][] row = new boolean[9][9];
      boolean[][] col = new boolean[9][9];
      boolean[][] cub = new boolean[9][9];

      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (board[i][j] == '.') continue;
          int valIdx = board[i][j] - '1';
          int cubNo = i / 3 * 3 + j / 3;
          if (row[i][valIdx] || col[j][valIdx] || cub[cubNo][valIdx]) {
            return false;
          }
          row[i][valIdx] = true;
          col[j][valIdx] = true;
          cub[cubNo][valIdx] = true;
        }
      }

      return true;
    }
  }
}
