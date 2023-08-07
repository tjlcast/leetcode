package com.jialtang.main;

import java.util.Arrays;

public class Main1 {
  public static void main(String[] args) {
    int[] scores = new int[] {1, 2, 3, 4, 5, 6};
    //    scores = new int[] {1, 2, 8, 4, 5, 6};
    scores = new int[] {1, 2, 8, 6, 5, 4, 3};
    int sugarN = dispatch(scores);
    System.out.println(sugarN);
  }

  private static int dispatch(int[] scores) {
    int n = scores.length;
    int[] fLeft = new int[scores.length];
    // int[] fRight = new int[scores.length];

    for (int i = 0; i < n; i++) {
      fLeft[i] = 1;
      if (i == 0) continue;
      if (scores[i] > scores[i - 1]) {
        fLeft[i] = fLeft[i - 1] + 1;
      }
    }

    System.out.println(Arrays.toString(fLeft));

    for (int i = n - 1; i > 0; i--) {
      if (scores[i - 1] > scores[i]) {
        if (fLeft[i - 1] < fLeft[i] + 1) {
          fLeft[i - 1] = fLeft[i] + 1;
        }
      }
    }

    System.out.println(Arrays.toString(fLeft));

    int ans = 0;
    for (Integer i : fLeft) {
      ans += i;
    }

    return ans;
  }
}
