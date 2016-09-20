package Algorithms;

public class Balanced_Binary_Tree_110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


class Solution_Balanced_Binary_Tree_110 {
	
	int dif ;
	
    public boolean isBalanced(TreeNode root) {
    	dif = 0 ;
        boolean ans = true ;
        
        dfs(root) ;
        if(dif > 1) {
        	ans = false ;
        }
        
        return ans ;
    }
    
    public int dfs(TreeNode root) {
    	if(root == null) {
    		return 0 ;
    	}
    	
    	int heightL = dfs(root.left) ;
    	int rightR = dfs(root.right) ;
    	
    	if(Math.abs(heightL-rightR) > dif) {
    		dif = Math.abs(heightL-rightR) ;
    	}
    	
    	if(heightL < rightR) {
    		heightL = rightR;
    	}
    	return heightL + 1;
    }
}