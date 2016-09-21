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
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {return root ;}
        
        TreeNode tempNode = root.left ;
        root.left = root.right ;
        root.right = tempNode ;
        
        invertTree(root.left) ;
        invertTree(root.right) ;
        
        return root ;
    }
}
