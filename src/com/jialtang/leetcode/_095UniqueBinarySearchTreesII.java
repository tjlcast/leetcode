package com.jialtang.leetcode;

import com.jialtang.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _095UniqueBinarySearchTreesII {
  public static void main(String[] args) {
    int n = 3;
    List<TreeNode> treeNodes = new Solution().generateTrees(n);
    treeNodes.stream().forEach(e -> System.out.println(e));
  }

  static class Solution {
    public List<TreeNode> generateTrees(int n) {
      return generate(1, n);
    }

    private List<TreeNode> generate(int l, int r) {
      List<TreeNode> ans = new ArrayList<>();

      if (l > r) {
        ans.add(null);
        return ans;
      }

      for (int i = l; i <= r; i++) {
        for (TreeNode left : generate(l, i - 1)) {
          for (TreeNode right : generate(i + 1, r)) {
            TreeNode node = new TreeNode();
            node.val = i;
            node.left = left;
            node.right = right;
            ans.add(node);
          }
        }
      }
      return ans;
    }
  }
}
