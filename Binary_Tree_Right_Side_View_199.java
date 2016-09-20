package Algorithms;

import java.util.* ;

public class Binary_Tree_Right_Side_View_199 {

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
class Solution_Binary_Tree_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ansSet = new ArrayList<Integer>() ;
        if(root == null) {
            return ansSet ;
        }
        bfs(root, ansSet) ;
        return ansSet ;
    }
    
    private void bfs(TreeNode root, ArrayList<Integer> ansSet) {
        TreeNode nullNode = new TreeNode(-1) ;
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>() ;
        int lastInteger = -1 ;
        
        queue.add(root) ;
        queue.add(nullNode) ;
        
        while(queue.size() != 0) {
            TreeNode curNode = queue.get(0) ;
            queue.remove(0) ;
            
            if(curNode == nullNode) {
                if(queue.size() != 0) {
                    queue.add(nullNode) ;
                }
                ansSet.add(new Integer(lastInteger)) ;
            } else {
                lastInteger = curNode.val ;
            }
            
            if(curNode.left != null) {
                queue.add(curNode.left) ;
            }
            if(curNode.right != null) {
                queue.add(curNode.right) ;
            }
        }
        
    }
}