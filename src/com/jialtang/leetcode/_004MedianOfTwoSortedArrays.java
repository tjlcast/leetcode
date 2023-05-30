package com.jialtang.leetcode;

public class _004MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] ints = {0, 0, 0};
        int[] ints1 = {-1, 0, 1};
        int topK = new Solution().findTopK(ints, ints1, 3);
        int topK1 = new Solution().findTopK(ints, ints1, 4);
        System.out.println(topK);
        System.out.println(topK1);
    }

    static class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if ((nums1.length + nums2.length) % 2 == 0) {
                int a = findTopK(nums1, nums2, (nums1.length + nums2.length) / 2);
                int b = findTopK(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
                return (double) (a + b) / 2;
            } else {
                return findTopK(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
            }
        }

        public int findTopK(int[] nums1, int[] nums2, int k) {
            int i1 = 0;
            int i2 = 0;
            int target = 0;
            while (k > 0) {
                if ((i2 >= nums2.length && i1 < nums1.length)
                        || (i1 < nums1.length && i2 < nums2.length && nums1[i1] <= nums2[i2])) {
                    target = nums1[i1++];
                } else if ((i1 >= nums1.length && i2 < nums2.length)
                        || (i1 < nums1.length && i2 < nums2.length && nums2[i2] < nums1[i1])) {
                    target = nums2[i2++];
                }
                k--;
            }
            return target;
        }
    }
}
