package com.jialtang.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _045Offer {
  public static void main(String[] args) {
    int[] arr = new int[] {3, 30, 34, 5, 9};

    String s = new Solution1().minNumber(arr);
    System.out.println(s);
  }

  static class Solution {
    public String minNumber(int[] nums) {
      String[] array = new String[nums.length];
      for (int i = 0; i < nums.length; i++) array[i] = nums[i] + "";
      Arrays.sort(
          array,
          new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
              if ((o1 + o2).compareTo(o2 + o1) > 0) {
                return 1;
              }
              return -1;
            }
          });
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < nums.length; i++) sb.append(array[i]);
      return sb.toString();
    }
  }

  static class Solution1 {
    public String minNumber(int[] nums) {
      return IntStream.of(nums)
          .mapToObj(String::valueOf)
          .sorted(((o1, o2) -> (o1 + o2).compareTo(o2 + o1)))
          .collect(Collectors.joining());
    }
  }
}
