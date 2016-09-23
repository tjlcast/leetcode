
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
    private String __tips__ = "通过函数递归的返回值进行判断（设为fx为，x及其孩子中有指定节点的数量），如果某次返回值为2着可以确定这次递归是公共节点。" ;
    
    int ancestorNum = 0 ;
    TreeNode ansNode = null ;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tempNode = new TreeNode(-1) ;
        tempNode.left = root ;
        dp(tempNode, p, q) ;
        return ansNode ;
    }
    
    private int dp(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {return 0 ;}
        int l = 0 ;
        int r = 0 ;
        int total = 0 ;
        
        if (total != 2)l = dp(root.left, p, q) ;
        total += l ;
        if (total != 2)r = dp(root.right, p, q) ;
        total += r ;
        
        if (l==2 && ansNode==null) ansNode = root.left ;
        if (r==2 && ansNode==null) ansNode = root.right ;
        
        if (root==p || root==q) {
            total += 1 ;
        }
        return total ;
    }
}
