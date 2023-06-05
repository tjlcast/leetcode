package com.jialtang.leetcode.common.practice;

public class GcdLcm {
  public static void main(String[] args) {
    int a = 4;
    int b = 6;

    int gcd = gcd(a, b);
    int lcm = lcm(a, b);

    System.out.println(gcd + " - " + lcm);
  }

  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

  public static int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }
}
