package com.jialtang.main;

import java.util.Arrays;
import java.util.LinkedList;

public class Main2 {
  static int total = 0;
  static LinkedList<Integer> queue = new LinkedList<>();

  public static void main(String[] argss) {
    String str = "101";
    int k = 30;

    travel(str, 0, k);
    System.out.println(total);
  }

  private static void travel(String str, int i, int k) {
    if (i >= str.length()) {
      total += 1;
      Integer[] objects = queue.toArray(new Integer[0]);
      System.out.println(Arrays.toString(objects));
      return;
    }

    int num = 0;
    for (int j = i; j < str.length() && num <= k; j++) {
      char c = str.charAt(j);
      num = num * 10 + (c - '0');
      // 前导为0的情况；
      if (j != i && num == c - '0') break;

      queue.addLast(num);
      travel(str, i + 1, k);
      queue.removeLast();
    }
  }
}
