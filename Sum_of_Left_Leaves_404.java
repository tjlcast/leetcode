/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0 ;
        
        int total = 0 ;
        if (root.left!=null && root.left.left==null && root.left.right==null) {
            total += root.left.val ;
        }
        
        total += sumOfLeftLeaves(root.left) ;
        total += sumOfLeftLeaves(root.right) ;
        
        return total ;
    }
}
