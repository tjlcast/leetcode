package com.jialtang.leetcode;

/** https://blog.csdn.net/xuchenhuics/article/details/117389303 */
public class _072EditDistance {
  public static void main(String[] args) {
    String word1, word2;
    int ans;

    word1 = "horse";
    word2 = "ros";
    ans = new Solution().minDistance(word1, word2);
    System.out.println(ans);
  }

  static class Solution {
    int m;
    int n;
    int[][] dp;

    public int minDistance(String word1, String word2) {
      this.m = word1.length();
      this.n = word2.length();
      this.dp = new int[m][n];

      return dfs(word1, 0, word2, 0);
    }

    private int dfs(String word1, int i, String word2, int j) {
      if (i == word1.length()) return word2.length() - j;
      if (j == word2.length()) return word1.length() - i;
      if (dp[i][j] > 0) return dp[i][j];

      int res = 0;
      if (word1.charAt(i) == word2.charAt(j)) {
        return dfs(word1, i + 1, word2, j + 1);
      } else {
        int insertCnt = dfs(word1, i, word2, j + 1); // 在word1的i位置前插入一个与word2[j]相同的字符，所以下一步j+1
        int deleteCnt = dfs(word1, i + 1, word2, j); // 直接删除word1[i]的字符
        int replaceCnt = dfs(word1, i + 1, word2, j + 1); // 修改word1[i]为word2[j]
        res = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
      }
      return res;
    }
  }
}
