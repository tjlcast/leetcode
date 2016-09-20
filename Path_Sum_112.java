package Algorithms;

public class Path_Sum_112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_Path_Sum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum) ;
    }
    
    public boolean dfs(TreeNode root, int cur_sum, int sum) {
        if(root == null) return false ;
        System.out.println("val: " + root.val) ;
        
        TreeNode curNode = root ;
        int val = curNode.val ;
        int total = val + cur_sum ;
    
        if(curNode.left == null && curNode.right == null) {
            if(total == sum) {
                return true ;
            } else {
                return false ;
            }
        }
        
        boolean ans = false ; 
        ans = dfs(root.left, total, sum) ;
        if(ans == true) {
            return ans ;
        }
        ans = dfs(root.right, total, sum) ;
        if(ans == true) {
            return ans ;
        }
        
        return ans ;
    }
}
