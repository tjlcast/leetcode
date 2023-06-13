package com.jialtang.leetcode;

import com.jialtang.leetcode.common.TreeNode;

public class _099RecoverBinarySearchTree {
  static class Solution {
    public void recoverTree(TreeNode root) {
      int n = getN(root);
      for (int i = 0; i < n; i++) {
        prevNode = null;
        dfs(root);
      }
    }

    private TreeNode prevNode;

    private void dfs(TreeNode root) {
      if (root == null) return;

      dfs(root.left);
      if (prevNode != null) {
        boolean j1 = prevNode.val < root.val;
        if (!j1) {
          int tmp = prevNode.val;
          prevNode.val = root.val;
          root.val = tmp;
        }
      }
      prevNode = root;
      dfs(root.right);
    }

    private int getN(TreeNode root) {
      if (root == null) return 0;
      return 1 + getN(root.left) + getN(root.right);
    }
  }
}
