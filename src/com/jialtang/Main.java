package com.jialtang;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n, k, ans = 0, l, r, mid = 0;
    long[] a = new long[10010];
    double[] b = new double[10010];
    double t;
    n = sc.nextLong();
    k = sc.nextLong();
    for (int i = 1; i <= n; i++) {
      b[i] = sc.nextDouble();
      a[i] = (long) (b[i] * 100);
      ans += a[i];
    }
    l = 0;
    r = ans / k + 1;

    while (l < r) {
      mid = (l + r + 1) / 2;
      ans = 0;
      for (int i = 1; i <= n; i++) ans += a[i] / mid;
      if (ans < k) r = mid - 1;
      else l = mid;
    }
    t = r * 1.00 / 100;
    System.out.printf("%.2f", t);
  }
}
