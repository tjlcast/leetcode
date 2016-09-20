package Algorithms;

import java.util.* ;

public class Path_Sum_II_113 {

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
class Solution_Path_Sum_II_113 {
    private ArrayList ansSet ;
    private ArrayList<Integer> cur_road ;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ansSet = new ArrayList() ;
        cur_road = new ArrayList<Integer>() ;
        
        dfs(root, 0, sum) ;
        
        return ansSet ;
    }
    
    public void dfs(TreeNode root, int cur_sum, int sum) {
        if(root == null) return  ;
        System.out.println("val: " + root.val) ;
        
        TreeNode curNode = root ;
        int val = curNode.val ;
        int total = val + cur_sum ;
        cur_road.add(val) ;
    
        if(curNode.left == null && curNode.right == null) {
            if(total == sum) {
                ArrayList<Integer> temp_road = new ArrayList<Integer>() ;
                for(int i=0; i<cur_road.size(); i++) {
                    temp_road.add(cur_road.get(i)) ;
                }
                ansSet.add(temp_road) ;
            }
        }
         
        dfs(root.left, total, sum) ;
        dfs(root.right, total, sum) ;
        cur_road.remove(cur_road.size()-1) ;
        
        return  ;
    }
}