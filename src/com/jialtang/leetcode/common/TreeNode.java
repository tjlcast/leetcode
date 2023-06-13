package com.jialtang.leetcode.common;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static class Create {
    public static TreeNode build(int[] nums) {
      return buildNode(nums, 0);
    }

    private static TreeNode buildNode(int[] nums, int i) {
      if (i >= nums.length) return null;
      if (nums[i] == -1) return null;

      TreeNode treeNode = new TreeNode(nums[i]);
      treeNode.left = buildNode(nums, (i + 1) * 2 - 1);
      treeNode.right = buildNode(nums, (i + 1) * 2);
      return treeNode;
    }
  }

  @Override
  public String toString() {
    String lStr = "", rStr = "";
    if (this.left != null) lStr = this.left.toString();
    if (this.right != null) rStr = this.right.toString();

    return lStr + this.val + " " + rStr;
  }

  public static void main(String[] args) {
    TreeNode treeNode = TreeNode.Create.build(new int[] {3, 1, 4, -1, -1, 2});
    System.out.println(treeNode.toString());
  }
}
