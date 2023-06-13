package com.jialtang.leetcode;

import com.jialtang.leetcode.common.TreeNode;

public class _098ValidateBinarySearchTree {

  public static void main(String[] args) {}

  static class Solution {
    int preVal = Integer.MIN_VALUE;
    boolean isFirst = true;

    public boolean isValidBST(TreeNode root) {
      if (root == null) return true;

      boolean ans = true;

      ans = ans & isValidBST(root.left);

      if (!isFirst) {
        ans = ans & (preVal < root.val);
        // isFirst = false;
      } else {
        ans = true;
        // isFirst = false;
      }
      isFirst = false;
      preVal = root.val;

      ans = ans & isValidBST(root.right);

      return ans;
    }
  }
}
