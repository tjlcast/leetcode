package Algorithms;

import java.util.* ;

public class Binary_Tree_Level_Order_Traversal_II_107 {

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
class Solution_Binary_Tree_Level_Order_Traversal_II_107 {
    private ArrayList ansSet ;
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ansSet = new ArrayList() ;
        if(root == null) {
            return ansSet ;
        }
        bfs(root) ;
        ansSet = reverseAns(ansSet) ;
        return ansSet ;
    }
    
    public void bfs(TreeNode root) {
        TreeNode nullNode = new TreeNode(-1) ;
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>() ;
        ArrayList<Integer> row = new ArrayList<Integer>() ;
        
        queue.add(root) ;
        queue.add(nullNode) ;
        
        while(queue.size() != 0) {
            TreeNode curNode = queue.get(0) ;
            queue.remove(0) ;
            
            if(curNode == nullNode) {
                if(queue.size() != 0) {
                    queue.add(curNode) ;
                }
                ansSet.add(row) ;
                row = new ArrayList<Integer> () ;
            } else {
                row.add(curNode.val) ;
            }
            
            if(curNode.left != null) {
                queue.add(curNode.left) ;
            }
            if(curNode.right != null) {
                queue.add(curNode.right) ;
            }
        }
    }
    
    private ArrayList reverseAns(ArrayList<ArrayList> ansSet) {
        ArrayList returnData = new ArrayList() ;
        
        for(int i=ansSet.size()-1; i>=0; i--) {
            returnData.add(ansSet.get(i)) ;
        }
        
        return returnData ;
    }
}