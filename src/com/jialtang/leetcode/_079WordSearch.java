package com.jialtang.leetcode;

import java.util.LinkedList;

public class _079WordSearch {

  public static void main(String[] args) {
    char[][] board;
    String word;
    boolean ans;

    board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    word = "ABCCED";
    ans = new Solution().exist(board, word);
    System.out.println("ans: " + ans);

    board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    word = "ABCB";
    ans = new Solution().exist(board, word);
    System.out.println("ans: " + ans);
  }

  static class Solution {
    private boolean ans;
    private int rows, cols;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
      rows = board.length;
      cols = board[0].length;
      this.word = word;
      this.board = board;

      LinkedList<Integer> queue = new LinkedList<>();
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          ans = ans || dp(i, j, 0, queue);
        }
      }

      return ans;
    }

    private boolean dp(int i, int j, int k, LinkedList<Integer> queue) {
      if (i < 0 || i >= rows) return false;
      if (j < 0 || j >= cols) return false;
      if (queue.contains(i * rows + j)) return false;
      if (k >= word.length()) {
        return true;
      }
      if (board[i][j] == word.charAt(k)) {
        queue.addLast(i * rows + j);
        if (dp(i, j + 1, k + 1, queue)) return true;
        if (dp(i + 1, j, k + 1, queue)) return true;
        if (dp(i, j - 1, k + 1, queue)) return true;
        if (dp(i - 1, j, k + 1, queue)) return true;
        queue.removeLast();
        return false;
      } else {
        return false;
      }
    }
  }
}
