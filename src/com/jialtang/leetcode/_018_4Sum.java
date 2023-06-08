package com.jialtang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _018_4Sum {

  public static void main(String[] args) {
    int[] nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    List<List<Integer>> lists = new Solution().fourSum(nums, target);
    System.out.println(lists);

    int[] nums1 = {2, 2, 2, 2, 2};
    int target1 = 8;
    List<List<Integer>> lists1 = new Solution().fourSum(nums1, target1);
    System.out.println(lists1);

    int[] nums2 = {0, 0, 0, 0};
    int target2 = 0;
    List<List<Integer>> lists2 = new Solution().fourSum(nums2, target2);
    System.out.println(lists2);

    int[] nums3 = {1000000000, 1000000000, 1000000000, 1000000000};
    int target3 = -294967296;
    List<List<Integer>> lists3 = new Solution().fourSum(nums3, target3);
    System.out.println(lists3);
  }

  /**
   * The `%1000000007` is for the bad case: nums=[1000000000,1000000000,1000000000,1000000000],
   * target=-294967296
   */
  static class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> res = new ArrayList<>();

      Arrays.sort(nums);
      int i = 0;
      for (; i < nums.length - 3; ) {
        int num = nums[i];
        int rest = target - nums[i];
        List<List<Integer>> lists = threeSum(Arrays.copyOfRange(nums, i + 1, nums.length), rest);
        lists.stream().forEach(e -> e.add(num));
        res.addAll(lists);
        i++;
        while (i < nums.length - 3 && nums[i] == nums[i - 1]) i++;
      }

      return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
      ArrayList<List<Integer>> objects = new ArrayList<>();
      for (int r = nums.length - 1; r >= 2; ) {
        int rest = target - nums[r];
        int l = 0, m = r - 1;
        while (l < m) {
          if ((nums[l] + nums[m]) % 1000000007 > rest) {
            m--;
          } else if ((nums[l] + nums[m]) % 1000000007 < rest) {
            l++;
          } else {
            List<Integer> objects1 = new ArrayList<>();
            objects1.add(nums[l]);
            objects1.add(nums[m]);
            objects1.add(nums[r]);
            objects.add(objects1);
            do {
              m--;
              l++;
            } while (l < m && nums[l - 1] == nums[l] && nums[m] == nums[m + 1]);
          }
        }
        r--;
        while (r >= 2 && nums[r] == nums[r + 1]) r--;
      }
      return objects;
    }
  }
}
