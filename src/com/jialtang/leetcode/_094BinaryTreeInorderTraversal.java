package com.jialtang.leetcode;

import com.jialtang.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _094BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode build = TreeNode.Create.build(new int[]{1, -1, 2, -1, -1, 3});
        List<Integer> integers = new Solution().inorderTraversal(build);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    static class Solution {
        private List<Integer> ans = new LinkedList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;

            dfs(root.left);
            ans.add(root.val);
            dfs(root.right);
        }
    }
}
