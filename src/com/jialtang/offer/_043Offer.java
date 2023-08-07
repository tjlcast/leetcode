package com.jialtang.offer;

public class _043Offer {

  public static void main(String[] args) {
    int n = 3101592;
    int i = new Solution().countDigitOne(n);
    System.out.println(i);
  }

  static class Solution {
    public int countDigitOne(int n) {
      // "1"出现的次数 = sum ("1"在各个计数位上出现的次数)
      // 从个位开始向最高位统计
      // 3101592
      // 将数字拆分为[a...][cur][b...]
      // cur 为当前位
      long base = 1, res = 0;
      while (base <= n) {
        long a, cur, b;
        a = (n / base) / 10;
        cur = (n / base) % 10;
        b = n % base;
        // 3101592
        if (cur > 1) {
          // 一、cur > 1，
          // [3101 ] 5 [92]
          // 变化范围：[0-3101] 1 [0-99]
          // 总个数： (a+1) * base
          res += (a + 1) * base;
        } else if (cur == 1) {
          // 二、cur == 1，
          // [310] 1 [592]
          // 1、变化范围 [0-309] 1 [0-999]
          // a * base
          // 2、变化范围 [310] 1 [0-592]
          // 1 * (b+1)
          // 总个数：a *base + (b + 1)
          res += a * base + b + 1;
        } else {
          // 三、cur < 1，
          // [31] 0 [1592]
          // 变化范围 [0-30] 1 [0-9999]
          // 总个数 a * base
          res += a * base;
        }
        base *= 10;
      }

      return (int) res;
    }
  }
}
