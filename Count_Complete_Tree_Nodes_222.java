/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "首先判断该节点的左右子树的两端是否相同，如果相同这该节点是完全二叉树。若不相同，则进行左右子树的递归" ;

    public int countNodes(TreeNode root) {
        if (root == null) return 0 ;
        
        int leftHeight = getLeftHeight(root) + 1;
        int rightHeight = getRightHeight(root) + 1;
        
        if (leftHeight == rightHeight) {
            return (1<<(leftHeight)) - 1 ;
        } 
        return 1 + countNodes(root.left) + countNodes(root.right) ;
    }
    
    private int getLeftHeight(TreeNode root) {
        int num = 0 ;
        
        while (root.left != null) {
            num++ ;
            root = root.left ;
        }
        return num ;
    }
    
    private int getRightHeight(TreeNode root) {
        int num = 0 ;
        
        while (root.right != null) {
            num++ ;
            root = root.right ;
        }
        return num ;
    }
}
 
 
 
class Solution2 {
    
    private String __tips__ = "暴力法，超时" ;
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0 ;
        
        int leftHeight = getHeight(root.left) ;
        int rightHeight = getHeight(root.right);
        
        if (leftHeight != rightHeight) {
            return countNodes(root.left) + (int)Math.pow(2, rightHeight) ;
        } 
        return (int)Math.pow(2,leftHeight) + countNodes(root.right) ;
    }
    
    private int getHeight(TreeNode root) {
        int num = 0 ;
        if (root == null) return num ;
        
        TreeNode cur = root ;
        while (cur != null) {
            num++ ;
            cur = cur.left ;
        }
        return num ;
    }
}
