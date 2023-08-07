package com.jialtang.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// 题目描述
// 软件攻城狮小E准备下班的时候，发现办公室只剩下他自己了，但是灯全部还开着，一方面他想关掉灯节省资源，可另一方面他又得赶班车。办公室的布局可用一个正方形矩阵表示，其中：
// 0：表示空位，可以通过；
// 1：表示桌子，不可通过；
// 2：表示一盏灯（假设灯和开关一体的），可以通过；
// 3：表示小E工位（只有一个），可以通过；
// 4：表示办公室门口（只有一个），可以通过；
//
// 现给定办公室布局信息及赶班车所需的最少时间，请帮小E计算在不耽误赶班车的情况，最多来得及熄掉几盏灯；如果小E无论如何都赶不上班车，则输出-1。 假设：
//
// 小E每一秒可以向上/下/左/右移动一个单位。
// 最后到达办公室门口，出门口即认为可赶上班车。
//
// 输入
// 首行一个整数 timeLimit，表示赶班车所需的最少时间，即小E要在 timeLimit 秒内（小于或等于）赶到办公室门口（可经过而暂不出去），其值范围：[1, 20000]
// 第二行一个整数 size，表示办公室正方矩形的边长，其值范围：[2, 50]
// 随后 size 行，每行 size 个整数，表示办公室的布局， 值为0,1,2,3,4其中一个。（其中 2 所表示的灯的数量 小于等于 11）
// 输出
// 一个整数，代表小E最多能熄掉几盏灯；或者 -1。
// 样例
// 输入样例 1
// 8
// 5
// 0 0 0 0 0
// 0 3 0 2 0
// 0 0 2 0 0
// 0 0 0 0 0
// 0 0 0 0 4
//
// 输出
// 2
//
// 输入样例 2
//
// 3
// 4
// 0 0 0 0
// 0 0 0 2
// 0 0 4 0
// 0 0 0 3
//
// 输出
// 0
//
// 输入样例 3
//
// 10
// 3
// 3 1 2
// 0 1 0
// 0 1 4
//
// 输出
// -1
public class Main3 {
  static int len;
  static int[][] matrix, dp;
  static int maxN = -1;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int minStep = sc.nextInt();
    len = sc.nextInt();
    int x = 0, y = 0;
    LinkedList<int[]> deng = new LinkedList<>();

    matrix = new int[len][len];
    dp = new int[len][len];
    for (int i = 0; i < len; i++) {
      Arrays.fill(dp[i], -1);
      for (int j = 0; j < len; j++) {
        matrix[i][j] = sc.nextInt();
        if (matrix[i][j] == 3) {
          x = i;
          y = j;
        }
        if (matrix[i][j] == 2) {
          deng.addLast(new int[] {i, j});
        }
      }
    }

    t(x, y, minStep, 0);
    System.out.println(maxN);
  }

  public static void t(int i, int j, int time, int score) {
    // final
    if (time == 0) {
      if (matrix[i][j] == 4) maxN = Math.max(maxN, score);
      return;
    }

    if (matrix[i][j] == 1) return;
    if (matrix[i][j] == 2) score += 1;
    if (dp[i][j] != -1) return;

    dp[i][j] = Math.max(score, dp[i][j]);
    if (matrix[i][j] == 4) {
      maxN = Math.max(maxN, score);
    }

    // next;
    if (i + 1 < len) {
      t(i + 1, j, time - 1, score);
    }
    if (j - 1 >= 0) {
      t(i, j - 1, time - 1, score);
    }
    if (i - 1 >= 0) {
      t(i - 1, j, time - 1, score);
    }
    if (j + 1 < len) {
      t(i, j + 1, time - 1, score);
    }

    dp[i][j] = -1;
  }
}
