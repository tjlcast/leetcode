package Algorithms;

import java.util.* ;

public class Binary_Tree_Inorder_Traversal_94 {

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
class Solution_Binary_Tree_Inorder_Traversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ansList = new ArrayList<Integer>() ;
        traversal(root, ansList) ;
        return ansList ;
    }
    
    public void traversal(TreeNode root, ArrayList<Integer> ansList) {
        if(root == null) {
            return ;
        }
        
        traversal(root.left, ansList) ;
        ansList.add(root.val) ;
        traversal(root.right, ansList) ;
        
        return ;
    }
}